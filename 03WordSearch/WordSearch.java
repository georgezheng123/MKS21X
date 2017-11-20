import java.util.*; //random, scanner, arraylist
import java.io.*; //file, filenotfoundexception

public class WordSearch{
    private char[][] data;
    private Random randgen;
    private ArrayList<String> wordsToAdd;
    private ArrayList<String> wordsAdded;

    public static void main(String[] args){
            try {
                int r = Integer.parseInt(args[0]);
                int c = Integer.parseInt(args[1]);
                if (r == 0 || c == 0 || !(args[2].substring(args[2].length() - 4).equals(".txt"))){
                        throw new ArrayIndexOutOfBoundsException();
                }
                if (args.length > 3){
                        int seed = Integer.parseInt(args[3]);
                        WordSearch wsearch = new WordSearch(r, c, args[2], seed);
                        if (args.length == 5 && args[4].equals("key")){
                            System.out.println(wsearch);
                            wsearch.createPuzzle();
                            System.out.println(wsearch);
                            System.out.println(wsearch.getWordsAdded());
                        }
                        else{
                            wsearch.createPuzzle();
                            System.out.println(wsearch);
                            System.out.println(wsearch.getWordsAdded());
                        }
                }
                else{
                        WordSearch wsearch = new WordSearch(r, c, args[2]);
                        wsearch.createPuzzle();
                        System.out.println(wsearch);
                        System.out.println(wsearch.getWordsAdded());
                }
            } 
            catch(Exception e){
                System.out.println("Please enter in the specifications for the word search in the following format: \n java WordSearch <row> <col> <filename> <seed> <answers>");
                System.out.println("<row>: rows");
                System.out.println("<col>: columns");
                System.out.println("<filename>: name of the file which contains the words");
                System.out.println("<seed>: seed (optional)");
                System.out.println("<answer>: show solution? (optional)");
            }
    }


    public WordSearch(int rows,int cols){
        Random rand = new Random();
        randgen = rand;
        ArrayList<String> a = new ArrayList<String>();
        ArrayList<String> b = new ArrayList<String>();
        this.wordsToAdd = a;
        this.wordsAdded = b;
        char[][] blah = new char[rows][cols];
        data = blah;
        for (int row=0; row<rows; row++){
            for (int col=0; col<cols; col++){
                data[row][col] = '_';
            }
        }
    }

    public WordSearch(int rows, int cols, String fileName){
        this(rows, cols);
        try{
            File f = new File(fileName);
            Scanner in = new Scanner(f);
            while(in.hasNext()){
                String line = in.nextLine();
                wordsToAdd.add(line);
            }
        for (int i=0; i<100900; i++){
            if (this.addAllWords()){
                break;
            }
        }
        }catch(FileNotFoundException e){
      System.out.println("java Driver [rows cols filename [randomSeed [answers]]]");
      System.out.println("Ensure that rows/cols are positive integers, that your filename exists and is not empty, etc,");

      System.exit(1);
    }
    }

    public WordSearch(int rows, int cols, String fileName, int seed){
        this(rows, cols);
        randgen = new Random(seed);
        this.randgen = randgen;
        try{
            File f = new File(fileName);
            Scanner in = new Scanner(f);
            while(in.hasNext()){
                String line = in.nextLine();
                wordsToAdd.add(line);
            }
        for (int i=0; i<100900; i++){
            if (this.addAllWords()){
                break;
            }
        }
        }catch(FileNotFoundException e){
      System.out.println("java Driver [rows cols filename [randomSeed [answers]]]");
      System.out.println("Ensure that rows/cols are positive integers, that your filename exists and is not empty, etc,");

      System.exit(1);
    }
    }


    private void clear(){
        for (int row=0; row<data.length; row++){
            for (int col=0; col<data[row].length; col++){
                data[row][col] = '_';
            }
        }
    }


    public String toString(){
        String ans = "";
        for (int row=0; row<data.length; row++){
            for (int col=0; col<data[row].length; col++){
                ans += data[row][col] + " ";
            }
            ans += "\n";
        }    
        return ans;
    }

    private boolean addAllWords(){
        for (int i=0; i<wordsToAdd.size(); i++){
            int rowInc = randgen.nextInt(2);
            int colInc = randgen.nextInt(2);
            int row = randgen.nextInt(data.length);
            int col = randgen.nextInt(data[0].length);
            if (addWord(row, col, wordsToAdd.get(i), rowInc, colInc )){
                String ahhhhhh = wordsToAdd.get(i);
                wordsToAdd.remove(ahhhhhh);
                wordsAdded.add(ahhhhhh);
            }
        }
        if (wordsToAdd.size() == 0) return true;
        return false;
    }

    private boolean addWord(int row, int col, String word, int rowIncrement, int colIncrement){
        if (rowIncrement ==0 && colIncrement == 0) return false;
        if ((word.length() + col) > data[row].length) return false;
        if ((word.length() + row) > data.length) return false;
        word = word.toUpperCase();
        for (int i=0; i<word.length(); i++){
            if (data[row+i*rowIncrement][col+i*colIncrement] != '_' 
                && data[row+i*rowIncrement][col+i*colIncrement] != word.charAt(i)) return false;
        }
        for (int i=0; i<word.length(); i++){
            data[row+i*rowIncrement][col+i*colIncrement] = word.charAt(i);
        }
        return true;

    }

    private char nextLetter(){
       String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       return alpha.charAt(randgen.nextInt(alpha.length()));
    }

    private void createPuzzle() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == '_') {
                    data[i][j] = nextLetter();
                }
            }
        }
    }

    public String getWordsAdded(){
        String listString = String.join(", ", wordsAdded);
        return listString;
    }
    

     
    // public boolean addWordHorizontal(String word,int row, int col){
    //     if ((word.length() + col) > data[row].length) return false;
    //     for (int i=col; i<col+word.length(); i++){
    //         if (data[row][i] != '_' && data[row][i] != word.charAt(i-col)) return false;
    //     }
    //     for (int i=0; i<word.length(); i++){
    //         data[row][col+i] = word.charAt(i);
    //     }
    //     return true;
    // }


    // public boolean addWordVertical(String word,int row, int col){
    //     if ((word.length() + row) > data.length) return false;
    //     for (int i=row; i<row+word.length(); i++){
    //         if (data[i][col] != '_' && data[i][col] != word.charAt(i-row)) return false;
    //     }
    //     for (int i=0; i<word.length(); i++){
    //         data[row+i][col] = word.charAt(i);
    //     }
    //     return true;
    // }

    // public boolean addWordDiagonal(String word,int row, int col){
    //     if ((word.length() + row) > data.length) return false;
    //     if ((word.length() + col) > data[row].length) return false;
    //     for (int i=0; i<word.length(); i++){
    //         if (data[row+i][col+i] != '_' && data[row+i][col+i] != word.charAt(i)) return false;
    //     }
    //     for (int i=0; i<word.length(); i++){
    //         data[row+i][col+i] = word.charAt(i);
    //     }
    //     return true;
    // }

}