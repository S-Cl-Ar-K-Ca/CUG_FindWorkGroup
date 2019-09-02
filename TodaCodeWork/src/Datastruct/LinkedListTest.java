package Datastruct;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.addLast(20);
        linkedList.addFirst(5);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(0,0);


        for (Integer i:linkedList) {
            System.out.println(i);
        }
    }
}
