package javaProject.catalogComics.controller;

import javaProject.catalogComics.catalog.PeopleCatalog;
import javaProject.catalogComics.model.People;

public class UserController {

    public void viewAll() {
	for (People user : PeopleCatalog.getInstance().findAll()) {
	    System.out.println(user.toString());
	}
    }

    public void register() {
	// TODO Auto-generated method stub

    }

    public void modify() {
	// TODO Auto-generated method stub

    }

    public void delete() {
	// TODO Auto-generated method stub

    }

}
