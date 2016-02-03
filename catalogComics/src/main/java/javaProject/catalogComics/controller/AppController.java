package javaProject.catalogComics.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javaProject.catalogComics.service.ComicService;
import javaProject.catalogComics.util.Resource;
import javaProject.catalogComics.view.GuessView;
import javaProject.catalogComics.view.LoginView;

public class AppController {

    private List<String> menu = new ArrayList<String>();

    public AppController() {
	Resource.init();
	menu = new GuessView().displayMenu();
	int option;
	do {
	    menu.forEach(itemMenu -> System.out.println(itemMenu));
	    Scanner scanner = new Scanner(System.in);
	    option = scanner.nextInt();

	    switch (option) {
	    case 1:
		new ComicService().findComics();
		System.out.println("Press enter to return to main menu.");
		break;

	    case 2:
		new LoginView();
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

}
