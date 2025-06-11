package exercise.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

// BEGIN
@Entity
@Table(name = "person")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
// END
