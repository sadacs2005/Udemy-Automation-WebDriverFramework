package collections;

import org.testng.annotations.Test;

public class Practice4_Test2 {
    
    @Test
    public void Test02_addValues() {
        Practice4_HashTableDecl.ht.put(04, "CANADA");
        Practice4_HashTableDecl.ht.put(05, "FRANCE");
        Practice4_HashTableDecl.ht.put(06, "IRELAND");
        System.out.println("The values in the HashTable for Test2 is \n"+ Practice4_HashTableDecl.ht);
    }

}
