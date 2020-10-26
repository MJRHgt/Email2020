
/**
 *
 * @author walte
 */
public class IndiceClass implements Comparable<IndiceClass>{
    public int registro;
    public double posicion;
    public String nombre_lista;
    public String usuario;
    public String usuario_asociado;
    public int apuntador;
    public boolean estatus;
    
    @Override
    public int compareTo(IndiceClass o) {
        IndiceClass otro = (IndiceClass) o;
        
        int commparacionPorUser = nombre_lista.compareTo(otro.nombre_lista);
        if (commparacionPorUser != 0)
        {
            return commparacionPorUser;
        }
        
        int commparacionPorList = usuario.compareTo(otro.usuario);
        if (commparacionPorList != 0)
        {
            return commparacionPorList;
        }
            
        return usuario_asociado.compareTo(otro.usuario_asociado);
    }
    
    
}
