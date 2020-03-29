import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import java.awt.event.*;
import javax.swing.table.*;

import datos.Cliente;
import datos.ClienteDatos;
import datos.Productos;
import datos.ProductosDatos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Boleta extends JFrame {
    /**
     * Descripción de la clase
     */
    private static final long serialVersionUID = 1L;
    // CRUD Contacto
    int clientId = 0;
   
    ClienteDatos clientDatos = new ClienteDatos();
    String[] clientColumns = { "Id", "Nombre","Documento"};
    String[][] clientMatriz = new String[0][clientColumns.length];
    DefaultTableModel model = new DefaultTableModel(clientMatriz, clientColumns);
    JTable contactoTable = new JTable(model);
    JScrollPane clientSP = new JScrollPane();
    
    //Crud Productos
    //ProductDatos productDatos = new ProductDatos();
     int productId = 0;
    ProductosDatos productosDatos = new ProductosDatos();
    String[] productsColumns = { "Id","Producto","Precio"};
    String[][] productsMatriz = new String[0][productsColumns.length];
    DefaultTableModel model2 = new DefaultTableModel(productsMatriz, productsColumns);
    JTable productTable = new JTable(model2);
    JScrollPane productSP = new JScrollPane();
    //end table
    
    // CRUD Contacto End

    public Boleta() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        // Creando MenuBar y agregando items
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("CRUD");
        JMenu m2 = new JMenu("AYUDA");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("Contactos");
        JMenuItem m12 = new JMenuItem("Productos");
        JMenuItem m19 = new JMenuItem("Salir");

        // CRUD Contacto
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new BoxLayout(clientPanel, BoxLayout.Y_AXIS));
        JLabel clientLblNombre = new JLabel("Ingrese Contacto:");
        JTextField clientTxtNombre = new JTextField();

        JLabel clientLblDocumento = new JLabel("Ingrese Documento de identidad:");
        JTextField clientTxtDocumento = new JTextField();

        JButton btnadd = new JButton("Agregar");
        JButton button;
        button = new JButton("Remove");
        clientSP.setViewportView(contactoTable);
        clientPanel.add(clientLblNombre);
        clientPanel.add(clientTxtNombre);
        clientPanel.add(clientLblDocumento);
        clientPanel.add(clientTxtDocumento);
        clientPanel.add(btnadd);
        clientPanel.add(button);
        clientPanel.add(clientSP);

        btnadd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clientId++;
                Cliente d = new Cliente();
                d.setId(clientId);
                d.setNombre(clientTxtNombre.getText());
                clientDatos.create(d);
                d.setDocumento(clientTxtDocumento.getText());
                

                List<Cliente> miLista = clientDatos.list();
                clientMatriz = new String[miLista.size()][clientColumns.length];
                for (int i = 0; i < miLista.size(); i++) {
                    clientMatriz[i][0] = miLista.get(i).getId() + "";
                    clientMatriz[i][1] = miLista.get(i).getNombre() + "";
                    clientMatriz[i][2] = miLista.get(i).getDocumento() + "";
                }
                model = new DefaultTableModel(clientMatriz, clientColumns);
                contactoTable = new JTable(model);// f5 table
                clientSP.setViewportView(contactoTable);// f5 table

            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // check for selected row first
                if (contactoTable.getSelectedRow() != -1) {
                    String ids = null;
                    int[] row = contactoTable.getSelectedRows();
                    ids = (String) contactoTable.getValueAt(row[0], 0);
                    System.out.println("Table element selected es: " + ids);
                    int id = Integer.parseInt(ids);
                    clientTxtNombre.setText(" " + id);
                    
                    
                    // remove selected row from the model
                    model.removeRow(contactoTable.getSelectedRow());
                    try {
                        clientDatos.delete(id);
                    } catch (java.util.ConcurrentModificationException e2) {
                        System.out.println("Contacto si exist e2="+e2);
                    }
                    

                   // JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
                }
            }
        });

        // CRUD Contacto End

        // CRUD Producto
        JPanel productoPanel = new JPanel();

        productoPanel.setLayout(new BoxLayout(productoPanel, BoxLayout.Y_AXIS));


        JLabel clientLblProducto = new JLabel("Ingrese el Producto:");
        JTextField clientTxtProducto = new JTextField();

        JLabel clientLblPrecio = new JLabel("Ingrese el Precio:");
        JTextField clientTxtPrecio = new JTextField();

        JButton btnadd2 = new JButton("Agregar");
        JButton button2;
        button2 = new JButton("Remove");
        productSP.setViewportView(productTable);
        productoPanel.add(clientLblProducto);
        productoPanel.add(clientTxtProducto);
        productoPanel.add(clientLblPrecio);
        productoPanel.add(clientTxtPrecio);
        productoPanel.add(btnadd2);
        productoPanel.add(button2);
        productoPanel.add(productSP);

        btnadd2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                productId++;
                Productos d = new Productos();
                d.setId(productId);
                d.setProductos(clientTxtProducto.getText());
                productosDatos.create(d);
                d.setPrecio(clientTxtPrecio.getText());  

                List<Productos> miLista = productosDatos.list();
                productsMatriz = new String[miLista.size()][productsColumns.length];
                for (int i = 0; i < miLista.size(); i++) {
                    productsMatriz[i][0] = miLista.get(i).getId() + "";
                    productsMatriz[i][1] = miLista.get(i).getProductos() + "";
                    productsMatriz[i][2] = miLista.get(i).getPrecio() + "";
                }
                model2 = new DefaultTableModel(productsMatriz, productsColumns);
                productTable = new JTable(model2);// f5 table
                productSP.setViewportView(productTable);// f5 table

            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // check for selected row first
                if (productTable.getSelectedRow() != -1) {
                    String ids = null;
                    int[] row = productTable.getSelectedRows();
                    ids = (String) productTable.getValueAt(row[0], 0);
                    System.out.println("Table element selected es: " + ids);
                    int id = Integer.parseInt(ids);
                    clientTxtProducto.setText(" " + id);
                    
                    
                    // remove selected row from the model
                    model2.removeRow(productTable.getSelectedRow());
                    try {
                        productosDatos.delete(id);
                    } catch (java.util.ConcurrentModificationException e2) {
                        System.out.println("Contacto si exist e2="+e2);
                    }
                    

                   // JOptionPane.showMessageDialog(null, "Selected row deleted successfully");
                }
            }
        });
        m11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Ir a contactos");
                JOptionPane.showMessageDialog(null, clientPanel, "Contactos", JOptionPane.PLAIN_MESSAGE);
            }
        });
        m12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("Ir a productos");
                JOptionPane.showMessageDialog(null, productoPanel, "Productos", JOptionPane.PLAIN_MESSAGE);
            }
        });
        m19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        // Actions del JFrame End

        m1.add(m11);
        m1.add(m12);
        m1.add(m19);

        // Creando el panel en la parte inferior y agregando componentes
        JPanel footPanel = new JPanel();
        JLabel footLblCopy = new JLabel("c(2020) POO");
        footPanel.add(footLblCopy);

        // Agregar componentes al marco.
        add(BorderLayout.NORTH, mb);
        add(BorderLayout.SOUTH, footPanel);

    }

    public static void main(String args[]) {
        // Creando el Marco
        Boleta ex = new Boleta();
        ex.setVisible(true);
    }

}