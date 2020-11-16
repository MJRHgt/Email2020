import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hichi
 */
public class BandejaCorreo {
    
    // Método para buscar los correos enviados por un usuario específico
    public List<CorreoClass> SearchSentEmails(String username)
    {
        List<CorreoClass> correosEnviados = new ArrayList<CorreoClass>();
        List<CorreoClass> totalCorreos = new ArrayList<CorreoClass>(); 
        
        totalCorreos = FillArbolBinario();
        
        for (CorreoClass cc:totalCorreos) {
            if (cc.Usuario_emisor.equals(username)) {
                correosEnviados.add(cc);
            }
        }
        
        return correosEnviados;
    }
    
    // Método para buscar los correos recibidos por un usuario específico
    public List<CorreoClass> SearchRecievedEmails(String username)
    {
        List<CorreoClass> correosRecibidos = new ArrayList<CorreoClass>();
        List<CorreoClass> totalCorreos = new ArrayList<CorreoClass>(); 
        
        totalCorreos = FillArbolBinario();
        
        for (CorreoClass cc:totalCorreos) {
            if (cc.Usuario_receptor.equals(username)) {
                correosRecibidos.add(cc);
            }
        }
        
        return correosRecibidos;
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
}
