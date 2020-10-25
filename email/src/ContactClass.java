
/**
 *
 * @author walte
 */
public class ContactClass implements Comparable<ContactClass>{
    public String user;
    public String contact;
    public String date;
    public String user_trans;
    public boolean estatus;
       
    @Override
    public int compareTo(ContactClass o) {
        ContactClass otro = (ContactClass) o;
        int commparacionPorUser = user.compareTo(otro.user);

        if (commparacionPorUser != 0)
            return commparacionPorUser;

        return contact.compareTo(otro.contact);
    }

}
