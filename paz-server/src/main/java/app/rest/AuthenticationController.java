package app.rest;

import app.exceptions.NotAcceptable;
import app.models.Cabin;
import app.models.User;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {


    @PostMapping(path = "login")
    public ResponseEntity<User> logIn(@RequestBody ObjectNode signInInfo){
        String email = signInInfo.get("email").asText();
        String password = signInInfo.get("password").asText();

        String[] emailSplit = email.split("@");

        if (Objects.equals(password, emailSplit[0])){
            User user = new User((int) (Math.random() * 100), emailSplit[0], email, "registered user", password);
            return ResponseEntity.accepted().header(HttpHeaders.AUTHORIZATION).body(user);
        } else{
            throw new NotAcceptable("Cannot authenticate user by email=" + email);
        }

    }
}
