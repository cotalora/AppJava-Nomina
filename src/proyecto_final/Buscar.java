package proyecto_final;

import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.*;
import javax.swing.*;

public class Buscar extends JFrame implements ActionListener {

    JTextField bus;
    JComboBox op;
    JButton bbus, pdf;
    JTextArea area;
    ImageIcon img7, img1;
    JButton salir;
    JLabel ti, img33, img11;
    JScrollPane pan;
    ImageIcon logo,img5, img2, img9;

    Buscar() {
        setTitle("Menú de busqueda");
        setSize(340, 370);
        setLayout(null);
        logo= new ImageIcon("ico.png");
        Image imagen=logo.getImage();
        this.setIconImage(imagen);

        this.setUndecorated(true);
        this.getContentPane().setBackground(new java.awt.Color(170, 219, 233));
        img5 = new ImageIcon("IMGs\\bar.png");
        img1 = new ImageIcon("IMGs\\cuadro.png");
        pdf = new JButton("");
        bbus = new JButton();
        img2 = new ImageIcon("IMGs\\bot.png");
        img9 = new ImageIcon("IMGs\\exp.png");
        bus = new JTextField();
        img33 = new JLabel();
        img11 = new JLabel();
        ti = new JLabel("Busqueda:");
        ti.setFont(new Font("Tahoma", Font.BOLD, 18));
        op = new JComboBox();
        area = new JTextArea();
        bus.setBorder(null);
        pan = new JScrollPane(area);
        img33.setIcon(img5);
        img11.setIcon(img1);
        op.addItem("-Seleccione-");
        op.addItem("Cedula");
        op.addItem("Nombre");
        op.addItem("Apellido");
        op.addItem("Fecha");
        op.addItem("Valor prestamo");
        op.addItem("N°Cuotas");
        op.addItem("Vallor cuotas");
        op.addItem("Fecha");

        img33.setBounds(15, 40, 200, 30);
        bus.setBounds(20, 45, 190, 20);
        op.setBounds(220, 40, 100, 25);
        ti.setBounds(10, 10, 100, 30);
        bbus.setBounds(60, 310, 100, 30);
        img11.setBounds(20, 80, 290, 200);
        area.setBounds(30, 83, 275, 190);
        pdf.setBounds(170, 310, 100, 30);

        img7 = new ImageIcon("IMGs\\eq.png");

        salir = new JButton();

        salir.setIcon(img7);
        bbus.setIcon(img2);
        pdf.setIcon(img9);

        salir.setBounds(300, 5, 30, 30);

        bus.setFont(new Font("Tahoma", Font.BOLD, 12));
        op.setFont(new Font("Tahoma", Font.BOLD, 12));
        area.setFont(new Font("Tahoma", Font.BOLD, 12));

        bbus.setOpaque(false);
        bbus.setContentAreaFilled(false);
        bbus.setBorderPainted(false);
        salir.setOpaque(false);
        salir.setContentAreaFilled(false);
        salir.setBorderPainted(false);
        pdf.setOpaque(false);
        pdf.setContentAreaFilled(false);
        pdf.setBorderPainted(false);
        area.setEditable(false);

        salir.setCursor(new Cursor(HAND_CURSOR));
        bbus.setCursor(new Cursor(HAND_CURSOR));
        pdf.setCursor(new Cursor(HAND_CURSOR));
        op.setCursor(new Cursor(HAND_CURSOR));

        this.add(salir);

        salir.addActionListener(this);
        pdf.addActionListener(this);

        this.add(bus);

        this.add(op);
        this.add(ti);
        this.add(bbus);
        this.add(area);
        this.add(pdf);
        this.add(img33);
        this.add(img11);

        bbus.addActionListener(this);

        setVisible(true);
        setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salir) {
            this.setVisible(false);
            this.setVisible(false);
            Menu m = new Menu();
        } else {
            BaseDatos Con = new BaseDatos();
            Con.conectado();
            area.setText(Con.Buscador(bus.getText(), op.getSelectedIndex()));
            Con.cerrar();
        }
        if (e.getSource() == pdf) {
            BaseDatos Con = new BaseDatos();
            String Datos[] = new String[2];
            Datos[0] = area.getText();
            Datos[1] = bus.getText();

            String ruta = ("C:\\Users\\Dagda\\Documents\\Archivos PDF\\") + Datos[1] + ".pdf";

            Con.crearPdf(ruta, Datos);
        }

    }

}
