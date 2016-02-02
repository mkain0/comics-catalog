package javaProject.catalogComics.model;

import java.util.Date;

public class Loan {

    private Date pickUp;
    private Date returned;
    private People reader;
    private Copy comicCopy;

    public Loan() {

    }

    public Loan(Date pickUp, Date returned, People reader, Copy comicCopy) {
	this.pickUp = pickUp;
	this.returned = returned;
	this.reader = reader;
	this.comicCopy = comicCopy;
    }

    public Date getPickUp() {
	return pickUp;
    }

    public void setPickUp(Date pickUp) {
	this.pickUp = pickUp;
    }

    public Date getReturned() {
	return returned;
    }

    public void setReturned(Date returned) {
	this.returned = returned;
    }

    public People getReader() {
	return reader;
    }

    public void setReader(People reader) {
	this.reader = reader;
    }

    public Copy getComicCopy() {
	return comicCopy;
    }

    public void setComicCopy(Copy comicCopy) {
	this.comicCopy = comicCopy;
    }

}
