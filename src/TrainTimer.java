import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


@SuppressWarnings("serial")
public class TrainTimer extends HttpServlet { 
  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException 
  {
	//JSP Form Response
	StringBuilder phone = new StringBuilder();
    String StationC = request.getParameter("StationCode");
    File newFile = new File("tmp","test.xml");
    System.out.println(newFile.getAbsolutePath());
    phone.append(request.getParameter("phone"));
    if(phone.charAt(0)=='0'){
    phone.replace(0, 1, "+353"); //Twilio requires country Codes, so this is to add that, unless it has been entered by the user
    }
    StringBuilder data = new StringBuilder();
    Logic trainLogic = new Logic(); //Call the logic Class
    
    //Processing is performed by the logic class
    trainLogic.getXML(StationC);
    ArrayList<Station> trains = trainLogic.returnStations();
    Collections.sort(trains, new Comparator<Station>(){
    	public int compare(Station sta1, Station sta2){ //sort the array for Text transmission
    		Integer s1 = Integer.parseInt(sta1.getDue());
    		Integer s2 = Integer.parseInt(sta2.getDue());
    		return s1.compareTo(s2);}});
    data.append("Traintimer("+trains.get(1).getSta()+"):\n");
    for(int i=0;i<trains.size();i++){
    	if(data.length()>140){
    	}else{
    		data.append((i+1)+". Train for "+trains.get(i).getDes()+" due in "+trains.get(i).getDue()+" Mins\n");
    	}
    }
    /*SendSMS sms = new SendSMS(); //sendSMS class is built around http://www.twilio.com/resources/code/howtos/sms-notification/SendNotifications.java
    sms.doSend(phone.toString(), data.toString()); //sends SMS*/
    
   request.setAttribute("results", trains); //Forward the result to a Results JSP page
   request.getRequestDispatcher("/Result.jsp").forward(request, response);
   try {
	Thread.sleep(60000);
} catch (InterruptedException e) {
	e.printStackTrace();
}
  }  
}