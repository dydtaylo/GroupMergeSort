import java.util.ArrayList;
import java.util.Random;

public class SortingComparisons{
  public static void main(String[] args){
    Random gen = new Random();
    ArrayList<Integer> nums, copy1, copy2, copy3, copy4, copy5;
    int numSizes = 5;
    int numTests = 100;
    int initSize = 10;
    int maxValue = 100;
    
    int size;
    long quickSortAverage, mergeSortAverage, stalinMergeSortAverage, groupSplitMergeSortAverage, groupMergeSortAverage;
    long startTime, endTime;
    for(int i = 1; i <= numSizes; i++){
      size = (int) Math.pow(initSize, i);
      quickSortAverage = 0l;
      mergeSortAverage = 0l;
      stalinMergeSortAverage = 0l;
      groupSplitMergeSortAverage = 0l;
      groupMergeSortAverage = 0l;
      for(int j = 0; j < numTests; j++){
        nums = new ArrayList<Integer>();
        for(int k = 0; k < size; k++)
          nums.add(gen.nextInt(maxValue));
        
        copy1 = copy(nums);
        copy2 = copy(nums);
        copy3 = copy(nums);
        copy4 = copy(nums);
        copy5 = copy(nums);
        
        startTime = System.nanoTime();
        QuickSort.sort(copy1);
        endTime = System.nanoTime();
        quickSortAverage += (endTime - startTime);
        
        startTime = System.nanoTime();
       // MergeSort.sort(copy2);
        endTime = System.nanoTime();
        mergeSortAverage += (endTime - startTime);
        
        startTime = System.nanoTime();
        //StalinMergeSort.sort(copy3);
        endTime = System.nanoTime();
        stalinMergeSortAverage += (endTime - startTime);
        
        startTime = System.nanoTime();
        GroupSplitMergeSort.sort(copy4);
        endTime = System.nanoTime();
        groupSplitMergeSortAverage += (endTime - startTime);
        
        startTime = System.nanoTime();
        GroupMergeSort.sort(copy5);
        endTime = System.nanoTime();
        groupMergeSortAverage += (endTime - startTime);
      }
      
      quickSortAverage /=  numTests;
      mergeSortAverage /= numTests;
      stalinMergeSortAverage /= numTests;
      groupSplitMergeSortAverage /= numTests;
      groupMergeSortAverage /= numTests;
      
      System.out.println("Average performance with size = " + size + " and trials = " + numTests + ":");
      System.out.println("   Quick Sort: " + (float) quickSortAverage/1000000 + " ms");
    //  System.out.println("   Merge Sort: " + (float) mergeSortAverage/1000000 + " ms");
    //  System.out.println("   Stalin Merge Sort: " + (float) stalinMergeSortAverage/1000000 + " ms");
      System.out.println("   Group Split Merge Sort: " + (float) groupSplitMergeSortAverage/1000000 + " ms");
      System.out.println("   Group Merge Sort: " + (float) groupMergeSortAverage/1000000 + " ms");
      System.out.println();
    }
  }
  
  public static ArrayList<Integer> copy(ArrayList<Integer> nums){
    return new ArrayList<Integer>(nums);
  }
}