package com.example.pdfgenerator.service;

import com.example.pdfgenerator.repository.KvpRepository;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

import static com.lowagie.text.PageSize.A4;

@Service
public class PDFGeneratorService {

    private KvpRepository kvRepository;
    public void export(HttpServletResponse response) throws IOException {

        Document document = new Document(A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(12);


        Paragraph paragraph = new Paragraph("This is the key", fontTitle);
        paragraph.setAlignment(paragraph.ALIGN_LEFT);
        Paragraph  paragraph1 = new Paragraph("This is the value", fontTitle);
        paragraph.setAlignment(paragraph1.ALIGN_LEFT);

        int width_space = 3, height_space = 4;
        int referred_width, referred_height;

        referred_width = 210 / width_space;
        referred_height = 297 / height_space;

        int x1=0,y1=0,x2=referred_width,y2=referred_height;
        int midPoint1,midPoint2;

        HashMap<Paragraph, Paragraph> hashMap = new HashMap<>();

        for (int i=0;i<height_space;i++) {
            for (int j = 0; j < width_space; j++) {
                midPoint1 = Math.floorDiv((x1 + referred_width), 2);
                midPoint2 = Math.floorDiv((y1 + referred_height), 2);

                Paragraph paragraph2 = new Paragraph("Key"+midPoint1);
                paragraph2.setAlignment(paragraph2.ALIGN_CENTER);
                Paragraph paragraph3 = new Paragraph("Value"+midPoint2);
                paragraph3.setAlignment(paragraph3.ALIGN_CENTER);

                document.add(hashMap.put(paragraph2, paragraph3));
                x1 = x2;
                x2 = x1 + referred_width;
                x1 = 0;
                y1 = y2;
                x2 = referred_width;
                y2 = referred_height + y1;
            }
        }
        document.close();
    }
}
