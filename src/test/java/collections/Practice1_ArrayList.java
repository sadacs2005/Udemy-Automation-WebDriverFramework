package collections;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class Practice1_ArrayList {
    
    @Test
    public void arrayListBasicOperation() {
        ArrayList<String> stringArrayList= new ArrayList<String>();
        //ADD
        stringArrayList.add("ANU");
        stringArrayList.add("SADA");
        stringArrayList.add(0, "SADANU");
        System.out.println("Initial Array List");
        System.out.println(stringArrayList);
        //Remove
        stringArrayList.remove(0);
        System.out.println("Array List after removing");
        System.out.println(stringArrayList);
        //Get
        System.out.println(stringArrayList.get(1));
        //Contains
        System.out.println(stringArrayList.contains("ANU"));
        //Find index of a object
        System.out.println(stringArrayList.indexOf("ANU"));
        //Find size
        System.out.println(stringArrayList.size());
        //Accepts duplicates
        stringArrayList.add("ANU");
        System.out.println(stringArrayList);
        
    }

}
