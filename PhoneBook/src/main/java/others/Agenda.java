package main.java.others;



import java.util.*;


public class Agenda {


    public List<Person> persons = new ArrayList<Person>();


    public Person add(Person p) {

        persons.add(p);
//        System.out.println("This new person was added : " + p);
        return p;

    }

    public void deletePerson(Person p) {

        persons.remove(p);
    }

    public Person updatePerson(Person p) {

        if (persons.contains(p)) {
            persons.remove(p);
        }
        return add(p);

    }

    public Person readPerson(String cnp) {

        Person person1 = new Person();
        for (int i = 0; i < persons.size(); i++) {

            if (persons.get(i).getCnp().equals(cnp)) {

                person1 = persons.get(i);

            }
        }
        return person1;
    }

    public List<Person> listAll() {

        return persons;

    }

//    USING A COMPARATOR / IMPLEMENTING THE COMPARABLE INTERFACE
//    public void sortAll(String criteriu) {
//
//        switch (criteriu) {
//
//            case "CNP":
//                Collections.sort(persons, Comparator.comparing(Person::getCnp));
//                break;
//            case "FIRSTNAME":
//                Collections.sort(persons, Comparator.comparing(Person::getFirstName));
//                break;
//            case "LASTNAME":
//                Collections.sort(persons, Comparator.comparing(Person::getLastName));
//                break;
//            case "AGE":
//                Collections.sort(persons, Person.AgeComparator);
//                break;
//            default:
//                Collections.sort(persons, Comparator.comparing(Person::getPhoneNumber));
//                criteriu = "PHONENUMBER";
//                break;
//        }
//
//        System.out.println("Printing the sorted array - sorted after " + criteriu + "! ");
//
//        for (Person listPerson : persons) {
//
//            System.out.println(listPerson);
//        }

//    }

//    Using an HashMap(String,Comparator<Person>)

    public void sortAll(String criteriu) {

        final Map<String, Comparator<Person>> mapaValori = new HashMap<>();

        mapaValori.put("CNP", Comparator.comparing(Person::getCnp));
        mapaValori.put("FIRSTNAME", Comparator.comparing(Person::getFirstName));
        mapaValori.put("LASTNAME", Comparator.comparing(Person::getLastName));
        mapaValori.put("AGE", Person.AgeComparator);
        mapaValori.put("OTHER", Comparator.comparing(Person::getPhoneNumber));

         Collections.sort(persons, mapaValori.get(criteriu));

        System.out.println("Printing the sorted array - sorted after " + criteriu + "! ");

        for (Person listPerson : persons) {

            System.out.println(listPerson);
        }
    }
}
