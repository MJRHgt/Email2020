
/**
 *
 * @author walte
 */
public class ABClass {
    //Arbol binario Class
    private CorreoClass value;
    private ABClass left;
    private ABClass right;
    private CorreoClass UltimoVal;
    
    //Metodos constructores
    public ABClass (CorreoClass value) {
        this.value = value;
    }
 
    public CorreoClass getValue() {
        return value;
    }
 
    public void setValue(CorreoClass value) {
        this.value = value;
    }
 
    public ABClass getLeft() {
        return left;
    }
 
    public void setLeft(ABClass left) {
        this.left = left;
    }
 
    public ABClass getRight() {
        return right;
    }
 
    public void setRight(ABClass right) {
        this.right = right;
    }
 
    //metodos para agregar al arbol nodos
    public void add(CorreoClass value) {
        if (value.compareTo(this.value) < 0) {
            if (left != null) {
                left.add(value);
            } else {
                left = new ABClass(value);
            }
        } else {
            if (right != null) {
                right.add(value);
            } else {
                right = new ABClass(value);
            }
        }
    }
    
    //metodos para agregar al arbol el nuevo nodo
    public void add2(CorreoClass value) {
        if (value.compareTo(this.value) < 0) {
            if (left != null) {
                left.add2(value);
            } else {
                left = new ABClass(value);
                this.value.Izq = value.No_Registro;
                UltimoVal = value;
            }
        } else {
            if (right != null) {
                right.add2(value);
            } else {
                right = new ABClass(value);
                this.value.Der = value.No_Registro;
                UltimoVal = value;
            }
        }
    }
   
    //metodo para retornar el ultimo valor
    public CorreoClass returnLast()
    {
        return UltimoVal;
    }
    
    // metodo para agregar al arbol
    @Override
    public String toString() {
        return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
    }
}
