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


}