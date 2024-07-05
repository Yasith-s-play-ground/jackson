import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToJavaObject {
    public static void main(String[] args) throws JsonProcessingException {
        String json = """
                {
                    "id":1,
                    "name":"Kasun Sampath",
                    "address":"Galle"
                }
                """;

        /* this is complex */
//        String pattern = """
//                {
//                "id"\\s+:\\s+(\\d+),
//                "name":"Kasun Sampath",
//                "contact":"Galle"
//                }
//                """;

        /* use object mapper to easily convert to a java object */
        ObjectMapper mapper = new ObjectMapper();
        Customer customer = mapper.readValue(json, Customer.class);
        System.out.println(customer);

    }
}
