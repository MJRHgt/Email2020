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
    
    public void Regorganizar_Contact(String user)
    {
        Regorganizar_bit_contactos(user);
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
           //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            File fileContact = new File("C:/MEIA/bitacora_contactos.txt");
            Date objDate = new Date();
            String strDateFormat = "dd/MMM/aaaa hh: mm: ss a";
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
            String fecha = objSDF.format(objDate);
            List<ContactClass> bitContactos = ReadFileContact(fileContact);
            if (bitContactos.size() < max_reorganizar) {
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
            }
            else
            {
                Regorganizar_Contact(user);
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
            }
            
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
                String[] datos = DescBitCont();
                File file = new File("C:/MEIA/bitacora_contactos.txt");
                String[] registro =RegistroContacto(file);
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
    
    //Metodo para obtner las lineas del documento de bitacora contacto
    private String[] DescBitCont()
    {
        String[] d = new String[9];
         File file = new File("C:/MEIA/desc_bitacora_contactos.txt");
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
    private String[] RegistroContacto(File file)
    {
        String[] R = new String[3];
        List<ContactClass> contact = ReadFileContact(file);
        int a=0;
        int i=0;
        R[0] = Integer.toString(contact.size());
        
        for (ContactClass uc: contact) {
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
    
    //Method for fill list with existing users in the file
    private List<ContactClass> ReadFileContact(File file){
        List<ContactClass> contact = new ArrayList<ContactClass>();
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
               ContactClass contactC = new ContactClass();
               contactC.user = userChar[0];
               contactC.contact = userChar[1];
               contactC.date = userChar[2];    
               contactC.user_trans = userChar[3];
               contactC.estatus = Boolean.parseBoolean(userChar[4]); //vigente
               contact.add(contactC);
           }
           fr.close();
        }
        catch(Exception e){
            System.out.println("linea error");
           e.printStackTrace();
        }
        
        return contact;
    }
    
    //Metodo para reorganizar el archivo bit_contactos
    private void Regorganizar_bit_contactos(String user)
    {
        //Guardar los datos de bitacora
        //Guardar los datos de deesc_bitacora
        //Limpiar el archivo bitacora
        //Cambio el archivo de desc_bitacora
        //inserto en contactos
        //inserto en desc_contactos
    }
    
}
