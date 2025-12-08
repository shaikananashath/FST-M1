package activities;

public class Activity8 {

	public static void main(String[] args) {
		try {
		Activity8.exceptionTest("Hello");
		Activity8.exceptionTest(null);
		}
		catch(CustomException e){
			e.getMessage();
			
		}
	}
	
	static void exceptionTest(String m) throws CustomException {
		if(m==null) {
			throw new CustomException("Null String");
		}		
		else{
			System.out.println(m);
		}
	}

}