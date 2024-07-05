import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderToJson {
    public static void main(String[] args) throws JsonProcessingException {
        Order order = new Order(1, "Asiri",
                new BigDecimal("25000.75"), LocalDate.now());

        /* need to create the mapper object like below adding modules */
        ObjectMapper mapper = JsonMapper.builder().findAndAddModules().build();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        String json = mapper.writeValueAsString(order);
        System.out.println(json);
    }
}
