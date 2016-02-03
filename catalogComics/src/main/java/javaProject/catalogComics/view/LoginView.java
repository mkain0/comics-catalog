package javaProject.catalogComics.view;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.People;
import javaProject.catalogComics.service.PeopleService;

public class LoginView {

    public LoginView() {
	try {
	    People people = this.login();
	    new UserMenuFactory().displayUserMenu(people);
	} catch (NoSuchAlgorithmException e) {
	    System.out.println("An error occurred.\n");
	} catch (NotFoundException e) {
	    System.out.println(e.getMessage() + "\n");
	}
    }

    public People login() throws NoSuchAlgorithmException, NotFoundException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("---------------------Login-----------------------");
	System.out.print("Username: ");
	String username = scanner.next();
	System.out.print("Password: ");
	String password = scanner.next();
	return new PeopleService().login(username, password);
    }

}
