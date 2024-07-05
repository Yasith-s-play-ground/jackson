import com.fasterxml.jackson.annotation.JsonIgnore;

public record Student(Integer id,
                      String name,
                      String contact,
                      /* ignoring value */
                      @JsonIgnore byte[] profilePicture) {

}
