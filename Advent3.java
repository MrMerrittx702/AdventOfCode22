


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Advent3  {

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
  /**prints each array item separately */
  private static void printArray(String[] array){
    for(String elem : array){
      System.out.println(elem);
    }
  }
  //@Overload
  private static void printArray(char[] array){
    for(char elem : array){
      System.out.println(elem);
    }
  }
  //@Overload
  private static void printArray(int[] array){
    for(int elem : array){
      System.out.println(elem);
    }
  }
  /**breaks the rucksacks into their 2 compartments */
  private static String[][] compartmentalize(String[] array){
    String[][] data = new String[array.length][2];
    for(int i = 0; i < array.length; i++){
      data[i][0] = array[i].substring(0,array[i].length()/2);
      data[i][1] = array[i].substring(array[i].length()/2); 
      //blank line in data means data[0][0] and data[0][1] are empty
    }
    return data;
  }
  /**compares the items in each compartment to find the shared item */
  private static char[] compareItems(String[][] array2d){
    char[] inBoth = new char[array2d.length];
    for(int i = 0; i < array2d.length; i++){
      for(int j = 0; j < array2d[i][0].length(); j++){
        for(int k = 0; k < array2d[i][0].length(); k ++){
          if(array2d[i][0].charAt(j) == array2d[i][1].charAt(k)){
            inBoth[i] = array2d[i][0].charAt(j);
          }
        }
      } 
    }
    return inBoth;
  }
  /**compares each set of 3 rucksacks for the shared badge */
  private static char[] findBadges(String[] array){
    char[] badges = new char[array.length/3];
    int k = 0;
    for(int i = 1; i < array.length; i+= 3){
      for(int j = 0; j < array[i].length(); j++){
        if(array[i+1].contains(Character.toString(array[i].charAt(j))) && array[i+2].contains(Character.toString(array[i].charAt(j)))){
          badges[k] = array[i].charAt(j);
        }
      }
      k++;
    }
    return badges;
  }
  /**converts from characters into integer priorities */
  private static int[] prioritize(char[] array){
    //ascii chart values 65-90 A-Z for problem 27-52
    //ascii char values 97-122 a-z for problem 1-26
    int[] priorities = new int[array.length];
    for(int i = 0; i < array.length; i++){
      if(Character.isUpperCase(array[i])){
        priorities[i] = ((int)array[i]) - 38; 
      }
      else if(Character.isLowerCase(array[i])){
        priorities[i] = ((int)array[i]) - 96;
      }
    }
    return priorities;
  }
  /**sums up priority values */
  private static int sum(int[] array){
    int sum = 0;
    for(int elem : array){
      sum += elem;
    }
    return sum;
  }

  public static void main(String[] args){
    String[] data = readFile("./input.txt").split("\n");
    String[][] data2d = compartmentalize(data);
    char[] inBoth = compareItems(data2d);
    //printArray(inBoth);
    int[] priorities = prioritize(inBoth);
    System.out.println(sum(priorities));
    
    
    System.out.println(sum(prioritize(findBadges(data))));







    
  }
}

