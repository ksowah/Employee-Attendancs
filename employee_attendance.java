import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

// Main class
public class Main {

    String name;
    
    
    // This template method is reused in other classes
    public void template(){

        System.out.println("Please enter full name: ");

        Scanner employeeName = new Scanner(System.in);
        name = employeeName.nextLine();

    }
    
    
     /* This class contains a method that prints the actual date and time*/   
    class TakeData extends Main{

        public void data(){

        LocalDateTime todayDate = LocalDateTime.now();
            DateTimeFormatter tDate = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
            DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");
            String date = todayDate.format(tDate);
            String theTime = todayDate.format(time);


        try{
            FileWriter employee = new FileWriter(/* ENTER FILE PATH HERE (IN QUOTES) */+ name + ".txt");
            employee.write(name + " was present on " + "'" + date +"'"+ " at exactly " + "'" +theTime + "'");
            employee.close();
            System.out.println("Submission received");

        }catch(IOException e){

            System.out.println("An unknown error occurred");
            e.printStackTrace();

            }

        }
    }

    
    /* This class contains a method that allows users to view their date and time */
    class Check extends Main{

        public void checkTime(){

            try{

                File check = new File(name + ".txt");
                Scanner seeTime = new Scanner(check);
                while(seeTime.hasNextLine()){
                    String readTime = seeTime.nextLine();
                    System.out.println(readTime);
                }

            }catch(FileNotFoundException e){

                System.out.println("Please make sure you have submitted time");
                e.printStackTrace();

            }


        }

    }



        public static void main(String[] args) {

            int response;


            System.out.println("to submit attendance time enter '1'");
            System.out.println("To check attendance time enter '0'");
            System.out.println("Enter response: ");

            Scanner takeResponse = new Scanner(System.in);
            response = takeResponse.nextInt();

            // conditional statement to put users in control of the program
            if (response == 1){

                Main parent = new Main();
                Main.TakeData collectData = parent.new TakeData();
                collectData.template();
                collectData.data();

            }else if (response == 0){

                Main parent = new Main();
                Main.Check checkData = parent.new Check();
                checkData.template();
                checkData.checkTime();

            }else{
                System.out.println("Invalid Input");
            }

        }
    }





