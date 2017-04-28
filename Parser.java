//package mypack;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;


public class Parser {
	//public static ArrayList <Node> nodelst= new ArrayList();
	public static void main(String[] args) {
		try {
			File file = new File("staff.xml");
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
                        			    .newDocumentBuilder();
			Document doc = dBuilder.parse(file);
//			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			//if (doc.hasChildNodes()) {
			///	printNote(doc.getChildNodes());
			//}
			//System.out.println("trial");
			//printNote(fetchNodes(doc.getElementsByTagName("staff")));
			//fetchNodes(doc.getElementsByTagName("nickname"));
			//System.out.println("ending trialmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm ");
		   } 

		catch (Exception e) {
			System.out.println(e.getMessage());
   		}

 	}

	 public static void printNote(NodeList nodeList) {
		for (int count = 0; count < nodeList.getLength(); count++) {
			Node tempNode = nodeList.item(count);// make sure it's element node.
			if (tempNode.getNodeType() == Node.ELEMENT_NODE) {	// get node name and value
			//	System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
			//	System.out.println("Node Value =" + tempNode.getTextContent());
				if (tempNode.hasAttributes()) {// get attributes names and values
					NamedNodeMap nodeMap = tempNode.getAttributes();
//nodelst.add(tempNode);			
					for (int i = 0; i < nodeMap.getLength(); i++) {
						Node node = nodeMap.item(i);
			//			System.out.println("attr name : " + node.getNodeName());
			//			System.out.println("attr value : " + node.getNodeValue());
					}
				}
				if (tempNode.hasChildNodes()) {// loop again if has child nodes
					printNote(tempNode.getChildNodes());
//nodelst.add();			
				}
			//	System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");

				}
		}
	//	for (Node n : nodelst){
	//		System.out.println(n.getNodeName());
	//		System.out.println(n.getNodeValue());
	//	}
	}

	public static ArrayList<Node> fetchNodes(NodeList nlst){
		ArrayList<Node> nodelst= new ArrayList<Node>();
			for (int count=0;count<nlst.getLength();count++){
				Node temp = nlst.item(count);
				nodelst.add(temp);
				if(temp.hasChildNodes()){
					NodeList temp_child= temp.getChildNodes();
					fetchNodes(temp_child);
					for (int c=0;c<temp_child.getLength();c++){
						Node child_node = nlst.item(c);
						nodelst.add(child_node);
					}
				}
			}
		for (Node node : nodelst){			
			System.out.println(node.getNodeName() + node.getNodeValue());		
		}
		return(nodelst);
	}

	
}

