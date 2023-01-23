package BloodClinic.bloodclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "email")
    private String email;
    @Column
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @Column
    private String phone_number;
    @Column
    private String jmbg;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column
    private String job;
    @Column
    private boolean deleted;
    @Column
    private boolean activated;
    @Column(name = "verification_code", length = 64)
    private String verificationCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public User(Integer id, String email, String password, String name, String surname, Address address, String phone_number, String jmbg, String job, Gender gender) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone_number = phone_number;
        this.jmbg = jmbg;
        this.job = job;
        this.gender = gender;
    }

    public User() {
    }

    public User(Integer id, String email, String password, String name, String surname, Address address, String phone_number, String jmbg, Gender gender, String job) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone_number = phone_number;
        this.jmbg = jmbg;
        this.gender = gender;
        this.job = job;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
