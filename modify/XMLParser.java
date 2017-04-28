//package project;

import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.*;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.*;
import static java.lang.System.in;

public class XMLParser{
  void printNote(NodeList nodeList) {
        for (int count = 0; count < nodeList.getLength(); count++) {
            Node tempNode = nodeList.item(count);// make sure it's element node.
            if (tempNode.getNodeType() == Node.ELEMENT_NODE) {  // get node name and value
                System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
                System.out.println("Node Value =" + tempNode.getTextContent());
                if (tempNode.hasAttributes()) {// get attributes names and values
                    NamedNodeMap nodeMap = tempNode.getAttributes();
                    nodelst.add(tempNode);          
                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        Node node = nodeMap.item(i);
                        System.out.println("attr name : " + node.getNodeName());
                        System.out.println("attr value : " + node.getNodeValue());
                    }
                }
                if (tempNode.hasChildNodes()) {// loop again if has child nodes
                    printNote(tempNode.getChildNodes());
                    nodelst.add();          
                }
                System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");

                }
        }

    public static void main(String [] args){
        try {
            File file = new File("BookStore.xml");
            DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            Function changeTagName = new Function()
            
            {
            public void execute(NodeList node) {
                try{
                File file = new File("BookStore.xml");
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
                return (node);
    }

    catch (Exception e) {
            System.out.println(e.getMessage());
           }

    }
    };
    Function modify= new Function()
    {
             public void execute(NodeList node){
                try
                {
                /*Node company = doc.getFirstChild();
            // Get the staff element by tag name directly
                Node staff = doc.getElementsByTagName("staff").item(0);
                // update staff attribute
                NamedNodeMap attr = staff.getAttributes();
                Node nodeAttr = attr.getNamedItem("id");
                nodeAttr.setTextContent("2");
        // append a new node to staff
                Element age = doc.createElement("age");
                age.appendChild(doc.createTextNode("28"));
                staff.appendChild(age);*/
        // loop the staff child node
                    File file = new File("BookStore.xml");
                    DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                    Document doc = dBuilder.parse(file);
                    
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Enter the OldNodeValue");
                    String selectValue = br.readLine();
                    System.out.println("Enter the newNodeValue");
                    String modified = br.readLine();

             //       Node bookstore = doc.getFirstChild();
               //     System.out.println(bookstore.getNodeName());
                    //Node title = 
                    //NodeList books = bookstore.getChildNodes();
                    //node=books;
                    //Text oldvalue = (Text)node.item(0);
                    //String oldname = oldvalue.getData();
                    //System.out.println(oldname);
                    for (int i = 0; i < node.getLength(); i++) {
                        Node n = node.item(i);
                        System.out.println(n.getNodeValue());
                        if (selectValue.equals(n.getNodeValue())) {
                            System.out.println(n.getNodeValue());
                            Text text = (Text)node.item(0);
                            text.setData(modified);
                            System.out.println(n.getNodeValue()); /////////////////////////checks
                            //n.setTextContent(modified);
                            break;
                        }
                        else{
                            NodeList child= n.getChildNodes();
                            Node fn = child.item(0);
                            execute(child);
                            if(selectValue.equals(fn.getNodeValue())){
                                System.out.println(fn.getNodeValue());   ////////////////////checks
                                break;
                            }
                        }
                    }
                } 
                    //System.out.println("Enter the Paren id");
                    /*int pid=Integer.parseInt(br.readLine());
                    System.out.println("Enter the child id");
                    int cid=Integer.parseInt(br.readLine());*/
                    /*NodeList modified_value = doc.getElementsByTagName(selectValue);
                    modified_value.setTextContent(modified);
                    System.out.println("new value:"+modified_value.getNodeValue());*/
                    //NodeList list = doc.getChildNodes();
             
             catch (Exception e) {
            System.out.println(e.getMessage());
           }
        }
    };
            
           // Mymap mp= new Mymap();
            //changeTagName();
            Mymap.call(changeTagName, doc.getChildNodes());
            printNote(doc.getChildNodes());
            //Mymap.call(modify,doc.getChildNodes());
        }
        
        catch (Exception e) {
            System.out.println(e.getMessage());
           }
    
    }

}


interface Function{
    public void execute(NodeList nodeList);
    //public void modify();
}

class Mymap{

    public static void call(Function fn, NodeList nodelist){
        //ArrayList<Node> store = new ArrayList<Node>();
        //for(i=0;i<nodelist.getLength();i++){
        //    Node temp = nodelist.item(i);
        //    store.add(temp);
        //}

        //ArrayList<Node> nodes = new ArrayList<Node>();
        //for(Node s : store){
            fn.execute(nodelist);
            //fn.modify();
        //}
        //return(nodes);
    }
}


//


