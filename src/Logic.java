import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.net.URI;
import java.util.ArrayList;

public class Logic {
	StringBuffer ret = new StringBuffer();
	ArrayList<Station> stations = new ArrayList<Station>();


	public Logic(){
		
	}
	
	public void getXML(String station){
	
		try{
			URI stationXML = new URI("http://api.irishrail.ie/realtime/realtime.asmx/getStationDataByCodeXML_WithNumMins?StationCode="+station+"&NumMins=30");
			DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dBF.newDocumentBuilder();
			Document results = dBuild.parse(stationXML.toString());
			results.getDocumentElement().normalize();
			 
			
			NodeList stationList = results.getElementsByTagName("objStationData");
			for(int i=0;i<stationList.getLength();i++){
				Node stationNode = stationList.item(i);
				if(stationNode.getNodeType()== Node.ELEMENT_NODE){
					Element stationElem = (Element) stationNode;
					String stat = getTagValue("Stationfullname", stationElem); 
					String due = getTagValue("Duein", stationElem);
					String des = getTagValue("Destination", stationElem);
					String status = getTagValue("Status", stationElem);
					String lastLoc = getTagValue("Lastlocation", stationElem);
					String dir = getTagValue("Direction", stationElem);
					
					Station newStation = new Station();
					newStation.setStation(stat, due, des, status, lastLoc, dir);
					stations.add(newStation);
					}
					
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if(nValue==null){return "No Status";}
		return nValue.getNodeValue();
	}
	  
	  
	
	
	
	public ArrayList<Station> returnStations(){
		return stations; 
	}
}