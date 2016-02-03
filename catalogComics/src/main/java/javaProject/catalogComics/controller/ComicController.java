package javaProject.catalogComics.controller;

public class ComicController implements CrudController {

    // public void viewAll() {
    // for (Copy copy : ComicCatalog.getInstance().findAll()) {
    // System.out.println(copy.toString());
    // }
    // }
    //
    // public void delete() {
    // System.out.println("-----------------Delete Comic-------------------");
    // System.out.print("ISBN: ");
    // Scanner scanner = new Scanner(System.in);
    // ComicCatalog.getInstance().delete(scanner.nextInt());
    // }

    @Override
    public String getTitle() {
	return "-------------Collection of Comics---------------";
    }

    @Override
    public void register() {
	// TODO Auto-generated method stub

    }

    @Override
    public void modify() {
	// TODO Auto-generated method stub

    }

    @Override
    public void delete() {
	// TODO Auto-generated method stub

    }

    @Override
    public void viewAll() {
	// TODO Auto-generated method stub

    }

}
