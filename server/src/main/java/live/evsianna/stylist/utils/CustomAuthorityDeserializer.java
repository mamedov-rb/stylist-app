package live.evsianna.stylist.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Rustam Mamedov
 */

public class CustomAuthorityDeserializer extends JsonDeserializer {

    @Override
    public Object deserialize(JsonParser jp, DeserializationContext context) throws IOException {
        final ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        final JsonNode jsonNode = mapper.readTree(jp);
        final List<GrantedAuthority> grantedAuthorities = new LinkedList<>();

        final Iterator<JsonNode> elements = jsonNode.elements();
        while (elements.hasNext()) {
            final JsonNode next = elements.next();
            final JsonNode authority = next.get("authority");
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.asText()));
        }
        return grantedAuthorities;
    }

}
