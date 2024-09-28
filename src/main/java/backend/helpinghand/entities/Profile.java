package backend.helpinghand.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name="profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private String email;
    private String address;
    private String phone;
    private String birthdate;


    @JsonIgnore
    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER)
    private List<Donation> donations;

    @JsonIgnore
    @OneToMany(mappedBy = "profile", fetch = FetchType.EAGER)
    private List<Comment> comments;
}
