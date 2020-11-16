
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
    
     //Method for get photo
    public byte[] OpenFile (File file){
        byte[]photo = new byte[1024*10000];
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
    
    //------------------------------- PRIVATE FUNCTIONS -------------------------------------------
    
    //Metodo para enviar un correo a un usuario en especifico
    private String ContactCorreo(String user, String contact, String asunto, String mensaje, String pathArchivo, byte[] archivo)
    {
        String res = "";
        String path = "";
        ABClass root = null;
        //obtener fecha de cuando se envio el correo
        Date objDate = new Date();
        String strDateFormat = "dd/MMM/aaaa hh: mm: ss a";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        String fecha = objSDF.format(objDate);
        File file = new File("C:/MEIA/arbolbinario.txt");
        //preguntar si el archivo no esta vacio 
        if (pathArchivo.length() > 0) {
            path = GetPathArchivo(pathArchivo,user,contact);
            SaveFile(path,archivo);//guardo archivo en la carpeta respectiva
        }
        //Arreglar si el mensaje viene con enter para no afectar el txt
        mensaje = FixMessage(mensaje);    
        //preguntar si el archivo desc_bitenviarcorreo esta vacio
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
            DescArbolBinario(user,fecha); 
        }
        else
        {
            //lectura del archivo
            List<CorreoClass> correos = FillArbolBinario();
            //crear arbol
            int x = 0;
            for (CorreoClass c : correos) {
                if (x == 0) {
                    root = new ABClass(c);
                    x++;
                }
                else
                {
                    root.add(c);
                }
            }
            //asginar nodo
            CorreoClass newCorreo = new CorreoClass();
            newCorreo.No_Registro = RegistroNo(correos);
            newCorreo.Izq = -1;
            newCorreo.Der = -1;
            newCorreo.Usuario_emisor = user;
            newCorreo.Usuario_receptor = contact;
            newCorreo.Fec_transac = fecha;
            newCorreo.Asunto = asunto;
            newCorreo.Mensaje = mensaje;
            newCorreo.Adjunto = path;
            newCorreo.estatus = true;
            //guardar datos
            root.add2(newCorreo);
            //eliminar archivo
            file.delete();
            ReadFile rf = new ReadFile();
            rf.ValidateFile();
            //insertamos el nuevo nodo
                
            //insertar en orden de registro en el archivo
            
                //luego se inserta en el archivo 
                try 
                {
                   //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                   FileWriter escribir2 = new FileWriter(file, true);
                   for (CorreoClass c : correos) {
                   escribir2.write(c.InsertData()+"\n");
                   }
                   escribir2.write(newCorreo.InsertData()+"\n");
                   //Cerramos la conexion
                   escribir2.close();
                } //Si existe un problema al escribir cae aqui
                catch (Exception e) {
                   System.out.println("Error al escribir en enviar correo");
                }
            
            //luego se coloca el descriptor
            DescArbolBinario(user,fecha);
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
        
        if (contactosLsita.size() > 0) {
            for (String c : contactosLsita) {
            res = res + ContactCorreo(user,c,asunto,mensaje,pathArchivo,archivo);
            }            
        }
        else
        {
            res = "No hay contactos agregados a esa lista";
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
   private String GetPathArchivo(String path,String user,String contact)
   {
       String newPath = "C:/MEIA/archivos/";
       StringBuilder builder=new StringBuilder(path);
       String pathR = builder.reverse().toString();//vuelta a la cadena
       String nombreFile = "";
       String diagonal = "\\";
       int diag = diagonal.charAt(0);
       for (int i = 0 ; i < pathR.length(); i++) {
           int x = pathR.charAt(i);
           if ( x != diag) {
               nombreFile = nombreFile + pathR.charAt(i);
           }
           else
           {
               i = pathR.length();
           }
       }
       StringBuilder builder2 =new StringBuilder(nombreFile);
       String nombreFileR = builder2.reverse().toString();//vuelta a la cadena
       newPath = newPath + user + "_" + contact + "_" + nombreFileR;
       return newPath;
   }
    
   //Metodo para insertar en el descriptor del archivo arbol binario
   private void DescArbolBinario(String user, String fecha)
   {
        try 
        {
           //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            File fileContact = new File("C:/MEIA/desc_arbolbinario.txt");
            //archivo vacio
            if (fileContact.length() == 0) {
                FileWriter escribir = new FileWriter(fileContact, true);
                escribir.write("nombre_simbolico:desc_arbolbinario"+"\n");
                escribir.write("fecha_creacion:"+fecha+"\n");
                escribir.write("usuario_creacion:admin"+"\n");
                escribir.write("fecha_modificacion:"+fecha+"\n");
                escribir.write("usuario_modificacion:"+user+"\n");
                escribir.write("#_registros:1"+"\n");
                escribir.write("registros_activos:1"+"\n");
                escribir.write("registros_inactivos:0"+"\n");
                //Cerramos la conexion
                escribir.close();
            }
            else
            {
                //FALTA AHORA LLENARLO SI LOS DATOS YA FUERON CREADOS POR PRIMERA VEZ
                String[] datos = DescBitCont();
                String[] registro = RegistroContacto();
                FileWriter escribir = new FileWriter(fileContact, true);
                escribir.write(datos[0]+"\n");
                escribir.write(datos[1]+"\n");
                escribir.write(datos[2]+"\n");
                escribir.write("fecha_modificacion:"+fecha+"\n");
                escribir.write("usuario_modificacion:"+user+"\n");
                escribir.write("#_registros:"+registro[0]+"\n");
                escribir.write("registros_activos:"+registro[1]+"\n");
                escribir.write("registros_inactivos:"+registro[2]+"\n");
                //Cerramos la conexion
                escribir.close();              
            }
            
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir desc_arbolbinario");
        }
   }
   
   //Metodo para obtner las lineas del documento de desc arbol binario
    private String[] DescBitCont()
    {
        String[] d = new String[8];
        File file = new File("C:/MEIA/desc_arbolbinario.txt");
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
   
   //Metodo para saber el registro de los contactos
    private String[] RegistroContacto()
    {
        String[] R = new String[3];
        List<CorreoClass> contact = FillArbolBinario();
        int a=0;
        int i=0;
        R[0] = Integer.toString(contact.size());
        
        for (CorreoClass uc: contact) {
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
    
   //Metodo para arreglar el mensaje y no tener enter dentro del mismo 
   private String FixMessage(String cadena)
   {
       return cadena.replaceAll("\n", " ");
   }
   
   //Metodo para la lectura del archivo de arbol binario
   private List<CorreoClass> FillArbolBinario()
   {
        List<CorreoClass> correo = new ArrayList<CorreoClass>();    
        File file = new File("C:/MEIA/arbolbinario.txt");
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
               CorreoClass correoC = new CorreoClass();
               correoC.No_Registro = Integer.parseInt(userChar[0]);    
               correoC.Izq = Integer.parseInt(userChar[1]); 
               correoC.Der = Integer.parseInt(userChar[2]); 
               correoC.Usuario_emisor = userChar[3];
               correoC.Usuario_receptor = userChar[4];
               correoC.Fec_transac = userChar[5];
               correoC.Asunto = userChar[6];
               correoC.Mensaje = userChar[7];
               correoC.Adjunto = userChar[8];
               correoC.estatus = Boolean.parseBoolean(userChar[9]); //vigente
               correo.add(correoC);
           }
           fr.close();
        }
        catch(Exception e){
            System.out.println("linea error");
           e.printStackTrace();
        }
       
       return correo;
   }
 
   //metodo obtener numero de registro
   private int RegistroNo(List<CorreoClass> correo)
   {
       int num = 0;
       for (CorreoClass c: correo) {
           if (num < c.No_Registro) {
               num = c.No_Registro;
           }
       }
       return num+1;
   }
}
