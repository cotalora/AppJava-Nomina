package proyecto_final;

import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.*;
import javax.swing.*;

public class EditarUsuarios extends JFrame implements ActionListener {

    JLabel nomb, apel, usua, contr, Lnro, ti, img44, img55, img66, img77, img88;
    JTextField nom, ape, usu, campo;
    JComboBox tipo;
    JPasswordField pass;
    JButton mod, buscar, borrar;
    ImageIcon logo,img7, img5, img2, img1, img3, img4;
    JButton salir;

    public EditarUsuarios() {
        this.setTitle("Editar usuarios");
        this.setSize(310, 350);
        this.setLayout(null);
        this.setUndecorated(true);
        this.getContentPane().setBackground(new java.awt.Color(170, 219, 233));
        logo= new ImageIcon("IMGs\\ico.png");
        Image imagen=logo.getImage();
        this.setIconImage(imagen);

        ti = new JLabel("EDITAR USUARIOS");
        ti.setFont(new Font("Tahoma", Font.BOLD, 18));
        campo = new JTextField();
        tipo = new JComboBox();
        tipo.addItem("-Seleccione-");
        tipo.addItem("Nombre");
        tipo.addItem("Apellido");
        tipo.addItem("Usuario");
        buscar = new JButton();
        nomb = new JLabel("Nombre:");
        apel = new JLabel("Apellido:");
        usua = new JLabel("Usuario:");
        contr = new JLabel("Contraseña:");
        img44 = new JLabel();
        img55 = new JLabel();
        img66 = new JLabel();
        img77 = new JLabel();
        img88 = new JLabel();
        nom = new JTextField();
        ape = new JTextField();
        usu = new JTextField();
        pass = new JPasswordField();
        mod = new JButton();
        borrar = new JButton();
        Lnro = new JLabel();
        img7 = new ImageIcon("IMGs\\eq.png");
        img5 = new ImageIcon("IMGs\\barus.png");
        img2 = new ImageIcon("IMGs\\barpa.png");
        img1 = new ImageIcon("IMGs\\bot.png");
        img3 = new ImageIcon("IMGs\\bor.png");
        img4 = new ImageIcon("IMGs\\botedi.png");
        salir = new JButton();
        salir.setIcon(img7);
        img44.setIcon(img5);
        img55.setIcon(img5);
        img66.setIcon(img5);
        img77.setIcon(img5);
        img88.setIcon(img2);
        buscar.setIcon(img1);
        borrar.setIcon(img3);
        mod.setIcon(img4);

        campo.setBorder(null);
        nom.setBorder(null);
        ape.setBorder(null);
        usu.setBorder(null);
        pass.setBorder(null);

        nom.setFont(new Font("Tahoma", Font.BOLD, 12));
        ape.setFont(new Font("Tahoma", Font.BOLD, 12));
        usu.setFont(new Font("Tahoma", Font.BOLD, 12));
        pass.setFont(new Font("Tahoma", Font.BOLD, 12));
        campo.setFont(new Font("Tahoma", Font.BOLD, 12));
        nomb.setFont(new Font("Tahoma", Font.BOLD, 12));
        apel.setFont(new Font("Tahoma", Font.BOLD, 12));
        usua.setFont(new Font("Tahoma", Font.BOLD, 12));
        contr.setFont(new Font("Tahoma", Font.BOLD, 12));
        tipo.setFont(new Font("Tahoma", Font.BOLD, 12));

        salir.setBounds(270, 5, 30, 30);
        img44.setBounds(15, 55, 160, 30);
        campo.setBounds(20, 60, 150, 20);
        tipo.setBounds(190, 55, 100, 25);
        buscar.setBounds(100, 95, 100, 30);
        nomb.setBounds(20, 140, 150, 30);
        img55.setBounds(85, 135, 160, 30);
        nom.setBounds(90, 140, 150, 20);
        apel.setBounds(20, 180, 150, 30);
        img66.setBounds(85, 175, 160, 30);
        ape.setBounds(90, 180, 150, 20);
        usua.setBounds(20, 220, 150, 30);
        img77.setBounds(85, 215, 160, 30);
        usu.setBounds(90, 220, 150, 20);
        contr.setBounds(20, 260, 150, 30);
        img88.setBounds(105, 255, 140, 30);
        pass.setBounds(110, 260, 130, 20);
        mod.setBounds(30, 300, 100, 30);
        borrar.setBounds(190, 300, 100, 30);
        ti.setBounds(10, 10, 200, 30);

        this.add(Lnro);
        this.add(nomb);
        this.add(nom);
        this.add(apel);
        this.add(ape);
        this.add(usua);
        this.add(usu);
        this.add(contr);
        this.add(pass);
        this.add(mod);
        this.add(campo);
        this.add(tipo);
        this.add(buscar);
        this.add(borrar);
        this.add(salir);
        this.add(ti);
        this.add(img44);
        this.add(img55);
        this.add(img66);
        this.add(img77);
        this.add(img88);

        mod.addActionListener(this);
        buscar.addActionListener(this);
        borrar.addActionListener(this);
        salir.addActionListener(this);

        salir.setOpaque(false);
        salir.setContentAreaFilled(false);
        salir.setBorderPainted(false);
        salir.setCursor(new Cursor(HAND_CURSOR));
        buscar.setOpaque(false);
        buscar.setContentAreaFilled(false);
        buscar.setBorderPainted(false);
        buscar.setCursor(new Cursor(HAND_CURSOR));
        borrar.setOpaque(false);
        borrar.setContentAreaFilled(false);
        borrar.setBorderPainted(false);
        borrar.setCursor(new Cursor(HAND_CURSOR));
        mod.setOpaque(false);
        mod.setContentAreaFilled(false);
        mod.setBorderPainted(false);
        mod.setCursor(new Cursor(HAND_CURSOR));
        tipo.setCursor(new Cursor(HAND_CURSOR));

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buscar) {
            BaseDatos conec = new BaseDatos();
            conec.conectado();
            String encontro[] = conec.modificarUsuario(campo.getText(), tipo.getSelectedIndex());
            Lnro.setText(encontro[0]);
            nom.setText(encontro[1]);
            ape.setText(encontro[2]);
            usu.setText(encontro[3]);
            pass.setText(encontro[4]);
            conec.cerrar();
        }
        if (e.getSource() == mod) {
            BaseDatos conec = new BaseDatos();
            conec.conectado();
            int re = conec.actualizaDatosUsuarios(Integer.parseInt(Lnro.getText()), nom.getText(), ape.getText(), usu.getText(), pass.getText());
            if (re == 1) {
                JOptionPane.showMessageDialog(null, "Actualización completa");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el cambio");
            }
        } else if (e.getSource() == borrar) {
            Lnro.setText("");
            nom.setText("");
            ape.setText("");
            usu.setText("");
            pass.setText("");
        }

        if (e.getSource() == salir) {
            MenuUsuarios mm = new MenuUsuarios();
            this.setVisible(false);
        }

    }

}
