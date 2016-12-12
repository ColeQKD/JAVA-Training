package main.java.others;



import java.util.Comparator;

public class Person implements Comparable<Person> {

    public static Comparator<? super Person> choice;
    private String cnp;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String phoneNumber;


    public Person(String cnp, String firstName, String lastName, Integer age, String email, String phoneNumber) {
        this.cnp = cnp;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Person() {
    }

    ;


    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "cnp='" + cnp + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (getCnp() != null ? !getCnp().equals(person.getCnp()) : person.getCnp() != null) return false;
        if (getFirstName() != null ? !getFirstName().equals(person.getFirstName()) : person.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(person.getLastName()) : person.getLastName() != null)
            return false;
        if (getAge() != null ? !getAge().equals(person.getAge()) : person.getAge() != null) return false;
        if (getEmail() != null ? !getEmail().equals(person.getEmail()) : person.getEmail() != null) return false;
        return getPhoneNumber() != null ? getPhoneNumber().equals(person.getPhoneNumber()) : person.getPhoneNumber() == null;

    }

    @Override
    public int hashCode() {
        int result = getCnp() != null ? getCnp().hashCode() : 0;
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        return result;
    }

    public static final Comparator<Person> CnpComparator = new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.cnp.compareTo(p2.cnp);
        }
    };

    public static final Comparator<Person> FirstNameComparator = new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.firstName.compareTo(p2.firstName);
        }
    };

    public static final Comparator<Person> LastNameComparator = new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.lastName.compareTo(p2.lastName);
        }
    };

    public static final Comparator<Person> AgeComparator = new Comparator<Person>() {

        @Override
        public int compare(Person p1, Person p2) {
            return p1.getAge() - p2.getAge();  // This will work because age is positive integer
        }

    };

    public static final Comparator<Person> PhoneNumberComparator = new Comparator<Person>() {
        @Override
        public int compare(Person p1, Person p2) {
            return p1.getPhoneNumber().compareTo(p2.getPhoneNumber());
        }


    };


    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
