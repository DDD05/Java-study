package edu.jaen.java.xml.sax;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class CheckSAXParser {
	List<Check> list;
	
	public List<Check> getcontent(String url)
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try
		{
			SAXParser parser = factory.newSAXParser();
			MyHandler handler = new MyHandler();
			parser.parse(new URL(url).openConnection().getInputStream() ,handler);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	
	class MyHandler extends DefaultHandler
	{
		Check check;
		StringBuffer sb;
		@Override
		public void startDocument() throws SAXException {
			list = new ArrayList<>();
			sb = new StringBuffer();
		}
		@Override
		public void startElement(String uri, String localName, String name, Attributes attributes)
				throws SAXException {
			if(name.equalsIgnoreCase("Check")) {
				check = new Check();
				check.setCode(attributes.getValue(0));
				check.setDate(attributes.getValue(1));
			}
		}
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			sb.append(ch,start,length);
		}
		@Override
		public void endElement(String uri, String localName, String name) throws SAXException {
			if(check != null)
			{
				if(name.equalsIgnoreCase("Clean"))
				{
					check.setClean(sb.toString().trim());
				}
				else if(name.equalsIgnoreCase("Ready"))
				{
					check.setReady(sb.toString().trim());
				}
				else if(name.equalsIgnoreCase("Response"))
				{
					check.setResponse(sb.toString().trim());
				}
				else if(name.equalsIgnoreCase("Request"))
				{
					sb.trimToSize();
					if(sb.length()>0)
						check.setRequest(sb.toString().trim());
				}
				else if(name.equalsIgnoreCase("Check"))
				{
					list.add(check);
				}
				sb.setLength(0);// 버퍼 초기화
			}//if check != null
			
		}//endElement
	}
}
