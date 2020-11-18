package proyecto_final;

import com.itextpdf.layout.element.Cell;
import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Menu extends JFrame implements ActionListener {

    JButton C, R, U, D, X, salir,about;
    ImageIcon logo, Crear, Modifi, Leer, Borrar, Usuarios, img7,aboutt;
    Container cont;
    JTable tabla;
    JScrollPane panel;
    DefaultTableModel modeloTabla;

    Menu() {
        this.setTitle("Menu Principal");
        this.setSize(1060, 350);
        this.setLayout(null);
        this.setUndecorated(true);
        this.getContentPane().setBackground(new java.awt.Color(170, 219, 233));
        logo = new ImageIcon("IMGs\\ico.png");
        Image imagen = logo.getImage();
        this.setIconImage(imagen);

        Crear = new ImageIcon("IMGs\\crear.png");
        C = new JButton();
        C.setIcon(Crear);
        C.setToolTipText("Crear nuevos registros de prestamos");

        Leer = new ImageIcon("IMGs\\buscar.png");
        R = new JButton();
        R.setIcon(Leer);
        R.setToolTipText("Consultar registros de prestamos");

        Modifi = new ImageIcon("IMGs\\editar.png");
        U = new JButton();
        U.setIcon(Modifi);
        U.setToolTipText("Modificar registros de prestamos");

        Borrar = new ImageIcon("IMGs\\borrar.png");
        D = new JButton();
        D.setIcon(Borrar);
        D.setToolTipText("Eliminar registros de prestamos");

        Usuarios = new ImageIcon("IMGs\\usuario.png");
        X = new JButton();
        X.setIcon(Usuarios);
        X.setToolTipText("Ver registros de los usuarios");

        img7 = new ImageIcon("IMGs\\eq.png");
        salir = new JButton();
        salir.setIcon(img7);
        
        aboutt = new ImageIcon("IMGs\\about.png");
        about = new JButton();
        about.setIcon(aboutt);

        tabla = new JTable();
        panel = new JScrollPane();
        modeloTabla = new DefaultTableModel(null, getColumnas());
        setFilas();
        tabla.setModel(modeloTabla);
        panel.add(tabla);
        tabla.setFont(new Font("Tahoma", Font.PLAIN, 12));
        panel.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.setViewportView(tabla);
        JTableHeader Theader = tabla.getTableHeader();
        Theader.setBackground(new java.awt.Color(0, 171, 197));
        Theader.setForeground(Color.WHITE);
        Theader.setFont(new Font("Tahoma", Font.BOLD, 15));

        tabla.enable(false);

        C.setOpaque(false);
        C.setContentAreaFilled(false);
        C.setBorderPainted(false);
        R.setOpaque(false);
        R.setContentAreaFilled(false);
        R.setBorderPainted(false);
        U.setOpaque(false);
        U.setContentAreaFilled(false);
        U.setBorderPainted(false);
        D.setOpaque(false);
        D.setContentAreaFilled(false);
        D.setBorderPainted(false);
        X.setOpaque(false);
        X.setContentAreaFilled(false);
        X.setBorderPainted(false);
        salir.setOpaque(false);
        salir.setContentAreaFilled(false);
        salir.setBorderPainted(false);
        
        about.setOpaque(false);
        about.setContentAreaFilled(false);
        about.setBorderPainted(false);

        tabla.setShowHorizontalLines(false);
        tabla.setShowVerticalLines(false);
        tabla.setDefaultRenderer(Object.class, new Rederer());

        C.setCursor(new Cursor(HAND_CURSOR));
        R.setCursor(new Cursor(HAND_CURSOR));
        U.setCursor(new Cursor(HAND_CURSOR));
        D.setCursor(new Cursor(HAND_CURSOR));
        X.setCursor(new Cursor(HAND_CURSOR));
        salir.setCursor(new Cursor(HAND_CURSOR));
        about.setCursor(new Cursor(HAND_CURSOR));
        C.setBounds(330, 10, 70, 70);
        R.setBounds(410, 10, 70, 70);
        U.setBounds(490, 10, 70, 70);
        D.setBounds(570, 10, 70, 70);
        X.setBounds(650, 10, 70, 70);
        salir.setBounds(1020, 10, 30, 30);
        about.setBounds(980, 10, 30, 30);
        panel.setBounds(20, 90, 1025, 235);

        add(C);
        add(R);
        add(U);
        add(D);
        add(X);
        add(salir);
        add(panel);
        add(about);

        C.addActionListener(this);
        R.addActionListener(this);
        U.addActionListener(this);
        D.addActionListener(this);
        X.addActionListener(this);
        salir.addActionListener(this);
        about.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(3);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == C) {
            Nuevo N = new Nuevo();
            this.setVisible(false);
        }
        if (e.getSource() == R) {
            Buscar B = new Buscar();
            this.setVisible(false);
        }
        if (e.getSource() == U) {
            Modificar M = new Modificar();
            this.setVisible(false);
        }

        if (e.getSource() == D) {
            Eliminar Bo = new Eliminar();
            this.setVisible(false);
        }

        if (e.getSource() == X) {
            MenuUsuarios mu = new MenuUsuarios();
            this.setVisible(false);
        }
        if (e.getSource() == salir) {
            System.exit(0);
        }
        if (e.getSource()== about) {
            String creditos = "Spec-UDEC 1.0\n"
                + "Desarrollado por:\n"
                + "- Cristian Otalora\n"
                + "- Andres Carvajal\n"
                + "- Paula Igua\n"
                + "Udec Chía, 2018";

            JOptionPane.showMessageDialog(
                null, creditos);
        }
    }

    private void setFilas() {
        BaseDatos co = new BaseDatos();
        co.conectado();
        System.out.println("conecto");
        try {
            String sql = "select  cedula, nombre, apellido, fecha, valorpre, numcuotas,valorcuotas from prestamos";

            PreparedStatement us = co.conexion.prepareStatement(sql);
            ResultSet res = us.executeQuery();

            Object datos[] = new Object[7];

            while (res.next()) {
                for (int i = 0; i < 7; i++) {
                    datos[i] = res.getObject(i + 1);
                }
                modeloTabla.addRow(datos);
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String[] getColumnas() {

        String Columnas[] = new String[]{
            "Cedula", "Nombre", "Apellido", "Fecha", "Valor prestamo", "N°Cuotas", "Valor cuotas"
        };
        return Columnas;
    }

}
