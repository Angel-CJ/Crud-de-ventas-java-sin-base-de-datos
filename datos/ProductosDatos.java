package datos;

import java.util.ArrayList;
import java.util.List;

/**
 * ContactoData DAO está el CRUD
 */
public class ProductosDatos {
    List<Productos> listaProductos = new ArrayList<Productos>();

    public List<Productos> list() {
        return listaProductos;
    }

    public void create(Productos c) {
        listaProductos.add(c);
        // System.out.println(d.getNombre()+" is created!");
    }

    public void delete(Productos c) {
        listaProductos.remove(c);
    }

    public void delete(int id) {
        boolean existe = false;
        for (Productos c : listaProductos) {
            System.out.println("Deleted:"+c.getId() + "\t" + c.getProductos());
            if (id == c.getId()) {
                try {
                    listaProductos.remove(c);
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


