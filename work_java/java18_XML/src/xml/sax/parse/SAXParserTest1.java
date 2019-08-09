package xml.sax.parse;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import edu.jaen.java.xml.sax.Check;

/*
 * SAX PARSER::
 * 	문서들을 순차적으로 읽어서 처리하는 이벤트 드리븐 방식의 파서
 * 메모리를 아주 적게 사용하고 그렇기에 속도가 빠르다.
 * 문서를 순차적으로 접근하지 구조적으로 접근하지 않기 때문에 
 * 문서를 변경하거나 조작할대 사용하는 파서는 아니다.
 */
public class SAXParserTest1 {
	public static void main(String[] args) {
		SAXParser parser = null;
		
		try {
			//1. 파서 리턴받고...
			SAXParserFactory ssf = SAXParserFactory.newInstance();
			parser = ssf.newSAXParser();
			
			//2.
			MySAXHandler handler = new MySAXHandler();
			parser.parse("addr.xml", handler);
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.out.println(e);
		}
		
		
	}

}//class

class MySAXHandler extends DefaultHandler
{
	@Override
	public void startDocument() throws SAXException {	// first
		System.out.println("XML Document START....");	// 단한번 호출....
	}
	@Override
	public void endDocument() throws SAXException {		// last
		System.out.println("XML Document END....");
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println("start Element : " + qName);
	}
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("end Element : " + qName + "\n");
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		System.out.println("charater is " + String.valueOf(ch,start,length));
	}
	//**********************************Error Handling***********************************************
	@Override
	public void warning(SAXParseException e) throws SAXException {
		System.out.println("-----------Warning");
	}
	@Override
	public void error(SAXParseException e) throws SAXException {
		System.out.println("-----------Error");
		super.error(e);
	}
	@Override
	public void fatalError(SAXParseException e) throws SAXException {
		System.out.println("-----------fatalError");
	}
	
}
