package BloodClinic.bloodclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ComplaintAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column
    private String answer;
    @Column
    private String email;
    @OneToOne
    private ComplaintForWorker complaintForEmployee;
    @OneToOne
    private ComplaintForCenter complaintForCenter;
}
