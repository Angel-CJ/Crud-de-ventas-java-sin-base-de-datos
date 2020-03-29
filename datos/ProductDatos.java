/*package datos;
import ClienteDatos;
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
*/