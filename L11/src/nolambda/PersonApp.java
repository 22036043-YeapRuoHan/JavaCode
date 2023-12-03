package nolambda;

import java.util.ArrayList;

public class PersonApp {

	public static void main(String[] args) {
		Person p1 = new Person("Mary", 21, 'F', "mary@gmail.com");
		Person p2 = new Person("alice", 19, 'F', "alice@gmail.com");
		Person p3 = new Person("tom", 18, 'M', "tom@gmail.com");
		Person p4 = new Person("ben", 22, 'M', "ben@gmail.com");
		Person p5 = new Person("jenny", 18, 'F', "jenny@gmail.com");
		Person p6 = new Person("john", 18, 'M', "john@gmail.com");
		Person p7 = new Person("andy", 25, 'F', "andy@gmail.com");

		ArrayList<Person> personList = new ArrayList<Person>();
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		personList.add(p5);
		personList.add(p6);
		personList.add(p7);

		System.out.println("Printing only males...");
		printPersonsByGender(personList, 'M');

		System.out.println("Printing older than 20...");
		printPersonsOlderThan(personList, 20);

		System.out.println("Printing younger than 20...");
		printPersonsYoungerThan(personList, 20);
		
		System.out.println("Printing NS candidates...");
		printNSCandidates(personList);
	}

	public static void printPersonsByGender(ArrayList<Person> persons, char gender) {

		for (Person p : persons) {
			if (p.getGender() == gender) {
				p.printPerson();
			}
		}
	}

	public static void printPersonsOlderThan(ArrayList<Person> personList, int age) {

		for (Person p : personList) {
			if (p.getAge() > age) {
				p.printPerson();
			}
		}
	}

	public static void printPersonsYoungerThan(ArrayList<Person> personList, int age) {

		for (Person p : personList) {
			if (p.getAge() < age) {
				p.printPerson();
			}
		}
	}

	public static void printNSCandidates(ArrayList<Person> personList) {
		for (Person p : personList) {
			if (p.getAge() == 18 && p.getGender() == 'M') {
				p.printPerson();
			}
		}
	}
}
