package javaProject.catalogComics.controller;

import java.util.Scanner;

import javaProject.catalogComics.catalog.ComicCatalog;
import javaProject.catalogComics.model.Copy;

public class ComicController {

    public void viewAll() {
	for (Copy copy : ComicCatalog.getInstance().findAll()) {
	    System.out.println(copy.toString());
	}
    }

    public void register() {
	// TODO Auto-generated method stub

    }

    public void modify() {
	// TODO Auto-generated method stub

    }

    public void delete() {
	System.out.println("-----------------Delete Comic-------------------");
	System.out.print("ISBN: ");
	Scanner scanner = new Scanner(System.in);
	ComicCatalog.getInstance().delete(scanner.nextInt());
    }

}
