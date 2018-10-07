package PracticeThis;



public class BaseClass {

	public static int i= 10;
	
	public BaseClass() {
		System.out.println("Hello");
	}
	

	public BaseClass(int i) {
		this.i=i;
		
	}
	
	public void print() {
		System.out.println("value of instance variable is=" +this.i);
		int i= 20;
		System.out.println("value of local variable is=" +i);
	}
	

	
	
}
