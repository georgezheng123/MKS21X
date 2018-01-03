
 import java.util.*;

public class driver {

	public static void main(String[] args){
		for (int i=0; i<8; i++){
			runTest02(i);	
		}
	}

	public static void runTest02(int testID){
  
  if(testID<0){
    System.out.println("Error in driver usage!");
    System.exit(0);
  }
  
  OrderedSuperArray s1 = new OrderedSuperArray();
  ArrayList<String> s2 = new ArrayList<>();
  
  try{
    if(testID == 0 ){
    }
    
    if(testID == 1 ){
      s1.add("4");
      s2.add("4");
      s2.add("4");
      s1.add("1");
      s2.add("1");
      s2.add("4");
      s1.add("0");
      s1.add("4");
      s2.add("0");
      s1.add("4");
    }
    
    if(testID == 2 ){
      s1.add("3");
      s2.add("3");
      s1.add("0");
      s2.add("0");
      s1.add("1");
      s2.add("1");
      s1.add("0");
      s2.add("0");
      s1.add("5");
      s2.add("5");
      s1.add("0");
      s2.add("0");
    }
    
    if(testID == 3 ){
      s1.add("1");
      s2.add("1");
            s1.add("0");
      s2.add("0");
      s1.add("5");
      s2.add("5");
      for(int i = 0; i < 10; i ++){
        String v = ""+(int)(Math.random()*1000);
        int in = (int)(Math.random()*s2.size());
        s1.add(in,v);
        s2.add(in,v);
      }
    }
    
    if(testID == 4 ){
      s1.add("1");
      s2.add("1");
      try{
        s1.set(0,"");
      } catch(UnsupportedOperationException e){
        
      }
    }
    
    if(testID == 5 ){
      try{
        s1.set(0,"");
      } catch(UnsupportedOperationException e){
        
      }
    }
    
    if(testID == 6 ){
      String[] x= {"adsf","b","X","C","fish","cat","Abby","break","romp"};
      s1 = new OrderedSuperArray(x);
      s2.addAll(Arrays.asList(x));
    }
    if(testID == 7 ){
      s1.add("1");
      s2.add("1");
      
      for(int i = 0; i < 1000;   i ++){
        String v = ""+(int)(Math.random()*1000);
        s1.add(v);
        s2.add(v);
      }
    }
    
    
  }catch(Exception f){
    s2.add("0");
    //f.printStackTrace();
  }
  
  Collections.sort(s2);
  if(equals(s1,s2)){
    System.out.println("Test "+testID+",PASS");
  }else{
    System.out.println("Test "+testID+",FAIL!");// "+s1+"!="+s2);
  }
}
public static boolean equals(OrderedSuperArray s, ArrayList<String> a){
    if(s.size() == a.size()){
      for(int i = 0; i < s.size(); i++){
        if(s.get(i) != a.get(i)){
          return false;
        }
      }
      return true;
    }
    return false;
  }

}
