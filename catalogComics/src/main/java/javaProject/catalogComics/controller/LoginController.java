package javaProject.catalogComics.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javaProject.catalogComics.catalog.PeopleCatalog;
import javaProject.catalogComics.exception.PeopleNotFoundException;
import javaProject.catalogComics.model.People;
import javaProject.catalogComics.util.Encryption;

public class LoginController {

    public LoginController() {
	try {
	    People people = this.login();
	    new UserMenuFactory().displayUserMenu(people);
	} catch (NoSuchAlgorithmException e) {
	    System.out.println("An error occurred.\n");
	} catch (PeopleNotFoundException e) {
	    System.out.println(e.getMessage() + "\n");
	}
    }

    public People login() throws NoSuchAlgorithmException, PeopleNotFoundException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("---------------------Login-----------------------");
	System.out.print("Username: ");
	String username = scanner.next();
	System.out.print("Password: ");
	String password = scanner.next();
	return PeopleCatalog.getInstance().findBy(username, Encryption.encrypted(password));
    }

}
