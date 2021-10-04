package com.techelevator.logger;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class LoggerDemo {

    public static void main(String[] args){
        Logger myLogger = new Logger("src\\logs\\myLog.txt");
        myLogger.write("Opening log session");

        Scanner input = new Scanner(System.in);
        System.out.print("Enter text to be written>>> ");
        String text = input.nextLine();
        String nowTime = LocalDateTime.now().toString();

        myLogger.write(LocalDateTime.now() + ": " + text);
        text = "other text with LocalDate object";
        myLogger.write(LocalDate.now() + ": " + text);
        text = "more text with LocalTime object";
        myLogger.write(LocalTime.now() + ": " + text);
        myLogger.write(nowTime + ": Ending here...");

        try {
            myLogger.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
