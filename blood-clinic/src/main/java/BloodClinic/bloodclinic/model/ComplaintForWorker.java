package BloodClinic.bloodclinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ComplaintForWorker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    private CenterAdministrator centerAdministrator;

    @ManyToOne
    @JsonIgnore
    private User user;

    @Column
    private String text;
}
