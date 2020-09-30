
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 *
 * @author walte
 */
public class BackupClass {
    //------------------------------- PUBLIC FUNCTIONS --------------------------------------------
    
    //Method to do backup
    public String Backup_Public(String user, String pathRelative)
    {
        String res="";
        res = Backup_P(user, pathRelative);
        return res;
    }
    
    
    //------------------------------- PRIVATE FUNCTIONS -------------------------------------------
    
    //Method private for perform all backup steps
    private String Backup_P(String user, String pathRelative)
    {
        String res = "";      
        //Escribir en bitacora_backup.txt
        WriteBackuptxt(user,pathRelative);
        //Escribir en desc_bitacora_backup.txt
        WriteDesBackuptxt(user);
        //Copiar y pegar la carpeta MEIA en la ruta definida por el usuario
        BackupFull(pathRelative+"/MEIA_Backup");
        res = "Se realizo con exito el Backup.";
        return res;
    }
    
    //Method for copy and paste the directory MEIA
    private void BackupFull(String pathRelative)
    {
        ValidateCreateDictionary(pathRelative);
        String origen = "C:/MEIA";
        File directorio = new File(origen);
        File f;
        if (directorio.isDirectory()) {
            ValidateCreateDictionary(pathRelative);
            String [] files = directorio.list();
            if (files.length > 0) {
                for (String archivo : files) {
                    f = new File (origen + File.separator + archivo);
                    if(f.isDirectory()) {
                        ValidateCreateDictionary(pathRelative+File.separator+archivo+File.separator);
                        copyFile(origen+File.separator+archivo+File.separator, pathRelative+File.separator+archivo+File.separator);
                    } else { //Es un archivo
                        copyFile(origen+File.separator+archivo, pathRelative+File.separator+archivo);
                    }
                }
            }
        }
    }
    
    //Method for write in file Backup.txt
    private void WriteBackuptxt(String user, String pathRelative)
    {
        try 
        {
            Date objDate = new Date();
            String strDateFormat = "dd/MMM/aaaa hh: mm: ss a";
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
            String fecha = objSDF.format(objDate);
            String campos = pathRelative+"|"+user+"|"+fecha;
            File file = new File("C:/MEIA/bitacora_backup.txt");
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir = new FileWriter(file, true);
            escribir.write(campos+"\n");
            //Cerramos la conexion
            escribir.close();
            
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir backup");
        }
    }
    
    //Method for write in file descBackup.txt
    private void WriteDesBackuptxt(String user)
    {
     try 
        {
            Date objDate = new Date();
            String strDateFormat = "dd/MMM/aaaa hh: mm: ss a";
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
            String fecha = objSDF.format(objDate);
            String Registros="";
            File file = new File("C:/MEIA/desc_bitacora_backup.txt");
            //file empty
            if (file.length() == 0) 
            {
                //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                FileWriter escribir = new FileWriter(file, true);
                Registros = "1";
                escribir.write("nombre_simbólico: bitacora_backup"+"\n");//nombre_simbolico
                escribir.write("fecha_creación: "+fecha+"\n");//fecha_Creacion
                escribir.write("usuario_creación: "+user+"\n");//usuario_creacion
                escribir.write("fecha_modificación: "+fecha+"\n");//fecha_modificacion
                escribir.write("usuario_modificación: "+user+"\n");//usuario_modificacion
                escribir.write("#_registros:"+Registros+"\n");//#_Registros
                //Cerramos la conexion
                escribir.close();
            }
            else
            {
                String[] lista = DeleteLineFile();
                //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                FileWriter escribir = new FileWriter(file, true);
                for (int i = 0; i < 3; i++) {
                    escribir.write(lista[i]+"\n");
                }
                Registros = RegisterBackup(lista[5]);
                escribir.write("fecha_modificación: "+fecha+"\n");//fecha_modificacion
                escribir.write("usuario_modificación: "+user+"\n");//usuario_modificacion
                escribir.write("#_registros:"+Registros+"\n");//#_Registros
                //Cerramos la conexion
                escribir.close();
            }
            
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir desbackup");
        }
    }
    
    //Method for validate create directory
    private void ValidateCreateDictionary(String path)
    {
        File directorio = new File(path);
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
    }
    
    //Method for copy file
    private void copyFile(String sOrigen, String sDestino) {
        try {
            File origen = new File(sOrigen);
            File destino = new File(sDestino);
            InputStream in = new FileInputStream(origen);
            OutputStream out = new FileOutputStream(destino);

            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            in.close();
            out.close();

        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //Method delete line file
    private String[] DeleteLineFile()
    {
        String[] lineas = new String[6];
        File file = new File("C:/MEIA/desc_bitacora_backup.txt");
        FileReader fr = null;
        BufferedReader br = null;

        try {
           fr = new FileReader (file);
           br = new BufferedReader(fr);          
           // read the file
           String linea;
           int x = 0;
           while((linea=br.readLine())!=null)
           {
               lineas[x] = linea;
               x++;
           }
           fr.close();
        }
        catch(Exception e){
            System.out.println("linea error");
           e.printStackTrace();
        }
        
        file.delete();
        ReadFile rf = new ReadFile();
        rf.ValidateFile();
        
        return lineas;
    }
    
    //Method int register
    private String RegisterBackup(String x){
        String r = "";
        String[] a = x.split("\\:");
        int data = Integer.parseInt(a[1]);
        data++;
        r = String.valueOf(data);
        return r;
    }
    
}
