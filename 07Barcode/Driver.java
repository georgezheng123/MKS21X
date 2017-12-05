public class Driver {

    public static void main(String[] args) {

        Barcode test = new Barcode("10101");
        System.out.println(test.getCode());
        System.out.println(test.getCode().length());
        //System.out.println(test.toZip("|:::||::|:|:::||:|::|:|:|:|"));

    }

}