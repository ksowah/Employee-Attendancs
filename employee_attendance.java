package com.Practice;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Third {

    String name;

    public void template(){

        System.out.println("Please enter full name: ");

        Scanner employeeName = new Scanner(System.in);
        name = employeeName.nextLine();

    }

    class TakeData extends Third{

        public void data(){

        LocalDateTime todayDate = LocalDateTime.now();
            DateTimeFormatter tDate = DateTimeFormatter.ofPattern("E, MMM dd yyyy");
            DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm");
            String date = todayDate.format(tDate);
            String theTime = todayDate.format(time);


        try{
            FileWriter employee = new FileWriter(name + ".txt");
            employee.write(name + " was present on " + "'" +date +"'"+ " at exactly " + "'" +theTime + "'");
            employee.close();
            System.out.println("Submission received");

        }catch(IOException e){

            System.out.println("An unknown error occurred");
            e.printStackTrace();

            }

        }
    }

    class Check extends Third{

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

            if (response == 1){

                Third parent = new Third();
                Third.TakeData collectData = parent.new TakeData();
                collectData.template();
                collectData.data();

            }else if (response == 0){

                Third parent = new Third();
                Third.Check checkData = parent.new Check();
                checkData.template();
                checkData.checkTime();

            }else{
                System.out.println("Invalid Input");
            }

        }
    }





