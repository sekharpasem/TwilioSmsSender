Use this smsservice to send sms using Twilio Account<br>

-Step1: Extract zip file <br>
-Step2: Import it into your desired IDE as a maven project (example:eclips,netbeans etc)<br>
-Step3: Create an account in https://www.twilio.com/<br>
-Step4: SignUp and Login into your account<br>
-Step5: Goto Menu on left side select "Programmable sms",click on get started and click on get your first twilio number<br>
-step5: Random number appears on screen,if you want to change you can<br>
-step6: GOTO "Console" on left top,you will see Console dashboard and credentials, Copy ACCOUNT SID,AUTH TOKEN<br>

So which we are using is <br>
<br>
    \<dependency\><br>
			\<groupId\>com.twilio.sdk\</groupId\><br>
			\<artifactId\>twilio-java-sdk\</artifactId\><br>
			\<version\>5.9.0\</version\><br>
			\<scope\>compile\</scope\><br>
		\</dependency\><br>

Sender:<br>
public class TwilioSmsSender {
	public static void send(String to, String body) {
		TwilioRestClient client = new TwilioRestClient("Account SID", "AUTH Token");

		// Build the parameters
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("To", to));
		params.add(new BasicNameValuePair("From", "from number"));
		params.add(new BasicNameValuePair("Body", body));

		MessageFactory messageFactory = client.getAccount().getMessageFactory();
		Message message = null;
		try {
			// sends message
			message = messageFactory.create(params);
		} catch (TwilioRestException e) {

		}
	}

}
