
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hichi
 */
public class ListClass implements Comparable<ListClass>{
    public String name;
    public String user;
    public String description;
    public int num_users;
    public String date;
    public boolean estatus;
    
    @Override
    public int compareTo(ListClass o) {
        ListClass otro = (ListClass) o;
        int commparacionPorNombre = name.compareTo(otro.name);

        if (commparacionPorNombre != 0)
            return commparacionPorNombre;

        return user.compareTo(otro.user);
    }
    
    // Constructor
    public ListClass(String _name, String _user, String _description, int _num_users, String _date, boolean _estatus)
    {
        name = _name;
        user = _user;
        description = _description;
        num_users = _num_users;
        date = _date;
        estatus = _estatus;
    }
    
    public ListClass()
    {
        name = null;
        user = null;
        description = null;
        num_users = 0;
        date = null;
        estatus = false;
    }
    
    //------------------------------- PUBLIC FUNCTIONS --------------------------------------------
    //var global
    int max_reorganizar = 3;
    
    public ListClass SearchList(String listName, String user)
    {
        List<ListClass> lists = AddListsToList(user);
        ListClass listC = new ListClass();
        
        for (ListClass l: lists) {
            
            if (l.name.equals(listName)) {
                listC = l;
            }
        }  
        return listC;
    }
    
    public List<ListClass> AddListsToList(String user)
    {
        List<ListClass> lists1 = new ArrayList<ListClass>();
        List<ListClass> lists2 = new ArrayList<ListClass>();
        
        File fileList1 = new File("C:/MEIA/bitacora_lista.txt");
        File fileList2 = new File("C:/MEIA/lista.txt");
        
        lists1 = ReadFileList(fileList1,user);
        lists2 = ReadFileList(fileList2,user);
        
        lists1.addAll(lists2);
        
        return lists1;
    }
    
    public String InsertList()
    {
        String res = "";
        res = InsertList_P(true); // true -> Inserta en el archivo bitácora_lista.txt
        return res;
    }
    
    public String[] ReadDesc(boolean descOption) // descOption -> (true = "desc_bitacora_lista") (false = "desc_lista")
    {
        String[] res = ReadDesc_P(descOption);
        return res;
    }
    
    //------------------------------- PRIVATE FUNCTIONS --------------------------------------------
    
    //Method that fills a list with all the active distribution lists for a specified user
    private List<ListClass> ReadFileList(File file, String user){
        List<ListClass> lists = new ArrayList<ListClass>();
        FileReader fr = null;
        BufferedReader br = null;

        try {
           fr = new FileReader (file);
           br = new BufferedReader(fr);          
           // read the file
           String linea;
           while((linea=br.readLine())!=null)
           {
               String separador = "\\|";
               String[] listChar = linea.split(separador);
               ListClass listC = new ListClass(listChar[0], listChar[1], listChar[2], Integer.parseInt(listChar[3]), listChar[4], Boolean.parseBoolean(listChar[5]));
               if (listC.estatus && listC.user.equals(user)) 
               { 
                   lists.add(listC); 
               } 
           }
           fr.close();
        }
        catch(Exception e){
            System.out.println("linea error");
           e.printStackTrace();
        }
        
        return lists;
    }
    
    //Method that inserts lists
    private String InsertList_P(boolean listOption) // listOption -> (true = "bitacora_lista") (false = "lista")
    {
        String path = "";
        
        if (listOption) { path = "C:/MEIA/bitacora_lista.txt"; }
        else { path = "C:/MEIA/lista.txt"; } 
        
        //Validate that the file is empty
        File fileList = new File(path);
        List<ListClass> lists ;
        if (fileList.length() == 0) {
            
            Insert(fileList);
            //SaveFile(userC.photoPath,photoPath);
            //crear metodo para insertar en el desc
            InsertDescList(listOption,user,user,"1","1","0");
        }
        else
        {
            //crear una lista de tipo ListClass que obtenga todos los valores del list.txt con un metodo privado 
            lists = ReadFileList(fileList);
            
            if (lists.size() == max_reorganizar) {
                Reorganizar_bit_lista(user);
            }
            //luego usar el metodo isListRepeated para verificar que no sea la misma lista (chequear llave primaria)
            if (!isListRepeated(lists, name + user)) 
            {
                Insert(fileList);
                //crear metodo para insertar en desc_lista.txt
                String[] R = RegistroTxt(listOption);
                InsertDescList(listOption, user,user,R[0],R[1],R[2]);
            }
            else
            {
                return "La lista '" + name + "' ya existe.";          
            }
        }
        
        return "Se registró con exito.";
    }
    
    //Metodo para reorganizar el archivo bitacora_lista
    private void Reorganizar_bit_lista(String user)
    {
        //Guardar los datos de bitacora
        File fileList = new File("C:/MEIA/bitacora_lista.txt");
        List<ListClass> bit_list = ReadFileList(fileList);
        //Guardar los datos de desc_bitacora
        String[] desc_bit_list = DescList(true);
        //Limpiar el archivo bitacora
        fileList.delete();
        //creamos de nuevo
        ReadFile rf = new ReadFile();
        rf.ValidateFile();
        //Cambio el archivo de desc_bitacora
        File fileDescList = new File("C:/MEIA/desc_bitacora_lista.txt");
        try
        {
            FileWriter escribir = new FileWriter(fileDescList, true);
            escribir.write(desc_bit_list[0] + "\n");
            escribir.write(desc_bit_list[1] + "\n");
            escribir.write(desc_bit_list[2] + "\n");
            escribir.write(desc_bit_list[3] + "\n");
            escribir.write("usuario_modificacion:" + user + "\n");
            escribir.write("#_registros:" + 0 + "\n");
            escribir.write("registros_activos:" + 0 + "\n");
            escribir.write("registros_inactivos:" + 0 + "\n");
            escribir.write(desc_bit_list[8] + "\n");
            escribir.write("max_reorganizar:3" + "\n");
            //Cerramos la conexion
            escribir.close();                   
        }
        catch (Exception e) {
            System.out.println("Error al escribir desc_bitacora_lista");
        }
        //inserto en lista
        InsertLists(bit_list,user);
        //inserto en desc_lista   
    }
    
    // método para insertar las listas en el archivo lista.txt
    private void InsertLists(List<ListClass> bit_lista, String user)
    {   
        //El archivo esta vacio?
        File fileList = new File("C:/MEIA/lista.txt");
        if (fileList.length() == 0) {
            //vacio
            List<ListClass> listas = bit_lista;
            listas = EliminarListasInactivas(listas);
            Collections.sort(listas); //se ordenan
            try
            {
                //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                FileWriter escribir = new FileWriter(fileList, true);
                for (ListClass c: listas) {
                    String insertList = c.name + "|";
                    insertList = insertList + c.user +"|";
                    insertList = insertList + c.description +"|";
                    insertList = insertList + c.num_users +"|";
                    insertList = insertList + c.date +"|";
                    insertList = insertList + c.estatus;
                    escribir.write(insertList + "\n");
                }              
                //Cerramos la conexion
                escribir.close();
                //inserto en desc_contactos    
                AddDescLista(user);
            } //Si existe un problema al escribir cae aqui
            catch (Exception e) {
                System.out.println("Error al escribir bitacora_lista");
            }
        }
        else
        {
            //no vacio
            List<ListClass> listas1 = ReadFileList(fileList);
            List<ListClass> listas2 = bit_lista;
            //agregar los nuevos contactos
            for(ListClass c: listas2){
                listas1.add(c);
            }
            listas1 = EliminarListasInactivas(listas1);
            Collections.sort(listas1); //se ordenan
            try
            {
                //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                FileWriter escribir = new FileWriter(fileList, true);
                for (ListClass c: listas1) {
                    String insertList = c.name + "|";
                    insertList = insertList + c.user +"|";
                    insertList = insertList + c.description +"|";
                    insertList = insertList + c.num_users +"|";
                    insertList = insertList + c.date +"|";
                    insertList = insertList + c.estatus;
                    escribir.write(insertList+"\n");
                }              
                //Cerramos la conexion
                escribir.close();
                //inserto en desc_contactos    
                AddDescLista(user);
            } //Si existe un problema al escribir cae aqui
            catch (Exception e) {
                System.out.println("Error al escribir bitacora_contactos");
            }
            
        }
    }
    
    //metodo para insertar los datos en el desc_lista
    private void AddDescLista(String user)
    {
        try 
        {
           //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            File fileList = new File("C:/MEIA/desc_lista.txt");
            Date objDate = new Date();
            String strDateFormat = "dd/MMM/aaaa hh: mm: ss a";
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
            String fecha = objSDF.format(objDate);
            //archivo vacio
            if (fileList.length() == 0) {
                FileWriter escribir = new FileWriter(fileList, true);
                escribir.write("nombre_simbolico:lista" + "\n");
                escribir.write("fecha_creacion:" + fecha + "\n");
                escribir.write("usuario_creacion:admin" + "\n");
                escribir.write("fecha_modificacion:" + fecha + "\n");
                escribir.write("usuario_modificacion:" + user + "\n");
                escribir.write("#_registros:3" + "\n");
                escribir.write("registros_activos:3" + "\n");
                escribir.write("registros_inactivos:0" + "\n");
                //Cerramos la conexion
                escribir.close();
            }
            else
            {
                //FALTA AHORA LLENARLO SI LOS DATOS YA FUERON CREADOS POR PRIMERA VEZ
                String[] datos = DescList(false);
                //File file = new File("C:/MEIA/lista.txt");
                String[] registro = RegistroTxt(false); // registros de lista.txt
                FileWriter escribir = new FileWriter(fileList, true);
                escribir.write(datos[0] + "\n");
                escribir.write(datos[1] + "\n");
                escribir.write(datos[2] + "\n");
                escribir.write("fecha_modificacion:" + fecha + "\n");
                escribir.write("usuario_modificacion:" + user + "\n");
                escribir.write("#_registros:" + registro[0] + "\n");
                escribir.write("registros_activos:" + registro[1] + "\n");
                escribir.write("registros_inactivos:" + registro[2] + "\n");
                //Cerramos la conexion
                escribir.close();              
            }
            
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir desc_bitacora_contacto");
        }
    }
    
    //Metodo para eliminar todas las listas que tienen un estado falso
    private List<ListClass> EliminarListasInactivas(List<ListClass> c)
    {
        List<ListClass> res = new ArrayList<ListClass>();
        
        for (ListClass list: c) {
            if (list.estatus == true) {
                res.add(list);
            }
        }     
        return res;
    }
    
    //Metodo para obtner las lineas del documento de desc_bitacora_lista o desc_lista
    private String[] DescList(boolean descOption) // descOption -> (true = "desc_bitacora_lista") (false = "desc_lista")
    {
        String path = "";
        
        if (descOption) { path = "C:/MEIA/desc_bitacora_lista.txt"; }
        else { path = "C:/MEIA/desc_lista.txt"; } 
        
        String[] d = new String[10];
        File file = new File(path);
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
           fr = new FileReader (file);
           br = new BufferedReader(fr);
           int x = 0;
           // read the file
           String linea;
           while((linea=br.readLine())!=null && x < d.length)
           {
               d[x] = linea;
               x++; 
           }
           fr.close();
        }
        catch(Exception e){
            System.out.println("linea error");
           e.printStackTrace();
        }
        
        //borramos datos 
        file.delete();
        //creamos de nuevo
        ReadFile rf = new ReadFile();
        rf.ValidateFile();
        
        return d;
    }
    
    //Method that gets entries (R[0] = cantidad de registros, R[1] = activos, R[2] = inactivos)
    private String[] RegistroTxt(boolean listOption) // listOption -> (true = "bitacora_lista") (false = "lista")
    {
        String path = "";
        
        if (listOption) { path = "C:/MEIA/bitacora_lista.txt"; }
        else { path = "C:/MEIA/lista.txt"; } 
        
        String[] R = new String[3];
        File file = new File(path);
        List<ListClass> lists = ReadFileList(file);
        int a=0;
        int i=0;
        R[0] = Integer.toString(lists.size());
        
        for (ListClass lc: lists) {
            if (lc.estatus == true) {
                a++;
            }else{
                i++;
            }
        }       
        R[1] = Integer.toString(a);
        R[2] = Integer.toString(i);       
        return R;
    }
    
    //Method that compares primary keys in list files
    private boolean isListRepeated(List<ListClass> listC, String primaryKey)
    {
        //scroll list
        for (ListClass lc:listC) {
            if ((lc.name + lc.user).equals(primaryKey)) 
            {
                return true;
            }
        }
        return false;
    }
    
    //Method that fills a list with the existing lists entries in the file
    private List<ListClass> ReadFileList(File file){
        List<ListClass> lists = new ArrayList<ListClass>();
        FileReader fr = null;
        BufferedReader br = null;

        try {
           fr = new FileReader (file);
           br = new BufferedReader(fr);          
           // read the file
           String linea;
           while((linea=br.readLine())!=null)
           {
               String separador = "\\|";
               String[] listChar = linea.split(separador);
               ListClass listC = new ListClass(listChar[0], listChar[1], listChar[2], Integer.parseInt(listChar[3]), listChar[4], Boolean.parseBoolean(listChar[5]));
               lists.add(listC);
           }
           fr.close();
        }
        catch(Exception e){
            System.out.println("linea error");
           e.printStackTrace();
        }
        
        return lists;
    }
    
    private void InsertDescList(boolean descOption, String UserC, String UserM,String Registros, String RA, String RI)
    {
        try 
        {
            String path = "";
            String nombreSimbolico = "";
        
            if (descOption) { 
                path = "C:/MEIA/desc_bitacora_lista.txt"; 
                nombreSimbolico = "desc_bitacora_lista";
            }
            else { 
                path = "C:/MEIA/desc_lista.txt"; 
                nombreSimbolico = "desc_lista";
            } 
            
            File file = new File(path);
            Date objDate = new Date();
            String strDateFormat = "dd/MMM/aaaa hh: mm: ss a";
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
            String fecha = objSDF.format(objDate);
            //validar primera insercion
            if (file.length() == 0) {               
                //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                FileWriter escribir = new FileWriter(file, true);
                escribir.write("nombre_simbolico:" + nombreSimbolico +"\n");
                escribir.write("fecha_creación:" + fecha + "\n");
                escribir.write("usuario_creación:admin" + "\n");
                escribir.write("fecha_modificación:" + fecha + "\n");
                escribir.write("usuario_modificación:admin"+"\n");
                escribir.write("#_registros:" + Registros + "\n");
                escribir.write("registros_activos: " + RA + "\n");
                escribir.write("registros_inactivos: " + RI + "\n");
                if (descOption) { escribir.write("max_reorganizar:3" + "\n"); }
                //Cerramos la conexion
                escribir.close();
            }
            else
            {
                String[] dato = ReadDesc_P(descOption);
                FileWriter escribir = new FileWriter(file, true);
                escribir.write("nombre_simbolico:" + dato[0]+"\n");
                escribir.write("fecha_creación:" + dato[1]+"\n");
                escribir.write("usuario_creación:" + dato[2]+"\n");
                escribir.write("fecha_modificación:" + fecha + "\n");
                escribir.write("usuario_modificación:" + UserM + "\n");
                escribir.write("#_registros:" + Registros+"\n");
                escribir.write("registros_activos:" + RA+"\n");
                escribir.write("registros_inactivos:" + RI+"\n");
                if (descOption) { escribir.write("max_reorganizar:3" + "\n"); }
                //Cerramos la conexion
                escribir.close();
            }
            
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir desc_user");
        }
    }
    
    private void Insert(File file)
    {
        try 
        {
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(file, true);
            escribir.write(InsertData()+"\n");
            //Cerramos la conexion
            escribir.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
    
    public String InsertData()
    {
        return name + "|" + user + "|" + description + "|" + num_users + "|" + date + "|" + estatus;
    }
    
    private String[] ReadDesc_P(boolean descOption) // descOption -> (true = "desc_bitacora_lista") (false = "desc_lista")
    {
        String[]  d = new String[3];
        String path = "";
        
        if (descOption) { path = "C:/MEIA/desc_bitacora_lista.txt"; }
        else { path = "C:/MEIA/desc_lista.txt"; } 
        
        File file = new File(path);
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
           fr = new FileReader (file);
           br = new BufferedReader(fr);
           int x = 0;
           // read the file
           String linea;
           while((linea=br.readLine())!=null && x < d.length)
           {
               String[] arrOfStr = linea.split(":");
               d[x] = arrOfStr[1];
               x++; 
           }
           fr.close();
        }
        catch(Exception e){
            System.out.println("linea error");
           e.printStackTrace();
        }
        
        //borramos datos 
        file.delete();
        //creamos de nuevo
        ReadFile rf = new ReadFile();
        rf.ValidateFile();
        
        return d;
    }
}
