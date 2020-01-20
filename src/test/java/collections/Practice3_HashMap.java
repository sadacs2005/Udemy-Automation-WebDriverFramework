package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

public class Practice3_HashMap {

    @Test
    public void hashMap() {
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(0, "Russia");
        hm.put(2, "South Africa");
        hm.put(1, "Brazil");
        hm.put(3, "Kenya");
        //Get value from key
        System.out.println(hm.get(1));
        System.out.println(hm);
        //Remove using key
        hm.remove(2);
        System.out.println(hm);
        //Converting Hashmap to set
        Set set = hm.entrySet();
        System.out.println("Converted Hash map to Set");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            System.out.println(me.getValue());
            System.out.println(me.getKey());
        }
    }
}
