package proyecto_final;

import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.*;
import javax.swing.*;

public class Modificar extends JFrame implements ActionListener {

    JLabel numc, tenom, teape, tefecha, tevalorpr, tenumcuo, tevalorcuot, lid, lfe, ti, img11, img22, img33, img44, img55, img66, img77;
    JTextField busca, cedu1, nom1, ape1, valorpr, numcuo, valorcuot;
    JComboBox opcio, dia1, mes1, año1;
    JButton buscaa, editar;
    ImageIcon logo,img7, img5, img6, img2, img1;
    JButton salir;

    Modificar() {
        setTitle("Editar");
        setSize(450, 580);
        setLayout(null);
        this.setUndecorated(true);
        this.getContentPane().setBackground(new java.awt.Color(170, 219, 233));
        logo= new ImageIcon("IMGs\\ico.png");
        Image imagen=logo.getImage();
        this.setIconImage(imagen);

        img11 = new JLabel();
        img22 = new JLabel();
        img33 = new JLabel();
        img44 = new JLabel();
        img55 = new JLabel();
        img66 = new JLabel();
        img77 = new JLabel();
        img5 = new ImageIcon("IMGs\\bar.png");
        img6 = new ImageIcon("IMGs\\barpec.png");
        img2 = new ImageIcon("IMGs\\bot.png");
        img1 = new ImageIcon("IMGs\\botedi.png");
        busca = new JTextField();
        opcio = new JComboBox();
        ti = new JLabel("EDITAR PRESTAMO");
        ti.setFont(new Font("Tahoma", Font.BOLD, 18));
        opcio.addItem("-Seleccione-");
        opcio.addItem("Cedula");
        opcio.addItem("Nombre");
        buscaa = new JButton();
        editar = new JButton();
        valorpr = new JTextField();
        numcuo = new JTextField();
        valorcuot = new JTextField();
        lid = new JLabel("");
        numc = new JLabel("No. Cedula");
        tenom = new JLabel("Nombre");
        teape = new JLabel("Apellido");
        tefecha = new JLabel("Fecha:");
        tevalorpr = new JLabel("Valor prestamo");
        tenumcuo = new JLabel("N° Cuotas");
        tevalorcuot = new JLabel("Valor cuotas");
        lfe = new JLabel();
        cedu1 = new JTextField();
        nom1 = new JTextField();
        ape1 = new JTextField();
        dia1 = new JComboBox();
        for (int i = 1; i <= 31; i++) {
            dia1.addItem("" + i);
        }
        mes1 = new JComboBox();
        buscaa.setIcon(img2);
        editar.setIcon(img1);
        mes1.addItem("Enero");
        mes1.addItem("Febrero");
        mes1.addItem("Marzo");
        mes1.addItem("Abril");
        mes1.addItem("Mayo");
        mes1.addItem("Junio");
        mes1.addItem("Julio");
        mes1.addItem("Agosto");
        mes1.addItem("Septiembre");
        mes1.addItem("Octubre");
        mes1.addItem("Noviembre");
        mes1.addItem("Diciembre");
        año1 = new JComboBox();
        for (int i = 2018; i <= 2090; i++) {
            año1.addItem(i);
        }

        busca.setFont(new Font("Tahoma", Font.BOLD, 12));
        cedu1.setFont(new Font("Tahoma", Font.BOLD, 12));
        nom1.setFont(new Font("Tahoma", Font.BOLD, 12));
        ape1.setFont(new Font("Tahoma", Font.BOLD, 12));
        valorpr.setFont(new Font("Tahoma", Font.BOLD, 12));
        numcuo.setFont(new Font("Tahoma", Font.BOLD, 12));
        valorcuot.setFont(new Font("Tahoma", Font.BOLD, 12));
        numc.setFont(new Font("Tahoma", Font.BOLD, 12));
        tenom.setFont(new Font("Tahoma", Font.BOLD, 12));
        teape.setFont(new Font("Tahoma", Font.BOLD, 12));
        tefecha.setFont(new Font("Tahoma", Font.BOLD, 12));
        tevalorpr.setFont(new Font("Tahoma", Font.BOLD, 12));
        tenumcuo.setFont(new Font("Tahoma", Font.BOLD, 12));
        tevalorcuot.setFont(new Font("Tahoma", Font.BOLD, 12));
        lid.setFont(new Font("Tahoma", Font.BOLD, 12));
        lfe.setFont(new Font("Tahoma", Font.BOLD, 12));
        opcio.setFont(new Font("Tahoma", Font.BOLD, 12));
        dia1.setFont(new Font("Tahoma", Font.BOLD, 12));
        mes1.setFont(new Font("Tahoma", Font.BOLD, 12));
        año1.setFont(new Font("Tahoma", Font.BOLD, 12));

        busca.setBorder(null);
        cedu1.setBorder(null);
        nom1.setBorder(null);
        ape1.setBorder(null);
        valorpr.setBorder(null);
        numcuo.setBorder(null);
        valorcuot.setBorder(null);
        img11.setBounds(15, 45, 200, 30);
        busca.setBounds(20, 50, 185, 20);
        opcio.setBounds(225, 45, 100, 25);
        buscaa.setBounds(330, 45, 100, 30);
        numc.setBounds(20, 80, 100, 30);
        tenom.setBounds(20, 150, 100, 30);
        teape.setBounds(20, 210, 100, 30);
        tefecha.setBounds(20, 270, 150, 30);
        lfe.setBounds(60, 270, 150, 30);
        tevalorpr.setBounds(20, 340, 150, 30);
        tenumcuo.setBounds(20, 400, 150, 30);
        tevalorcuot.setBounds(20, 460, 150, 30);

        img22.setBounds(15, 105, 200, 30);
        cedu1.setBounds(20, 110, 185, 20);
        img33.setBounds(15, 175, 200, 30);
        nom1.setBounds(20, 180, 185, 20);
        img44.setBounds(15, 235, 200, 30);
        ape1.setBounds(20, 240, 185, 20);
        img55.setBounds(15, 365, 200, 30);
        valorpr.setBounds(20, 370, 185, 20);
        img66.setBounds(15, 425, 200, 30);
        numcuo.setBounds(20, 430, 185, 20);
        img77.setBounds(15, 485, 200, 30);
        valorcuot.setBounds(20, 490, 50, 20);
        dia1.setBounds(15, 300, 40, 25);
        mes1.setBounds(60, 300, 90, 25);
        año1.setBounds(155, 300, 60, 25);
        editar.setBounds(170, 530, 100, 30);
        ti.setBounds(10, 10, 200, 30);

        img7 = new ImageIcon("IMGs\\eq.png");
        salir = new JButton();
        salir.setIcon(img7);
        img11.setIcon(img5);
        img22.setIcon(img5);
        img33.setIcon(img5);
        img44.setIcon(img5);
        img55.setIcon(img5);
        img66.setIcon(img5);
        img77.setIcon(img6);

        salir.setBounds(400, 5, 30, 30);

        salir.setOpaque(false);
        salir.setContentAreaFilled(false);
        salir.setBorderPainted(false);
        buscaa.setOpaque(false);
        buscaa.setContentAreaFilled(false);
        buscaa.setBorderPainted(false);
        editar.setOpaque(false);
        editar.setContentAreaFilled(false);
        editar.setBorderPainted(false);

        salir.setCursor(new Cursor(HAND_CURSOR));
        buscaa.setCursor(new Cursor(HAND_CURSOR));
        editar.setCursor(new Cursor(HAND_CURSOR));
        opcio.setCursor(new Cursor(HAND_CURSOR));
        dia1.setCursor(new Cursor(HAND_CURSOR));
        mes1.setCursor(new Cursor(HAND_CURSOR));
        año1.setCursor(new Cursor(HAND_CURSOR));

        this.add(salir);

        salir.addActionListener(this);

        this.add(busca);
        this.add(opcio);
        this.add(buscaa);
        this.add(numc);
        this.add(tenom);
        this.add(teape);
        this.add(tefecha);
        this.add(tevalorpr);
        this.add(tenumcuo);
        this.add(tevalorcuot);
        this.add(cedu1);
        this.add(nom1);
        this.add(ape1);
        this.add(valorpr);
        this.add(numcuo);
        this.add(valorcuot);
        this.add(dia1);
        this.add(mes1);
        this.add(año1);
        this.add(editar);
        this.add(lfe);
        this.add(ti);
        this.add(img11);
        this.add(img22);
        this.add(img33);
        this.add(img44);
        this.add(img55);
        this.add(img66);
        this.add(img77);

        editar.addActionListener(this);
        buscaa.addActionListener(this);

        setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buscaa) {
            BaseDatos conec = new BaseDatos();
            conec.conectado();
            String encontro[] = conec.Busca_Modificar(busca.getText(), opcio.getSelectedIndex());
            lid.setText(encontro[0]);
            cedu1.setText(encontro[1]);
            nom1.setText(encontro[2]);
            ape1.setText(encontro[3]);
            lfe.setText(encontro[4]);
            valorpr.setText(encontro[5]);
            numcuo.setText(encontro[6]);
            valorcuot.setText(encontro[7]);
            conec.cerrar();
        }
        if (e.getSource() == editar) {
            BaseDatos conec = new BaseDatos();
            conec.conectado();
            int re = conec.actualizaDatos(Integer.parseInt(lid.getText()), cedu1.getText(), nom1.getText(), ape1.getText(), dia1.getSelectedItem() + "/" + mes1.getSelectedItem() + "/" + año1.getSelectedItem(), valorpr.getText(), numcuo.getText(), valorcuot.getText());
            if (re == 1) {
                JOptionPane.showMessageDialog(null, "Actualización completa");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo realizar el cambio");
            }
        }

        if (e.getSource() == salir) {
            this.setVisible(false);
            Menu m = new Menu();
        }
    }

}
