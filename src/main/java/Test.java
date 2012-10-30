import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class Test {
	
	StringBuffer ret;

	public Test(){
		
	}
	
	public void getXML(){
		try{
			File XMLResult = new File("getAllStationsXML.xml");
			DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dBF.newDocumentBuilder();
			Document results = dBuild.parse(XMLResult);
			results.getDocumentElement().normalize();
			
			NodeList stationList = results.getElementsByTagName("objStation");
			for(int i=0;i<stationList.getLength();i++){
				Node stationNode = stationList.item(i);
				if(stationNode.getNodeType()== Node.ELEMENT_NODE){
					Element stationElem = (Element) stationNode;
					ret.append("\n" + " Station Name: " + getTagValue("StationDesc", stationElem));
					
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}
	  
	  
	
	
	
	public String returnString(){return this.ret.toString();}
}