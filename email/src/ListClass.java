
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class ListClass {
    public String name;
    public String user;
    public String description;
    public int num_users;
    public String date;
    public boolean estatus;
    
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
    
    //------------------------------- PUBLIC FUNCTIONS --------------------------------------------
    
    
    public String InsertList()
    {
        String res = "";
        res = InsertList_P();
        return res;
    }
    
    public String[] ReadDesc(boolean descOption) // descOption -> (true = "bitacora_lista") (false = "lista")
    {
        String[] res = ReadDesc_P(descOption);
        return res;
    }
    
    //------------------------------- PRIVATE FUNCTIONS --------------------------------------------
    
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
            lists = ReadFileUser(fileList);
            //luego usar el metodo isListRepeated para verificar que no sea la misma lista (chequear llave primaria)
            if (!isListRepeated(lists, name + user)) 
            {
                Insert(fileList);
                //crear metodo para insertar en desc_user.txt
                String[] R= RegistroTxt();
                InsertDescList(listOption, user,user,R[0],R[1],R[2]);
            }
            else
            {
                return "El usuario '"+user+"' ya existe.";          
            }
        }
        
        return "Se registro con exito.";
    }
    
    //Method that gets entries
    private String[] RegistroTxt()
    {
        String[] R = new String[3];
        File file = new File("C:/MEIA/usuario.txt");
        List<ListClass> lists = ReadFileUser(file);
        int a=0;
        int i=0;
        R[0] = Integer.toString(lists.size());
        
        for (ListClass uc: lists) {
            if (uc.estatus == true) {
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
    
    //Method that fills a list with the existing users in the file
    private List<ListClass> ReadFileUser(File file){
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
        
        return users;
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
                escribir.write("Registros_activos: "+RA+"\n");
                escribir.write("Registros_inactivos: "+RI+"\n");
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
                escribir.write("Registros_activos:" + RA+"\n");
                escribir.write("Registros_inactivos:" + RI+"\n");
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
        try {
            
            File archivoDesc = new File(path);
            archivoDesc.createNewFile();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return d;
    }
}
