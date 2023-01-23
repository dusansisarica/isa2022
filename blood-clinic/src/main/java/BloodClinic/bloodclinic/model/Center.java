package BloodClinic.bloodclinic.model;

import javax.persistence.*;

@Entity
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
