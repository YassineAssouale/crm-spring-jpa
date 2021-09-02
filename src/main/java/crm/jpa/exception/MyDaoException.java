package crm.jpa.exception;

public class MyDaoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8824656011210694499L;

	public MyDaoException(String msg) {
		super(msg);
	}
	
	public MyDaoException(Throwable cause) {
		super(cause);
	}
	
	public MyDaoException(String msg, Throwable cause) {
		super(msg, cause);
	}
	

}
