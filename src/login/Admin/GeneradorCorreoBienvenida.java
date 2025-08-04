package login.Admin;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.mycompany.java_crud_mysqlfinal.CConexion;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;


public class GeneradorCorreoBienvenida {

    public void escribir(String correo, String contrasena, String nombre) {
        Document documento = new Document();

        try {
            // Ruta al escritorio
            String ruta = System.getProperty("user.home") + "/Desktop/PDFalCorreo/"+nombre+".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

            // === Fuentes ===
            Font fontCuerpo = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.ITALIC);
            Font fontDatos = new Font(Font.FontFamily.COURIER, 12, Font.NORMAL, BaseColor.BLACK);

            // === Contenido del documento ===
            documento.add(new Paragraph("Bienvenido "+nombre+" a Farmacia Luna\n\n", fontCuerpo));
            documento.add(new Paragraph("Nos alegra contar contigo como parte de nuestro equipo.\n"
                    + "Estamos comprometidos con el bienestar de nuestros clientes, y tú serás parte fundamental de esa misión.\n\n", fontCuerpo));

            documento.add(new Paragraph("Tus datos de acceso son:\n", fontCuerpo));
            documento.add(new Paragraph("Correo: " + correo, fontDatos));
            documento.add(new Paragraph("Contraseña: " + contrasena, fontDatos));

            documento.add(new Paragraph("\n¡Éxito en esta nueva etapa!", fontCuerpo));

            JOptionPane.showMessageDialog(null, "Archivo generado");

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            if (documento.isOpen()) {
                documento.close();
            }
        }
    }

    public static void main(String[] args) {
        GeneradorCorreoBienvenida p = new GeneradorCorreoBienvenida();
        p.escribir("colaborador@farmacialuna.com", "12345678","ruben");
    }
}
