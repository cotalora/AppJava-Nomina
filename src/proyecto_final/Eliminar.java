package proyecto_final;

import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.*;
import javax.swing.*;

public class Eliminar extends JFrame implements ActionListener {

    JTextField bus;
    JLabel l1, ti, img11, img33;
    JComboBox op;
    JButton bbus, Elim;
    JTextArea area;
    ImageIcon logo,img7, img1, img5, img2, img3;
    JButton salir;
    JScrollPane pan;

    Eliminar() {
        setTitle("Menú de eliminacion");
        setSize(340, 360);
        setLayout(null);

        this.setUndecorated(true);
        this.getContentPane().setBackground(new java.awt.Color(170, 219, 233));
        logo= new ImageIcon("IMGs\\ico.png");
        Image imagen=logo.getImage();
        this.setIconImage(imagen);

        img5 = new ImageIcon("IMGs\\bar.png");
        img1 = new ImageIcon("IMGs\\cuadro.png");
        img7 = new ImageIcon("IMGs\\eq.png");
        salir = new JButton();
        salir.setIcon(img7);
        img2 = new ImageIcon("IMGs\\bot.png");
        img3 = new ImageIcon("IMGs\\botel.png");
        ti = new JLabel("ELIMINAR PRESTAMO");

        img11 = new JLabel();
        img33 = new JLabel();
        bbus = new JButton();
        Elim = new JButton();
        bus = new JTextField();
        l1 = new JLabel();
        op = new JComboBox();

        area = new JTextArea();
        pan = new JScrollPane(area);
        op.addItem("-Seleccione-");
        op.addItem("Cedula");
        op.addItem("Nombre");
        op.addItem("Apellido");
        op.addItem("Fecha");
        op.addItem("Valor prestamo");
        op.addItem("N°Cuotas");
        op.addItem("Vallor cuotas");
        op.addItem("Fecha");

        img11.setIcon(img1);
        img33.setIcon(img5);
        bbus.setIcon(img2);
        Elim.setIcon(img3);
        bus.setBorder(null);

        ti.setFont(new Font("Tahoma", Font.BOLD, 18));
        bus.setFont(new Font("Tahoma", Font.BOLD, 12));
        l1.setFont(new Font("Tahoma", Font.BOLD, 12));
        op.setFont(new Font("Tahoma", Font.BOLD, 12));
        area.setFont(new Font("Tahoma", Font.BOLD, 12));
        img33.setBounds(15, 50, 200, 30);
        bus.setBounds(20, 55, 190, 20);
        op.setBounds(220, 50, 100, 25);
        ti.setBounds(10, 10, 200, 30);
        bbus.setBounds(60, 310, 100, 30);
        Elim.setBounds(180, 310, 100, 30);
        area.setBounds(25, 100, 275, 190);
        salir.setBounds(300, 5, 30, 30);
        img11.setBounds(15, 95, 290, 200);

        this.add(bus);
        this.add(op);
        this.add(bbus);
        this.add(area);
        this.add(Elim);
        this.add(salir);
        this.add(ti);
        this.add(img11);
        this.add(img33);

        salir.addActionListener(this);

        bbus.addActionListener(this);

        Elim.addActionListener(this);

        salir.setOpaque(false);
        salir.setContentAreaFilled(false);
        salir.setBorderPainted(false);
        bbus.setOpaque(false);
        bbus.setContentAreaFilled(false);
        bbus.setBorderPainted(false);
        Elim.setOpaque(false);
        Elim.setContentAreaFilled(false);
        Elim.setBorderPainted(false);

        setVisible(true);
        salir.setCursor(new Cursor(HAND_CURSOR));
        bbus.setCursor(new Cursor(HAND_CURSOR));
        Elim.setCursor(new Cursor(HAND_CURSOR));
        op.setCursor(new Cursor(HAND_CURSOR));
        setResizable(false);
        area.setEditable(false);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bbus) {
            BaseDatos Con = new BaseDatos();
            Con.conectado();
            String data[] = Con.Busca_Modificar(bus.getText(), op.getSelectedIndex());
            area.setText("Cedula: " + data[1] + "\n" + "Nombre: " + data[2] + "\n" + "Apellidos: " + data[3] + "\n" + "Fecha: " + data[4] + "\n" + "Valor prestamo: " + data[5] + "\n" + "Numero de cuotas: " + data[6] + "\n" + "Valor cuotas: " + data[7] + "\n=======================");
            l1.setText(data[0]);
            Con.cerrar();
        }
        if (e.getSource() == Elim) {
            BaseDatos Con = new BaseDatos();
            Con.conectado();
            int res = Con.BorrarDatospre(Integer.parseInt(l1.getText()));
            Con.cerrar();
            if (res == 1) {
                JOptionPane.showMessageDialog(null, "Haz sido borrado");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo borrar");
            }
        }

        if (e.getSource() == salir) {
            this.setVisible(false);
            Menu m = new Menu();
        }

    }

}
