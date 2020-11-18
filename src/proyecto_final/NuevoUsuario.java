package proyecto_final;

import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.*;
import javax.swing.*;

public class NuevoUsuario extends JFrame implements ActionListener {

    JLabel nomb, apel, usua, contr, ti, img44, img55, img66, img77;
    JTextField nom, ape, usu;
    JPasswordField pass;
    JButton añad, borr;
    ImageIcon logo,img7, img5, img6, img9, img4;
    JButton salir;

    public NuevoUsuario() {
        this.setTitle("Añadir usuarios");
        this.setSize(250, 260);
        this.setLayout(null);
        this.setUndecorated(true);
        this.getContentPane().setBackground(new java.awt.Color(170, 219, 233));
        logo= new ImageIcon("IMGs\\ico.png");
        Image imagen=logo.getImage();
        this.setIconImage(imagen);

        nomb = new JLabel("Nombre:");
        apel = new JLabel("Apellido:");
        usua = new JLabel("Usuario:");
        contr = new JLabel("Contraseña:");
        ti = new JLabel("NUEVO USUARIO");
        img44 = new JLabel();
        img55 = new JLabel();
        img66 = new JLabel();
        img77 = new JLabel();
        ti.setFont(new Font("Tahoma", Font.BOLD, 18));
        nom = new JTextField();
        ape = new JTextField();
        usu = new JTextField();
        pass = new JPasswordField();
        añad = new JButton();
        borr = new JButton();
        img4 = new ImageIcon("IMGs\\bor.png");
        img7 = new ImageIcon("IMGs\\eq.png");
        img5 = new ImageIcon("IMGs\\barus.png");
        img6 = new ImageIcon("IMGs\\barpa.png");
        img9 = new ImageIcon("IMGs\\añña.png");
        salir = new JButton();
        salir.setIcon(img7);
        img44.setIcon(img5);
        img55.setIcon(img5);
        img66.setIcon(img5);
        img77.setIcon(img6);
        añad.setIcon(img9);
        borr.setIcon(img4);

        nom.setFont(new Font("Tahoma", Font.BOLD, 12));
        ape.setFont(new Font("Tahoma", Font.BOLD, 12));
        usu.setFont(new Font("Tahoma", Font.BOLD, 12));
        pass.setFont(new Font("Tahoma", Font.BOLD, 12));
        nomb.setFont(new Font("Tahoma", Font.BOLD, 12));
        apel.setFont(new Font("Tahoma", Font.BOLD, 12));
        usua.setFont(new Font("Tahoma", Font.BOLD, 12));
        contr.setFont(new Font("Tahoma", Font.BOLD, 12));

        nomb.setBounds(10, 50, 150, 30);
        img44.setBounds(65, 45, 160, 30);
        nom.setBounds(70, 50, 150, 20);
        apel.setBounds(10, 90, 150, 30);
        img55.setBounds(65, 85, 160, 30);
        ape.setBounds(70, 90, 150, 20);
        usua.setBounds(10, 130, 150, 30);
        img66.setBounds(65, 125, 160, 30);
        usu.setBounds(70, 130, 150, 20);
        contr.setBounds(10, 170, 150, 30);
        img77.setBounds(85, 165, 160, 30);
        pass.setBounds(90, 170, 130, 20);
        añad.setBounds(10, 220, 100, 30);
        borr.setBounds(130, 220, 100, 30);
        salir.setBounds(210, 5, 30, 30);
        ti.setBounds(10, 10, 200, 30);

        nom.setBorder(null);
        ape.setBorder(null);
        usu.setBorder(null);
        pass.setBorder(null);

        this.add(nomb);
        this.add(nom);
        this.add(apel);
        this.add(ape);
        this.add(usua);
        this.add(usu);
        this.add(contr);
        this.add(pass);
        this.add(añad);
        this.add(borr);
        this.add(salir);
        this.add(ti);
        this.add(img44);
        this.add(img55);
        this.add(img66);
        this.add(img77);

        salir.setCursor(new Cursor(HAND_CURSOR));
        añad.setCursor(new Cursor(HAND_CURSOR));
        borr.setCursor(new Cursor(HAND_CURSOR));

        salir.setOpaque(false);
        salir.setContentAreaFilled(false);
        salir.setBorderPainted(false);
        añad.setOpaque(false);
        añad.setContentAreaFilled(false);
        añad.setBorderPainted(false);
        borr.setOpaque(false);
        borr.setContentAreaFilled(false);
        borr.setBorderPainted(false);

        salir.addActionListener(this);
        añad.addActionListener(this);
        borr.addActionListener(this);

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == añad) {
            int s;
            BaseDatos Con = new BaseDatos();
            Con.conectado();

            s = Con.guardaDatosUsuario(nom.getText(), ape.getText(), usu.getText(), pass.getText());
            if (s == 1) {
                JOptionPane.showMessageDialog(null, "Guardado Exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Problema al guardar");
            }
            Con.cerrar();
        } else if (e.getSource() == borr) {
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
