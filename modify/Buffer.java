//package mypack;
import org.w3c.dom.*;
//import ArrayList;
import java.util.ArrayList;
import java.util.*;
import javax.xml.parsers.*;
import java.io.*;

public class Buffer {
	public static void main(String[] args) {
		try {
			File file = new File("staff.xml");
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                        			    .newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			if (doc.hasChildNodes()) {
				printNote(doc.getChildNodes());
			}
			//modify(doc);
			/*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    		System.out.print("Please enter string : ");
    		String string = null;
    		try {
        		string = reader.readLine();
    		} catch (IOException e) {
        		e.printStackTrace();
    		}*/
			Function dbl= new Function()
			{
			 public void modify(Document doc){
 				Node company = doc.getFirstChild();
			// Get the staff element by tag name directly
				Node staff = doc.getElementsByTagName("staff").item(0);
				// update staff attribute
				NamedNodeMap attr = staff.getAttributes();
				Node nodeAttr = attr.getNamedItem("id");
				nodeAttr.setTextContent("2");
		// append a new node to staff
				Element age = doc.createElement("age");
				age.appendChild(doc.createTextNode("28"));
				staff.appendChild(age);
		// loop the staff child node
				NodeList list = staff.getChildNodes();
				for (int i = 0; i < list.getLength(); i++) {
                   Node node = list.item(i);
		   // get the salary element, and update the value
		   			if ("salary".equals(node.getNodeName())) {
					node.setTextContent("2000000");
		   			}
                   //remove firstname
		  			 if ("firstname".equals(node.getNodeName())) {
					staff.removeChild(node);
		   			}
		   		} 
 			 }
		    };
		System.out.println("\n\nmymap\n\n");
		printNote(Mymap.call(dbl,doc.getChildNodes()));
		System.out.println("");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
   		}

 	}
	public static void printNote(NodeList nodeList) {
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);	// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {	// get node name and value
				System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
				System.out.println("Node Value =" + tempNode.getTextContent());
				if (tempNode.hasAttributes()) {// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();
					for (int i = 0; i < nodeMap.getLength(); i++) {
						Node node = nodeMap.item(i);
						System.out.println("attr name : " + node.getNodeName());
						System.out.println("attr value : " + node.getNodeValue());
					}
				}
				if (tempNode.hasChildNodes()) {// loop again if has child nodes
					printNote(tempNode.getChildNodes());
				}
				System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");

				}
			}
	}

	interface Function
	{
		 void modify(Document doc);
	}

	class Mymap
	{
		public static ArrayList<Node> call(Function fn, NodeList nodeList)
		{
			ArrayList<Node> temparr = new ArrayList<Node>();
			for(int i=0;i<nodeList.getLength();i++)
			{
				Node temparr=fn.modify(nodeList.get(i));
			}
		return temparr;
		}
	}
}

