package backend.helpinghand.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name="organizations")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String org_name;
    private String org_description;
    private String org_email;
    private String org_phone;

    @JsonIgnore
    @OneToMany(mappedBy = "organization", fetch = FetchType.EAGER)
    private List<Campaign> campaigns;
}
