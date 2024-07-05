import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class JavaObjectToJson {
    public static void main(String[] args) throws JsonProcessingException {
        Customer customer = new Customer(1, "Kasun Sampath", "Galle");

        /* this is not an easy task when dealing with complex objects*/
//        String json= """
//                {
//                "id": %s,
//                "name": "%s",
//                "contact": "%s"
//                }
//                """.formatted(customer.getId(),customer.getName(),customer.getAddress());
//        System.out.printf(json);

        /* therefore we use this kind of APIs */
        ObjectMapper mapper = new ObjectMapper();

        // to enable standard indentation ("pretty-printing"):
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String json = mapper.writeValueAsString(customer);
        System.out.println(json);

        /* if object cannot be converted to json directly put properties to a hashmap
        * and then convert, this is the last option, linked hash map can be used
        * to preserve the order of properties*/
        Map<String, Object> properties = new LinkedHashMap<>();
        properties.put("id", customer.getId());
        properties.put("name", customer.getName());
        properties.put("contact", customer.getAddress());
        String json2 = mapper.writeValueAsString(properties);
        System.out.println(json2);
    }
}
