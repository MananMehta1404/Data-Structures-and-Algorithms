package Hashing;

import java.util.*;

public class Hash_Map {
    public static void main(String[] args) {
        // Creating a HashMap
        HashMap<Integer, String> map = new HashMap<>();

        // Adding elements to the HashMap
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        map.put(0, "ZERO");
        
        // Size of the HashMap
        System.out.println("Size of the map is: " + map.size());
        
        // Displaying the HashMap
        System.out.println(map);

        // Adding the same key again -> It will replace the previous value
        map.put(1, "ONE");
        System.out.println(map);

        // Displaying the HashMap using an iterator
        // First method
        for(Map.Entry<Integer, String> entry: map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        
        // Second method
        for(Integer key: map.keySet()){
            System.out.println(key + " : " + map.get(key));
        }

        // Checking if an element is present in the HashMap
        if(map.containsKey(1)){
            System.out.println("1 is present in the map");
            System.out.println("Value of 1 is: " + map.get(1));
        }
        if(!map.containsKey(4)){
            System.out.println("4 is absent in the map");
        }

        // Removing an element from the HashMap
        map.remove(1);
        if(!map.containsKey(1)){
            System.out.println("1 is removed from the map");
        }
    }
}
