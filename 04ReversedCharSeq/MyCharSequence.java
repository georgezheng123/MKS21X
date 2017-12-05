import java.lang.CharSequence;

public class MyCharSequence implements CharSequence{

	char[] arr;

	public MyCharSequence(char[] grr){
		arr = grr;
	}

	public int length(){
		return arr.length;
	} 
	
	public char charAt(int index){
		return arr[index];

	}

	public MyCharSequence subSequence(int start, int end){
		char[] blah = new char[end - start];
		for (int i=0; i<end-start; i++){
			blah[i] = arr[i+start];
		}
		MyCharSequence ehh = new MyCharSequence(blah);
		return ehh;

	}

	public String toString(){
		String ans = "";
		for (int i=arr.length-1; i>=0; i--){
			ans += arr[i] + " ";
		}
		return ans;
	}

}