import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
 
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.CallFactory;
import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.resource.instance.Call;

public class SendCall{
	
	public static final String ACCOUNTSID="AC4ec831329d317ff210717149d88ce48d";
	public static final String AUTHTOKEN ="1bed194febf4682c9eed34871f5c739a";
	
	public void doSend(String to, String data) throws UnsupportedEncodingException{
		TwilioRestClient trainClient =new TwilioRestClient(ACCOUNTSID, AUTHTOKEN);
		Account keithTwilio = trainClient.getAccount();
		CallFactory keithCall = keithTwilio.getCallFactory();
		String say = data;
		String twiml = "<Response><Say voice=\"women\">" + say + "</Say></Response>";
		
		Map<String,String> callDetails = new HashMap<String,String>();
		callDetails.put("From", "702-505-4171");
		callDetails.put("To", to);
		callDetails.put("Url", "http://twimlets.com/echo?Twiml="+ URLEncoder.encode(twiml, "UTF-8"));
		
		try{
			Call trainAlert = keithCall.create(callDetails);
		}catch (TwilioRestException e){e.printStackTrace();}
		
		
	}
}
