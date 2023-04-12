package br.com.blsoft.relatoriospdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class firstPdf {

    public void PrimeiroPdf(String frase) throws DocumentException, FileNotFoundException {
        Document documentPdf = new Document();
        PdfWriter.getInstance(documentPdf, new FileOutputStream("Relatorio.pdf"));
        documentPdf.open();
        Paragraph parafragoTeste = new Paragraph(frase);
        documentPdf.add(parafragoTeste);
        documentPdf.close();
    }
}
