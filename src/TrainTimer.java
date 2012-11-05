import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


@SuppressWarnings("serial")
public class TrainTimer extends HttpServlet {
	ArrayList<Station> trains;
	StringBuilder phone = new StringBuilder();
	StringBuilder data = new StringBuilder();
	String comms;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//JSP Form Response

		String StationC = request.getParameter("StationCode");
		comms = request.getParameter("comms");
		phone.append(request.getParameter("phone"));
		if(phone.charAt(0)=='0'){
			phone.replace(0, 1, "+353"); //Twilio requires country Codes, so this is to add that, unless it has been entered by the user
		}

		Logic trainLogic = new Logic(); //Call the logic Class

		//Processing is performed by the logic class
		trainLogic.getXML(StationC);
		trains = trainLogic.returnStations();
		//sort the array for Text transmission
		Collections.sort(trains, new Comparator<Station>(){
			public int compare(Station sta1, Station sta2){ 
				Integer s1 = Integer.parseInt(sta1.getDue());
				Integer s2 = Integer.parseInt(sta2.getDue());
				return s1.compareTo(s2);}});
				
			Comm();
			phone.delete(0, phone.length());
		//Forward the result to a Results JSP page
		request.setAttribute("results", trains); 
		request.getRequestDispatcher("/Result.jsp").forward(request, response);


	} 
	
	public void Comm() throws UnsupportedEncodingException{
		if(comms.equals("sms")){
			SmsSend();
		}else if(comms.equals("call")){
			CallSend();
		}
	}

	public void SmsSend(){ 
		//Generate SMS Body
		data.append("Traintimer("+trains.get(1).getSta()+"):\n");
		for(int i=0;i<trains.size();i++){
			if(data.length()>130){
			}else{
				data.append((i+1)+". Train for "+trains.get(i).getDes()+" due in "+trains.get(i).getDue()+" Mins\n");
			}
		}
		//sendSMS class is built around http://www.twilio.com/resources/code/howtos/sms-notification/SendNotifications.java
		SendSMS sms = new SendSMS(); 
		//sends SMS
		sms.doSend(phone.toString(), data.toString());
	}
	
	public void CallSend() throws UnsupportedEncodingException{ 
		//Generate SMS Body
		data.append("Train Timer for Station  "+trains.get(1).getSta()+"\n"+"<pause length=\"2\"/>");
		for(int i=0;i<trains.size();i++){
				data.append("<pause length=\"1\"/>"+(i+1)+". Train for "+trains.get(i).getDes()+" due in "+trains.get(i).getDue()+" Mins\n" +"<pause length=\"2\"/>");	
		}
		data.append("Thank you for using Train Timer");
		
		SendCall call = new SendCall();
		call.doSend(phone.toString(), data.toString());
	}
}
