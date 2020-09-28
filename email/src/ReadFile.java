
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
    
    //Method public for insert user
    public String InsertUser2(String user, String pass, String date, String email, int tel, byte[] photoPath, boolean rol, boolean estatus)
    {
        String res = "";
        //res = InsertUser_P(user,name,lastName,pass,date,email,tel,photoPath,rol,estatus);
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
    public void DropOut(String user)
    {
    
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
    
    
}
