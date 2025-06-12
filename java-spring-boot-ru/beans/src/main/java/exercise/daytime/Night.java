package exercise.daytime;
import jakarta.annotation.PostConstruct;

public class Night implements Daytime {
    private String name = "night";

    public String getName() {
        return name;
    }

    // BEGIN
    @PostConstruct
    private void init() {
        System.out.printf("Bean %s has been created%n", this);
    }
    // END
}
