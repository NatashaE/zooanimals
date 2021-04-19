import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class animalHabitatInfo {

    Scanner scnr = new Scanner(System.in);
    String[] fileContent = null;


    public void monitorAnimal() throws IOException {
        //Read the animal file
        BufferedReader animal = new BufferedReader(new FileReader("./ZooFiles/animals.txt"));

        //display animal options
        String currentLine;
        //variables to help read the file
        int option = 0;
        int counter = -1;
        boolean firstLine = false;
        boolean section = false;
        int space = 0;

        System.out.println("Choose an animal to monitor:");

        while((currentLine = animal.readLine())!=null)
        {
            section = false;

            //check for blank line
            if(currentLine.equals(""))
            {
                space++;

                if(space == 1)
                {
                    fileContent = new String[option];
                }

                //mark true bc a blank line means new section and a first line
                firstLine = true;
                section = true;

                counter++;

            }

            //check if no blank line
            if(space == 0)
            {
                //Display the menu to select the
                //details of an animal.
                option++;

                System.out.println("Enter " + option + " for " + currentLine);
            }
            else if(space != 0 && section == false) {
                if(firstLine == true)
                {
                    fileContent[counter] = currentLine
                    //set back to false bc the next line is not the first
                    firstLine = false;
                }
                else
                {
                    fileContent[counter] = fileContent[counter] + " " + currentLine + "\n";
                }
            }
        }
        //Close the animal file
        animal.close();

        //Ask user to choose an animal
        int animalOption = scnr.nextInt();

        //Display the animal details
        System.out.println(fileContent[animalOption-1]);
        System.out.println("");

        //look for the asterisks indicating something is not right
        if(fileContent[animalOption-1].contains("****"))
        {
            //Prompt alert window bc something is not right
            JOptionPane.showMessageDialog(null, "Warning: something out of the normal range!");
        }
    }

    public void monitorHabitat() throws IOException {
        //This reads the habitat file
        BufferedReader habitat = new BufferedReader(new FileReader("./ZooFiles/habitats.txt"));

        //user choose h for habitat so we display the habitat options
        String currentLine;
        //variables to help read the file
        int option = 0;
        int counter = -1;
        boolean firstLine = false;
        boolean section = false;
        int space = 0;

        System.out.println("List of the habitats:");

        //Read each line of the file using a while
        while((currentLine = habitat.readLine()) != null)
        {
            section = false;

            //Check blank line in file
            if(currentLine.equals(""))
            {
                //if there's blank lines then
                space++;


                if(space == 1) {
                    fileContent = new String[option];
                }

                firstLine = true;
                section = true;

                counter++;
            }

            //no blank line
            if(space == 0) {
                //Print the habitats
                option++;
                System.out.println("Enter " + option + " for " + currentLine);
            }
            else if(space != 0 && section == false) {
                if(firstLine == true)
                {
                    fileContent[counter] = currentLine;

                    //set back to false bc the next line is not the first
                    firstLine = false;
                }
                else
                {
                    fileContent[counter] = fileContent[counter] + " " + currentLine + "\n";
                }
            }
        }

        //Close habitat file
        habitat.close();

        //Get a habitat from user
        int habitatOption = scnr.nextInt();

        //Print the habitat information
        System.out.println(fileContent[habitatOption-1]);
        System.out.println("");

        //Check if something is not normal
        if(fileContent[habitatOption-1].contains("****"))
        {
            //Alert message
            JOptionPane.showMessageDialog(null, "Warning: something out of the normal range!");
        }
    }
}
