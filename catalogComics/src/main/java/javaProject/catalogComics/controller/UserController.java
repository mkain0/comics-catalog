package javaProject.catalogComics.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javaProject.catalogComics.catalog.PeopleCatalog;
import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.People;
import javaProject.catalogComics.model.User;
import javaProject.catalogComics.util.Encryption;

public class UserController implements CrudController {

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
	    int id = this.save(new User(username, password, lastName, firstName));
	    System.out.println("Registered Successfully. User ID: " + id);
	} catch (NoSuchAlgorithmException e) {
	    System.out.println("An error occurred.\n");
	}
    }

    public int save(User user) throws NoSuchAlgorithmException {
	user.setPassword(Encryption.encrypted(user.getPassword()));
	return PeopleCatalog.getInstance().save(user);
    }

    @Override
    public void modify() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Modify User-------------------");
	System.out.println("User ID: ");
	int id = scanner.nextInt();
	People people;
	try {
	    people = this.findBy(id);
	    System.out.println("First name: ");
	    people.setFirstName(scanner.nextLine());
	    System.out.println("Last name: ");
	    people.setLastName(scanner.nextLine());
	    System.out.println("Username: ");
	    people.setUsername(scanner.nextLine());
	    System.out.println("Password: ");
	    people.setPassword(scanner.nextLine());

	    this.update(people);
	} catch (NotFoundException e) {
	    System.out.println(e.getMessage());
	}
    }

    public void update(People people) {
	PeopleCatalog.getInstance().update(people);
    }

    public People findBy(int id) throws NotFoundException {
	return PeopleCatalog.getInstance().findBy(id);
    }

    @Override
    public void delete() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Delete User-------------------");
	System.out.println("User ID: ");
	int id = scanner.nextInt();
	PeopleCatalog.getInstance().delete(id);
    }

    @Override
    public void viewAll() {
	PeopleCatalog.getInstance().findAll().forEach(people -> System.out.println(people.toString()));
    }

}
