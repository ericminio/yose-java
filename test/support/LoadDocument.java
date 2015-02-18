package support;

import org.w3c.dom.Element;
import yose.support.FileContent;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;

public class LoadDocument {

    public static Element from(String file) throws Exception {
        String page = FileContent.of( file );
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        return builder.parse( new ByteArrayInputStream( page.getBytes() ) ).getDocumentElement();
    }
}
