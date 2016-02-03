package javaProject.catalogComics.view;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.People;
import javaProject.catalogComics.model.User;
import javaProject.catalogComics.service.PeopleService;

public class UserView implements CrudViewTemplate {

    private PeopleService peopleService = new PeopleService();

    @Override
    public String getTitle() {
	return "------------------User Panel--------------------";
    }

    @Override
    public void register() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Create User-------------------");
	System.out.println("First name: ");
	String firstName = scanner.nextLine();
	System.out.println("Last name: ");
	String lastName = scanner.nextLine();
	System.out.println("Username: ");
	String username = scanner.nextLine();
	System.out.println("Password: ");
	String password = scanner.nextLine();
	try {
	    int id = peopleService.save(new User(username, password, lastName, firstName));
	    System.out.println("Registered Successfully. User ID: " + id);
	} catch (NoSuchAlgorithmException e) {
	    System.out.println("An error occurred.\n");
	}
    }

    @Override
    public void modify() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Modify User-------------------");
	System.out.println("User ID: ");
	int id = scanner.nextInt();
	People people;
	try {
	    people = peopleService.findBy(id);
	    System.out.println("First name: ");
	    people.setFirstName(scanner.nextLine());
	    System.out.println("Last name: ");
	    people.setLastName(scanner.nextLine());
	    System.out.println("Username: ");
	    people.setUsername(scanner.nextLine());
	    System.out.println("Password: ");
	    people.setPassword(scanner.nextLine());
	    peopleService.update(people);
	} catch (NotFoundException e) {
	    System.out.println(e.getMessage());
	}
    }

    @Override
    public void delete() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Delete User-------------------");
	System.out.println("User ID: ");
	int id = scanner.nextInt();
	peopleService.delete(id);
    }

    @Override
    public void viewAll() {
	peopleService.findAll().forEach(people -> System.out.println(people.toString()));
    }

}
