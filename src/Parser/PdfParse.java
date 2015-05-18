package Parser;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
/**
 * 
 * @author steven
 *
 */
public class PdfParse {
	/**
	 * 
	 */
	String parse="";
	public PdfParse(){
		
	}
	
	/**
	 * 
	 */
	public void casa(){
		System.out.print("Casa");
	}
	
	/**
	 * 
	 * @param dir
	 * @return 
	 */
	
	public String parserPdf(String dir){
		InputStream is = null;
	    try {
	    	is = new BufferedInputStream(new FileInputStream(new File(dir)));
	    	AutoDetectParser pdfparser = new AutoDetectParser();
	    	ContentHandler contenthandler = new BodyContentHandler();
	    	Metadata metadata = new Metadata();
	    	
	    	//PDFParser pdfparser = new PDFParser();
	    	pdfparser.parse(is, contenthandler, metadata, new ParseContext());
	    	parse+=contenthandler.toString();
           
	    }
	    catch (IOException e) {
	    	e.printStackTrace();
	    } catch (TikaException e) {
	    	e.printStackTrace();
	    } catch (SAXException e) {
	    	e.printStackTrace();
	    } finally {
	    	if (is != null) {
	    		try {
	    			is.close();
	    		} catch(IOException e) {
	    			e.printStackTrace();
	    		}
	    	}
	    }
	    return parse;
	}
	public void Pdf(String dir){
        InputStream is = null;
 
        try {
            is = new BufferedInputStream(new FileInputStream(new File(dir)));
 
            Parser parser = new AutoDetectParser();
            ContentHandler handler = new BodyContentHandler(System.out);
            //parse+=handler.toString();
 
            Metadata metadata = new Metadata();
 
            parser.parse(is, handler, metadata, new ParseContext());
 
            for (String name : metadata.names()) {
                String value = metadata.get(name);
 
                if (value != null) {
                    System.out.println("Metadata Name:  " + name);
                    System.out.println("Metadata Value: " + value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //return parse;
    }
	
	/*public void parserPdf(String dir){
		InputStream is = null;
	    try {
	      is = new FileInputStream(dir);
	      ContentHandler contenthandler = new BodyContentHandler();
	      Metadata metadata = new Metadata();
	      PDFParser pdfparser = new PDFParser();
	      pdfparser.parse(is, contenthandler, metadata, new ParseContext());
	      System.out.println(contenthandler.toString());
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	    finally {
	        if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    }
	  }
    
	
	/*public String parseExample() throws IOException, SAXException, TikaException {
	    InputStream stream = PdfParse.class.getResourceAsStream("test.doc");
	    AutoDetectParser parser = new AutoDetectParser();
	    BodyContentHandler handler = new BodyContentHandler();
	    Metadata metadata = new Metadata();
	    try {
	        parser.parse(stream, handler, metadata);
	        return handler.toString();
	    } finally {
	        stream.close();
	    }
	}
	
	/*public String parseToPlainText() throws IOException, SAXException, TikaException {
	    BodyContentHandler handler = new BodyContentHandler();
	     
	    InputStream stream = PdfParse.class.getResourceAsStream("test.doc");
	    AutoDetectParser parser = new AutoDetectParser();
	    Metadata metadata = new Metadata();
	    try {
	        parser.parse(stream, handler, metadata);
	        return handler.toString();
	    } finally {
	        stream.close();
	    }
	}
	/*public String testTika() throws Exception {
		  InputStream input=new FileInputStream(new File("test.doc"));
		  ContentHandler textHandler=new BodyContentHandler();
		  Metadata metadata=new Metadata();
		  Parser parser=new AutoDetectParser();
		  ParseContext context=new ParseContext();
		  parser.parse(input,textHandler,metadata,context);
		  //System.out.println("Title: " + metadata.get(Metadata.TITLE));
		 return textHandler.toString();
	}*/
}