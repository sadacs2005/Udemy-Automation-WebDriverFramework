package collections;

import java.util.HashSet;
import java.util.Iterator;

import org.testng.annotations.Test;

public class Practice2_HashSet {
    HashSet<String> stringHashSet=null;
    
    @Test
    public void hashSetBasicOperations() {
        stringHashSet =new HashSet<String>();
        //Add
        stringHashSet.add("CANADA");
        stringHashSet.add("Australia");
        stringHashSet.add("INDIA");
        stringHashSet.add("United States");
        stringHashSet.add("Malaysia");
        //Does not accept duplicates
        stringHashSet.add("CANADA");
        System.out.println(stringHashSet);
        //Remove
        stringHashSet.remove("Australia");
        //Size
        System.out.println(stringHashSet.size());
    }
    
    @Test
    public void iterator() {
        System.out.println("The values by iterating are:");
        Iterator<String> it=stringHashSet.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
