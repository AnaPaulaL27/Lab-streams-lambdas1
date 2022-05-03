package org.examples.streamapi._4;

import org.examples.streamapi.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.examples.streamapi.TestUtil.PEOPLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredicateTest {
/*
    We used Predicates with the Stream's filter method.


    In Java, each method must belong to a Type - there are no methods on their own.
    Every lambda we pass is an implementation of a functional interface - (a functional interface is an interface with one method only).

    We can assign a lambda to a reference which sometimes may be helpful write more reusable code.

 */

    @Test
    void filterUsingAPredicate() {
        // Use lambda expression and assign it to a variable

        Predicate<Person> ageMoreThan30 = (person) -> {
            return person.getAge() > 30;
        };

        Predicate<Person> ageLessThan20 = (person) -> {
            return person.getAge() < 20;
        };

        List<Person> peopleOlderThan30AndYoungerThen20 = PEOPLE
                .stream()
                // Time to use the predicates ?
                .filter(ageLessThan20.or(ageLessThan20))
                .toList();

        assertEquals(5, peopleOlderThan30AndYoungerThen20.size());
    }


//            Time for some practice:
//             - create the same test but this time use IntelliJ to help you get rid of unnecessary code in the lambdas
    //             (e.g. return keyword)

    @Test
    void filterUsingAPredicate2() {
        // Use lambda expression and assign it to a variable

        Predicate<Person> ageMoreThan30 = (person) -> person.getAge() > 30;

        Predicate<Person> ageLessThan20 = (person) -> person.getAge() < 20;

        List<Person> peopleOlderThan30AndYoungerThen20 = PEOPLE
                .stream()
                // Time to use the predicates ?
                .filter(ageLessThan20.or(ageLessThan20))
                .toList();

        assertEquals(5, peopleOlderThan30AndYoungerThen20.size());
    }


    //             - use FilterTest exercises again, but this time with the help of predefined predicates
//     - filter by: age < 20 && age > 30
    @Test
    void PredicateIsAgeBelow20orHigher30() {
        Predicate<Person> ageMoreThan30 = (person) -> person.getAge() > 30;

        Predicate<Person> ageLessThan20 = (person) -> person.getAge() < 20;

        List<Person> peopleOlderThan30AndYoungerThen20 = PEOPLE
                .stream()

                .filter(ageLessThan20.or(ageMoreThan30))
                .toList();

        assertEquals(11, peopleOlderThan30AndYoungerThen20.size());
    }


    @Test
    void PredicatePeopleYoungerThan20() {
        Predicate<Person> ageLessThan20 = (person) -> person.getAge() < 20;

        List<Person> peopleYoungerThan20 = PEOPLE
                .stream()

                .filter(ageLessThan20)
                .toList();

        assertEquals(5, peopleYoungerThan20.size());
    }


    @Test
    void PredicatePeopleFirstLetterZAndAgeBelow20() {
        Predicate<Person> firstLetterZ = (person) -> person.getName().startsWith("Z");
        Predicate<Person> ageLessThan20 = (person) -> person.getAge() < 20;


        List<Person> PeopleFirstLetterZAndAgeBelow20 = PEOPLE
                .stream()

                .filter(firstLetterZ.and(ageLessThan20))
                .toList();

        assertEquals(1, PeopleFirstLetterZAndAgeBelow20.size());
    }


    @Test
    void PredicatePeopleGenderNonBinaryAgeGreater30() {
        Predicate<Person> genderNonBinary = (person) -> person.getGender() == Person.Gender.NON_BINARY;
        Predicate<Person> ageMoreThan30 = (person) -> person.getAge() > 30;


        List<Person> PeopleGenderNonBinaryAgeGreater30 = PEOPLE
                .stream()

                .filter(genderNonBinary.and(ageMoreThan30))
                .toList();

        assertEquals(2, PeopleGenderNonBinaryAgeGreater30.size());
    }

    @Test
    void PredicatePeopleLastNameLetterBAndAgeGreater50() {
        Predicate<Person> lastNameLetterB = (person) -> person.getLastName().startsWith("B");
        Predicate<Person> ageMoreThan50 = (person) -> person.getAge() > 50;


        List<Person> PeopleGenderNonBinaryAgeGreater30 = PEOPLE
                .stream()

                .filter(lastNameLetterB.and(ageMoreThan50))
                .toList();

        assertEquals(1, PeopleGenderNonBinaryAgeGreater30.size());

    }
}







