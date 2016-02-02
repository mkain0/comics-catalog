package javaProject.catalogComics.model;

import javaProject.catalogComics.util.CopyStatus;

public class Copy {

    private int number;
    private CopyStatus status;

    public Copy() {

    }

    public Copy(int number, CopyStatus status) {
	this.number = number;
	this.status = status;
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

}
