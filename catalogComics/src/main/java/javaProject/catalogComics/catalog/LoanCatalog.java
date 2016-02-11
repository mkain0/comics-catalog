package javaProject.catalogComics.catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.Loan;

public class LoanCatalog {

    private static LoanCatalog uniqueInstance;
    private List<Loan> loans = new ArrayList<>();

    private LoanCatalog() {

    }

    public static synchronized LoanCatalog getInstance() {
	if (uniqueInstance == null) {
	    return uniqueInstance = new LoanCatalog();
	}
	return uniqueInstance;
    }

    public List<Loan> findAll() {
	return loans;
    }

    public void save(Loan loan) {
	if (loan == null) {
	    throw new IllegalArgumentException();
	}
	LoanCatalog.getInstance().findAll().add(loan);
    }

    public void update(Loan loanToUptade) {
	if (loanToUptade == null) {
	    throw new IllegalArgumentException();
	}
	LoanCatalog.getInstance().findAll().removeIf(condition(loanToUptade));
	LoanCatalog.getInstance().findAll().add(loanToUptade);
    }

    private Predicate<? super Loan> condition(Loan loan) {
	return element -> element.equals(loan);
    }

    public Loan findPendingLoan(String username, int isbn) throws NotFoundException {
	for (Loan loan : loans) {
	    boolean pendingLoan = loan.getReturned() == null && loan.getReader().getUsername().equals(username)
		    && loan.getComicCopy().getComic().getIsbn() == isbn;
	    if (pendingLoan)
		return loan;
	}
	throw new NotFoundException("Loan not found.");
    }

    public boolean hasAnyPendingLoan(int id) {
	return LoanCatalog.getInstance().findAll().stream().anyMatch(loan -> {
	    if (loan.getReturned() == null && loan.getReader().getId() == id) {
		return false;
	    } else {
		return true;
	    }
	});
    }
}
