//input.txt can be found in the Day2 directory.

/**
Code Notes
A rock
B paper
C scissors

X rock 1pt
Y paper 2pts
Z scissors 3pts

points 
6 for win
3 for draw 
0 for loss
*/

import java.io.File; //Import File class
import java.io.FileNotFoundException; //Import this class for errors
import java.util.Scanner; //Import Scanner class to read files.
class AdventDay2{

  /**readFile accepts a file and returns the contents as a single string */
  public static String readFile(String file){
    String data = "";
    try{
      File input = new File(file);
      Scanner readIn = new Scanner(input);
      while(readIn.hasNextLine()){
        data += "\n" + readIn.nextLine();
        
      }
      readIn.close();
    }
    catch (FileNotFoundException e){
      System.out.println("An error occured");
      e.printStackTrace();
    }
    return data;
  }
  /**printArr accepts an array and prints out the contents individually seperated with a ,  */
  private static void printArr(String[] arr){
    for(String item : arr){
      System.out.print(item + ",");
    }
  }
  /**getPoints accepts an array and calculates the number of points earned during the tournament */
  private static int getPoints(String[] arr){
    int score = 0;
    
    for(String elem : arr){
      String[] tempArr = elem.split(" ");
      
      if(tempArr.length < 2){
        continue;
      }

      tempArr[1] = getPlay(tempArr);
      
      if(tempArr[1].equals("X")){
        score += 1;
      }
      else if (tempArr[1].equals("Y")){
        score += 2;
      }
      else if(tempArr[1].equals("Z")){
        score += 3;
      }

      if(( tempArr[0].equals("A") &&  tempArr[1].equals("Y")) || ( tempArr[0].equals("B") &&  tempArr[1].equals("Z")) || ( tempArr[0].equals("C") &&  tempArr[1].equals("X"))){
        score += 6;
      }
      else if ((tempArr[0].equals("A") && tempArr[1].equals("X")) || (tempArr[0].equals("B") && tempArr[1].equals("Y")) || (tempArr[0].equals("C") && tempArr[1].equals("Z"))){
        score += 3;
      }
    }
    return score;
  }
  /**getPlay accepts and array and returns the correct shape to play */
  private static String getPlay(String[] arr){
    if(arr[1].equals("Z")){
      return win(arr[0]);
    }
    else if (arr[1].equals("Y")){
      return draw(arr[0]);
    }
    else if(arr[1].equals("X")){
      return lose(arr[0]);
    }
    return "";
  }
  /**win accepts a string and determines what to play to win */
  private static String win(String str){
    if(str.equals("A")){
      return "Y";
    }
    else if(str.equals("B")){
      return "Z";
    }
    else if(str.equals("C")){
      return "X";
    }
    return "";
  }
  /** draw accepts a string and determines what to play to draw */
  private static String draw(String str){
    if(str.equals("A")){
      return "X";
    }
    else if(str.equals("B")){
      return "Y";
    }
    else if(str.equals("C")){
      return "Z";
    }
    return "";
  }
  /** lose accepts a string and determines what to play to lose*/
  private static String lose(String str){
    if(str.equals("A")){
      return "Z";
    }
    else if(str.equals("B")){
      return "X";
    }
    else if(str.equals("C")){
      return "Y";
    }
    return "";
  }

  public static void main(String[] args){

    String data = readFile("./input.txt");//reads input file from current directory
  
    String[] dataArr = data.split("\n");//splits data into an array
    
    int total = getPoints(dataArr);
    System.out.println(total);
  
  }
}