package uvt.services;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final ClientComponent clientComponent;
    @GetMapping("/")
    public String helloWorld() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/client")
    public String helloClient() {
        return "Hello from ClientComponent = " + clientComponent.toString();
    }
}
