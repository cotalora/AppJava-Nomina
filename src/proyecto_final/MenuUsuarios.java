package proyecto_final;

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

public class MenuUsuarios extends JFrame implements ActionListener {

    JButton cr, mo, bo;
    ImageIcon logo,crearus, modificarus, borrarus;
    Container cont;
    JTable tab;
    JScrollPane pan;
    ImageIcon img7;
    JButton salir;
    JLabel ti;

    DefaultTableModel modeloTabla;

    MenuUsuarios() {
        this.setTitle("Menu de usuarios");
        this.setSize(710, 380);
        this.setLayout(null);
        this.setUndecorated(true);
        this.getContentPane().setBackground(new java.awt.Color(170, 219, 233));
        logo= new ImageIcon("IMGs\\ico.png");
        Image imagen=logo.getImage();
        this.setIconImage(imagen);

        img7 = new ImageIcon("IMGs\\eq.png");
        salir = new JButton();
        salir.setIcon(img7);

        ti = new JLabel("MENÚ DE USUARIOS");
        ti.setFont(new Font("Tahoma", Font.BOLD, 18));

        crearus = new ImageIcon("IMGs\\añad.png");
        cr = new JButton();
        cr.setIcon(crearus);
        cr.setToolTipText("Crear un nuevo usuario");

        modificarus = new ImageIcon("IMGs\\edi.png");
        mo = new JButton();
        mo.setIcon(modificarus);
        mo.setToolTipText("Modificar un usuario");

        borrarus = new ImageIcon("IMGs\\eli.png");
        bo = new JButton();
        bo.setIcon(borrarus);
        bo.setToolTipText("Eliminar un usuario");

        tab = new JTable();
        pan = new JScrollPane();
        modeloTabla = new DefaultTableModel(null, getColumnas());
        setFilas();
        tab.setModel(modeloTabla);
        pan.add(tab);
        pan.setViewportView(tab);
        cr.setOpaque(false);
        cr.setContentAreaFilled(false);
        cr.setBorderPainted(false);
        mo.setOpaque(false);
        mo.setContentAreaFilled(false);
        mo.setBorderPainted(false);
        bo.setOpaque(false);
        bo.setContentAreaFilled(false);
        bo.setBorderPainted(false);

        cr.setCursor(new Cursor(HAND_CURSOR));
        mo.setCursor(new Cursor(HAND_CURSOR));
        bo.setCursor(new Cursor(HAND_CURSOR));

        tab.enable(false);

        salir.setBounds(670, 5, 30, 30);
        cr.setBounds(250, 40, 70, 70);
        mo.setBounds(330, 40, 70, 70);
        bo.setBounds(410, 40, 70, 70);
        pan.setBounds(15, 120, 680, 235);
        ti.setBounds(10, 10, 200, 30);

        JTableHeader Theader = tab.getTableHeader();
        Theader.setBackground(new java.awt.Color(0, 171, 197));
        Theader.setForeground(Color.WHITE);
        Theader.setFont(new Font("Tahoma", Font.BOLD, 15));
        tab.setShowHorizontalLines(false);
        tab.setShowVerticalLines(false);
        tab.setDefaultRenderer(Object.class, new Rederer());

        this.add(cr);
        this.add(mo);
        this.add(bo);
        this.add(pan);
        this.add(salir);
        this.add(ti);

        salir.addActionListener(this);

        cr.addActionListener(this);
        mo.addActionListener(this);
        bo.addActionListener(this);

        salir.setOpaque(false);
        salir.setContentAreaFilled(false);
        salir.setBorderPainted(false);

        salir.setCursor(new Cursor(HAND_CURSOR));

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cr) {
            NuevoUsuario nu = new NuevoUsuario();
            this.setVisible(false);
        }

        if (e.getSource() == mo) {
            EditarUsuarios mod = new EditarUsuarios();
            this.setVisible(false);
        }

        if (e.getSource() == bo) {
            EliminarUsuarios bor = new EliminarUsuarios();
            this.setVisible(false);
        }

        if (e.getSource() == salir) {
            this.setVisible(false);
            Menu m = new Menu();
        }

    }

    private void setFilas() {
        BaseDatos co = new BaseDatos();
        co.conectado();
        System.out.println("conecto");
        try {
            String sql = "select nombre, apellido, usuario, clave from usuario";

            PreparedStatement us = co.conexion.prepareStatement(sql);
            ResultSet res = us.executeQuery();

            Object datos[] = new Object[4];

            while (res.next()) {
                for (int i = 0; i < 4; i++) {
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
            "Nombre", "Apellido", "Usuario"
        };
        return Columnas;
    }
}
