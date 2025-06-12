package exercise.daytime;

import jakarta.annotation.PostConstruct;

public class Day implements Daytime {
    private String name = "day";

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
