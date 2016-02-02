package javaProject.catalogComics.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaProject.catalogComics.model.Admin;
import javaProject.catalogComics.model.People;

public class MenuFactory {

    public void displayUserMenu(People people) {
	if (people instanceof Admin) {
	    this.adminMenu();
	}
	this.userMenu();
    }

    private void adminMenu() {
	List<String> menu = new ArrayList<String>();
	menu.add("----------------Admin Dashboard-----------------");
	menu.add("1- Collection of Comics");
	menu.add("2- Users Panel");
	menu.add("3- Exit");
	menu.add("Option: ");
	int option;
	do {
	    menu.forEach(itemMenu -> System.out.println(itemMenu));
	    Scanner scanner = new Scanner(System.in);
	    option = scanner.nextInt();

	    switch (option) {
	    case 1:
		this.colletionComicMenu();
		break;

	    case 2:
		this.userPanelMenu();
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

    private void colletionComicMenu() {
	List<String> menu = new ArrayList<String>();
	menu.add("-------------Collection of Comics---------------");
	menu.addAll(this.crudMenu());
	int option;
	ComicController comicController = new ComicController();
	do {
	    menu.forEach(itemMenu -> System.out.println(itemMenu));
	    Scanner scanner = new Scanner(System.in);
	    option = scanner.nextInt();

	    switch (option) {
	    case 1:
		comicController.register();
		break;

	    case 2:
		comicController.modify();
		break;

	    case 3:
		comicController.delete();
		break;

	    case 4:
		comicController.viewAll();
		break;

	    case 5:
		break;

	    default:
		System.out.println("Wrong option, try again.");
		break;
	    }
	} while (option != 5);

    }

    private void userPanelMenu() {
	List<String> menu = new ArrayList<String>();
	menu.add("------------------User Panel--------------------");
	menu.addAll(this.crudMenu());
	int option;
	UserController userController = new UserController();
	do {
	    menu.forEach(itemMenu -> System.out.println(itemMenu));
	    Scanner scanner = new Scanner(System.in);
	    option = scanner.nextInt();

	    switch (option) {
	    case 1:
		userController.register();
		break;

	    case 2:
		userController.modify();
		break;

	    case 3:
		userController.delete();
		break;

	    case 4:
		userController.viewAll();
		break;

	    case 5:
		break;

	    default:
		System.out.println("Wrong option, try again.");
		break;
	    }
	} while (option != 5);

    }

    private List<String> crudMenu() {
	List<String> menu = new ArrayList<String>();
	menu.add("1- Register");
	menu.add("2- Modify");
	menu.add("3- Delete");
	menu.add("4- List");
	menu.add("5- Back");
	menu.add("Option: ");
	return menu;
    }

    private void userMenu() {
	System.out.println("-------------------User Menu--------------------");
	System.out.println("1- View collection of comics");
	System.out.println("2- Loan");
	System.out.println("3- Exit");
	System.out.println("Option: ");
    }
}
