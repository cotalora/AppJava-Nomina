package proyecto_final;

import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;

import java.awt.event.*;
import javax.swing.*;

public class EliminarUsuarios extends JFrame implements ActionListener {

    JTextField bus;
    JLabel l1, ti, img11, img22;
    JComboBox op;
    JButton bbus, Elim;
    JTextArea area;
    ImageIcon logo,img7, img1, img2, img3, img4;
    JButton salir;
    JScrollPane pan;

    EliminarUsuarios() {
        setTitle("Menú de eliminacion");
        setSize(340, 340);
        setLayout(null);

        this.setUndecorated(true);
        this.getContentPane().setBackground(new java.awt.Color(170, 219, 233));
        logo= new ImageIcon("IMGs\\ico.png");
        Image imagen=logo.getImage();
        this.setIconImage(imagen);

        img11 = new JLabel();
        img22 = new JLabel();
        img1 = new ImageIcon("IMGs\\bar.png");
        img2 = new ImageIcon("IMGs\\cuadro.png");
        img3 = new ImageIcon("IMGs\\bot.png");
        img4 = new ImageIcon("IMGs\\botel.png");
        ti = new JLabel("ELIMINAR USUARIOS");
        ti.setFont(new Font("Tahoma", Font.BOLD, 18));
        bbus = new JButton();
        Elim = new JButton();
        bus = new JTextField();
        l1 = new JLabel();
        op = new JComboBox();
        area = new JTextArea();
        pan = new JScrollPane(area);
        op.addItem("-Seleccione-");
        op.addItem("Nombre");
        op.addItem("Apellido");
        op.addItem("Usuario");
        img7 = new ImageIcon("IMGs\\eq.png");
        salir = new JButton();
        salir.setIcon(img7);
        img11.setIcon(img1);
        img22.setIcon(img2);
        bbus.setIcon(img3);
        Elim.setIcon(img4);

        bus.setBorder(null);
        area.setBorder(null);

        bus.setFont(new Font("Tahoma", Font.BOLD, 12));
        op.setFont(new Font("Tahoma", Font.BOLD, 12));
        area.setFont(new Font("Tahoma", Font.BOLD, 12));

        img11.setBounds(20, 45, 200, 30);
        bus.setBounds(25, 50, 190, 20);
        op.setBounds(230, 45, 100, 25);
        bbus.setBounds(50, 300, 100, 30);
        Elim.setBounds(180, 300, 100, 30);
        img22.setBounds(25, 85, 290, 200);
        area.setBounds(30, 90, 275, 190);
        salir.setBounds(300, 5, 30, 30);
        ti.setBounds(10, 10, 200, 30);

        salir.setOpaque(false);
        salir.setContentAreaFilled(false);
        salir.setBorderPainted(false);
        salir.setCursor(new Cursor(HAND_CURSOR));

        Elim.setOpaque(false);
        Elim.setContentAreaFilled(false);
        Elim.setBorderPainted(false);
        Elim.setCursor(new Cursor(HAND_CURSOR));

        bbus.setOpaque(false);
        bbus.setContentAreaFilled(false);
        bbus.setBorderPainted(false);
        bbus.setCursor(new Cursor(HAND_CURSOR));

        this.add(bus);
        this.add(op);
        this.add(bbus);
        this.add(area);
        this.add(Elim);
        this.add(salir);
        this.add(ti);
        this.add(img11);
        this.add(img22);

        bbus.addActionListener(this);
        salir.addActionListener(this);

        Elim.addActionListener(this);

        setVisible(true);

        setResizable(false);
        this.setLocationRelativeTo(null);
        area.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bbus) {
            BaseDatos Con = new BaseDatos();
            Con.conectado();
            String data[] = Con.Busca_Modificar2(bus.getText(), op.getSelectedIndex());
            area.setText("Nombre: " + data[1] + "\n" + "Apellido: " + data[2] + "\n" + "Usuario: " + data[3] + "\n=======================");
            l1.setText(data[0]);
            Con.cerrar();
        }
        if (e.getSource() == Elim) {
            BaseDatos Con = new BaseDatos();
            Con.conectado();
            int res = Con.BorrarDatos(Integer.parseInt(l1.getText()));
            Con.cerrar();
            if (res == 1) {
                JOptionPane.showMessageDialog(null, "Haz sido borrado");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo borrar");
            }
        }

        if (e.getSource() == salir) {
            MenuUsuarios mm = new MenuUsuarios();
            this.setVisible(false);
        }

    }

}
