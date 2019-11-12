package co.com.sophos.certification.challenge.exceptions;

public class AssertionPlazavea extends AssertionError{
	
	private static final long serialVersionUID = 1L;
	
	public static final String SUCCESS_DIALOG_GET_MESSAGE = "The product was not added to shopping cart or the message dialog is not visible.";
	public static final String PRODUCT_IS_NOT_THE_SAME = "The product that user have selected is not the same in shopping cart.";

	public AssertionPlazavea(String message) {
		super(message);
	}
	
	public AssertionPlazavea(String message, Throwable cause) {
		super(message, cause);
	}
	
}
