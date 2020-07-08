package com.firman.utest.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":5}";

    @Test
    public void jsonAssert_StrictTrue_ExactMatchExceptForSpace() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":5}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_WithoutEscapeChars() throws JSONException {
        String expectedResponse = "{id:1, name:Ball, price:10}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

}
