package com.company;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        public class Main {
            public static void main(String[] args) {
                // Create a map
                Map<String, Integer> map = new HashMap<>();

                // Add key-value pairs to the map
                map.put("apple", 1);
                map.put("banana", 2);
                map.put("orange", 3);

                // Print the map
                System.out.println("Map: " + map);

                // Retrieve a value from the map
                System.out.println("Value for key 'apple': " + map.get("apple"));

                // Check if a key is present in the map
                System.out.println("Contains key 'banana': " + map.containsKey("banana"));

                // Iterate over the map
                System.out.println("Entries:");
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
                }

                // Remove a key-value pair from the map
                map.remove("orange");
                System.out.println("Map after removing key 'orange': " + map);
            }
        }
    }
}
