package com.yosanai.example.hialex;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.IntentRequest;
import com.amazon.speech.speechlet.LaunchRequest;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SessionEndedRequest;
import com.amazon.speech.speechlet.SessionStartedRequest;
import com.amazon.speech.speechlet.Speechlet;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

public class HelloSpeechlet implements Speechlet {

	@Override
	public SpeechletResponse onIntent(IntentRequest request, Session session) throws SpeechletException {
		SpeechletResponse ret = null;
		Intent intent = request.getIntent();
		if (intent.getName().equals("Hello")) {
			return getResponse("Saying hello", "Welcome");
		} else if (intent.getName().equals("HelloMe")) {
			return getResponse("Saying hello to you", "Welcome " + intent.getSlot("Who").getValue());
		} else if (intent.getName().equals("Add")) {
			return getResponse("Adding numbers",
					"The sum of the two numbers are " + (Integer.parseInt(intent.getSlot("NumberA").getValue())
							+ Integer.parseInt(intent.getSlot("NumberB").getValue())));
		} else {
			ret = getResponse("Hmm!", "I am clueless :-)");
		}
		return ret;
	}

	@Override
	public SpeechletResponse onLaunch(LaunchRequest request, Session session) throws SpeechletException {
		return getResponse("HelloWorld", "Welcome to the Alexa Skills Kit, you can say hello");
	}

	@Override
	public void onSessionEnded(SessionEndedRequest request, Session session) throws SpeechletException {
	}

	@Override
	public void onSessionStarted(SessionStartedRequest request, Session session) throws SpeechletException {
	}

	private SpeechletResponse getResponse(String title, String response) {
		SimpleCard card = new SimpleCard();
		card.setTitle(title);
		card.setContent(response);
		PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
		speech.setText(response);
		Reprompt reprompt = new Reprompt();
		reprompt.setOutputSpeech(speech);
		return SpeechletResponse.newAskResponse(speech, reprompt, card);
	}

}
