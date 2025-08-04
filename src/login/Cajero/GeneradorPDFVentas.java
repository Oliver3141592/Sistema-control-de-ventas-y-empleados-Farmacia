package login.Cajero;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.mycompany.java_crud_mysqlfinal.CConexion;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;

public class GeneradorPDFVentas {

    public void escribir(String nombre) {
        Document documento = new Document();

        try {
            // Ruta al escritorio
            String ruta = System.getProperty("user.home") + "/Desktop/CortesDeCaja/"+nombre+".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

            // === Colores ===
            BaseColor colorCabecera = new BaseColor(160, 160, 160); // Gris medio
            BaseColor colorCeldaId = new BaseColor(160, 160, 160);  // Igual que cabecera
            BaseColor colorCeldas = new BaseColor(240, 240, 240);   // Gris claro
            BaseColor colorTextoBlanco = BaseColor.WHITE;
            BaseColor colorBorde = new BaseColor(255, 255, 255);    // Bordes blancos

            // === Fuentes ===
            Font fontCabecera = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, colorTextoBlanco);
            Font fontFila = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL, BaseColor.BLACK);
            Font fontFilaBlanca = new Font(Font.FontFamily.HELVETICA, 9, Font.NORMAL, colorTextoBlanco);

            // === Crear tabla con 5 columnas ===
            PdfPTable tabla = new PdfPTable(5);
            tabla.setWidthPercentage(100);
            tabla.setSpacingBefore(10f);
            tabla.setSpacingAfter(10f);
            tabla.setWidths(new float[]{2, 4, 2, 2, 2});

            // === Encabezados personalizados ===
            String[] headers = {"Venta", "Producto", "Cantidad", "Precio Unitario", "Subtotal"};
            for (String h : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(h, fontCabecera));
                cell.setBackgroundColor(colorCabecera);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                cell.setPadding(6);
                cell.setBorderColor(colorBorde);
                tabla.addCell(cell);
            }

            // === Conexión y datos ===
            CConexion conexion = new CConexion(); // Tu clase de conexión personalizada
            String sql = """
                SELECT d.id_venta, p.nombre, d.cantidad, d.precio_unitario, d.subtotal
                FROM usuarios.detalle_venta d
                JOIN usuarios.productos p ON d.id_producto = p.id_producto
            """;

            PreparedStatement ps = conexion.estableceConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                for (int i = 1; i <= 5; i++) {
                    Phrase contenido;
                    PdfPCell celda;

                    // Primera columna (id_venta): estilo gris con letra blanca
                    if (i == 1) {
                        contenido = new Phrase(rs.getString(i), fontFilaBlanca);
                        celda = new PdfPCell(contenido);
                        celda.setBackgroundColor(colorCeldaId);
                    } else {
                        contenido = new Phrase(rs.getString(i), fontFila);
                        celda = new PdfPCell(contenido);
                        celda.setBackgroundColor(colorCeldas);
                    }

                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda.setPadding(6);
                    celda.setBorderColor(colorBorde);
                    tabla.addCell(celda);
                }
            }

            documento.add(tabla);
            JOptionPane.showMessageDialog(null, "Archivo creado exitosamente:\n/Desktop/CortesDeCaja/"+nombre+".pdf");

        } catch (DocumentException | IOException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (documento.isOpen()) {
                documento.close();
            }
        }
    }

    public static void main(String[] args) {
        GeneradorPDFVentas p = new GeneradorPDFVentas();
        String nombre="";
        p.escribir(nombre);
    }
}
