package com.cht;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyPdfBox {
    void insertText() {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = null;
        try {
            contentStream = new PDPageContentStream(document, page);
            contentStream.setFont(PDType1Font.COURIER, 12);
            contentStream.beginText();
            contentStream.showText("Hello World");
            contentStream.endText();
            contentStream.close();
            document.save("pdfBoxHelloWorld.pdf");
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void insertImage() {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        Path path = null;
        URL url = null;
        URI uri = null;
        try {
            url = ClassLoader.getSystemResource("Java_logo.png");
            uri = url.toURI();
            path = Paths.get(uri);
            PDPageContentStream contentStream = null;
            contentStream = new PDPageContentStream(document, page);
            PDImageXObject image
                = PDImageXObject.createFromFile(path.toAbsolutePath().toString(), document);
            contentStream.drawImage(image, 0, 0);
            contentStream.close();
            document.save("pdfBoxImage.pdf");
            document.close();
        } catch (NullPointerException | IOException | URISyntaxException e) {
            System.err.println(url);
            e.printStackTrace();
        }
    }
}
