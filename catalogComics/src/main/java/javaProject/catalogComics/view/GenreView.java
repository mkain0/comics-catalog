package javaProject.catalogComics.view;

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
    public void register() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Create Genre------------------");
	System.out.println("Description: ");
	String description = scanner.nextLine();

	int id = comicService.saveGenre(new Genre(description));
	System.out.println("Registered Successfully. Genre ID: " + id);
    }

    @Override
    public void modify() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Modify Genre-------------------");
	System.out.println("Genre ID: ");
	int id = scanner.nextInt();
	Genre genre;
	try {
	    genre = comicService.findGenreBy(id);
	    System.out.println("Description: ");
	    genre.setDescription(scanner.nextLine());

	    comicService.updateGenre(genre);
	} catch (NotFoundException e) {
	    System.out.println(e.getMessage());
	}
    }

    @Override
    public void delete() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("------------------Delete Genre-------------------");
	System.out.println("Genre ID: ");
	int id = scanner.nextInt();
	comicService.deleteGenre(id);
    }

    @Override
    public void viewAll() {
	comicService.findGenres().forEach(genre -> System.out.println(genre.toString()));
    }

}
