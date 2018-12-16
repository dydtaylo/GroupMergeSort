import java.util.ArrayList;
import java.util.Random;

public class MergeSort{
  
  
  public static void mergeSort(ArrayList<Integer> nums){
    ArrayList<Integer> sorted = sort(nums);

    for(int i = 0; i < sorted.size(); i++)
      nums.set(i, sorted.get(i));
  }
  public static ArrayList<Integer> sort(ArrayList<Integer> nums){
    if(nums.size() > 1)
      return merge(sortedPrefix(nums), sort(unsortedSuffix(nums)));
    else
      return nums;
  }
                                 
  public static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b){
    if(a == null && b == null)
      return new ArrayList<Integer>();
    else if(a == null)
      return b;
    else if(b == null)
      return a;
    
    int aCount = 0;
    int bCount = 0;
    int count = 0;
    ArrayList<Integer> merged = new ArrayList<Integer>();
    
    while(aCount < a.size() && bCount < b.size()){
      if(a.get(aCount) < b.get(bCount)){
        merged.add(a.get(aCount));
        aCount++;
        count++;
      }
      else{
        merged.add(b.get(bCount));
        bCount++;
        count++;
      }
    }
    
    if(aCount == a.size()){
      for(bCount = bCount; bCount < a.size() + b.size() - aCount; bCount++)
        merged.add(b.get(bCount));
    }
    else{
      for(aCount = aCount; aCount < a.size() + b.size() - bCount; aCount++)
        merged.add(a.get(aCount));
    }
    
    return merged;
  }
    
  public static ArrayList<Integer> sortedPrefix(ArrayList<Integer> nums){
    int lengthOfPrefix = 1;
    for(int i = 1; i < nums.size(); i++){
      if(nums.get(i) > nums.get(i - 1))
        lengthOfPrefix++;
      else
        break;
    }
    
    ArrayList<Integer> prefix = new ArrayList<Integer>();
    for(int i = 0; i < lengthOfPrefix; i++)
      prefix.add(nums.get(i));
    
    return prefix;
  }
  public static ArrayList<Integer> unsortedSuffix(ArrayList<Integer> nums){
    int lengthOfSuffix = nums.size() - sortedPrefix(nums).size();
    ArrayList<Integer> rest = new ArrayList<Integer>();
    for(int i = nums.size() - lengthOfSuffix; i < nums.size(); i++)
      rest.add(nums.get(i));
    
    return rest;
  }
  
  public static void main(String [] args){
    Random gen = new Random();
    ArrayList<Integer> nums = new ArrayList<Integer>();
    
    for(int i = 0; i < 20; i++)
      nums.add(gen.nextInt(100));
    
    System.out.println(nums);
    mergeSort(nums);
    System.out.println(nums);
  }
}