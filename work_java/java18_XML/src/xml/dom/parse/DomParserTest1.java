package xml.dom.parse;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

/* 
 * xml 파서
 * ::
 * xml 문서를 읽고, 해석하여서
 * 태그명, 속성이름, 값들을 분류해서 우리가 프로그램으로 다를수있게 해주는것
 * DOM | SAX
 * DOM : 트리구조의 객체로 올린다. 대용량에서 약간 힘들다
 * SAX : 
 */
public class DomParserTest1 {

	public static void main(String[] args) {
		//1.
		DocumentBuilder parser = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			parser = dbf.newDocumentBuilder();
			System.out.println(parser.getClass().getName());

			//2. xml 문서를 파싱한다.	Document를 리턴받는다.
			Document doc = parser.parse("addr.xml");
			
			//3.
			Element root =doc.getDocumentElement();
			System.out.println(root.getNodeName());
			System.out.println(root.getTagName());
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
