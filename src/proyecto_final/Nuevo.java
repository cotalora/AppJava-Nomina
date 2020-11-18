package proyecto_final;

import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.*;
import javax.swing.*;

public class Nuevo extends JFrame implements ActionListener {

    JLabel cedula, nombre, apellido, fecha, valorp, cuotas, valorc;
    JTextField tcedula, tnombre, tapellido, tvalorp, tcuotas;
    JLabel tvalorc, ti, img44, img55, img66, img77, img88, img99;
    JComboBox dia, mes, año;
    JButton btn, salir;
    ImageIcon logo,img7, img5, img6;

    Nuevo() {
        setTitle("Menú añadir");
        setSize(370, 380);
        setLayout(null);
        this.setUndecorated(true);
        this.getContentPane().setBackground(new java.awt.Color(170, 219, 233));
        logo= new ImageIcon("IMGs\\ico.png");
        Image imagen=logo.getImage();
        this.setIconImage(imagen);
        img44 = new JLabel();
        img55 = new JLabel();
        img66 = new JLabel();
        img77 = new JLabel();
        img88 = new JLabel();
        img99 = new JLabel();
        img5 = new ImageIcon("IMGs\\bar.png");
        img6 = new ImageIcon("IMGs\\botbar2.png");
        cedula = new JLabel("Cedula");
        nombre = new JLabel("Nombres");
        apellido = new JLabel("Apellidos");
        fecha = new JLabel("Fecha de Prestamo");
        valorp = new JLabel("Valor del prestamo");
        cuotas = new JLabel("Número de cuotas");
        valorc = new JLabel("Valor de cuotas");
        tcedula = new JTextField();
        tcedula.setBorder(null);
        tnombre = new JTextField();
        tnombre.setBorder(null);
        tapellido = new JTextField();
        tapellido.setBorder(null);
        tvalorp = new JTextField();
        tvalorp.setBorder(null);
        tcuotas = new JTextField();
        tcuotas.setBorder(null);
        tvalorc = new JLabel();
        ti = new JLabel("NUEVO PRESTAMO");
        dia = new JComboBox();
        for (int i = 1; i <= 31; i++) {
            dia.addItem("" + i);
        }
        mes = new JComboBox();
        mes.addItem("Enero");
        mes.addItem("Febrero");
        mes.addItem("Marzo");
        mes.addItem("Abril");
        mes.addItem("Mayo");
        mes.addItem("Junio");
        mes.addItem("Julio");
        mes.addItem("Agosto");
        mes.addItem("Septiembre");
        mes.addItem("Octubre");
        mes.addItem("Noviembre");
        mes.addItem("Diciembre");
        año = new JComboBox();
        for (int i = 2018; i <= 2090; i++) {
            año.addItem("" + i);
        }
        btn = new JButton();
        btn.setIcon(img6);

        img7 = new ImageIcon("IMGs\\eq.png");
        salir = new JButton();
        salir.setIcon(img7);
        img44.setIcon(img5);
        img55.setIcon(img5);
        img66.setIcon(img5);
        img77.setIcon(img5);
        img88.setIcon(img5);
        img99.setIcon(img5);

        cedula.setBounds(20, 60, 100, 20);
        nombre.setBounds(20, 100, 100, 20);
        apellido.setBounds(20, 140, 100, 20);
        fecha.setBounds(20, 180, 150, 20);
        valorp.setBounds(20, 220, 150, 20);
        cuotas.setBounds(20, 260, 150, 20);
        valorc.setBounds(20, 300, 150, 20);
        img44.setBounds(145, 55, 200, 30);
        tcedula.setBounds(155, 60, 180, 20);
        img55.setBounds(145, 95, 200, 30);
        tnombre.setBounds(155, 100, 180, 20);
        img66.setBounds(145, 135, 200, 30);
        tapellido.setBounds(155, 140, 180, 20);
        img77.setBounds(145, 215, 200, 30);
        tvalorp.setBounds(155, 220, 180, 20);
        img88.setBounds(145, 255, 200, 30);
        tcuotas.setBounds(155, 260, 180, 20);
        tvalorc.setBounds(155, 300, 100, 20);
        dia.setBounds(145, 180, 40, 25);
        mes.setBounds(190, 180, 90, 25);
        año.setBounds(285, 180, 60, 25);
        btn.setBounds(110, 330, 160, 30);
        salir.setBounds(330, 5, 30, 30);
        ti.setBounds(10, 10, 200, 30);

        ti.setFont(new Font("Tahoma", Font.BOLD, 18));

        cedula.setFont(new Font("Tahoma", Font.BOLD, 12));

        nombre.setFont(new Font("Tahoma", Font.BOLD, 12));

        apellido.setFont(new Font("Tahoma", Font.BOLD, 12));

        fecha.setFont(new Font("Tahoma", Font.BOLD, 12));

        valorp.setFont(new Font("Tahoma", Font.BOLD, 12));

        cuotas.setFont(new Font("Tahoma", Font.BOLD, 12));

        valorc.setFont(new Font("Tahoma", Font.BOLD, 12));

        tcedula.setFont(new Font("Tahoma", Font.BOLD, 12));
        tnombre.setFont(new Font("Tahoma", Font.BOLD, 12));
        tapellido.setFont(new Font("Tahoma", Font.BOLD, 12));
        tvalorp.setFont(new Font("Tahoma", Font.BOLD, 12));
        tcuotas.setFont(new Font("Tahoma", Font.BOLD, 12));
        tvalorc.setFont(new Font("Tahoma", Font.BOLD, 12));
        dia.setFont(new Font("Tahoma", Font.BOLD, 12));
        mes.setFont(new Font("Tahoma", Font.BOLD, 12));
        año.setFont(new Font("Tahoma", Font.BOLD, 12));
        btn.setFont(new Font("Tahoma", Font.BOLD, 12));

        salir.setOpaque(false);
        salir.setContentAreaFilled(false);
        salir.setBorderPainted(false);

        salir.setCursor(new Cursor(HAND_CURSOR));
        btn.setCursor(new Cursor(HAND_CURSOR));
        dia.setCursor(new Cursor(HAND_CURSOR));
        mes.setCursor(new Cursor(HAND_CURSOR));
        año.setCursor(new Cursor(HAND_CURSOR));

        this.add(cedula);
        this.add(nombre);
        this.add(apellido);
        this.add(fecha);
        this.add(valorp);
        this.add(cuotas);
        this.add(valorc);
        this.add(tnombre);
        this.add(tapellido);
        this.add(dia);
        this.add(mes);
        this.add(año);
        this.add(tvalorp);
        this.add(tcuotas);
        this.add(tvalorc);
        this.add(btn);
        this.add(tcedula);
        this.add(img44);
        this.add(img55);
        this.add(img66);
        this.add(img77);
        this.add(img88);
        this.add(salir);
        this.add(ti);

        btn.setOpaque(false);
        btn.setContentAreaFilled(false);
        btn.setBorderPainted(false);

        btn.addActionListener(this);
        salir.addActionListener(this);

        setVisible(true);
        setResizable(false);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            int r, a, z = 0;

            r = Integer.parseInt(tcuotas.getText());
            a = Integer.parseInt(tvalorp.getText());

            z = a / r;

            String w = String.valueOf(z);

            tvalorc.setText(w);

            int g;
            BaseDatos Con = new BaseDatos();
            Con.conectado();

            g = Con.guardaDatosPrestamo(tcedula.getText(), tnombre.getText(), tapellido.getText(), dia.getSelectedItem() + "/" + mes.getSelectedItem() + "/" + año.getSelectedItem(), tvalorp.getText(), tcuotas.getText(), tvalorc.getText());
            if (g == 1) {
                JOptionPane.showMessageDialog(null, "Guardado Exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Problema al guardar");
            }
            Con.cerrar();
        }

        if (e.getSource() == salir) {
            this.setVisible(false);
            Menu m = new Menu();
        }

    }

}
