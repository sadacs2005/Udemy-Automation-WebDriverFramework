package collections;

import org.testng.annotations.Test;

public class Practice4_Test1 {
    
    @Test
    public void Test01_addValues() {
        Practice4_HashTableDecl.ht.put(01, "INDIA");
        Practice4_HashTableDecl.ht.put(02, "Srilanka");
        Practice4_HashTableDecl.ht.put(03, "BANGLADESH");
        System.out.println("The values in the HashTable for Test1 is \n"+ Practice4_HashTableDecl.ht);
    }
}
