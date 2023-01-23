package BloodClinic.bloodclinic.dto;

import BloodClinic.bloodclinic.model.Address;
import BloodClinic.bloodclinic.model.Gender;

import javax.persistence.*;

public class RegistrationDto {
    public String email;
    public String passwordFirst;
    public String passwordSecond;
    public String name;
    public String surname;
    public AddressDto address;
    public String phone_number;
    public String jmbg;
    public Gender gender;
    public String job;
}
