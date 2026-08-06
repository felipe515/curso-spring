package br.com.felipe.Services;

import br.com.felipe.exception.ResourceNotFoundException;
import br.com.felipe.model.Person;
import br.com.felipe.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        logger.info("Find All people");

        return repository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one person!");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("no records found this ID!"));
    }

    public Person create(Person person){
        logger.info("Creating one person!");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("updating one person!");
        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourceNotFoundException("no records found this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id){
        logger.info("deleting one person!");

        Person entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("no records found this ID!"));
        repository.delete(entity);
    }

}
