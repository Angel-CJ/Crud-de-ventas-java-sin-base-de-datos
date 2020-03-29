package datos;

import java.util.ArrayList;
import java.util.List;

/**
 * ContactoData DAO está el CRUD
 */
public class ClienteDatos {
    List<Cliente> listaClientes = new ArrayList<Cliente>();

    public List<Cliente> list() {
        return listaClientes;
    }

    public void create(Cliente c) {
        listaClientes.add(c);
        // System.out.println(d.getNombre()+" is created!");
    }

    public void delete(Cliente c) {
        listaClientes.remove(c);
    }

    public void delete(int id) {
        boolean existe = false;
        for (Cliente c : listaClientes) {
            System.out.println("Deleted:"+c.getId() + "\t" + c.getNombre());
            if (id == c.getId()) {
                try {
                    listaClientes.remove(c);
                    //listaContactos.update();

                } catch (java.util.ConcurrentModificationException e2) {
                    
                    System.out.println("Contacto si exist e2="+e2);
                }
                
                
                existe= true;
            }
        }
        if(!existe) {
            System.out.println("Contacto no existe");
        }
    }

    public void remove(int id) {
        boolean existe = false;
        for (Cliente c : listaClientes) {
            System.out.println("Deleted:"+c.getId2() + "\t" + c.getProducto());
            if (id == c.getId2()) {
                try {
                    listaClientes.remove(c);
                    //listaContactos.update();

                } catch (java.util.ConcurrentModificationException e2) {
                    
                    System.out.println("Contacto si exist e2="+e2);
                }
                
                
                existe= true;
            }
        }
        if(!existe) {
            System.out.println("Contacto no existe");
        }
    }

}


