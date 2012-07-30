package org.springframework.social.foursquare.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class VenueBeenHereTest {

    @Test
    public void shouldParseCount() throws JsonParseException, JsonMappingException, IOException {
        String beenHereJson = "{\"count\":3}";
        ObjectMapper mapper = new ObjectMapper();
        VenueBeenHere beenHere = mapper.readValue(beenHereJson, VenueBeenHere.class);
        assertEquals(3, beenHere.getCount());
        assertFalse(beenHere.isMarked());
    }
    
    @Test
    public void shouldParseCountAndMarkedFalse() throws JsonParseException, JsonMappingException, IOException {
        String beenHereJson = "{\"count\":3, \"marked\":false}";
        ObjectMapper mapper = new ObjectMapper();
        VenueBeenHere beenHere = mapper.readValue(beenHereJson, VenueBeenHere.class);
        assertEquals(3, beenHere.getCount());
        assertFalse(beenHere.isMarked());
    }
    
    @Test
    public void shouldParseCountAndMarkedTrue() throws JsonParseException, JsonMappingException, IOException {
        String beenHereJson = "{\"count\":3, \"marked\":true}";
        ObjectMapper mapper = new ObjectMapper();
        VenueBeenHere beenHere = mapper.readValue(beenHereJson, VenueBeenHere.class);
        assertEquals(3, beenHere.getCount());
        assertTrue(beenHere.isMarked());
    }
}
