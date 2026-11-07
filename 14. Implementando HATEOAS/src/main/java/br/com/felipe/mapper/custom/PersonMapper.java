package br.com.felipe.mapper.custom;

import br.com.felipe.data.dto.v1.PersonDTO;
import br.com.felipe.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {



    public Person convertDTOEntity(PersonDTO person) {
        Person entity = new Person();
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
     //  entity.setBirthDay(new Date());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }
}
