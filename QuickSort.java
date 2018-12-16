import java.util.ArrayList;
import java.util.Random;

public class QuickSort{
  public static void sort(ArrayList<Integer> nums){
    quickSort(nums, 0, nums.size() - 1);
  }
  public static void quickSort(ArrayList<Integer> nums, int low, int high){
    if(low < high){
      int partition = partition(nums, low, high);
      
      quickSort(nums, low, partition - 1);
      quickSort(nums, partition + 1, high);
    }
  }
  public static int partition(ArrayList<Integer> nums, int low, int high){
    int pivot = nums.get(high);
    int i = (low - 1);
    for(int j = low; j < high; j++){
      if(nums.get(j) <= pivot){
        i++;
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
      }
    }
    
    int temp = nums.get(i + 1);
    nums.set(i + 1, nums.get(high));
    nums.set(high, temp);
    
    return i + 1;
  }
  
  public static void main(String [] args){
    Random gen = new Random();
    ArrayList<Integer> nums = new ArrayList<Integer>();
    
    for(int i = 0; i < 20; i++)
      nums.add(gen.nextInt(100));
    
    System.out.println(nums);
    sort(nums);
    System.out.println(nums);
  }
}