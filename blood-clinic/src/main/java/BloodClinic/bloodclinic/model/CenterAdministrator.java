package BloodClinic.bloodclinic.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class CenterAdministrator extends User {

    @ManyToOne
    @JsonBackReference
    private Center center;
}
