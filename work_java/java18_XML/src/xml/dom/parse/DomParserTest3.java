package xml.dom.parse;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class DomParserTest3 {
	public static void main(String[] args) throws Exception {
		//1.
		DocumentBuilder parser = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			parser = dbf.newDocumentBuilder();
			System.out.println(parser.getClass().getName());

			//2. xml 문서를 파싱한다.	Document를 리턴받는다.
			Document doc = parser.parse("addr.xml");
			
			//3. root를 얻어낸다.
			Element root =doc.getDocumentElement();
			System.out.println(root.getNodeName());
			System.out.println(root.getTagName());
			
			//4. root의 첫번째 자식을 얻어낸다.
			getNode(root);
	}
	public static void getNode(Node root)	// 인자값을 Node로 입력...
	{
		for(Node ch = root.getFirstChild() ; ch != null ; ch = ch.getNextSibling())
		{
			if(ch.getNodeType() == Node.ELEMENT_NODE)	//1
			{
				System.out.println(ch.getNodeName());
				getNode(ch);
			}
			else if(ch.getNodeType() == Node.TEXT_NODE && ch.getNodeValue().trim().length() != 0)
			{
				System.out.println(ch.getNodeValue());
			}
		}
	}

}
