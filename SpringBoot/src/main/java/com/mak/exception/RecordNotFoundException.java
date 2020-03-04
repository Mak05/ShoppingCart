package com.mak.exception;

@SuppressWarnings("serial")
public class RecordNotFoundException extends Exception {

	public RecordNotFoundException(String searchItem) {

		super("The search item " + searchItem + " is not found.");

	}

	public RecordNotFoundException() {

		super("No Products found to List");

	}

	public RecordNotFoundException(int id) {
		super("ID not found");
	}

}
