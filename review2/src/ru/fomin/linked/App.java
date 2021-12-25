package ru.fomin.linked;

public class App {

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addFirst(5);
        System.out.println(linkedList);
        System.out.println("size: "+linkedList.getSize());

        linkedList.add(4, 7);
        System.out.println(linkedList);
        System.out.println("size: "+linkedList.getSize());

        System.out.println( linkedList.remove(4));
        System.out.println(linkedList);
        System.out.println("size: "+linkedList.getSize());
        System.out.println(linkedList.get(1));

        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
        System.out.println("removing");
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList);
        System.out.println("size: "+linkedList.getSize());
    }

}
