package test.java.latintrainer.handlers;


import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.response.ResponseBuilder;

import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TestUtil {

    public static HandlerInput mockHandlerInput(Map<String, Object> sessionAttributes,
                                                Map<String, Object> persistentAttributes,
                                                Map<String, Object> requestAttributes) {
        return mockHandlerInput(Collections.emptyMap(), sessionAttributes, persistentAttributes, requestAttributes);
    }

    public static HandlerInput mockHandlerInput(String key, String value,
                                                Map<String, Object> sessionAttributes,
                                                Map<String, Object> persistentAttributes,
                                                Map<String, Object> requestAttributes) {
        return mockHandlerInput(Collections.singletonMap(key, value), sessionAttributes, persistentAttributes, requestAttributes);
    }

    public static HandlerInput mockHandlerInput(Map<String, String> slotValues,
                                                Map<String, Object> sessionAttributes,
                                                Map<String, Object> persistentAttributes,
                                                Map<String, Object> requestAttributes) {
        final AttributesManager attributesManagerMock = Mockito.mock(AttributesManager.class);
        when(attributesManagerMock.getSessionAttributes()).thenReturn(sessionAttributes);
        when(attributesManagerMock.getPersistentAttributes()).thenReturn(persistentAttributes);
        when(attributesManagerMock.getRequestAttributes()).thenReturn(requestAttributes);


        // Mock Slots
        Intent.Builder intentBuilder = Intent.builder();
        slotValues.forEach((key, value) -> intentBuilder.putSlotsItem(key, Slot.builder()
                .withName(key)
                .withValue(value)
                .build()));

        final RequestEnvelope requestEnvelopeMock = RequestEnvelope.builder()
                .withRequest(IntentRequest.builder()
                        .withIntent(intentBuilder.build())
                        .build())
                .build();

        // Mock Handler input attributes
        final HandlerInput input = Mockito.mock(HandlerInput.class);
        when(input.getAttributesManager()).thenReturn(attributesManagerMock);
        when(input.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(input.getRequestEnvelope()).thenReturn(requestEnvelopeMock);

        return input;
    }

    public static Response standardTestForHandle(RequestHandler handler, String slotName, String slotValue) {
        final Map<String, Object> sessionAttributes = new HashMap<>();
        final Map<String, Object> persistentAttributes = new HashMap<>();
        sessionAttributes.put(slotName, slotValue);
        final HandlerInput inputMock = TestUtil.mockHandlerInput(slotName, slotValue, sessionAttributes, persistentAttributes, null);
        final Optional<Response> res = handler.handle(inputMock);

        assertTrue(res.isPresent());
        final Response response = res.get();

        //assertFalse(response.getShouldEndSession());
        assertNotEquals("Test", response.getReprompt());
        assertNotNull(response.getOutputSpeech());
        return response;
    }


    public static Response standardTestForHandle(RequestHandler handler, Map<String, String> slots) {
        final Map<String, Object> sessionAttributes = new HashMap<>();
        final Map<String, Object> persistentAttributes = new HashMap<>();
        persistentAttributes.putAll(slots);
        sessionAttributes.putAll(slots);
        final HandlerInput inputMock = TestUtil.mockHandlerInput(slots, sessionAttributes, persistentAttributes, null);
        final Optional<Response> res = handler.handle(inputMock);

        assertTrue(res.isPresent());
        final Response response = res.get();

        //assertFalse(response.getShouldEndSession());
        assertNotEquals("Test", response.getReprompt());
        assertNotNull(response.getOutputSpeech());
        return response;
    }


    public static Response standardTestForHandle(RequestHandler handler) {
        final Map<String, Object> sessionAttributes = new HashMap<>();
        sessionAttributes.put("Modus", "Test");
        sessionAttributes.put("Kapitel", "1");
        sessionAttributes.put("highscore", "Test");
        final HandlerInput inputMock = TestUtil.mockHandlerInput(sessionAttributes, null, null);
        final Optional<Response> res = handler.handle(inputMock);

        assertTrue(res.isPresent());
        final Response response = res.get();

        //assertFalse(response.getShouldEndSession());
        assertNotEquals("Test", response.getReprompt());
        assertNotNull(response.getOutputSpeech());
        return response;
    }

    public static Response sessionEndedTestForHandle(RequestHandler handler) {
        final HandlerInput inputMock = TestUtil.mockHandlerInput(null,  null, null, null);
        final Optional<Response> res = handler.handle(inputMock);

        assertTrue(res.isPresent());
        final Response response = res.get();
        assertTrue(response.getShouldEndSession());
        return response;
    }
}



