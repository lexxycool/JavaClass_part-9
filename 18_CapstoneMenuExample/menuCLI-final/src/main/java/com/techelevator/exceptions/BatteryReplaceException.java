package com.techelevator.exceptions;

// creating my own exception class
// Exception is the parent, this BRE is the child
public class BatteryReplaceException extends Exception{

    public BatteryReplaceException(){
        // pass custom message up to the parent class
        // called Exception
        // this is inheritance!
        super("No Battery replacements allowed today!");
    }
}
