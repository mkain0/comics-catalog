package javaProject.catalogComics.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.Genre;
import javaProject.catalogComics.service.ComicService;

public class GenreView implements CrudViewTemplate {

    private ComicService comicService = new ComicService();

    @Override
    public String getTitle() {
	return "--------------------Genres----------------------";
    }

    @Override
    public void register() throws InputMismatchException {
	System.out.println("------------------Create Genre------------------");
	System.out.print("Description: ");
	String description = new Scanner(System.in).next();

	int id = comicService.saveGenre(new Genre(description));
	System.out.println("Registered Successfully. Genre ID: " + id);
    }

    @Override
    public void modify() throws InputMismatchException {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Modify Genre-------------------");
	System.out.print("Genre ID: ");
	int id = scanner.nextInt();
	Genre genre;
	try {
	    genre = comicService.findGenreBy(id);
	    System.out.print("Description: ");
	    genre.setDescription(scanner.next());

	    comicService.updateGenre(genre);
	} catch (NotFoundException e) {
	    System.out.println(e.getMessage());
	}
    }

    @Override
    public void delete() throws InputMismatchException {
	System.out.println("------------------Delete Genre-------------------");
	System.out.print("Genre ID: ");
	int id = new Scanner(System.in).nextInt();
	comicService.deleteGenre(id);
    }

    @Override
    public void viewAll() {
	comicService.findGenres().forEach(genre -> System.out.println(genre.toString()));
    }

}
