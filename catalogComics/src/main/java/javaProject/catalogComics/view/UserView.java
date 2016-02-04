package javaProject.catalogComics.view;

import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;
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
    public void register() throws InputMismatchException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Create User-------------------");
	System.out.print("First name: ");
	String firstName = scanner.next();
	System.out.print("Last name: ");
	String lastName = scanner.next();
	System.out.print("Username: ");
	String username = scanner.next();
	System.out.print("Password: ");
	String password = scanner.next();
	try {
	    int id = peopleService.save(new User(username, password, lastName, firstName));
	    System.out.println("Registered Successfully. User ID: " + id);
	} catch (NoSuchAlgorithmException e) {
	    System.out.println("An error occurred.\n");
	}
    }

    @Override
    public void modify() throws InputMismatchException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Modify User-------------------");
	System.out.print("User ID: ");
	int id = scanner.nextInt();
	People people;
	try {
	    people = peopleService.findBy(id);
	    System.out.print("First name: ");
	    people.setFirstName(scanner.next());
	    System.out.print("Last name: ");
	    people.setLastName(scanner.next());
	    System.out.print("Username: ");
	    people.setUsername(scanner.next());
	    System.out.print("Password: ");
	    people.setPassword(scanner.next());
	    peopleService.update(people);
	} catch (NotFoundException e) {
	    System.out.println(e.getMessage());
	}
    }

    @Override
    public void delete() throws InputMismatchException {
	System.out.println("------------------Delete User-------------------");
	System.out.print("User ID: ");
	int id = new Scanner(System.in).nextInt();
	peopleService.delete(id);
    }

    @Override
    public void viewAll() {
	peopleService.findAll().forEach(people -> System.out.println(people.toString()));
    }

}
