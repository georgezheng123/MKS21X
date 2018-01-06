import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * 
 * @author Khyber Sen
 * @author Khinshan Khan
 */
public class BarcodeTest {
    
    private static final Random random = new Random(123456789L);
    private static final Supplier<String> zipGenerator = //
            () -> String.valueOf(random.nextInt()).substring(1, 6);
    private static final Supplier<Barcode> barcodeGenerator = () -> new Barcode(zipGenerator.get());
    
    private static void checkBarcode(final Barcode barcode) {
        final String code = barcode.toCode();
        final Barcode reverse = new Barcode(code);
        if (!barcode.toString().equals(reverse.toString())) {
            throw new AssertionError(barcode + " != " + reverse);
        }
    }
    
    private static void test1() {
        final List<Barcode> list = Stream.generate(barcodeGenerator).limit(1000)
                .collect(Collectors.toList());
        list.sort(null);
        list.forEach(BarcodeTest::checkBarcode);
    }
    
    /**
     * @author Khinshan Khan
     */
    private static void test2() {
        final Barcode b = new Barcode("08451");
        final Barcode c = new Barcode("99999");
        final Barcode d = new Barcode("11111");
        System.out.println(b); //084518 |||:::|::|::|::|:|:|::::|||::|:|
        System.out.println(b.toString().compareTo("084518 |||:::|::|::|::|:|:|::::|||::|:|")); //0
        System.out.println(b.compareTo(b)); //0
        System.out.println(c.compareTo(b));
        System.out.println(d.compareTo(b));
        /*length
        Barcode e = new Barcode("123456");
        System.out.println(e);
        */
        /*length
        Barcode e = new Barcode("1234");
        System.out.println(e);
        */
        /*type
        Barcode e= new Barcode("12.45");
        System.out.println(e);
        */
    }
    
    private static void test3() {
        Stream.generate(zipGenerator).limit(1000).forEach(zip -> {
            final String code = Barcode.toCode(zip);
            if (!zip.equals(Barcode.toZip(code))) {
                throw new AssertionError(zip + " != " + code);
            }
        });
    }
    
    public static void main(final String[] args) {
        test1();
        System.out.println("\n\n\n");
        test2();
        test3();
    }
    
}