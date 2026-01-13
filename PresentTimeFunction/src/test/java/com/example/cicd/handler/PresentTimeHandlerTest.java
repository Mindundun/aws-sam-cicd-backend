package com.example.cicd.handler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class PresentTimeHandlerTest {

    @Test
    public void successfulResponseCheck() {
        PresentTimeHandler app = new PresentTimeHandler();
        APIGatewayProxyResponseEvent result = app.handleRequest(new APIGatewayProxyRequestEvent(), null);

        // 상태 코드가 200인지 확인
        assertEquals(Integer.valueOf(200), result.getStatusCode());

        // 헤더에 JSON 타입이 있는지 확인
        assertEquals("application/json", result.getHeaders().get("Content-Type"));

        // 바디에 "now"라는 글자가 들어있는지 확인
        String content = result.getBody();
        assertTrue(content.contains("\"now\""));
    }
}