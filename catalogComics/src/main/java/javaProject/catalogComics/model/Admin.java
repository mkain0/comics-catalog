package javaProject.catalogComics.model;

import java.util.Scanner;

import javaProject.catalogComics.catalog.PeopleCatalog;

public class Admin implements People {

    private int id;
    private String username;
    private String password;
    private String lastName;
    private String firstName;

    public Admin(int id, String username, String password, String lastName, String firstName) {
	this.id = id;
	this.username = username;
	this.password = password;
	this.lastName = lastName;
	this.firstName = firstName;
    }

    public Admin(String username, String password, String lastName, String firstName) {
	this.username = username;
	this.password = password;
	this.lastName = lastName;
	this.firstName = firstName;
    }

    @Override
    public int getId() {
	return id;
    }

    @Override
    public void setId(int id) {
	this.id = id;
    }

    @Override
    public String getUsername() {
	return username;
    }

    @Override
    public void setUsername(String username) {
	this.username = username;
    }

    @Override
    public String getPassword() {
	return password;
    }

    @Override
    public void setPassword(String password) {
	this.password = password;
    }

    @Override
    public String getLastName() {
	return lastName;
    }

    @Override
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
	return firstName;
    }

    @Override
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    @Override
    public void displayMenu() {
	int option;
	do {
	    System.out.println("----------------Admin Dashboard-----------------");
	    System.out.println("1- Collection of Comics");
	    System.out.println("2- Users Panel");
	    System.out.println("3- Exit");
	    System.out.print("Option: ");

	    Scanner scanner = new Scanner(System.in);
	    option = scanner.nextInt();

	    switch (option) {
	    case 1:
		this.colletionComicMenu();
		break;

	    case 2:
		this.UserPanelMenu();
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

    private void UserPanelMenu() {
	int option;
	do {
	    System.out.println("------------------User Panel--------------------");
	    System.out.println("1- Register");
	    System.out.println("2- Modify");
	    System.out.println("3- Delete");
	    System.out.println("4- List");
	    System.out.println("5- Back");
	    System.out.print("Option: ");

	    Scanner scanner = new Scanner(System.in);
	    option = scanner.nextInt();

	    switch (option) {
	    case 1:
		this.colletionComicMenu();
		break;

	    case 2:
		this.UserPanelMenu();
		break;

	    case 3:
		System.out.println("Goodbye.");
		System.exit(0);
		break;

	    case 4:
		this.listUsers();
		break;

	    case 5:
		break;

	    default:
		System.out.println("Wrong option, try again.");
		break;
	    }
	} while (option != 5);

    }

    private void listUsers() {
	for (People user : PeopleCatalog.getInstance().findAll()) {
	    System.out.println(user.toString());
	}
    }

    private void colletionComicMenu() {
	// TODO Auto-generated method stub

    }

}
