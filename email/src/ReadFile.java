
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
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
                    System.out.println("Directorio creado");
                } else {
                    System.out.println("Error al crear directorio");
                }
            }
            //Exist directory fotografia
            File directorio2 = new File("C:/MEIA/fotografia");
            if (!directorio2.exists()) {
                if (directorio2.mkdirs()) {
                    System.out.println("Directorio2 creado");
                } else {
                    System.out.println("Error al crear directorio2");
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
    public String SaveFile(File file, byte[]photo){
        String message = null;
        try
        {
            out = new FileOutputStream(file);
            out.write(photo);
            message = "Succesful";
        }
        catch(Exception e)
        {
        }
        return message;
    }
    
    //Method public for insert user
    public String InsertUser(String user, String name, String lastName, String pass, String date, String email, int tel, byte[] photoPath)
    {
        String res = "";
        res = ValidateUser(user,name,lastName,pass,date,email,tel,photoPath);
        return res;
    }
    
    //------------------------------- PRIVATE FUNCTIONS -------------------------------------------
    
    //Method for insert user
    private String ValidateUser(String user, String name, String lastName, String pass, String date, String email, int tel, byte[] photoPath)
    {
        String res = "";
        if (!user.equals("")) {
            if (!name.equals("")) {
                if (!lastName.equals("")) {
                    if (!date.equals("")) {
                        if (!email.equals("")) {
                            if (tel != 0) {
                                if (photoPath!= null) {
                                    res =  InsertUser_P(user,name,lastName,pass,date,email,tel,photoPath);           
                                }
                                else
                                    res = "Campo fotografia se encuentra vacio.";                               
                            }
                            else
                                res = "Campo telefono se encuentra vacio.";            
                        }
                        else
                            res = "Campo email se encuentra vacio.";            
                    }
                    else
                        res = "Campo nacimiento se encuentra vacio.";         
                }
                else
                    res = "Campo apellido se encuentra vacio.";           
            }
            else
                res = "Campo nombre se encuentra vacio.";        
        }
        else
            res = "Campo usuario se encuentra vacio.";
        
        return res;
    }
    
    //Method for insert user
    private String InsertUser_P(String user, String name, String lastName, String pass, String date, String email, int tel, byte[] photoPath)
    {
        return "Se registro con exito.";
    }
    
}
