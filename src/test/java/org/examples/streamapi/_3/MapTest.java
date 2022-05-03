package org.examples.streamapi._3;


import org.examples.streamapi.model.Person;
import org.examples.streamapi.model.PersonDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.examples.streamapi.TestUtil.PEOPLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MapTest {

    @Test
    void mapPersonObjectsToStrings_comments() {
        List<String> names = PEOPLE
                .stream()
                .map(
                        (person) -> {
                            return person.getName();
                        }
                )
                .toList();
        // Certainly not the best way to check the returned list, but it will do for this case ;)
        assertEquals("Alec", names.get(0));
        assertEquals("Alivia", names.get(19));
        assertEquals(20, names.size());
    }

    @Test
    void mapPersonObjectsToStrings() {

        List<String> names = PEOPLE
                .stream()
                /*
                    The syntax can get even crazier - but this is just a syntax sugar!
                    It's the same as in the first example, so use the extended (the most obvious version)
                    and then use IntelliJ to get to the most straightforward ( at the beginning, the craziest) syntax.
                 */
                .map(Person::getName)
                .toList();

        assertEquals("Alec", names.get(0));
        assertEquals("Alivia", names.get(19));
        assertEquals(20, names.size());
    }

//    Time for some practice:
//     - map to List<Integers> (age)

    @Test
    void mapPersonObjectToIntegerAge(){

        List<Integer> age = PEOPLE
                .stream()
                .map(Person::getAge)
                .toList();

        assertEquals(20, age.get(0));
        assertEquals(21, age.get(19));
        assertEquals(20, age.size());
    }


//     - map to List<String> (lastName)

    @Test
    void mapPersonObjectToStringLastname(){

        List<String> lastname = PEOPLE
                .stream()
                .map(Person::getLastName)
                .toList();

        assertEquals("Gunn", lastname.get(0));
        assertEquals("Parrish",lastname.get(19));
        assertEquals("Winters", lastname.get(6));
        assertEquals(20, lastname.size());
    }


//     - map to List<Person.GENDER>

    @Test
    void mapPersonObjectToStringGender(){

        List<Person.Gender> gender = PEOPLE
                .stream()
                .map(Person::getGender)
                .toList();

        assertEquals("Male", gender.get(0));
        assertEquals("Female", gender.get(19));;
        assertEquals(20, gender.size());
    }



//     extras: map List<Person> to List<PersonDTO>


    // USING BASIC LAMBDA SYNTAX

    @Test
    void mapPersonObjectsToPersonDTOObjects() {

        List<PersonDTO> names = PEOPLE                    // <PersonDTO because that's the end thing we get object of type personDTO
                // list of type person, stream it
                .stream()                                    // List : [person1,person2, person3...]
                .map(                                        // map according to lambda - recipe

                        // Recipe   //  A map Method that transforms object of type person to an object of type PersonDTO

                        (person) -> {  // person goes in
                            String name = person.getName();
                            String lastName = person.getLastName();
                            return new PersonDTO(name,lastName);
                        }

                )
                .toList();

        // convert it back to a list
        // Certainly not the best way to check the returned list, but it will do for this case ;)


        assertEquals("Alec", names.get(0).getName());
        assertEquals("Alivia", names.get(19).getName());
        assertEquals(20, names.size());
    }



}





