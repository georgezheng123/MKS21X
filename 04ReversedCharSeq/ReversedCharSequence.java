import java.lang.CharSequence;

public class ReversedCharSequence implements CharSequence{

	String s1 = "";
	char[] arr;

	public ReversedCharSequence(String grr){
		s1 = "";
		int end = grr.length()-1;
		for (int i=end; i > -1; i--){
	    	s1 += grr.charAt(i);
		}
		arr = s1.toCharArray();
	}

	public int length(){
		return (arr).length;
	} 
	
	public char charAt(int index){
		return arr[index];

	}

	public ReversedCharSequence subSequence(int start, int end){
		String holder = "";
		for (int i=end-1; i >= start; i--){
	    	holder += s1.charAt(i);
		}
		ReversedCharSequence ehh = new ReversedCharSequence(holder);
		return ehh;

	}

	public String toString(){
		return s1;
	}

	    public static void main(String[]args){
	
	ReversedCharSequence s = new ReversedCharSequence("hello world");
	System.out.println(s.length() + ".... expecting 11");
	System.out.println(s + ".... expecting dlrow olleh");
	System.out.println(s.charAt(1) + ".... expecting l");
	System.out.println(s.subSequence(2, 7) + ".... expecting row o");
    }

}