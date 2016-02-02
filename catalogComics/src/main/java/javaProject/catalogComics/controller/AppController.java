package javaProject.catalogComics.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javaProject.catalogComics.catalog.ComicCatalog;
import javaProject.catalogComics.catalog.PeopleCatalog;
import javaProject.catalogComics.exception.PeopleNotFoundException;
import javaProject.catalogComics.model.People;
import javaProject.catalogComics.util.Resource;

public class AppController {

    public AppController() {
	Resource.init();
	this.displayGuessMenu();

    }

    public void displayGuessMenu() {
	int option;
	do {
	    System.out.println("Welcome to Sheldon Cooper's collection of Comics");
	    System.out.println("---------------------Menu-----------------------");
	    System.out.println("1- View collection of comics");
	    System.out.println("2- Login");
	    System.out.println("3- Exit");
	    System.out.print("Option: ");

	    Scanner scanner = new Scanner(System.in);
	    option = scanner.nextInt();

	    switch (option) {
	    case 1:
		this.displayCollectionComics();
		break;

	    case 2:
		try {
		    try {
			this.login();
		    } catch (NoSuchAlgorithmException e) {
			System.out.println("An error occurred.\n");
		    }

		} catch (PeopleNotFoundException e) {
		    System.out.println(e.getMessage() + "\n");
		}
		break;

	    case 3:
		System.out.println("Goodbye.");
		System.exit(0);
		break;

	    default:
		System.out.println("Wrong option, try again.");
		break;
	    }
	} while (option != 3);
    }

    private void displayCollectionComics() {
	// Pending - Need refactor after CRUD Comic
	ComicCatalog.getInstance().loadComics();

    }

    private void login() throws NoSuchAlgorithmException, PeopleNotFoundException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("---------------------Login-----------------------");
	System.out.print("Username: ");
	String username = scanner.next();
	System.out.print("Password: ");
	String password = scanner.next();
	People people = PeopleCatalog.getInstance().findBy(username, password);
	people.displayMenu();
    }

}
