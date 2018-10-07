package PracticeThis;

public class thisString {

	public String s= "hello";
	
	public thisString() {
		System.out.println("This strinf is");
	}
	public thisString(String s) {
		 this.s =s;
	}
	
	public void prints() {
		System.out.println("value of instance String s is" +this.s);
		
		String s= this.s.concat("world");
		
		System.out.println("value of local String s is" +s);
	}
}
