/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 *
 *this is LANKOANDE Urbain code
 * Prince.COM << lankoandeurbain8@gmail.com >>
 *
 */
package classe;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.JTable;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author lankoande
 */
public class exportPdf {

    public static void exportTableToPdf(JTable table, String fileName) {
        try {
            // Créer un document en mode paysage
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
            float[] columnWidths = new float[table.getColumnCount()];
            for (int i = 0; i < table.getColumnCount(); i++) {
                pdfTable.addCell(table.getColumnName(i));
                columnWidths[i] = table.getColumnModel().getColumn(i).getWidth();
            }
            pdfTable.setWidthPercentage(columnWidths, document.getPageSize());

            for (int rows = 0; rows < table.getRowCount(); rows++) {
                for (int cols = 0; cols < table.getColumnCount(); cols++) {
                    pdfTable.addCell(table.getModel().getValueAt(rows, cols).toString());
                }
            }

            document.add(pdfTable);
            document.close();
            JOptionPane.showMessageDialog(table, "<html>Exportation effectuée <br> chemin: " + fileName + "</html>");
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(table, "Erreur lors de l'exportation : " + e.getMessage());
        }
    }
}
