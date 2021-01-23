package br.com.arfaxtec.sbm.services.exception;

public class ObjectNoSuchElementException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ObjectNoSuchElementException(String msg) {
		super(msg);
	}

}
