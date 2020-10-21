import java.io.BufferedReader;
import java.io.File;
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
public class ListContact {
    
    //------------------------------- PUBLIC FUNCTIONS -------------------------------------------
    //var global
    int max_reorganizar = 3;
    
    public List<UserClass> AddListUser()
    {
        List<UserClass> users = new ArrayList<UserClass>();
        File fileUser = new File("C:/MEIA/usuario.txt");
        users = ReadFileUser(fileUser);
        return users;
    }
    
    public List<UserClass> AddListContact(String user)
    {
        List<UserClass> contact = new ArrayList<UserClass>();
        File fileContact = new File("C:/MEIA/contactos.txt");
        contact = ReadFileContact(fileContact,user);
        return contact;
    }
    
    public String AddContact(String Contact , String user)
    {
        String res = AddContactP(Contact, user);
        return res;
    }

    //------------------------------- PRIVATE FUNCTIONS -------------------------------------------    
    
    
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
  
    //Method for fill list with existing contact the user in the file
    private List<UserClass> ReadFileContact(File file, String user){
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
    
    //Metodo para agregar contacto
    private String AddContactP (String Contact , String user)
    {
        try 
        {
            //FALTA COLOCAR SI YA HAY MAS DE 3 O SI NO HAY Y DEPENDE DE ESO CAMBIAR LA FORMA DE HACERLO
            
           //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            File fileContact = new File("C:/MEIA/bitacora_contactos.txt");
            Date objDate = new Date();
            String strDateFormat = "dd/MMM/aaaa hh: mm: ss a";
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
            String fecha = objSDF.format(objDate);
            FileWriter escribir = new FileWriter(fileContact, true);
            String insertContact = user + "|";
            insertContact = insertContact + Contact +"|";
            insertContact = insertContact + fecha +"|";
            insertContact = insertContact + user +"|";
            insertContact = insertContact + "true";
            escribir.write(insertContact+"\n");
            //Cerramos la conexion
            escribir.close();
            //desc_bitacora
            AddBitacoraContact(user);
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir bitacora_contactos");
        }
        return "El usuario: " + user + " agrego con exito al contacto: " + Contact + ".";
    }
    
    //Metodo para agregar bitacora contacto
    private void AddBitacoraContact(String user)
    { 
        try 
        {
           //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            File fileContact = new File("C:/MEIA/desc_bitacora_contactos.txt");
            Date objDate = new Date();
            String strDateFormat = "dd/MMM/aaaa hh: mm: ss a";
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
            String fecha = objSDF.format(objDate);
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
                escribir.write("max_reorganizar:"+ max_reorganizar +"\n");
                //Cerramos la conexion
                escribir.close();
            }
            else
            {
                //FALTA AHORA LLENARLO SI LOS DATOS YA FUERON CREADOS POR PRIMERA VEZ
            }
            
        } //Si existe un problema al escribir cae aqui
        catch (Exception e) {
            System.out.println("Error al escribir desc_bitacora_contacto");
        }
    }
    
    //Metodo para obtner las lineas del documento de bitacora contacto
    
}
