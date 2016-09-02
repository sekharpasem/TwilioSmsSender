package com.twiliosmssender.sender;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

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
