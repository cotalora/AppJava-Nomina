package proyecto_final;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import java.io.File;
import java.io.IOException;

public class BaseDatos {

    Menu m;

    String url = "BD\\prestamos.db";
    Connection conexion;

    public void conectado() {
        try {
            conexion = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (conexion != null) {
                System.out.println("Conexión exitosa");
            }
        } catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
    }

    public void cerrar() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error en el cierre" + ex.getMessage());
        }
    }

    public int validarUsuario(String Us, String Ps) {
        int estado = 0;
        ResultSet result;
        String claveRes;
        try {
            PreparedStatement st
                    = conexion.prepareStatement("select * from usuario where usuario=?");
            st.setString(1, Us);
            result = st.executeQuery();
            while (result.next()) {
                claveRes = result.getString("clave");
                if (claveRes.equals(Ps) && !result.getString("usuario").isEmpty()) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estado;
    }

    public int guardaDatosUsuario(String Nom, String Ape, String Usu, String Cla) {
        int estado;
        try {
            PreparedStatement st = conexion.prepareStatement("insert into usuario (nombre,apellido,usuario,clave) values (?,?,?,?)");
            st.setString(1, Nom);
            st.setString(2, Ape);
            st.setString(3, Usu);
            st.setString(4, Cla);

            st.execute();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }

    public String[] modificarUsuario(String Dato, int opcion) {
        String resultado[] = new String[5], campoDB = "";
        ResultSet result;
        try {

            if (opcion == 1) {
                campoDB = "select * from usuario where nombre";
            }
            if (opcion == 2) {
                campoDB = "select * from usuario where apellido";
            }
            if (opcion == 3) {
                campoDB = "select * from usuario where usuario";
            }
            if (opcion == 4) {
                campoDB = "select * from usuario where clave";
            }
            PreparedStatement st
                    = conexion.prepareStatement(campoDB + "=?");
            st.setString(1, Dato);
            result = st.executeQuery();
            while (result.next()) {
                resultado[0] = result.getString("id");
                resultado[1] = result.getString("nombre");
                resultado[2] = result.getString("apellido");
                resultado[3] = result.getString("usuario");
                resultado[4] = result.getString("clave");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public int actualizaDatosUsuarios(int id, String Nom, String Ape, String Usu, String Cla) {
        int estado;
        try {
            PreparedStatement st = conexion.prepareStatement("update usuario set nombre=?,apellido=?,usuario=?,clave=?" + "where id=?");
            st.setString(1, Nom);
            st.setString(2, Ape);
            st.setString(3, Usu);
            st.setString(4, Cla);
            st.setInt(5, id);
            st.executeUpdate();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }

    public int guardaDatosPrestamo(String Ced, String Nom, String Ape, String Fec, String Vap, String Ncu, String Vcu) {
        int estado;
        try {
            PreparedStatement st = conexion.prepareStatement("insert into prestamos (cedula,nombre,apellido,fecha,valorpre,numcuotas,valorcuotas) values (?,?,?,?,?,?,?)");
            st.setString(1, Ced);
            st.setString(2, Nom);
            st.setString(3, Ape);
            st.setString(4, Fec);
            st.setString(5, Vap);
            st.setString(6, Ncu);
            st.setString(7, Vcu);

            st.execute();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }

    public String Buscador(String Dato, int opcion) {
        String area = "", campobs = "";
        ResultSet result;

        try {

            if (opcion == 1) {
                campobs = "select * from prestamos where cedula";
            }
            if (opcion == 2) {
                campobs = "select * from prestamos where nombre";
            }
            if (opcion == 3) {
                campobs = "select * from prestamos where apellido";
            }

            if (opcion == 4) {
                campobs = "select * from prestamos where fecha";
            }
            if (opcion == 5) {
                campobs = "select * from prestamos where valorpre";
            }
            if (opcion == 6) {
                campobs = "select * from prestamos where numcuotas";
            }
            if (opcion == 7) {
                campobs = "select * from prestamos where valorcuotas";
            }
            PreparedStatement st = conexion.prepareStatement(campobs + "=?");
            st.setString(1, Dato);
            result = st.executeQuery();
            while (result.next()) {

                area = area + "\nID:" + result.getInt("id")
                        + "\nCedula: " + result.getString("cedula")
                        + "\nNombres: " + result.getString("nombre")
                        + "\nApellidos: " + result.getString("apellido")
                        + "\nFecha: " + result.getString("fecha")
                        + "\nValor prestamo: " + result.getString("valorpre")
                        + "\nNumero cuotas: " + result.getString("numcuotas")
                        + "\nValor cuotas: " + result.getString("valorcuotas");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return area;

    }

    public String[] Busca_Modificar(String Dato, int opcion) {
        String resultado[] = new String[8], campoDB = "";
        ResultSet result;
        try {

            if (opcion == 1) {
                campoDB = "select * from prestamos where cedula";
            }
            if (opcion == 2) {
                campoDB = "select * from prestamos where nombre";
            }
            if (opcion == 3) {
                campoDB = "select * from prestamos where apellido";
            }

            if (opcion == 4) {
                campoDB = "select * from prestamos where fecha";
            }
            if (opcion == 5) {
                campoDB = "select * from prestamos where valorpre";
            }
            if (opcion == 6) {
                campoDB = "select * from prestamos where numcuotas";
            }
            if (opcion == 7) {
                campoDB = "select * from prestamos where valorcuotas";
            }
            PreparedStatement st = conexion.prepareStatement(campoDB + "=?");
            st.setString(1, Dato);
            result = st.executeQuery();
            while (result.next()) {
                resultado[0] = result.getString("id");
                resultado[1] = result.getString("cedula");
                resultado[2] = result.getString("nombre");
                resultado[3] = result.getString("apellido");
                resultado[4] = result.getString("fecha");
                resultado[5] = result.getString("valorpre");
                resultado[6] = result.getString("numcuotas");
                resultado[7] = result.getString("valorcuotas");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public int actualizaDatos(int id, String Ced, String Nom, String Ape, String Fe, String Vp, String Ncu, String Vcu) {
        int estado;
        try {
            PreparedStatement st = conexion.prepareStatement(
                    "update prestamos set cedula=?, nombre=?, apellido=?,fecha=?,valorpre=?,numcuotas=?,valorcuotas=?"
                    + "where id=?");
            st.setString(1, Ced);
            st.setString(2, Nom);
            st.setString(3, Ape);
            st.setString(4, Fe);
            st.setString(5, Vp);
            st.setString(6, Ncu);
            st.setString(7, Vcu);
            st.setInt(8, id);
            st.executeUpdate();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }

    public int BorrarDatos(int id) {
        int estado;
        try {
            PreparedStatement st = conexion.prepareStatement("delete from usuario where id=?");
            st.setInt(1, id);
            st.executeUpdate();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;
    }

    public String[] Busca_Modificar2(String Dato, int opcion) {
        String resultado[] = new String[4], campoDB = "";
        ResultSet result;
        try {

            if (opcion == 1) {
                campoDB = "select * from usuario where nombre";
            }
            if (opcion == 2) {
                campoDB = "select * from usuario where apellido";
            }
            if (opcion == 3) {
                campoDB = "select * from usuario where usuario";
            }

            PreparedStatement st = conexion.prepareStatement(campoDB + "=?");
            st.setString(1, Dato);
            result = st.executeQuery();
            while (result.next()) {
                resultado[0] = result.getString("id");
                resultado[1] = result.getString("nombre");
                resultado[2] = result.getString("apellido");
                resultado[3] = result.getString("usuario");

            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public int BorrarDatospre(int id) {
        int estado;
        try {
            PreparedStatement st = conexion.prepareStatement("delete from prestamos where id=?");
            st.setInt(1, id);
            st.executeUpdate();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }
        return estado;

    }

    public void crearPdf(String Ruta, String t[]) {
        File file;
        PdfWriter writer;
        PdfDocument pdf;
        Document document;
        try {
            file = new File(Ruta);
            file.getParentFile().mkdirs();
            writer = new PdfWriter(Ruta);
            pdf = new PdfDocument(writer);
            document = new Document(pdf) {
            };

            document.add(new Paragraph("-------------------------------------Informacion del prestamo------------------------------------- " + t[0]));

            document.close();
        } catch (IOException ioex) {
            System.out.println("" + ioex.getMessage());
        }
    }
}
