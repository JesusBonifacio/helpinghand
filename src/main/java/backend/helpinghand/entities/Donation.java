package backend.helpinghand.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name="donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float money_amount;
    private String donation_date;
    private String status;


    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;


    @ManyToOne
    @JoinColumn(name ="campaign_id")
    private Campaign campaign;
}
