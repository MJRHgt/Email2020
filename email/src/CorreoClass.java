
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author walte
 */
public class CorreoClass implements Comparable<CorreoClass>{
    public int No_Registro;
    public int Izq;
    public int Der;
    public String Usuario_emisor;
    public String Usuario_receptor;
    public String Fec_transac;
    public String Asunto;
    public String Mensaje;
    public String Adjunto;
    public boolean estatus;
    
    //method return data
    public String InsertData()
    {
        return No_Registro + "|" + Izq + "|" + Der + "|" + Usuario_emisor + "|" + Usuario_receptor + "|" + Fec_transac
                + "|" + Asunto  + "|" + Mensaje  + "|" + Adjunto + "|" + estatus;
    }
    
    @Override
    public int compareTo(CorreoClass o) {
        CorreoClass otro = (CorreoClass) o;
        String strDateFormat = "dd/MMM/aaaa hh: mm: ss a";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        Date date1 = null,date2 = null;
        try {
             date1 = objSDF.parse(Fec_transac);
             date2 = objSDF.parse(otro.Fec_transac);
        } catch (ParseException ex) {
            Logger.getLogger(CorreoClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int commparacionPorUser = Usuario_emisor.compareTo(otro.Usuario_emisor);
        if (commparacionPorUser != 0)
        {
            return commparacionPorUser;
        }
        
        int commparacionPorList = Usuario_receptor.compareTo(otro.Usuario_receptor);
        if (commparacionPorList != 0)
        {
            return commparacionPorList;
        }
            
        return date1.compareTo(date2);
    }
}
