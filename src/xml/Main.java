package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document d=builder.parse("test.xml");

        //document\element都实现了node，document是文本节点，根，element则是标签节点
        preorder(d,0);

    }

    private static void preorder(Node n, int m){
        if(n.getChildNodes().getLength()==0){
            return;
        }

        NodeList nodeList=n.getChildNodes();
        for(int i=0;i<nodeList.getLength();i++){

            //xml的子节点，不仅只有标签，纯文本，换行符也会被识别为子节点
            if(nodeList.item(i).getNodeType()==Node.ELEMENT_NODE){
                for(int j=0;j<m;j++) System.out.print("     ");
                System.out.println(nodeList.item(i).getNodeName());
                preorder(nodeList.item(i),m+1);
            }
        }
    }
}
