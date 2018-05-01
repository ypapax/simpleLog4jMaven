package testlog4j.testlog4j;


/**
 * Hello world!
 */

import java.io.*;
import java.net.*;

import org.apache.log4j.*;
import org.apache.log4j.xml.*;

public class App {
    // Next : check jar 
    static Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("INFO2");

    }
}
