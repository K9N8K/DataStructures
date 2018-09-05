// HashTable in Java
// Kyle Ko
// Description: I created a HashTable class that implements chaining via Linked Lists

import java.util.*;

public class HashTable {
    
    // private Node class for array elements (chaining)
    private class Node{
        String data;
        Node next;
        public Node(String input){
            this.data = input;
            this.next = null;
        }
    }
    
    Node[] theArray;
    int arraySize;
    
    public static void main(String[] args){
        HashTable Table1 = new HashTable(30);
        String[] elementsToAdd = {"1", "5", "17", "21", "26", "5"};
        int numElements = elementsToAdd.length;
        int collisions = 0;
        Table1.HashFunction1(elementsToAdd, Table1.theArray);
        
        // PRINTING
        // Goes through each slot in array and prints elements in linked list
        for(int i = 0; i < Table1.arraySize; i++){
            if(Table1.theArray[i] == null){
                System.out.println("Empty Slot: " + i);
            } else {
                boolean first = true;
                System.out.print("SLOT: " + i + " CONTAINS: ");
                for(Node front = Table1.theArray[i]; front != null; front = front.next){
                    System.out.print(front.data + " ");
                    if(first == false){
                        collisions++;
                    }
                    first = false;
                }
                System.out.println();
            }
        }
        
        System.out.println("Number of Elements: " + numElements);
        System.out.println("Number of Collisions: " + collisions);
    }
    
        // Creates a new HashTable with null slots in array 
        // ex. HashTable name = new HashTable(size of array);
    HashTable (int size){
        arraySize = size;
        theArray = new Node[size];
        Arrays.fill(theArray, null);
    }

    public void HashFunction1(String[] stringsForArray, Node[] theArray){
        for(int n = 0; n < stringsForArray.length; n++){
            String key = stringsForArray[n];
            Node insert = new Node(key);
            
            int arrayIndex = Integer.parseInt(key);
            if(theArray[arrayIndex] == null){
                theArray[arrayIndex] = insert;
            } else {
                insert.next = theArray[arrayIndex];
                theArray[arrayIndex] = insert;
            }
        }

    }
}
