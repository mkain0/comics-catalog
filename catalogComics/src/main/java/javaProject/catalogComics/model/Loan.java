package javaProject.catalogComics.model;

import java.util.Date;

public class Loan {

    private Date pickUp;
    private Date returned;
    private People reader;
    private Copy comicCopy;

    public Loan() {

    }

    public Loan(Date pickUp, People reader, Copy comicCopy) {
	this.pickUp = pickUp;
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

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Loan other = (Loan) obj;
	if (comicCopy == null) {
	    if (other.comicCopy != null)
		return false;
	} else if (!comicCopy.equals(other.comicCopy))
	    return false;
	if (pickUp == null) {
	    if (other.pickUp != null)
		return false;
	} else if (!pickUp.equals(other.pickUp))
	    return false;
	if (reader == null) {
	    if (other.reader != null)
		return false;
	} else if (!reader.equals(other.reader))
	    return false;
	return true;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((comicCopy == null) ? 0 : comicCopy.hashCode());
	result = prime * result + ((pickUp == null) ? 0 : pickUp.hashCode());
	result = prime * result + ((reader == null) ? 0 : reader.hashCode());
	return result;
    }

}
