package lambda;

public class Person{

	  private String name;
	    private int age;
	    private char gender;
	    private String emailAddress;
	    
	    

	    public Person(String name, int age,char gender, String emailAddress) {
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.emailAddress = emailAddress;
		}

	    public String getName() {
			return name;
		}

	    
		public int getAge() {
			return age;
		}

		public char getGender() {
			return gender;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void printPerson() {
	        System.out.println("Name: "+name);
	        System.out.println("Age: "+age);
	        System.out.println("Gender: "+gender);
	        System.out.println("Email: "+emailAddress);
	        System.out.println();
	    }
	}