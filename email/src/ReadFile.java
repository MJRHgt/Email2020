import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;


/**
 *
 * @author walte
 */
public class ReadFile {
    
    //------------------------------- PUBLIC FUNCTIONS --------------------------------------------
    
    //Save photo
    FileInputStream in;
    FileOutputStream out;
     
    //Method create files in C:
    public void ValidateFile()
    {
        try {
            //Exist directory MEIA
            File directorio = new File("C:/MEIA");
            if (!directorio.exists()) {
                if (directorio.mkdirs()) {
                   // System.out.println("Directorio creado");
                } else {
                   // System.out.println("Error al crear directorio");
                }
            }
            //Exist directory fotografia
            File directorio2 = new File("C:/MEIA/fotografia");
            if (!directorio2.exists()) {
                if (directorio2.mkdirs()) {
                   // System.out.println("Directorio2 creado");
                } else {
                  //  System.out.println("Error al crear directorio2");
                }
            }
            //Exist File user
            File archivoUser = new File("C:/MEIA/usuario.txt");
            if (!archivoUser.exists())
            {
                archivoUser.createNewFile();
            }
            
            File archivoDescUser = new File("C:/MEIA/desc_usuario.txt");
            if (!archivoDescUser.exists())
            {
                archivoDescUser.createNewFile();
            }    
            
            //Exist File bitacora_backup
            File archivoBit_b = new File("C:/MEIA/bitacora_backup.txt");
            if (!archivoBit_b.exists())
            {
                archivoBit_b.createNewFile();
            }   
            //Exist File desc_bitacora_backup"
            File archivoDescBit_br = new File("C:/MEIA/desc_bitacora_backup.txt");
            if (!archivoDescBit_br.exists())
            {
                archivoDescBit_br.createNewFile();
            }   
            
            //Exist File bitacora_backup
            File archivoBit_user = new File("C:/MEIA/bitacora_usuario.txt");
            if (!archivoBit_user.exists())
            {
                archivoBit_user.createNewFile();
            }   
            
            //Exist File desc_bitacora_backup"
            File archivoDescBit_user = new File("C:/MEIA/desc_bitacora_usuario.txt");
            if (!archivoDescBit_user.exists())
            {
                archivoDescBit_user.createNewFile();
            }   
            
            //Exist File contactos"
            File archivoContactos = new File("C:/MEIA/contactos.txt");
            if (!archivoContactos.exists())
            {
                archivoContactos.createNewFile();
            }
            
            //Exist File bitacora_contactos"
            File archivoBit_contact = new File("C:/MEIA/bitacora_contactos.txt");
            if (!archivoBit_contact.exists())
            {
                archivoBit_contact.createNewFile();
            }
            
            //Exist File desc_contacto"
            File archivoDesc_Contactos = new File("C:/MEIA/desc_contactos.txt");
            if (!archivoDesc_Contactos.exists())
            {
                archivoDesc_Contactos.createNewFile();
            }
            
            //Exist File desc_bitacora_contactos"
            File archivoDescBit_Contactos = new File("C:/MEIA/desc_bitacora_contactos.txt");
            if (!archivoDescBit_Contactos.exists())
            {
                archivoDescBit_Contactos.createNewFile();
            }
            
            //Exist File lista"
            File archivoLista = new File("C:/MEIA/lista.txt");
            if (!archivoLista.exists())
            {
                archivoLista.createNewFile();
            }
            
            //Exist File bitacora_lista"
            File archivoBit_Lista = new File("C:/MEIA/bitacora_lista.txt");
            if (!archivoBit_Lista.exists())
            {
                archivoBit_Lista.createNewFile();
            }
            
            //Exist File desc_lista"
            File archivoDesc_Lista = new File("C:/MEIA/desc_lista.txt");
            if (!archivoDesc_Lista.exists())
            {
                archivoDesc_Lista.createNewFile();
            }
            
            //Exist File desc_bitacora_lista"
            File archivoDescBit_Lista = new File("C:/MEIA/desc_bitacora_lista.txt");
            if (!archivoDescBit_Lista.exists())
            {
                archivoDescBit_Lista.createNewFile();
            }
            
            //Exist File lista_usuario
            File archivoListaUsuario = new File("C:/MEIA/lista_usuario.txt");
            if (!archivoListaUsuario.exists())
            {
                archivoListaUsuario.createNewFile();
            }
            
            //Exist File desc_lista_usuario
            File archivoDesc_ListaUsuario = new File("C:/MEIA/desc_lista_usuario.txt");
            if (!archivoDesc_ListaUsuario.exists())
            {
                archivoDesc_ListaUsuario.createNewFile();
            }
            
            //Exist File indice
            File archivoIndice = new File("C:/MEIA/indice.txt");
            if (!archivoIndice.exists())
            {
                archivoIndice.createNewFile();
            }
            
            //Exist File desc_indice
            File archivoDescIndice = new File("C:/MEIA/desc_indice.txt");
            if (!archivoDescIndice.exists())
            {
                archivoDescIndice.createNewFile();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
     //Method for get photo
    public byte[] OpenFile (File file){
        byte[]photo = new byte[1024*100];
        try
        {
            in = new FileInputStream(file);
            in.read(photo);
        }
        catch(Exception e)
        {
        }
        return photo;
    }
    
    //Method for save photo
    public void SaveFile(String path, byte[]photo){
        try
        {
            File file = new File(path);
            out = new FileOutputStream(file);
            out.write(photo);
        }
        catch(Exception e)
        {
        }
    }
    
    //Method public for insert user
    public String InsertUser(String user, String name, String lastName, String pass, String date, String email, int tel, byte[] photoPath, boolean rol, boolean estatus)
    {
        String res = "";
        res = InsertUser_P(user,name,lastName,pass,date,email,tel,photoPath,rol,estatus);
        return res;
    }
    
    //Method public for modify user
    public String InsertUser2(String user, String pass, String date, String email, int tel, byte[] photoPath, boolean rol, boolean estatus)
    {
        String res = "";
        res = ModifyUser(user,pass,date,email,tel,photoPath,rol,estatus);
        return res;
    }
    
     //Method public for insert user
    public String InsertUser3(String UserL, String user, String name, String lastName, String pass, String date, String email, int tel, byte[] photoPath, boolean rol, boolean estatus)
    {
        String res = "";
        res = InsertUser_P2(UserL,user,name,lastName,pass,date,email,tel,photoPath,rol,estatus);
        return res;
    }
    
    //Method public for modify 2 user
    public String ModifyUser(String userL,String user, String name, String lastName, String pass, String date, String email, int tel, byte[] photoPath, boolean rol, boolean estatus)
    {
        String res = "";
        res = ModifyUser2(userL,user,name,lastName,pass,date,email,tel,photoPath,rol,estatus);
        return res;
    }
    
    //Method public login
    public String Login(String user, String password)
    {
        String res = "";
        res = Login_V(user,password);
        return res;
    }
    
    //Method public darse de baja
    public boolean DropOut(String user)
    {
        boolean isAdmin = true;
        File file = new File("C:/MEIA/usuario.txt");
        List<UserClass> users = ReadFileUser(file);
        file.delete();
        ValidateFile();
        
        for (UserClass uc:users) {
            if (uc.user.equals(user) && uc.rol == false) {
                uc.estatus = false;
                isAdmin= false;
                Insert(uc,file);
            }
            else
            {
                Insert(uc,file);
            }
        }

        return isAdmin;
    }
    
    public boolean isUser(String user)
    {
        File file = new File("C:/MEIA/usuario.txt");
        List<UserClass> users = ReadFileUser(file);
        for (UserClass uc:users) {
            if (uc.user.equals(user)) {
                return true;
            }
        }
        return false;
    }
    
    public UserClass DataUser(String user)
    {
        File file = new File("C:/MEIA/usuario.txt");
        UserClass userN = new UserClass();
        List<UserClass> users = ReadFileUser(file);
        for (UserClass uc:users) {
            if (uc.user.equals(user)) {
                userN=uc;
            }
        }
        return userN;
    }
    
    //------------------------------- PRIVATE FUNCTIONS -------------------------------------------
    
    //Method for insert user
    private String InsertUser_P(String user, String name, String lastName, String pass, String date, String email, int tel, byte[] photoPath,  boolean rol, boolean estatus)
    {
        //Validate file empty
        File fileUser = new File("C:/MEIA/usuario.txt");
        List<UserClass> users ;
        if (fileUser.length() == 0) {
            UserClass userC = new UserClass();
            userC.user = "admin";
            userC.name = name;
            userC.lastName = lastName;
            userC.password = pass;
            userC.date = date;
            userC.email = email;
            userC.number = tel;
            userC.photoPath = "C:/MEIA/fotografia/admin.jpeg";//+user+".jpeg";
            userC.rol = true;//first admin
            userC.estatus = true; //vigente
            Insert(userC, fileUser);
            SaveFile(userC.photoPath,photoPath);
            //crear metodo para insertar en desc_user.txt
            InsertDescUser(user,user,"1","1","0");
        }
        else
        {
            //crear una lista de tipo UserClass que obtenga todos los valores del user.txt con un metodo privado 
            users = ReadFileUser(fileUser);
            //luego usar el metodo isRepeatuser para verificar que no sea el mismo usuario
            if (!isRepeatUser(users,user)) 
            {
                UserClass userC = new UserClass();
                userC.user = user;
                userC.name = name;
                userC.lastName = lastName;
                userC.password = pass;
                userC.date = date;
                userC.email = email;
                userC.number = tel;
                userC.photoPath = "C:/MEIA/fotografia/"+user+".jpeg";//+user+".jpeg";
                userC.rol = rol;//first admin
                userC.estatus = estatus; //vigente
                Insert(userC, fileUser);
                SaveFile(userC.photoPath,photoPath);
                //crear metodo para insertar en desc_user.txt
                String[] R= RegistroTxt();
                InsertDescUser(user,user,R[0],R[1],R[2]);
            }
            else
            {
                return "El usuario '"+user+"' ya existe.";          
            }
        }
        
        return "Se registro con exito.";
    }
    
    //Method for validate different user because this camp is primary key
    private boolean isRepeatUser(List<UserClass> userC, String userN)
    {
        //scroll list
        for (UserClass uc:userC) {
            if (uc.user.equals(userN)) 
            {
                return true;
            }
        }
        return false;
    }
    
    private void Insert(UserClass userC, File file)
    {
        try 
        {
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(file, true);
            escribir.write(userC.InsertData()+"\n");
            //Cerramos la conexion
            escribir.close();
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
    
    //Method for fill list with existing users in the file
    private List<UserClass> ReadFileUser(File file){
        List<UserClass> users = new ArrayList<UserClass>();
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
               String[] userChar = linea.split(separador);
               UserClass userC = new UserClass();
               userC.user = userChar[0];
               userC.name = userChar[1];
               userC.lastName = userChar[2];
               userC.password = userChar[3];
               userC.rol = Boolean.parseBoolean(userChar[4]);//first admin
               userC.date = userChar[5];
               userC.email = userChar[6];
               userC.number = Integer.parseInt(userChar[7]);
               userC.photoPath = userChar[8];//+user+".jpeg";             
               userC.estatus = Boolean.parseBoolean(userChar[9]); //vigente
               users.add(userC);
           }
           fr.close();
        }
        catch(Exception e){
            System.out.println("linea error");
           e.printStackTrace();
        }
        
        return users;
    }
  
    //Method for validate login
    private String Login_V(String user, String password){
        //var
        String res="";
        List<UserClass> users ;
        File fileUser = new File("C:/MEIA/usuario.txt");
        users = ReadFileUser(fileUser);
        boolean flag_Exist=false;
        Password passClass = new Password();
        
        //Exist users
         if (fileUser.length() == 0) 
         {
            res = "archivo vacio";
         }
         else
         {
             //Exist user - scroll list
            for (UserClass uc:users) 
            {
                if (uc.user.equals(user)) 
                {
                    flag_Exist = true;
                    String pass = passClass.P_dencode("meia", uc.password);
                    if (pass.equals(password)) {
                        if (uc.estatus == true) {
                            if (uc.rol == true) {
                                res = "admin";
                            }
                            else
                            {
                                res = "usuario";
                            }
                        }
                        else
                        {
                            res = "Su cuenta no se encuentra vigente.";
                        }
                    }
                    else
                    {
                        res = "Contraseña incorrecta.";
                    }
                }
            }
            if (flag_Exist == false) 
            {
                res = "El ususario no existe.";
            }
         }
        return res;
    }
    
    //method modify
    private String ModifyUser(String user, String pass, String date, String email, int tel, byte[] photoPath, boolean rol, boolean estatus)
    {
        File file = new File("C:/MEIA/usuario.txt");
        List<UserClass> users = ReadFileUser(file);
        file.delete();
        ValidateFile();
        
        for (UserClass uc:users) {
            if (uc.user.equals(user)) {
                uc.password = pass;
                uc.date = date;
                uc.email = email;
                uc.number = tel;
                Insert(uc,file);
                SaveFile(uc.photoPath,photoPath);
            }
            else
            {
                Insert(uc,file);
            }
            

        }
        
        String[] R= RegistroTxt();
        InsertDescUser(user,user,R[0],R[1],R[2]);             
        return "Modificado con exito.";
    }
    
    //method modify
    private String ModifyUser2(String userL,String user, String name, String lastName, String pass, String date, String email, int tel, byte[] photoPath, boolean rol, boolean estatus)
    {
        File file = new File("C:/MEIA/usuario.txt");
        List<UserClass> users = ReadFileUser(file);
        file.delete();
        ValidateFile();
        
       for (UserClass uc:users) {
            if (uc.user.equals(user)) {
                uc.user = user;
                uc.name = name;
                uc.lastName = lastName;
                uc.password = pass;
                uc.date = date;
                uc.email = email;
                uc.number = tel;
                Insert(uc,file);
                SaveFile(uc.photoPath,photoPath);
            }
            else
            {
                Insert(uc,file);
            }
            
        }
        
        String[] R= RegistroTxt();
        InsertDescUser(userL,userL,R[0],R[1],R[2]);             
        return "Modificado con exito.";
    }
    
    //Method for insert user
    private String InsertUser_P2(String UserL, String user, String name, String lastName, String pass, String date, String email, int tel, byte[] photoPath,  boolean rol, boolean estatus)
    {
        //Validate file empty
        File fileUser = new File("C:/MEIA/usuario.txt");
        List<UserClass> users ;
        if (fileUser.length() == 0) {
            UserClass userC = new UserClass();
            userC.user = "admin";
            userC.name = name;
            userC.lastName = lastName;
            userC.password = pass;
            userC.date = date;
            userC.email = email;
            userC.number = tel;
            userC.photoPath = "C:/MEIA/fotografia/admin.jpeg";//+user+".jpeg";
            userC.rol = true;//first admin
            userC.estatus = true; //vigente
            Insert(userC, fileUser);
            SaveFile(userC.photoPath,photoPath);
            //crear metodo para insertar en desc_user.txt
            String[] R= RegistroTxt();
            InsertDescUser(UserL,UserL,R[0],R[1],R[2]);
        }
        else
        {
            //crear una lista de tipo UserClass que obtenga todos los valores del user.txt con un metodo privado 
            users = ReadFileUser(fileUser);
            //luego usar el metodo isRepeatuser para verificar que no sea el mismo usuario
            if (!isRepeatUser(users,user)) 
            {
                UserClass userC = new UserClass();
                userC.user = user;
                userC.name = name;
                userC.lastName = lastName;
                userC.password = pass;
                userC.date = date;
                userC.email = email;
                userC.number = tel;
                userC.photoPath = "C:/MEIA/fotografia/"+user+".jpeg";//+user+".jpeg";
                userC.rol = rol;//first admin
                userC.estatus = estatus; //vigente
                Insert(userC, fileUser);
                SaveFile(userC.photoPath,photoPath);
                //crear metodo para insertar en desc_user.txt
                String[] R= RegistroTxt();
                InsertDescUser(UserL,UserL,R[0],R[1],R[2]);
            }
            else
            {
                return "El usuario '"+user+"' ya existe.";          
            }
        }
        
        return "Se registro con exito.";
    }
    
    //Method for insert desc_user
    private void InsertDescUser(String UserC, String UserM,String Registros, String RA, String RI)
    {
        try 
        {
            File file = new File("C:/MEIA/desc_usuario.txt");
            Date objDate = new Date();
            String strDateFormat = "dd/MMM/aaaa hh: mm: ss a";
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
            String fecha = objSDF.format(objDate);
            //validar primera insercion
            if (file.length() == 0) {               
                //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                FileWriter escribir = new FileWriter(file, true);
                escribir.write("nombre_simbolico: Usuario"+"\n");
                escribir.write("fecha_creación: "+fecha+"\n");
                escribir.write("usuario_creación: admin"+"\n");
                escribir.write("fecha_modificación: "+fecha+"\n");
                escribir.write("usuario_modificación: admin"+"\n");
                escribir.write("#_registros: "+Registros+"\n");
                escribir.write("Registros_activos: "+RA+"\n");
                escribir.write("Registros_inactivos: "+RI+"\n");
                //Cerramos la conexion
                escribir.close();
            }
            else
            {
                String[] dato = DataDescUser();
                FileWriter escribir = new FileWriter(file, true);
                escribir.write(dato[0]+"\n");
                escribir.write(dato[1]+"\n");
                escribir.write(dato[2]+"\n");
                escribir.write("fecha_modificación: "+fecha+"\n");
                escribir.write("usuario_modificación: "+UserM+"\n");
                escribir.write("#_registros: "+Registros+"\n");
                escribir.write("Registros_activos: "+RA+"\n");
                escribir.write("Registros_inactivos: "+RI+"\n");
                //Cerramos la conexion
                escribir.close();
            }
            
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir desc_user");
        }
    }
    
    //Method for get Registros
    private String[] RegistroTxt()
    {
        String[] R = new String[3];
        File file = new File("C:/MEIA/usuario.txt");
        List<UserClass> users = ReadFileUser(file);
        int a=0;
        int i=0;
        R[0] = Integer.toString(users.size());
        
        for (UserClass uc: users) {
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
    
    //Method for get data the desc_user
    private String[] DataDescUser ()
    {
        String[]  d = new String[3];
        File file = new File("C:/MEIA/desc_usuario.txt");
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
        ValidateFile();
        
        return d;
    }
    
    
    
}
