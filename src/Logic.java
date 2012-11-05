import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.net.URI;
import java.util.ArrayList;

public class Logic {
	ArrayList<Station> stations = new ArrayList<Station>();


	public Logic(){
		
	}
	
	public void getXML(String station){
	
		try{
			//get the XML Result from the REST API and convert it to XML
			URI stationXML = new URI("http://api.irishrail.ie/realtime/realtime.asmx/getStationDataByCodeXML_WithNumMins?StationCode="+station+"&NumMins=30");
			DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuild = dBF.newDocumentBuilder();
			Document results = dBuild.parse(stationXML.toString());
			results.getDocumentElement().normalize();
			 
			//Create List of trains arriving at the stations based on the XML & Chosen station
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
		//method refined via research @ http://stackoverflow.com/questions/4976266/dom-xml-parser-java-same-tags
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if(nValue==null){return "No Status";}
		return nValue.getNodeValue();
	}
	  
	  
	
	
	
	public ArrayList<Station> returnStations(){
		if(stations.isEmpty()){return null;}
		return stations; 
	}
}