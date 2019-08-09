package com.ssafy.weather;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherDAO {
	
	List<Weather> list = new ArrayList<Weather>();
	
	public List<Weather> getNewsList(String url)
	{
		list.clear();
		connectXML(url);//GUI print list
		
		return list;
	}
	
	private void connectXML(String url)
	{
		//1. 파서 리턴
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			MyHandler handler = new MyHandler();
			parser.parse(new URL(url).openConnection().getInputStream(), handler);
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		//2. parsing ... url, handler
	}
	public class MyHandler extends DefaultHandler
	{
		Weather weather;
		StringBuffer sb;
		@Override
		public void startDocument() throws SAXException {
			sb = new StringBuffer();
		}
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if(qName.equalsIgnoreCase("data"))
			{
				weather = new Weather();
			}
		}
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			sb.append(ch,start,length);
		}
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(weather != null)
			{
				if(qName.equalsIgnoreCase("hour"))
				{
					weather.setHour(sb.toString().trim());
				}
				else if(qName.equalsIgnoreCase("temp"))
				{
					weather.setTemp(sb.toString().trim());
				}
				else if(qName.equalsIgnoreCase("wfKor"))
				{
					weather.setWfKor(sb.toString().trim());
				}
				else if(qName.equalsIgnoreCase("reh"))
				{
					sb.trimToSize();
					if(sb.length()>0)
						weather.setReh(sb.toString().trim());
				}
				else if(qName.equalsIgnoreCase("data"))
				{
					list.add(weather);
				}
				sb.setLength(0);
			}
		}
		@Override
		public void endDocument() throws SAXException {
		}
	}
}
