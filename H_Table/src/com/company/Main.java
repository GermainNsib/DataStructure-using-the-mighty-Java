package com.company;
import java.util.LinkedList;

public class Main {


    public static void main(String[] args) {
        /*A hash table, also known as a hash map, is a data structure that implements an associative array abstract data type, 
        a structure that can map keys to values. A hash table uses a hash function to compute an index into an array of buckets 
        or slots, from which the desired value can be found.*/


        public class HashTable<K, V> {
            private static final int DEFAULT_CAPACITY = 10;
            private LinkedList<Entry<K, V>>[] table;
            private int size;

            private static class Entry<K, V> {
                private K key;
                private V value;

                public Entry(K key, V value) {
                    this.key = key;
                    this.value = value;
                }

                public K getKey() {
                    return key;
                }

                public V getValue() {
                    return value;
                }

                public void setValue(V value) {
                    this.value = value;
                }
            }

            public HashTable() {
                this(DEFAULT_CAPACITY);
            }

            public HashTable(int capacity) {
                table = new LinkedList[capacity];
                size = 0;
            }

            private int hash(K key) {
                return key.hashCode() % table.length;
            }

            public void put(K key, V value) {
                int index = hash(key);
                if (table[index] == null) {
                    table[index] = new LinkedList<>();
                }
                for (Entry<K, V> entry : table[index]) {
                    if (entry.getKey().equals(key)) {
                        entry.setValue(value);
                        return;
                    }
                }
                table[index].add(new Entry<>(key, value));
                size++;
            }

            public V get(K key) {
                int index = hash(key);
                if (table[index] != null) {
                    for (Entry<K, V> entry : table[index]) {
                        if (entry.getKey().equals(key)) {
                            return entry.getValue();
                        }
                    }
                }
                return null;
            }

            public void remove(K key) {
                int index = hash(key);
                if (table[index] != null) {
                    table[index].removeIf(entry -> entry.getKey().equals(key));
                    size--;
                }
            }

            public int size() {
                return size;
            }

            public static void main(String[] args) {
                HashTable<String, Integer> hashTable = new HashTable<>();
                hashTable.put("one", 1);
                hashTable.put("two", 2);
                hashTable.put("three", 3);

                System.out.println("Value for key 'two': " + hashTable.get("two"));

                hashTable.remove("two");
                System.out.println("Value for key 'two' after removal: " + hashTable.get("two"));

                System.out.println("Size of hash table: " + hashTable.size());
            }
        }
    }
}
