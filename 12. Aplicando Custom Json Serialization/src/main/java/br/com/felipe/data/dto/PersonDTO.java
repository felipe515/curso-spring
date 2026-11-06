package br.com.felipe.data.dto;

//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//import tools.jackson.databind.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import tools.jackson.databind.annotation.JsonSerialize;
import br.com.felipe.serializer.GenderSerializer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

//@JsonPropertyOrder({"id", "address", "first_name", "last_name", "gender"})
public class PersonDTO implements Serializable{

    private static final long serialVersionUID = 1L;


    private Long id;
//    @JsonProperty("first_name")
    private String firstName;
//    @JsonProperty("last_name")
    private String lastName;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDay;
    private String address;
//    @JsonIgnore
    @JsonSerialize(using = GenderSerializer.class)
    private String gender;

    private String sensitiveDate;

    public PersonDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getSensitiveDate() {
        return sensitiveDate;
    }

    public void setSensitiveDate(String sensitiveDate) {
        this.sensitiveDate = sensitiveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(id, personDTO.id) && Objects.equals(firstName, personDTO.firstName) && Objects.equals(lastName, personDTO.lastName) && Objects.equals(birthDay, personDTO.birthDay) && Objects.equals(address, personDTO.address) && Objects.equals(gender, personDTO.gender) && Objects.equals(sensitiveDate, personDTO.sensitiveDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthDay, address, gender, sensitiveDate);
    }
}
