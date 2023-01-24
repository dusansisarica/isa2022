package BloodClinic.bloodclinic.dto;

import BloodClinic.bloodclinic.model.Address;
import BloodClinic.bloodclinic.model.Gender;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
public class UserDto {
    public Integer id;
    public String email;
    public String password;
    public String name;
    public String surname;
    public Address address;
    public String phone_number;
    public String jmbg;
    public Gender gender;
    public String job;
    public boolean deleted;
    public boolean activated;
    public String verificationCode;
    public Integer penalty;


}
