package javaProject.catalogComics.controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaProject.catalogComics.catalog.ComicCatalog;
import javaProject.catalogComics.exception.PeopleNotFoundException;
import javaProject.catalogComics.model.People;
import javaProject.catalogComics.util.Resource;

public class AppController {

    private List<String> menu = new ArrayList<String>();

    public AppController() {
	Resource.init();
	menu = new GuessContoller().displayMenu();
	int option;
	do {
	    this.displayMenuOption();
	    Scanner scanner = new Scanner(System.in);
	    option = scanner.nextInt();

	    switch (option) {
	    case 1:
		ComicCatalog.getInstance().findAll().forEach(copy -> System.out.println(copy.toString()));
		System.out.println("Press enter to return to main menu.");
		break;

	    case 2:
		this.login();
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

    private void displayMenuOption() {
	menu.forEach(itemMenu -> System.out.println(itemMenu));
    }

    private void login() {
	try {
	    People people = new LoginController().login();
	    new MenuFactory().displayUserMenu(people);
	} catch (NoSuchAlgorithmException e) {
	    System.out.println("An error occurred.\n");
	} catch (PeopleNotFoundException e) {
	    System.out.println(e.getMessage() + "\n");
	}
    }

}
