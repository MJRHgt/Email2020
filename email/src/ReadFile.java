
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    
    
    //------------------------------- PRIVATE FUNCTIONS -------------------------------------------
    
    
    
    
}
