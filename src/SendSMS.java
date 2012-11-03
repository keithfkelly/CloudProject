import java.util.HashMap;
import java.util.Map;
 
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.TwilioRestResponse;
import com.twilio.sdk.resource.factory.SmsFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Sms;
import com.twilio.sdk.resource.factory.CallFactory;

public class SendSMS {
	
	public static final String ACCOUNTSID="AC4ec831329d317ff210717149d88ce48d";
	public static final String AUTHTOKEN ="1bed194febf4682c9eed34871f5c739a";
	
	public void doSend(String to, String data){
		TwilioRestClient trainClient =new TwilioRestClient(ACCOUNTSID, AUTHTOKEN);
		Account keithTwilio = trainClient.getAccount();
		SmsFactory keithSMS = keithTwilio.getSmsFactory();
		CallFactory keithCall = keithTwilio.getCallFactory();
		
		Map<String,String> smsDetails = new HashMap<String,String>();
		smsDetails.put("From", "702-505-4171");
		smsDetails.put("To", to);
		smsDetails.put("Body", data);
		
		try{
			Sms trainAlert = keithSMS.create(smsDetails);
		}catch (TwilioRestException e){e.printStackTrace();}
		
		
	}
}
