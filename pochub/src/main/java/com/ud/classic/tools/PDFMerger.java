package com.ud.classic.tools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * This class is used to merge two or more 
 * existing pdf file using iText jar.
 */
public class PDFMerger {

static void mergePdfFiles(List<InputStream> inputPdfList,
        OutputStream outputStream) throws Exception{
    //Create document and pdfReader objects.
    Document document = new Document();
    List<PdfReader> readers = 
            new ArrayList<PdfReader>();
    int totalPages = 0;

    //Create pdf Iterator object using inputPdfList.
    Iterator<InputStream> pdfIterator = 
            inputPdfList.iterator();

    // Create reader list for the input pdf files.
    while (pdfIterator.hasNext()) {
            InputStream pdf = pdfIterator.next();
            PdfReader pdfReader = new PdfReader(pdf);
            readers.add(pdfReader);
            totalPages = totalPages + pdfReader.getNumberOfPages();
    }

    // Create writer for the outputStream
    PdfWriter writer = PdfWriter.getInstance(document, outputStream);

    //Open document.
    document.open();

    //Contain the pdf data.
    PdfContentByte pageContentByte = writer.getDirectContent();

    PdfImportedPage pdfImportedPage;
    int currentPdfReaderPage = 1;
    Iterator<PdfReader> iteratorPDFReader = readers.iterator();

    // Iterate and process the reader list.
    while (iteratorPDFReader.hasNext()) {
            PdfReader pdfReader = iteratorPDFReader.next();
            //Create page and add content.
            while (currentPdfReaderPage <= pdfReader.getNumberOfPages()) {
                  document.newPage();
                  pdfImportedPage = writer.getImportedPage(
                          pdfReader,currentPdfReaderPage);
                  pageContentByte.addTemplate(pdfImportedPage, 0, 0);
                  currentPdfReaderPage++;
            }
            currentPdfReaderPage = 1;
    }

    //Close document and outputStream.
    outputStream.flush();
    document.close();
    outputStream.close();

    System.out.println("Pdf files merged successfully.");
}

public static void main(String args[]){
    try {
        //Prepare input pdf file list as list of input stream.
    	System.out.println("Start of the PDF Merge");
        List<InputStream> inputPdfList = new ArrayList<InputStream>();
        inputPdfList.add(new FileInputStream("/Users/uddipanbasu/Documents/Doc_hub/Uddipan/H1B_with_I-140/India-Id-details/Pan-Card-1.pdf"));
        inputPdfList.add(new FileInputStream("/Users/uddipanbasu/Documents/Doc_hub/Uddipan/H1B_with_I-140/India-Id-details/Pan-Card-2.pdf"));
//        inputPdfList.add(new FileInputStream("/Users/uddipanbasu/Documents/Doc_hub/Uddipan/H1B_with_I-140/Passort-H1B/IMG_2533.pdf"));
//        inputPdfList.add(new FileInputStream("/Users/uddipanbasu/Documents/Doc_hub/Uddipan/H1B_with_I-140/Passort-H1B/IMG_2534.pdf"));
//        inputPdfList.add(new FileInputStream("/Users/uddipanbasu/Documents/Doc_hub/Uddipan/H1B_with_I-140/Passort-H1B/IMG_2535.pdf"));
//        inputPdfList.add(new FileInputStream("/Users/uddipanbasu/Documents/Doc_hub/Uddipan/H1B_with_I-140/Passort-H1B/IMG_2536.pdf"));
//        inputPdfList.add(new FileInputStream("/Users/uddipanbasu/Documents/Doc_hub/Uddipan/H1B_with_I-140/Passort-H1B/IMG_2537.pdf"));
//        inputPdfList.add(new FileInputStream("/Users/uddipanbasu/Documents/Doc_hub/Uddipan/H1B_with_I-140/Passort-H1B/IMG_2538.pdf"));
//        inputPdfList.add(new FileInputStream("/Users/uddipanbasu/Documents/Doc_hub/Uddipan/H1B_with_I-140/Passort-H1B/IMG_2539.pdf"));
//        inputPdfList.add(new FileInputStream("/Users/uddipanbasu/Documents/Doc_hub/Uddipan/H1B_with_I-140/Passort-H1B/IMG_2540.pdf"));
//        inputPdfList.add(new FileInputStream("/Users/uddipanbasu/Documents/Doc_hub/Uddipan/H1B_with_I-140/Passort-H1B/IMG_2541.pdf"));


        //Prepare output stream for merged pdf file.
        OutputStream outputStream = 
                new FileOutputStream("/Users/uddipanbasu/Documents/Doc_hub/Uddipan/H1B_with_I-140/India-Id-details/IndiaPanCard-Uddipan.pdf");

        //call method to merge pdf files.
        mergePdfFiles(inputPdfList, outputStream);    
        
        System.out.println("End of the PDF Merge");
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}

