package javaProject.catalogComics.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javaProject.catalogComics.model.People;
import javaProject.catalogComics.model.User;
import javaProject.catalogComics.service.ComicService;

public class UserMenuFactory {

    public void displayUserMenu(People people) {
	try {
	    if (people instanceof User) {
		this.userMenu();
	    } else {
		this.adminMenu();
	    }
	} catch (InputMismatchException e) {
	    System.out.println("Take care! Look what you press.");
	    this.displayUserMenu(people);
	}
    }

    private void userMenu() throws InputMismatchException {
	List<String> menu = new ArrayList<String>();
	menu.add("-------------------User Menu--------------------");
	menu.add("1- View collection of comics");
	menu.add("2- Loan");
	menu.add("3- Exit");
	menu.add("Option: ");
	int option;
	do {
	    menu.forEach(itemMenu -> System.out.println(itemMenu));
	    Scanner scanner = new Scanner(System.in);
	    option = scanner.nextInt();

	    switch (option) {
	    case 1:
		new ComicService().findComics().forEach(comic -> System.out.println(comic.toString()));
		System.out.println("Press enter to return to main menu.");
		break;

	    case 2:
		new LoanView().loan();
		break;

	    case 3:
		System.out.println("Goodbye.");
		break;

	    default:
		System.out.println("Wrong option, try again.");
		break;
	    }
	} while (option != 3);
    }

    private void adminMenu() throws InputMismatchException {
	List<String> menu = new ArrayList<String>();
	menu.add("----------------Admin Dashboard-----------------");
	menu.add("1- Collection of Comics");
	menu.add("2- Genres");
	menu.add("3- Users Panel");
	menu.add("4- Loans");
	menu.add("5- Exit");
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
		new LoanView().close();
		break;

	    case 5:
		System.out.println("Goodbye.");
		break;

	    default:
		System.out.println("Wrong option, try again.");
		break;
	    }
	} while (option != 5);
    }

    private void createCrudMenu(int type) throws InputMismatchException {
	CrudViewTemplate crudController = new CrudMenuFactory().displayCrudMenu(type);
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
