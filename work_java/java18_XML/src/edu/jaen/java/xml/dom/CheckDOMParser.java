package edu.jaen.java.xml.dom;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CheckDOMParser
{
	public List<Check> getContent(String url)
	{
		List<Check> list = new ArrayList<Check>();
		
		//1.
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder parser = factory.newDocumentBuilder();
			Document doc = parser.parse(new URL(url).openConnection().getInputStream());
			Element root = doc.getDocumentElement();	//CheckList ... Check들... 
			NodeList items = root.getElementsByTagName("Check");
			
			for(int i = 0 ; i < items.getLength(); i++) // 6
			{
				Check check = new Check();
				Node item = items.item(i);
				check.setCode(item.getAttributes().getNamedItem("code").getNodeValue());
				check.setDate(item.getAttributes().getNamedItem("date").getNodeValue());
				
				NodeList properties = item.getChildNodes();
				for(int j = 0 ; j < properties.getLength(); j++)
				{
					Node property = properties.item(j);
					String name = property.getNodeName();
					if(name.equalsIgnoreCase("Clean"))
					{
						check.setClean(property.getFirstChild().getNodeValue());
					}
					else if(name.equalsIgnoreCase("Ready"))
					{
						check.setReady(property.getFirstChild().getNodeValue());
					}
					if(name.equalsIgnoreCase("Response"))
					{
						check.setResponse(property.getFirstChild().getNodeValue());
					}
					else if(name.equalsIgnoreCase("Request"))
					{
						if(property.getFirstChild() != null)
						{
							check.setRequest(property.getFirstChild().getNodeValue());
						}
					}//else if
				}//for
				list.add(check);
			}
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		return list;
	}
}
