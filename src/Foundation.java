import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Foundation {

    public static HashMap<StringPair,IntPair> pollMap = new HashMap<StringPair,IntPair>();

    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("Welcome to the NLP Reference Game!");

        File inputFile = new File ("/Users/Aishwarya/IdeaProjects/NLPReferenceGame/src/inputTestFile");
        Scanner input = new Scanner(inputFile).useDelimiter(",");

        ArrayList<String> parsed = parseFile(input);
        readPairs(parsed);

        StringPair sp1 = new StringPair("Cat", "Dog");
        StringPair sp2 = new StringPair("Chimp", "Zebra");


        //generateStatement(sp2);
        System.out.println();
        //generateStatement(sp1);
        generateStatementGeneral("Zebra", "Chimp");
        System.out.println();

        System.out.println(pollMap);
    }

    //read file and input contents into an arrayList
    //this is based on the condition that each line has two objects on it
    public static ArrayList<String> parseFile(Scanner input){
        ArrayList<String> processedList = new ArrayList<String>();
        while(input.hasNextLine()){
            String line = input.nextLine();
            StringTokenizer st = new StringTokenizer(line, ",");
            while(st.hasMoreTokens()){
                processedList.add(st.nextToken().trim());
            }
        }
        return processedList;
    }

    //retrieve user input regarding the pairs in the input file and organize them accordingly
    public static ArrayList<String> readPairs(ArrayList<String> pairs){
        ArrayList<String> responses = new ArrayList<String>();

        Scanner input = new Scanner(System.in);
        for(int i = 0; i < pairs.size(); i = i+2){
            System.out.println("Which is the bigger object, " + pairs.get(i) + " or " + pairs.get(i+1) + "?");
            String firstInput = pairs.get(i);
            String secondInput = pairs.get(i+1);

            String response = input.nextLine();
            StringPair sp = makePair(firstInput, secondInput);
            IntPair ip;
            if(response.equalsIgnoreCase(sp.getLeft())){
                ip = new IntPair(1,0);
            }else if(response.equalsIgnoreCase(sp.getRight())){
                ip = new IntPair(0,1);
            }else{
                ip = null;
            }

            if(ip != null) {
                if (pollMap.containsKey(sp)) {
                    IntPair old = pollMap.get(sp);
                    if (ip.getLeft() > ip.getRight()) {
                        old.incrementLeft();
                    } else {
                        old.incrementRight();
                    }
                    pollMap.remove(sp);
                    pollMap.put(sp, old);
                } else {
                    pollMap.put(sp, ip);
                }
            }
        }
        return responses;
    }

    private static String capitalize(String input){
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    private static void generateStatement(StringPair sp){
        IntPair ip = pollMap.get(sp);
        if(ip != null) {
            System.out.println("According to what you've told me.....");
            if(ip.getLeftStats() > ip.getRightStats()){
                System.out.println(sp.getLeft() + " is usually bigger than " + sp.getRight());
            }else if(ip.getLeftStats() < ip.getRightStats()){
                System.out.println(sp.getRight() + " is usually bigger than " + sp.getLeft());
            }else{
                System.out.println(sp.getRight() + " and " + sp.getLeft() + " are relatively similar in size");
            }
        }else{
            System.out.println("That pair is not in my records");
        }
    }

    private static StringPair makePair(String p1, String p2){
        StringPair sp;
        if(p1.compareTo(p2) < 0){
            sp = new StringPair(capitalize(p1), capitalize(p2));
        }else{
            sp = new StringPair(capitalize(p2), capitalize(p1));
        }
        return sp;
    }

    private static void generateStatementGeneral(String s1, String s2){
        StringPair temp = new StringPair(s1, s2);
        StringPair temp2 = new StringPair(s2, s1);

        if (pollMap.containsKey(temp)){
            generateStatement(temp);
        }else if(pollMap.containsKey(temp2)){
            generateStatement(temp2);
        }else{
            System.out.println("That pair doesn't exist in my records!");
        }
    }
}
