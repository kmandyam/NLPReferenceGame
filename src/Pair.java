/**
 * Created by Karishma on 4/26/16.
 */
public class Pair {
    private String left;
    private String right;
    public Pair(String left, String right){
        this.left = left;
        this.right = right;
    }

    public String getLeft(Pair p){
        return p.left;
    }

    public String getRight(Pair p){
        return p.right;
    }


}

//First off, I want a poll for every single pair I've ever asked about...that's what this HashMap is gonna be: StringPair to an IntPair
    //The StringPair has a left and right and the intPair shows how many times the left is bigger or the right is bigger
//Next, I want an official ordering of sizes...this should happen whenever I get a redundant pair thing...at that point, I'd want to create
// some sort of master list, or set of lists...
// When it comes to clarification from the user, I would want to add this into my poll list as well -> let's keep clarification to a minimum for now,
//so that we just end up with a collection of lists -> we can figure out how to consolidate this later....
//Here's all the things we can do with this model:
 //generate a confidence factor for any previously said pair
 //generate a set of lists for any previously given object (and it's relation to other objects)

