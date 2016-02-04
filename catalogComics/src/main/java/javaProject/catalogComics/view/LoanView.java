package javaProject.catalogComics.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javaProject.catalogComics.exception.NotAvailableComicException;
import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.service.ComicService;
import javaProject.catalogComics.service.LoanService;

public class LoanView {

    private ComicService comicService = new ComicService();
    private LoanService loanService = new LoanService();

    public void displayMenu() throws InputMismatchException {
	List<String> menu = new ArrayList<String>();
	menu.add("-------------------Loan Menu--------------------");
	menu.add("1- View loans");
	menu.add("2- Close loan");
	menu.add("3- Back");
	menu.add("Option: ");
	int option;
	do {
	    menu.forEach(itemMenu -> System.out.println(itemMenu));
	    option = new Scanner(System.in).nextInt();

	    switch (option) {

	    case 1:
		this.viewAll();
		break;

	    case 2:
		this.close();
		break;

	    case 3:
		break;

	    default:
		System.out.println("Wrong option, try again.");
		break;
	    }
	} while (option != 3);

    }

    public void loan() throws InputMismatchException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("-------------------Loan Menu--------------------");
	try {
	    comicService.findComicAvailable().forEach(comic -> System.out.println(comic.toString()));
	    System.out.print("Insert ISBN to Loan: ");
	    int isbn = scanner.nextInt();
	    System.out.print("Insert your username: ");
	    String username = scanner.next();
	    loanService.loan(isbn, username);
	    System.out.println("Registered Successfully.");
	} catch (NotFoundException | NotAvailableComicException e) {
	    System.out.println(e.getMessage());
	}
    }

    public void close() throws InputMismatchException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("-------------------Loan Menu--------------------");
	System.out.print("Insert username: ");
	String username = scanner.next();
	System.out.print("Insert ISBN: ");
	int isbn = scanner.nextInt();
	try {
	    loanService.closeLoan(loanService.findPendingLoan(username, isbn));
	    System.out.println("Closed Successfully.");
	} catch (NotFoundException e) {
	    System.out.println(e.getMessage());
	}
    }

    public void viewAll() {
	loanService.finAll().forEach(loan -> System.out.println(loan.toString()));
    }

}
