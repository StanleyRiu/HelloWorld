package com.cht;

import org.apache.commons.cli.*;

import java.util.Arrays;

public class CLI {
    String[] args;
    public CLI(String[] args) {
        //this.args = Arrays.copyOf(args, args.length);
        this.args = args;
    }

    void test() throws ParseException {
        // create Options object
        Options options = new Options();
        // add a option
        options.addOption("a", false, "add two numbers");

        //Create a parser
        CommandLineParser parser = new DefaultParser();
        //parse the options passed as command line arguments
        CommandLine cmd = parser.parse(options, args);

        //hasOptions checks if option is present or not
        if (cmd.hasOption("a")) {
            // add the two numbers
            for (String s : this.args) System.out.println(s);
            System.out.println(cmd.getOptionValue("a"));
        } else if (cmd.hasOption("m")) {
            // multiply the two numbers
        }
    }
}
