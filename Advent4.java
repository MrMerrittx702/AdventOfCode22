import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Advent4 {

    /**reads in file input */
  private static String readFile(String file){
    
    String data = "";
    try {
      File input = new File(file);
      Scanner readIn = new Scanner(input);

      while(readIn.hasNextLine()){
        data += "\n" + readIn.nextLine();//adds a line at beginning.
      }
      readIn.close();
    }
    catch (FileNotFoundException e){
      System.out.println("An error occured");
      e.printStackTrace();
    }
    return data;
  
  }
  private static void printArray(String[] array){
    for(String elem : array){
      System.out.println(elem);
    }
  }
  private static String[] toArray(String data){

    String[] dataArray = data.split("\n");
    return dataArray;
  }
  private static int compareSectionAssignments(String[] array){
    int count = 0;
    //split up
    
    for (int i = 1; i < array.length; i++){

      //get the range numbers
      String[] temp = array[i].split(",");
      String[] assign1 = temp[0].split("-");
      String[] assign2 = temp[1].split("-");
      
      //to make the thinking easier. Integer.parseInt converts from string to integer
      int start1 = Integer.parseInt(assign1[0]); 
      int end1 = Integer.parseInt(assign1[1]);
      int start2 = Integer.parseInt(assign2[0]); 
      int end2 = Integer.parseInt(assign2[1]); 
      
      //first part
      boolean firstInSecond = start1 >= start2 && end1 <= end2;
      boolean secondInFirst = start1 <= start2 && end1 >= end2;

      //second part
      boolean overlap1 = (start1 >= start2 && start1 <= end2) || (end1 >= start2 && end1 <= end2);
      boolean overlap2 = (start2 >= start1 && start2 <= end1) || (end2 >= start1 && end2 <= end1);

      //if(firstInSecond || secondInFirst){ //for first part
      if(overlap1 || overlap2){//for second part
        count++;
      }
    }
    return count;
  }
  public static void main(String[] args){

    String data = readFile("./input.txt");
    String[] dataArray = toArray(data);
    //printArray(dataArray);
    
    System.out.println(compareSectionAssignments(dataArray));


  }
}

