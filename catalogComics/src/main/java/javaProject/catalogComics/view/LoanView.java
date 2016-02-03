package javaProject.catalogComics.view;

import javaProject.catalogComics.service.ComicService;

public class LoanView {

    private ComicService comicService = new ComicService();

    public void loan() {
	System.out.println("-------------------Loan Menu--------------------");
	comicService.findComicAvailable();

	// TODO I'll be back.
    }

}
