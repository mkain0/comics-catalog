package javaProject.catalogComics.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaProject.catalogComics.model.People;
import javaProject.catalogComics.model.User;

public class UserMenuFactory {

    public void displayUserMenu(People people) {
	if (people instanceof User) {
	    this.userMenu();
	}
	this.adminMenu();
    }

    private void userMenu() {
	System.out.println("-------------------User Menu--------------------");
	System.out.println("1- View collection of comics");
	System.out.println("2- Loan");
	System.out.println("3- Exit");
	System.out.println("Option: ");
    }

    private void adminMenu() {
	List<String> menu = new ArrayList<String>();
	menu.add("----------------Admin Dashboard-----------------");
	menu.add("1- Collection of Comics");
	menu.add("2- Genres");
	menu.add("3- Users Panel");
	menu.add("4- Exit");
	menu.add("Option: ");
	int option;
	do {
	    menu.forEach(itemMenu -> System.out.println(itemMenu));
	    Scanner scanner = new Scanner(System.in);
	    option = scanner.nextInt();

	    switch (option) {
	    case 1:
	    case 2:
	    case 3:
		this.createCrudMenu(option);
		break;

	    case 4:
		System.out.println("Goodbye.");
		break;

	    default:
		System.out.println("Wrong option, try again.");
		break;
	    }
	} while (option != 4);
    }

    private void createCrudMenu(int type) {
	CrudController crudController = new CrudMenuFactory().displayCrudMenu(type);
	List<String> menu = new ArrayList<String>();
	menu.add(crudController.getTitle());
	menu.addAll(crudController.getMenu());
	int option;
	do {
	    menu.forEach(itemMenu -> System.out.println(itemMenu));
	    Scanner scanner = new Scanner(System.in);
	    option = scanner.nextInt();

	    switch (option) {
	    case 1:
		crudController.register();
		break;

	    case 2:
		crudController.modify();
		break;

	    case 3:
		crudController.delete();
		break;

	    case 4:
		crudController.viewAll();
		break;

	    case 5:
		break;

	    default:
		System.out.println("Wrong option, try again.");
		break;
	    }
	} while (option != 5);
    }

}
