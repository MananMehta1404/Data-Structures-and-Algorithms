package Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class Hash_Set{
    public static void main(String[] args) {
        // Creating a HashSet
        HashSet<Integer> set = new HashSet<>();

        // Adding elements to the HashSet
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);

        // Size of the HashSet
        System.out.println("Size of the set is: " + set.size());

        // Displaying the HashSet
        System.out.println(set);

        // Displaying the HashSet using an iterator
        set.add(0);
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

        // Checking if an element is present in the HashSet
        if(set.contains(1)){
            System.out.println("1 is present in the set");
        }
        if(!set.contains(4)){
            System.out.println("4 is absent in the set");
        }

        // Removing an element from the HashSet
        set.remove(1);
        if(!set.contains(1)){
            System.out.println("1 is removed from the set");
        }
    }
}