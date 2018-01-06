public class Driver {

    public static void main(String[] args) {

        String[]badBarcodes = {"|||:::||:::||:::||:::||:::||:::",
      "|||:::||:::||:::||:::||:::||:::||||",
      "|||:::||:::||:::||:::||:::||::::",
      ":||:::||:::||:::||:::||:::||:::|",
      "||:|::||z::|:|::||::f:::|||:|::|",
      "|:::||||:::a::||||::::::||::||:|",
      "|||:::||:::||:::||:::||::::::|||"    };
String[] badZips = {"9012",      "000000",      "12x34"};
	
		for (String i: badZips){
			try{
        Barcode a = new Barcode(i);
      } catch(IllegalArgumentException e){
        System.out.println(i);
      }
		}


    }

}