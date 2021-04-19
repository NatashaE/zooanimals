import java.util.Scanner;
import java.io.IOException;

class MonitorSystem
{
   public static void main(String[] args) throws IOException {
      //This is the scanner that reads the user input
      Scanner scnr = new Scanner(System.in);

      //instantiate an instance of the animalHabitatInfo class
      animalHabitatInfo animalHabitatInfo = new animalHabitatInfo();

      char userChoice = '\0';

      //while loop continues until they choose exit
      while(userChoice != 'e')
      {
         //Print choices for the user to pick from
         System.out.println("Enter a to monitor an animal");
         System.out.println("Enter h to monitor a habitat");
         System.out.println("Enter e for exit");
         System.out.print("Please enter an option: ");

         userChoice = scnr.next().charAt(0);


         if(userChoice == 'a')
         {
            animalHabitatInfo.monitorAnimal();
         }
         else if (userChoice == 'h')
         {
            animalHabitatInfo.monitorHabitat();
         }
         else if(userChoice == 'e')
         {
            //user wants to exit so give them an exit message
            System.out.println("Thanks, bye now!");
         }
         else
         {
            //If user doesn't enter a valid option
            System.out.println("Please enter one of the given choices.");
         }
      }
   }
}