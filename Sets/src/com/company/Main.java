package com.company;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {


        public class Main {
            public static void main(String[] args) {
                // Create a set
                Set<String> set1 = new HashSet<>();
                Set<String> set2 = new HashSet<>();

                // Add elements to the sets
                set1.add("apple");
                set1.add("banana");
                set1.add("orange");

                set2.add("orange");
                set2.add("pear");
                set2.add("kiwi");

                // Print the sets
                System.out.println("Set 1: " + set1);
                System.out.println("Set 2: " + set2);

                // Perform set operations
                Set<String> union = new HashSet<>(set1);
                union.addAll(set2);
                System.out.println("Union: " + union);

                Set<String> intersection = new HashSet<>(set1);
                intersection.retainAll(set2);
                System.out.println("Intersection: " + intersection);

                Set<String> difference = new HashSet<>(set1);
                difference.removeAll(set2);
                System.out.println("Difference (Set 1 - Set 2): " + difference);
            }
        }
    }
}
