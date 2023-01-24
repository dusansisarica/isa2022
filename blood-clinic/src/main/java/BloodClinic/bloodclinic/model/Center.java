package BloodClinic.bloodclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Center {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "description")
    private String description;
    @Column(name = "avg_grade")
    private double avgGrade;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Appointment> appointments;

    public Center() {
    }

    public Center(String name, String address, String description, double avgGrade) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.avgGrade = avgGrade;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDescription() {
        return description;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
}
