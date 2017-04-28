import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.*;
import org.w3c.dom.NodeList;
import org.w3c.*;
import java.util.ArrayList;

public class XMLParser{

    public static void main(String [] args){
        try {
            File file = new File("staff.xml");
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            Function change = new Function()
    {
    public void changeTagName(NodeList node) {
        try{
        File file = new File("staff.xml");
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the originalTagName");
        String fromTag = br.readLine();
        System.out.println("Enter the newTagName");
        String toTag = br.readLine();

        NodeList nodes = doc.getElementsByTagName(fromTag);
        node = nodes;
        for (int i = 0; i < nodes.getLength(); i++) {
               if (nodes.item(i) instanceof Element) {
                Element elem = (Element)nodes.item(i);
                doc.renameNode(elem, elem.getNamespaceURI(), toTag);
                System.out.println(elem.getNodeName());
            }
        }
    }

    catch (Exception e) {
            System.out.println(e.getMessage());
           }

    }
    };

	Function clone = new Function()
    {
    public void changeTagName(NodeList node) {
        try{
        File file = new File("staff.xml");
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the TagName");
        String fromTag = br.readLine();
	   Node targetSections = doc.getElementsByTagName(fromTag).item(0);
	   Node sourceSection = dBuilder.parse(file).getElementsByTagName(fromTag).item(0);
	   targetSections.appendChild(doc.adoptNode(sourceSection.cloneNode(true)));
       System.out.println("Node : "+targetSections.getNodeName()+" ");
	}

    catch (Exception e) {
            System.out.println(e.getMessage());
           }

    }
    };

    Function add = new Function()
    {
    public void changeTagName(NodeList node) {
        try{
        File file = new File("staff.xml");
        DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = dBuilder.parse(file);  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the new element");
        String fromTag = br.readLine();
        System.out.println("Enter the content");
        String toTag = br.readLine();               
       
        Node node1 = doc.createElement(fromTag);
        node1.setTextContent(toTag);
        System.out.println(node1.getNodeName());
        System.out.println(node1.getTextContent());  
        }

        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    };

    Function fetch = new Function()
    {
    public void changeTagName(NodeList node) {
        try{
        ArrayList<Node> nodelst= new ArrayList<Node>();
            for (int count=0;count<node.getLength();count++){
                Node temp = node.item(count);
                nodelst.add(temp);
                if(temp.hasChildNodes()){
                    NodeList temp_child= temp.getChildNodes();
                    changeTagName(temp_child);
                    for (int c=0;c<temp_child.getLength();c++){
                        Node child_node = node.item(c);
                        nodelst.add(child_node);
                    }
                }
            }
        for (Node n : nodelst){          
            System.out.println(n.getNodeName() + n.getNodeValue());       
        }
    }

    catch (Exception e) {
            System.out.println(e.getMessage());
           }

    }
    };


     //   Mymap.call(add, doc.getChildNodes());
    //	Mymap.call(change, doc.getChildNodes());
	  //  Mymap.call(clone, doc.getChildNodes());

        Myfilter.call(fetch, doc.getChildNodes());
        }
        
        catch (Exception e) {
            System.out.println(e.getMessage());
           }
    
    }

}


interface Function{
    public void changeTagName(NodeList nodeList);
}

class Mymap{

    public static void call(Function fn, NodeList nodelist){
        fn.changeTagName(nodelist);
    }
}

class Myfilter{

    public static void call(Function fn, NodeList nodelist){
        fn.changeTagName(nodelist);
    }
}



