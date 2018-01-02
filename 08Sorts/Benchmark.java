import java.util.Arrays;
public class Benchmark{
	//50	180	271	251	36	128	335	62	1	75	42	35	1	0	3	0	695	3117	7476	6741	481	2104	6214	1831	2	1903	786	628	1	0	32	5
    public static void sort(int[]ary,int method){
	if(method == 0){
	    Sorts.bubbleSort(ary);
	}
	if(method == 1){
	    Sorts.selectionSort(ary);
	}
	if(method == 2){
	    Sorts.insertionSort(ary);
	}
	if(method == 3){
	    Arrays.sort(ary);
	}
    }

    public static String methodName(int i){
	String[]names = {"Bubble","Selection","Insertion","Built In"};
	return names[i];
    }
    
    public static void main(String[]args){
	int SIZE = 0;

	if(args.length == 1){
	    SIZE = Integer.parseInt(args[0]);
	}

	
	int[]inc = new int[SIZE];
	int[]dec = new int[SIZE];
	int[]rnd = new int[SIZE];
	int[]rndsmall = new int[SIZE];
	int[][] arrays = new int [40][];
	
	System.out.println("Increasing,Decreasing,Random,RandomFewValues");
	for(int method = 0; method < 4; method++){
	    //create some random arrays
	    for(int i = 0; i < inc.length; i ++){
		inc[i] = -10000 + 10 * i + (int)(Math.random()*5);
		dec[SIZE-i-1] = inc[i];
		rnd[i] = (int)(Math.random() * 20000000)-10000000;
		rndsmall[i] = (int)(Math.random() * 5);
	    }

	    //fill the big list with some duplicates
	    for(int i = 0; i < arrays.length / 4; i += 4){
		arrays[i]=Arrays.copyOf(inc,SIZE);
		arrays[i+1]=Arrays.copyOf(dec,SIZE);
		arrays[i+2]=Arrays.copyOf(rnd,SIZE);
		arrays[i+3]=Arrays.copyOf(rndsmall,SIZE);
	    }


	
	    //print which type of sort is being used
	    System.out.println(methodName(method)+":");
	    long start,end;
	    for(int j = 0; j < 4; j++){
		start = System.currentTimeMillis();
		for(int i = 0; i < arrays.length / 4; i += 4){
		    sort(arrays[i+j],method);
		}
		end = System.currentTimeMillis();
		System.out.print(end-start+"	");
	    }
	    System.out.println();

	
	    Arrays.sort(inc);
	    Arrays.sort(dec);
	    Arrays.sort(rnd);	
	    Arrays.sort(rndsmall);
	    if( ! ( Arrays.equals(inc,arrays[0]) &&
		    Arrays.equals(dec,arrays[1]) &&
		    Arrays.equals(rnd,arrays[2]) &&
		    Arrays.equals(rndsmall,arrays[3])))
		{
		    System.out.println("FAILED TO SORT PROPERLY!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		    System.out.println("FAILED TO SORT PROPERLY!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		    System.out.println("FAILED TO SORT PROPERLY!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		    System.out.println("FAILED TO SORT PROPERLY!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}

	}
	 
    }
}
