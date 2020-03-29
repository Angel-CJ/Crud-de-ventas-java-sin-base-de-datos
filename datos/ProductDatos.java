/*package datos;

public class ProductDatos {
    List<Cliente> listaProductos = new ArrayList<Cliente>();

    public List<Cliente> list() {
        return listaProductos;
    }

    public void create(Cliente c) {
        listaProductos.add(c);
        // System.out.println(d.getNombre()+" is created!");
    }

    public void delete(Cliente c) {
        listaProductos.remove(c);
    }

    public void delete(int id2) {
        boolean existe = false;
        for (Cliente c : listaProductos) {
            System.out.println("Deleted:"+c.getId2() + "\t" + c.getNombre());
            if (id2 == c.getId2()) {
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
*/