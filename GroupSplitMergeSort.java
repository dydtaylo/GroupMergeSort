import java.util.ArrayList;
import java.util.Random;

public class GroupSplitMergeSort{
  
  public static void sort(ArrayList<Integer> nums){
    ArrayList<Integer> sorted = merge(makeSortedLists(nums));
    
    for(int i = 0; i < sorted.size(); i++)
      nums.set(i, sorted.get(i));
  }
  
  public static ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> listOfLists){
    ArrayList<Integer> sorted = new ArrayList<Integer>();
    while(listOfLists.size() > 0)
      sorted = merge(sorted, listOfLists.remove(0));
    
    return sorted;
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
  
  public static ArrayList<ArrayList<Integer>> makeSortedLists(ArrayList<Integer> nums){
    ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    int current;
    boolean foundList;
    for(int i = 0; i < nums.size(); i++){
      current = nums.get(i);
      foundList = false;
      for(int j = 0; j < lists.size() && !foundList; j++){
        if(lists.get(j).get(lists.get(j).size() - 1) <= current){
          lists.get(j).add(current);
          foundList = true;
        }
      }
      if(!foundList){
        lists.add(new ArrayList<Integer>());
        lists.get(lists.size() - 1).add(current);
      }
    }
    
    return lists;
  }
  
  public static boolean isSorted(ArrayList<Integer> nums){
    for(int i = 1; i < nums.size(); i++){
      if(nums.get(i - 1) > nums.get(i))
        return false;
    }
    
    return true;
  }
  
  public static void main(String [] args){
    Random gen = new Random();
    ArrayList<Integer> nums = new ArrayList<Integer>();
    
    for(int i = 0; i < 20; i++)
      nums.add(gen.nextInt(100));
    
    System.out.println(nums);
    sort(nums);
    System.out.println(nums);
    System.out.println(isSorted(nums));
  }
}