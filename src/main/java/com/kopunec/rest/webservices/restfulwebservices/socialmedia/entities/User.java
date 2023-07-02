package com.kopunec.rest.webservices.restfulwebservices.socialmedia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "user_details")
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Length(min = 2)
    String name;

    @Temporal(TemporalType.DATE)
    @Past
    @NonNull
    LocalDate birthDate;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    List<Post> posts;
}
