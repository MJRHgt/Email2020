
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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

            //FileWriter fw = new FileWriter(archivoUser);
            //BufferedWriter bw = new BufferedWriter(fw);
            //bw.write("asd");
            //bw.close();
            //Exist File desc_user
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
    public String InsertUser(String user, String name, String lastName, String pass, String date, String email, int tel, byte[] photoPath)
    {
        String res = "";
        res = InsertUser_P(user,name,lastName,pass,date,email,tel,photoPath);
        return res;
    }
    
    //------------------------------- PRIVATE FUNCTIONS -------------------------------------------
    
    //Method for insert user
    private String InsertUser_P(String user, String name, String lastName, String pass, String date, String email, int tel, byte[] photoPath)
    {
        //Validate file empty
        File fileUser = new File("C:/MEIA/usuario.txt");
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
            //luego usar el metodo isRepeatuser para verificar que no sea el mismo usuario
        }
        
        return "Se registro con exito.";
    }
    
    //Method for validate different user because this camp is primary key
    private boolean isRepeatUser(List<UserClass> userC, String userN)
    {
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
}
