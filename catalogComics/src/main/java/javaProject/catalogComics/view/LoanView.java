package javaProject.catalogComics.view;

import java.util.Scanner;

import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.service.ComicService;
import javaProject.catalogComics.service.LoanService;

public class LoanView {

    private ComicService comicService = new ComicService();
    private LoanService loanService = new LoanService();

    public void loan() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("-------------------Loan Menu--------------------");
	comicService.findComicAvailable().forEach(comic -> System.out.println(comic.toString()));
	System.out.print("Insert ISBN to Loan: ");
	int isbn = scanner.nextInt();
	System.out.print("Insert your username: ");
	String username = scanner.next();
	try {
	    loanService.loan(isbn, username);
	    System.out.println("Registered Successfully.");
	} catch (NotFoundException e) {
	    System.out.println(e.getMessage());
	}
    }

    public void close() {
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

}
