package javaProject.catalogComics.service;

import java.util.Date;
import java.util.List;

import javaProject.catalogComics.catalog.ComicCatalog;
import javaProject.catalogComics.catalog.LoanCatalog;
import javaProject.catalogComics.catalog.PeopleCatalog;
import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.Comic;
import javaProject.catalogComics.model.Copy;
import javaProject.catalogComics.model.Loan;
import javaProject.catalogComics.model.People;
import javaProject.catalogComics.util.CopyStatus;

public class LoanService {

    public void loan(int isbn, String username) throws NotFoundException {
	Comic comic = ComicCatalog.getInstance().findBy(isbn);
	for (Copy copy : comic.getCopies()) {
	    if (copy.getStatus().equals(CopyStatus.AVAILABLE)) {
		People reader = PeopleCatalog.getInstance().findBy(username);
		this.saveLoan(copy, reader);
		break;
	    }
	}
    }

    public void saveLoan(Copy copy, People reader) {
	copy.setStatus(CopyStatus.BORROWED);
	// Same problem... status..
	Loan loan = new Loan(new Date(), reader, copy);
	LoanCatalog.getInstance().save(loan);
    }

    public void closeLoan(Loan loan) {
	loan.setReturned(new Date());
	// This is possible?
	loan.getComicCopy().setStatus(CopyStatus.AVAILABLE);
	LoanCatalog.getInstance().update(loan);
    }

    public Loan findPendingLoan(String username, int isbn) throws NotFoundException {
	return LoanCatalog.getInstance().findPendingLoan(username, isbn);
    }

    public List<Loan> finAll() {
	return LoanCatalog.getInstance().findAll();
    }
}
