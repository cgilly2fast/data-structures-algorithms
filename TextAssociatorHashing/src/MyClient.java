// CSE 373, Homework 3 (TextAssociator)
// Ramdon sentence generator

import java.io.*;     // for File, FileNotFoundException
import java.util.*;   // for Scanner, List, Set, Collections

public class MyClient {

    //Path to desired grammar file to read
    public final static String GRAMMAR_FILE = "dxarts.txt";
    public static TextAssociator sc;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to the CSE 373 random sentence generator!");
        System.out.println();

        Scanner console = new Scanner(System.in);
        List<String> lines = readLines(GRAMMAR_FILE);
        sc = new TextAssociator();

        for(String line : lines) {
            // split non-terminal form terminals
            String[] rule = line.trim().split("::="); 
            sc.addNewWord( rule[0] );
            // split each terminal up into individual terminals
            String[] terminals = rule[1].trim().split("[|]");
            for( String term : terminals ) {
                sc.addAssociation(rule[ 0 ], term);
            }    
        }

        String symbol = "<q>";
        
        doGenerate(console, symbol);
            
    }
    
    // Prompts user for a number of phrases to generate from the given symbol,
    // generates that many using the provided GrammarSolver and displays them to the 
    // console.
    public static void doGenerate(Scanner console, String symbol) {
        System.out.print("How many do you want me to generate? ");
        if (console.hasNextInt()) {
            int number = console.nextInt();
            if (number < 0) {
                System.out.println("No negatives allowed.");
            } else {
                System.out.println();
                for (int i = 0; i < number; i++) {
                	String result = generate(symbol);
                    System.out.println(result);
                }
            }
        } else {
            System.out.println("That is not a valid integer.");
        }
        console.nextLine();   // to position to next line
    }

    // Reads text from the file with the given name and returns as a List.
    // Strips empty lines and trims leading/trailing whitespace from each line.
    // pre: a file with the given name exists, throws FileNotFoundException otherwise
    public static List<String> readLines(String fileName) throws FileNotFoundException {
        List<String> lines = new ArrayList<String>();
        Scanner input = new Scanner(new File(fileName));
        while (input.hasNextLine()) {
            String line = input.nextLine().trim();
            if (line.length() > 0) {
                lines.add(line);
            }
        }
        return lines;
    }

   // PRE:  GrammarSolver must be intialized.
   // POST: returns sentence from grammar with no white space on front or end 
   public static String generate(String symbol) {
      // trims white space of sentence
      return makeSentence(symbol).trim();
   }
   
   // PRE:  will only be called when user calls generate method. throws 
   //       IllegalArgumentException if string is null or size 0.
   // POST: returns sentence following rules of grammar
   public static String makeSentence(String symbol) {
      check(symbol);
      Random rand = new Random();
      String result = "";
      // check if symbol is terinmal or non-terminal  
      if(sc.getAssociations(symbol) != null ){
        // creates random number within 0 and number of terimals assigned to 
        // terminal
        int randIndex = rand.nextInt(sc.getAssociations(symbol).size());
        // creates array of all terminals assigned to non-terminal
        String[] terms = sc.getAssociations(symbol).toArray(new String[0]);
        // splits called terminal up to remove white space
        String[] split = terms[randIndex].split("[ \t]+");
        // adds each token of terminals to result
        for(String rule : split) {
           result += makeSentence(rule);
        }   
      } else {
        result += symbol + " ";
      }   
      return result;  
   }
   
   // PRE:  Paramter of type string must be passed
   // POST: throws IllegalArgumentException if string is null or size 0.
   public static void check(String symbol) {
      if(symbol == null || symbol.length() == 0) {
        throw new IllegalArgumentException();
      }          
   }
} 
