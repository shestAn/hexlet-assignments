package exercise.controller;

import exercise.daytime.Daytime;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// BEGIN
@RestController
@AllArgsConstructor
public class WelcomeController {

    private final Daytime datetime;

    @GetMapping("/welcome")
    public String showWelcome() {
        return "It is %s now! Welcome to Spring!".formatted(datetime.getName());
    }

}
// END
