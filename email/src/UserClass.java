
/**
 *
 * @author walte
 */
public class UserClass {
    
    public String user;
    public String name;
    public String lastName;
    public String password;
    public boolean rol; //admin = 1
    public String date;
    public String email;
    public int number;
    public String photoPath;
    public boolean estatus; //vigente = 1
    
    //method return data
    public String InsertData()
    {
        return user + "|" + name + "|" + lastName + "|" + password + "|" + rol + "|" + date + "|" + email  + "|" 
                + number  + "|" + photoPath + "|" + estatus;
    }
    
}
