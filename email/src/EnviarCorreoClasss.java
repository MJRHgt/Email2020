
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 *
 * @author walte
 */
public class EnviarCorreoClasss {
    
    FileInputStream in;
    FileOutputStream out;
    int Reorganizacion = 3;
    
    //------------------------------- PUBLIC FUNCTIONS -------------------------------------------
    
    public String EnviaCorreo(boolean Metodo,String user, String contacto, String lista, String asunto, String mensaje, String archivo,byte[] file)
    {
        String res = "";
        if (Metodo) {
            //Ingreso por medio de un contacto           
            res = ContactCorreo(user,contacto,asunto,mensaje,archivo,file);
        }else
        {
            //Ingreso por medio de una lista
            res = ListCorreo(user,lista,asunto,mensaje,archivo,file);
        }
        return res;
    }
    
    //------------------------------- PRIVATE FUNCTIONS -------------------------------------------
    
    //Metodo para enviar un correo a un usuario en especifico
    private String ContactCorreo(String user, String contact, String asunto, String mensaje, String pathArchivo, byte[] archivo)
    {
        String res = "";
        String path = "";
        //obtener fecha de cuando se envio el correo
        Date objDate = new Date();
        String strDateFormat = "dd/MMM/aaaa hh: mm: ss a";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        String fecha = objSDF.format(objDate);
        //preguntar si el archivo no esta vacio 
        if (pathArchivo.length() > 0) {
             path = GetPathArchivo(pathArchivo,user,contact,fecha);
            SaveFile(path,archivo);//guardo archivo en la carpeta respectiva
        }
        //Arreglar si el mensaje viene con enter para no afectar el txt
        
        //FALTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
        
        //preguntar si el archivo desc_bitenviarcorreo esta vacio
        File file = new File("C:/MEIA/arbolbinario.txt");
        if (file.length() == 0) {
            //Es el primero que se ingresa
            //se asigna como valor inicial nodo raiz
            CorreoClass newCorreo = new CorreoClass();
            newCorreo.No_Registro = 0;
            newCorreo.Izq = -1;
            newCorreo.Der = -1;
            newCorreo.Usuario_emisor = user;
            newCorreo.Usuario_receptor = contact;
            newCorreo.Fec_transac = fecha;
            newCorreo.Asunto = asunto;
            newCorreo.Mensaje = mensaje;
            newCorreo.Adjunto = path;
            newCorreo.estatus = true;
            //luego se inserta en el archivo 
             try 
            {
                //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                FileWriter escribir = new FileWriter(file, true);
                escribir.write(newCorreo.InsertData()+"\n");
                //Cerramos la conexion
                escribir.close();
            } //Si existe un problema al escribir cae aqui
            catch (Exception e) {
                System.out.println("Error al escribir");
            }
            //luego se coloca el descriptor
            DescArbolBinario(user,fecha); //ARREGLAR METODO
        }
        else
        {
            //preguntar cuantos hay guardados antes de reorganizar
        }
    
        return res;
    }
    
    //metodo para enviar a todos los contactos de una lista el correo
    private String ListCorreo(String user, String list, String asunto, String mensaje, String pathArchivo, byte[] archivo)
    {
        String res = "";
        List<IndiceClass> indice = ReadFileIndice();
        List<String> contactosLsita = new ArrayList<String>();
        for (IndiceClass c : indice) {
            if (c.nombre_lista.equals(list) && c.usuario.equals(user)) {
                contactosLsita.add(c.usuario_asociado);
            }
        }
        
        for (String c : contactosLsita) {
            res = res + ContactCorreo(user,c,asunto,mensaje,pathArchivo,archivo);
        }
        
        return res;
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
       
    //Method for save file
    private void SaveFile(String path, byte[]archivo){
        try
        {
            File file = new File(path);
            out = new FileOutputStream(file);
            out.write(archivo);
        }
        catch(Exception e)
        {
        }
    }
    
    //Metodo para obtener la direccion donde se guardara el archivo
   private String GetPathArchivo(String path,String user,String contact, String fecha)
   {
       String newPath = "C:/MEIA/archivos/";
       StringBuilder builder=new StringBuilder(path);
       String pathR = builder.reverse().toString();//vuelta a la cadena
       String nombreFile = "";
       for (int i = 0 ; i < pathR.length(); i++) {
           if (pathR.charAt(i) != '/') {
               nombreFile = nombreFile + pathR.charAt(i);
           }
           else
           {
               i = pathR.length();
           }
       }
       StringBuilder builder2 =new StringBuilder(nombreFile);
       String nombreFileR = builder2.reverse().toString();//vuelta a la cadena
       newPath = newPath + user + "_" + contact + "_" + fecha + "_"+ nombreFileR;
       return newPath;
   }
    
   //Metodo para insertar en el descriptor del archivo arbol binario
   private void DescArbolBinario(String user, String fecha)
   {
        try 
        {
           //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            File fileContact = new File("C:/MEIA/desc_bitacora_contactos.txt");
            //archivo vacio
            if (fileContact.length() == 0) {
                FileWriter escribir = new FileWriter(fileContact, true);
                escribir.write("nombre_simbolico:desc_bitacora_contactos"+"\n");
                escribir.write("fecha_creacion:"+fecha+"\n");
                escribir.write("usuario_creacion:admin"+"\n");
                escribir.write("fecha_modificacion:"+fecha+"\n");
                escribir.write("usuario_modificacion:"+user+"\n");
                escribir.write("#_registros:1"+"\n");
                escribir.write("registros_activos:1"+"\n");
                escribir.write("registros_inactivos:0"+"\n");
                escribir.write("max_reorganizar:"+ Reorganizacion +"\n");
                //Cerramos la conexion
                escribir.close();
            }
            else
            {
                //FALTA AHORA LLENARLO SI LOS DATOS YA FUERON CREADOS POR PRIMERA VEZ
                String[] datos = new String[1];//DescBitCont();
                File file = new File("C:/MEIA/bitacora_contactos.txt");
                String[] registro = new String[1];//RegistroContacto(file);
                FileWriter escribir = new FileWriter(fileContact, true);
                escribir.write(datos[0]+"\n");
                escribir.write(datos[1]+"\n");
                escribir.write(datos[2]+"\n");
                escribir.write("fecha_modificacion:"+fecha+"\n");
                escribir.write("usuario_modificacion:"+user+"\n");
                escribir.write("#_registros:"+registro[0]+"\n");
                escribir.write("registros_activos:"+registro[1]+"\n");
                escribir.write("registros_inactivos:"+registro[2]+"\n");
                escribir.write(datos[8]+"\n");
                //Cerramos la conexion
                escribir.close();              
            }
            
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir desc_bitacora_contacto");
        }
   }
   
   
}
