package in.reqres.models.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterRequest {

    private String email;
    private String password;

    public RegisterRequest(String email) {

        this.email = email;
    }
}
