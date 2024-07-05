import com.fasterxml.jackson.annotation.JsonProperty;

public record Employee(Integer id,
                        /* to change name of property in json */
                       @JsonProperty("first_name") String firstName,
                       @JsonProperty("last_name") String lastName,
                       String contact) {
}
