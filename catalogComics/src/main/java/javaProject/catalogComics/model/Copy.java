package javaProject.catalogComics.model;

import javaProject.catalogComics.util.CopyStatus;

public class Copy {

    private int number;
    private CopyStatus status;
    private Comic comic;

    public Copy() {

    }

    public Copy(int number, CopyStatus status, Comic comic) {
	this.number = number;
	this.status = status;
	this.setComic(comic);
    }

    public int getNumber() {
	return number;
    }

    public void setNumber(int number) {
	this.number = number;
    }

    public CopyStatus getStatus() {
	return status;
    }

    public void setStatus(CopyStatus status) {
	this.status = status;
    }

    public Comic getComic() {
	return comic;
    }

    public void setComic(Comic comic) {
	this.comic = comic;
    }

    @Override
    public String toString() {
	return "Copy number: " + number + ", Status: " + status + ", Comic: " + comic.toString();
    }

}
