import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.net.URI;
import java.net.URL;
import java.io.File;

public class Logic {
	StringBuffer ret = new StringBuffer();


	public Logic(){
		
	}
	
	public void getXML(String station){
		try{
			URI XMLResult = new URI("http://api.irishrail.ie/realtime/realtime.asmx/getStationDataByCodeXML_WithNumMins?StationCode="+station+"&NumMins=30");
			DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dBF.newDocumentBuilder();
			Document results = dBuild.parse(XMLResult.toString());
			results.getDocumentElement().normalize();
			
			NodeList stationList = results.getElementsByTagName("objStationData");
			for(int i=0;i<1/*stationList.getLength()+1*/;i++){
				Node stationNode = stationList.item(i);
				if(stationNode.getNodeType()== Node.ELEMENT_NODE){
					Element stationElem = (Element) stationNode;
						ret.append("\n" + "Due in: " + getTagValue("Duein", stationElem)+"<br/>");
						ret.append("\n" + "Status :" + getTagValue("Lastlocation", stationElem)+"<br/>");
						ret.append("\n" + " Direction : " + getTagValue("Direction", stationElem)+"<br/>");
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
	  
	  
	
	
	
	public String returnString(){
		String returnS = this.ret.toString();
		return returnS; 
	}
}