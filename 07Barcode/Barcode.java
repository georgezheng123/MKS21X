public class Barcode {

	private String barcode;
	public String zipcode;


    public Barcode(String zip){
    	if (zip.length() != 5 || !zip.matches("[0-9]+")) {
    		throw new IllegalArgumentException();
    	}
    	zipcode = zip;
    	barcode = '|' + toCode(zip) + '|';
    }

    private static String toCode(String zip){
    	String bar = "";
    	String[] conversions = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    	for (char c : zip.toCharArray() ){

    		bar += conversions[Character.getNumericValue(c)];
    	}
    	return bar;
    }

    public String toZip(String code){
    	String ans = "";
    	if (code.length() != 32) throw new IllegalArgumentException();
    	for (char c: code.toCharArray() ){
    			if (c != '|' && c != ':') throw new IllegalArgumentException();
    	}
    	if (code.toCharArray()[0] != '|' || code.toCharArray()[31] != '|') throw new IllegalArgumentException();
    	code = code.substring(1,31);
    	for (int i=0; i<6; i++){
    		String numbSect = code.substring(i*5,(i+1)*5)+1;
    		ans += zipHelper(numbSect);
    	}
    	return ans;

    }

    private String zipHelper(String section){
    	String[] conversions = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    	for (int i=0; i<conversions.length; i++){
    		if (conversions[i] == section) return "" + i;
    	}
    	throw new IllegalArgumentException();

    }


    public int compareTo(Barcode other){
    	return Integer.parseInt(this.getZip()) - Integer.parseInt(other.getZip());
    }


    public String getZip(){
    	return zipcode;
    }

    public String getCode(){
    	return barcode;
    }



    public String toString(){
    	return barcode + " (" + zipcode + ") ";
    }
}