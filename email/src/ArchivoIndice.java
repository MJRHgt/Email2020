
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 *
 * @author walte
 */
public class ArchivoIndice {
    
    int inicio = 1;
    //------------------------------- PUBLIC FUNCTIONS -------------------------------------------
    
    public String Insert(String list, String user, String contact)
    {
       return InsertP(list, user, contact);
    }
    
    public void Reeorganizar(String user)
    {
        ReorganizarP(user);
    }
    
    public String Eliminar(String list, String user, String contact)
    {
        return EliminarP(list, user, contact);
    }
    
    //------------------------------- PRIVATE FUNCTIONS -------------------------------------------
    
    //metodo para insertar en todo los archivos
    private String InsertP(String list, String user, String contact)
    {
        //comprobar de que no existan
        if (!ExisteLlave(list,user,contact)) {
            //insertamos en lista_usuario
            InsertListUser(list,user,contact);
            //insertamos en desc_lista_usuario
            InsertDescListUser(user);
            //insertamos en el indice
            InsertIndice(list,user,contact);
            //insertamos en desc_indice    
            InsertDescIndice(user);
            return "Se registro con exito la lista: " + list + " con el contacto: " + contact + ".";
        }    
        
        return "El contacto ya se encuentra en esa lista.";
    }
    
    //Metodo para saber si viene la misma llave
    private boolean ExisteLlave(String list, String user, String contact)
    {
        List<BloqueClass> bloque = ReadFileBloque();
        if (bloque.size() != 0) {
            for (BloqueClass bc: bloque) {
                if (bc.nombre_lista.equals(list) && bc.usuario.equals(user) && bc.usuario_asociado.equals(contact)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    //Metodo para obtener los datos de lista_usuario
    private List<BloqueClass> ReadFileBloque()
    {
        List<BloqueClass> bloque = new ArrayList<BloqueClass>();
        FileReader fr = null;
        BufferedReader br = null;
        File file = new File("C:/MEIA/lista_usuario.txt");
        try {
           fr = new FileReader (file);
           br = new BufferedReader(fr);          
           // read the file
           String linea;
           while((linea=br.readLine())!=null)
           {
               String separador = "\\|";
               String[] userChar = linea.split(separador);
               BloqueClass bloqueC = new BloqueClass();
               bloqueC.nombre_lista = userChar[0];    
               bloqueC.usuario = userChar[1];
               bloqueC.usuario_asociado = userChar[2];
               bloqueC.descripcion = userChar[3];
               bloqueC.fecha_creacion = userChar[4];
               bloqueC.estatus = Boolean.parseBoolean(userChar[5]); //vigente
               bloque.add(bloqueC);
           }
           fr.close();
        }
        catch(Exception e){
            System.out.println("linea error");
           e.printStackTrace();
        }
        
        return bloque;
    }
       
    //Metodo para obtener los datos de indice
    private List<IndiceClass> ReadFileIndice()
    {
        List<IndiceClass> indice = new ArrayList<IndiceClass>();
        FileReader fr = null;
        BufferedReader br = null;
        File file = new File("C:/MEIA/indice.txt");
        try {
           fr = new FileReader (file);
           br = new BufferedReader(fr);          
           // read the file
           String linea;
           while((linea=br.readLine())!=null)
           {
               String separador = "\\|";
               String[] userChar = linea.split(separador);
               IndiceClass indiceC = new IndiceClass();
               indiceC.registro = Integer.parseInt(userChar[0]); 
               indiceC.posicion = Double.parseDouble(userChar[1]); 
               indiceC.nombre_lista = userChar[2]; 
               indiceC.usuario = userChar[3];
               indiceC.usuario_asociado = userChar[4];
               indiceC.apuntador = Integer.parseInt(userChar[5]);
               indiceC.estatus = Boolean.parseBoolean(userChar[6]); //vigente
               indice.add(indiceC);
           }
           fr.close();
        }
        catch(Exception e){
            System.out.println("linea error");
           e.printStackTrace();
        }
        
        return indice;
    }
    
    //Metodo para insertar en el archivo de lista_usuario
    private void InsertListUser(String list, String user, String contact)
    {
        String Descripcion = DescripcionLista(list,user);
        try 
        {
           //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            File file = new File("C:/MEIA/lista_usuario.txt");
            Date objDate = new Date();
            String strDateFormat = "dd/MMM/aaaa hh: mm: ss a";
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
            String fecha = objSDF.format(objDate);
            FileWriter escribir = new FileWriter(file, true);
            String res = list + "|";
            res = res + user + "|";
            res = res + contact + "|";
            res = res + Descripcion + "|";
            res = res + fecha + "|";
            res = res + "true";
            escribir.write(res+"\n");
            //Cerramos la conexion
            escribir.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir desc_bitacora_contacto");
        }
        
    }
    
    //Metodo descripcion de la lista
    private String DescripcionLista(String list,String user)
    {
        ListClass lc = new ListClass();
        List<ListClass> listaC = lc.AddListsToList(user);
        String res = "";
        for (ListClass l : listaC) {
            if (l.name.equals(list)) {
                res = l.description;
            }
        }       
        return res;
    }
    
    //Metodo para insertar en el archivo desc_lista_usuario
    private void InsertDescListUser(String user)
    {
        try 
        {
           //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            File file = new File("C:/MEIA/desc_lista_usuario.txt");
            Date objDate = new Date();
            String strDateFormat = "dd/MMM/aaaa hh: mm: ss a";
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
            String fecha = objSDF.format(objDate);
            //archivo vacio
            if (file.length() == 0) {
                FileWriter escribir = new FileWriter(file, true);
                escribir.write("nombre_simbolico:lista_usuario"+"\n");
                escribir.write("fecha_creacion:"+fecha+"\n");
                escribir.write("usuario_creacion:admin"+"\n");
                escribir.write("fecha_modificacion:"+fecha+"\n");
                escribir.write("usuario_modificacion:"+user+"\n");
                escribir.write("#registros:1"+"\n");
                escribir.write("registros_activos:1"+"\n");
                escribir.write("#registros_inactivos:0"+"\n");
                //Cerramos la conexion
                escribir.close();
            }
            else
            {
                String[] datos = DescListUser();
                String[] registro = RegistroListUser();
                FileWriter escribir = new FileWriter(file, true);
                escribir.write(datos[0]+"\n");
                escribir.write(datos[1]+"\n");
                escribir.write(datos[2]+"\n");
                escribir.write("fecha_modificacion:"+fecha+"\n");
                escribir.write("usuario_modificacion:"+user+"\n");
                escribir.write("#registros:"+registro[0]+"\n");
                escribir.write("registros_activos:"+registro[1]+"\n");
                escribir.write("#registros_inactivos:"+registro[2]+"\n");
                //Cerramos la conexion
                escribir.close();
            
            }
            
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir desc_bitacora_contacto");
        }
    }
    
    //metodo para obtener los datos de desc_lista_usuario
    private String[] DescListUser()
    {
        String[] d = new String[9];
        File file = new File("C:/MEIA/desc_lista_usuario.txt");
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
    
    //Metodo para saber el registro de las lista_usuarios
    private String[] RegistroListUser()
    {
        String[] R = new String[3];
        List<BloqueClass> bloque = ReadFileBloque();
        int a=0;
        int i=0;
        R[0] = Integer.toString(bloque.size());
        
        for (BloqueClass uc: bloque) {
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
    
    //Metodo para insertar en el archivo indice
    private void InsertIndice(String list, String user, String contact)
    {
        try 
        {
           //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            File file = new File("C:/MEIA/indice.txt");
            //archivo vacio
            if (file.length() == 0) {
                FileWriter escribir = new FileWriter(file, true);
                String res = "1|";
                res = res + "1.1|";
                res = res + list + "|";
                res = res + user + "|";
                res = res + contact + "|";
                res = res + "0|";
                res = res + "true";
                escribir.write(res+"\n");
                //Cerramos la conexion
                escribir.close();
            }
            else
            {
                int registroMax = RegistroMax();
                FileWriter escribir = new FileWriter(file, true);
                String res = "";
                //obtener el registro mas grande
                res = res + registroMax + "|";
                res = res + "1." + registroMax + "|";
                //Insertamos demas datos
                res = res + list + "|";
                res = res + user + "|";
                res = res + contact + "|";
                //preguntar hacia donde apunta
                res = res +  "-1|";
                //colocar status
                res = res + "true";
                escribir.write(res+"\n");
                //Cerramos la conexion
                escribir.close();
                RegApuntador(registroMax,list,user,contact);
            }
            
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir desc_bitacora_contacto");
        }
    }
    
     //Metodo para insertar en el archivo desc_lista_usuario
    private void InsertDescIndice(String user)
    {
        try 
        {
           //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            File file = new File("C:/MEIA/desc_indice.txt");
            Date objDate = new Date();
            String strDateFormat = "dd/MMM/aaaa hh: mm: ss a";
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
            String fecha = objSDF.format(objDate);
            //archivo vacio
            if (file.length() == 0) {
                FileWriter escribir = new FileWriter(file, true);
                escribir.write("nombre_simbolico:lista_usuario"+"\n");
                escribir.write("fecha_creacion:"+fecha+"\n");
                escribir.write("usuario_creacion:admin"+"\n");
                escribir.write("fecha_modificacion:"+fecha+"\n");
                escribir.write("usuario_modificacion:"+user+"\n");
                escribir.write("#registros:1"+"\n");
                escribir.write("registros_activos:1"+"\n");
                escribir.write("#registros_inactivos:0"+"\n");
                escribir.write("registro_inicio:"+ inicio +"\n");
                //Cerramos la conexion
                escribir.close();
            }
            else
            {
                String[] datos = DescIndice();
                String[] registro = RegistroIndice();
                FileWriter escribir = new FileWriter(file, true);
                escribir.write(datos[0]+"\n");
                escribir.write(datos[1]+"\n");
                escribir.write(datos[2]+"\n");
                escribir.write("fecha_modificacion:"+fecha+"\n");
                escribir.write("usuario_modificacion:"+user+"\n");
                escribir.write("#registros:"+registro[0]+"\n");
                escribir.write("registros_activos:"+registro[1]+"\n");
                escribir.write("#registros_inactivos:"+registro[2]+"\n");
                escribir.write("registro_inicio:"+ inicio +"\n");
                //Cerramos la conexion
                escribir.close();           
            }           
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir desc_bitacora_contacto");
        }
    }
    
     //metodo para obtener los datos de desc_indice
    private String[] DescIndice()
    {
        String[] d = new String[9];
        File file = new File("C:/MEIA/desc_indice.txt");
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
    
    //Metodo para saber el registro de indice
    private String[] RegistroIndice()
    {
        String[] R = new String[3];
        List<IndiceClass> indice = ReadFileIndice();
        int a=0;
        int i=0;
        R[0] = Integer.toString(indice.size());
        
        for (IndiceClass uc: indice) {
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
    
    //Metodo para reorganizar
    private void ReorganizarP(String user)
    {
        List<BloqueClass> bloque = ReadFileBloque();       
        File file2 = new File("C:/MEIA/lista_usuario.txt");
        file2.delete();
        ReadFile rf = new ReadFile();
        rf.ValidateFile();
         try
            {
                //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                FileWriter escribir = new FileWriter(file2, true);
                for (BloqueClass c: bloque) {
                    if (c.estatus == true) {
                        String insertContact = c.nombre_lista + "|";
                        insertContact = insertContact + c.usuario +"|";
                        insertContact = insertContact + c.usuario_asociado +"|";
                        insertContact = insertContact + c.descripcion +"|";
                        insertContact = insertContact + c.fecha_creacion +"|";
                        insertContact = insertContact + c.estatus;
                        escribir.write(insertContact+"\n");
                    }                   
                }              
                //Cerramos la conexion
                escribir.close();
                              
            } //Si existe un problema al escribir cae aqui
            catch (Exception e) {
                System.out.println("Error al escribir bitacora_contactos");
            }
         InsertDescIndice(user);
    }
    
    //Metodo para obtener el registro mas grande
    private int RegistroMax()
    {
        List<IndiceClass> indice = ReadFileIndice();
        int res = 0;
        for (IndiceClass ic : indice) {
            if (res < ic.registro) {
                res =ic.registro;
            }
        }
        return res+1;
    }
    
    //Metodo para saber hacia donde apunta en el indice
    private void RegApuntador(int registroMax, String list, String user, String contact)
    {
        //obtener todos los datos
        List<IndiceClass> indice3 = ReadFileIndice();
        List<IndiceClass> indice = LimpiarIndice(indice3);
        List<IndiceClass> indice2 = LimpiarIndice(indice3);
        //eliminarlos
        File file = new File("C:/MEIA/indice.txt");
        file.delete();
        ReadFile rf = new ReadFile();
        rf.ValidateFile();
        //realziar una busqueda para saber donde ingresa
        Collections.sort(indice2); //se ordenan
        IndiceClass[] x = new IndiceClass[indice2.size()];
        int r = 0;
        for (IndiceClass c:indice2) {
            x[r] = c;
            r++;
        }
        int dato = 0;
        for (int i = 0; i < x.length; i++) {
            if (i != x.length-1) {
                for (IndiceClass c:indice) {
                    if (c.nombre_lista.equals(x[i+1].nombre_lista) && c.usuario.equals(x[i+1].usuario) && c.usuario_asociado.equals(x[i+1].usuario_asociado) ) 
                    {
                        dato = c.registro;
                    }
                }
                for (IndiceClass c:indice) {
                    if (c.nombre_lista.equals(x[i].nombre_lista) && c.usuario.equals(x[i].usuario) && c.usuario_asociado.equals(x[i].usuario_asociado) ) 
                    {
                        c.apuntador = dato;
                    }
                }
                
            }
            else
            {
                for (IndiceClass c:indice) {
                    if (c.nombre_lista.equals(x[i].nombre_lista) && c.usuario.equals(x[i].usuario) && c.usuario_asociado.equals(x[i].usuario_asociado) ) 
                    {
                        c.apuntador = 0;
                    }
                }
            }
            
            for (IndiceClass c:indice) {
                    if (c.nombre_lista.equals(x[0].nombre_lista) && c.usuario.equals(x[0].usuario) && c.usuario_asociado.equals(x[0].usuario_asociado) ) 
                    {
                        inicio=c.registro;
                    }
                }
        }
        
        
        //insertar los datos guardados
        FillIndice(indice);
    }
    
    //Metodo para llenar todo el archivo nuevamente
    private void FillIndice(List<IndiceClass> indice )
    {
        try
            {
                File file = new File("C:/MEIA/indice.txt");
                //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                FileWriter escribir = new FileWriter(file, true);
                for (IndiceClass c: indice) {
                    String insertContact = c.registro + "|";
                    insertContact = insertContact + c.posicion +"|";
                    insertContact = insertContact + c.nombre_lista +"|";
                    insertContact = insertContact + c.usuario +"|";
                    insertContact = insertContact + c.usuario_asociado +"|";
                    insertContact = insertContact + c.apuntador +"|";
                    insertContact = insertContact + c.estatus;
                    escribir.write(insertContact+"\n");
                }              
                //Cerramos la conexion
                escribir.close();
                
                
            } //Si existe un problema al escribir cae aqui
            catch (Exception e) {
                System.out.println("Error al escribir bitacora_contactos");
            }
    }
    
    //Metodo para eliminar
    private String EliminarP(String list, String user, String contact)
    {
        List<IndiceClass> indice = ReadFileIndice();
        List<BloqueClass> bloque = ReadFileBloque();
        boolean flag = false;
        for (BloqueClass c : bloque) {
            if (c.nombre_lista.equals(list) && c.usuario.equals(user) && c.usuario_asociado.equals(contact)) {
                flag= true;
                c.estatus = false;
            }
        }
        if (flag == true) {
            File file = new File("C:/MEIA/indice.txt");
            File file2 = new File("C:/MEIA/lista_usuario.txt");
            file.delete();
            file2.delete();
            ReadFile rf = new ReadFile();
            rf.ValidateFile();
            
            for (IndiceClass c : indice) {
                if (c.nombre_lista.equals(list) && c.usuario.equals(user) && c.usuario_asociado.equals(contact)) {
                    c.estatus = false;
                }
            }
            
            FillIndice(indice);
            
             try
            {
                //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                FileWriter escribir = new FileWriter(file2, true);
                for (BloqueClass c: bloque) {
                    String insertContact = c.nombre_lista + "|";
                    insertContact = insertContact + c.usuario +"|";
                    insertContact = insertContact + c.usuario_asociado +"|";
                    insertContact = insertContact + c.descripcion +"|";
                    insertContact = insertContact + c.fecha_creacion +"|";
                    insertContact = insertContact + c.estatus;
                    escribir.write(insertContact+"\n");
                }              
                //Cerramos la conexion
                escribir.close();
                
                
            } //Si existe un problema al escribir cae aqui
            catch (Exception e) {
                System.out.println("Error al escribir bitacora_contactos");
            }
            RegApuntador(inicio,list,user,contact);
            return "Se elimino correctamente.";
        }
        else
        {
            return "No se encontraron coincidencias.";
        }
        
    }
    
    //metodo para eliminar a los de estado 0
    private List<IndiceClass> LimpiarIndice(List<IndiceClass> x)
    {
        List<IndiceClass> res = new ArrayList<IndiceClass>();
        
        for (IndiceClass c : x) {
            if (c.estatus == true) {
                res.add(c);
            }
        }
        
        
        return res;
    }
    
}
