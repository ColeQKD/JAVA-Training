package main.java.entities;

import java.util.Scanner;


public class Test {

    public static void main(String[] args) {

        Agenda testAgenda = new Agenda();

//        Person testPerson = new Person("18401", "Lucian", "Plopeanu", 26, "a@a.com", "0742544712");
//        testAgenda.add(testPerson);
//        testAgenda.deletePerson(testPerson);

        testAgenda.add(new Person("18403", "Lucian7", "Plopeanu4", 32, "a@a.com", "0742544715"));
        testAgenda.add(new Person("18404", "Lucian4", "Plopeanu5", 21, "a@a.com", "0742544716"));
        testAgenda.add(new Person("18405", "Lucian5", "Plopeanu6", 88, "a@a.com", "0742544717"));
        testAgenda.add(new Person("18406", "Lucian6", "Plopeanu7", 46, "a@a.com", "0742544718"));
        testAgenda.add(new Person("18407", "Lucian3", "Plopeanu8", 55, "a@a.com", "0742544710"));
        testAgenda.add(new Person("18408", "Lucian8", "Plopeanu1", 13, "a@a.com", "0742544719"));
        testAgenda.add(new Person("18409", "Lucian0", "Plopeanu4", 26, "a@a.com", "0742544712"));

//        testAgenda.listAll();

//        System.out.println(testAgenda.readPerson("18404"));

        String choice;

        while (true) {

            System.out.print("Please insert the type of sort you want to do (cnp / firstName / lastName / age / other = phone number) : ");

            Scanner input = new Scanner(System.in);
            choice = input.nextLine().toUpperCase();

            if (choice.equals("-")) {
                System.out.print("The termination key was pressed !");
                break;
            }

            testAgenda.sortAll(choice);


        }
    }
}
