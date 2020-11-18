package proyecto_final;

import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.*;
import javax.swing.*;

public class LogIn extends JFrame implements ActionListener {

    JTextField usu;
    JPasswordField pass;
    JLabel lusu, img11, img22, img33, img44, iniciosec;
    Container co;
    JButton ent, sal;
    ImageIcon logo,img1, img2, img3, img4, img5, img6, img7;
    LogIn() {
        this.setTitle("Login");
        this.setSize(250, 300);
        this.setLayout(null);
        
        this.setUndecorated(true);
        this.getContentPane().setBackground(new java.awt.Color(170, 219, 233));
        logo= new ImageIcon("IMGs\\ico.png");
        Image imagen=logo.getImage();
        this.setIconImage(imagen);
        ent = new JButton();
        sal = new JButton();
        usu = new JTextField();
        pass = new JPasswordField();
        img1 = new ImageIcon("IMGs\\FOR.png");
        img2 = new ImageIcon("IMGs\\bar.png");
        img3 = new ImageIcon("IMGs\\user1.png");
        img4 = new ImageIcon("IMGs\\pasword1.png");
        img5 = new ImageIcon("IMGs\\bar.png");
        img6 = new ImageIcon("IMGs\\botbar.png");
        img7 = new ImageIcon("IMGs\\eq.png");
        img11 = new JLabel();
        img22 = new JLabel();
        lusu = new JLabel();
        img33 = new JLabel();
        img44 = new JLabel();
        iniciosec = new JLabel("INICIO DE SESIÓN");
        iniciosec.setFont(new Font("Tahoma", Font.BOLD, 18));
        iniciosec.setForeground(new java.awt.Color(51, 51, 55));
        usu.setFont(new Font("Tahoma", Font.BOLD, 12));
        pass.setFont(new Font("Tahoma", Font.BOLD, 12));
        img11.setIcon(img1);
        img22.setIcon(img2);
        lusu.setIcon(img3);
        img33.setIcon(img4);
        img44.setIcon(img5);
        ent.setIcon(img6);
        sal.setIcon(img7);

        ent.setOpaque(false);
        ent.setContentAreaFilled(false);
        ent.setBorderPainted(false);
        sal.setOpaque(false);
        sal.setContentAreaFilled(false);
        sal.setBorderPainted(false);

        usu.setBorder(null);
        pass.setBorder(null);
        ent.setCursor(new Cursor(HAND_CURSOR));
        sal.setCursor(new Cursor(HAND_CURSOR));
        iniciosec.setBounds(40, 120, 1000, 20);
        img11.setBounds(50, 20, 150, 86);
        img22.setBounds(25, 150, 200, 30);
        img33.setBounds(30, 190, 200, 30);
        img44.setBounds(25, 190, 200, 30);
        lusu.setBounds(30, 155, 20, 20);
        usu.setBounds(60, 155, 150, 20);
        pass.setBounds(60, 195, 150, 20);
        ent.setBounds(50, 230, 160, 30);
        sal.setBounds(210, 10, 30, 30);

        this.add(lusu);
        this.add(usu);
        this.add(pass);
        this.add(ent);
        this.add(img11);
        this.add(img22);
        this.add(img33);
        this.add(img44);
        this.add(iniciosec);
        this.add(sal);

        ent.addActionListener(this);
        sal.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ent) {
            int k;
            BaseDatos co = new BaseDatos();
            co.conectado();

            k = co.validarUsuario(usu.getText(), pass.getText());
            if (k == 1) {
                Menu m = new Menu();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario/Clave no validos");
                System.exit(0);
            }
            setVisible(false);
            co.cerrar();
        }
        if (e.getSource() == sal) {
            System.exit(0);
        }
    }

}
