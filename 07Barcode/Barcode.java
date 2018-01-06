public class Barcode implements Comparable<Barcode> {

	private String barcode;
	public String zipcode;


    public Barcode(String zip){
    	if (zip.length() != 5 || !zip.matches("[0-9]+")) {
    		throw new IllegalArgumentException();
    	}
    	zipcode = zip;
    	barcode = toCode(zip);
    }

    public static String toCode(String zip){
        if (zip.length() != 5 || !zip.matches("[0-9]+")) {
            throw new IllegalArgumentException();
        }

        zip = zip + checksum(zip);
    	String bar = "";
    	String[] conversions = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    	for (char c : zip.toCharArray() ){
    		bar += conversions[Character.getNumericValue(c)];
    	}
    	return '|' + bar + '|';
    }

    public static String toZip(String code){
    	String ans = "";
    	if (code.length() != 32) throw new IllegalArgumentException();
    	for (char c: code.toCharArray() ){
    			if (c != '|' && c != ':') throw new IllegalArgumentException();
    	}
    	if (code.toCharArray()[0] != '|' || code.toCharArray()[31] != '|') throw new IllegalArgumentException();
        String givenChecksumCode = code.substring(26,31);
        code = code.substring(1,26);
    	for (int i=0; i<5; i++){
    		String numbSect = code.substring(i*5,(i+1)*5);
    		ans += zipHelper(numbSect);
    	}
        int givenChecksum = -999;
        String[] conversions = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
        for (int i=0; i<conversions.length; i++){
            if (conversions[i].equals(givenChecksumCode)) givenChecksum = i;
        }
        if (givenChecksum != checksum(ans)) {
            System.out.println(givenChecksumCode);
            System.out.println(givenChecksum);
            System.out.println(checksum(ans));
            throw new IllegalArgumentException();}


    	return ans;

    }

    private static String zipHelper(String section){
        String[] conversions = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
    	for (int i=0; i<conversions.length; i++){
    		if (conversions[i].equals(section)) return "" + i;
    	}
    	throw new IllegalArgumentException();

    }

    public static int checksum(String zip){
        int ans = 0;
        for (int i=0; i<zip.length(); i++){
            ans += Integer.parseInt(zip.substring(i, i+1));
        }
        return ans % 10 ;
    }


    public int compareTo(Barcode other){
    	return Integer.parseInt(this.getZip()) - Integer.parseInt(other.getZip());
    }

     public Boolean equals(Barcode other){
        return compareTo(other) == 0;
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