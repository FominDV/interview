package ru.fomin.array;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        MyArrayList<String> arrayList = new MyArrayList<>(4);
        System.out.println(arrayList);
        System.out.println();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        arrayList.set(3, "D");
        System.out.println("size: "+arrayList.getSize());
        System.out.println("capacity: "+arrayList.getCapacity());
        System.out.println(arrayList);
        System.out.println();

        arrayList.add("e");
        System.out.println("size: "+arrayList.getSize());
        System.out.println("capacity: "+arrayList.getCapacity());
        System.out.println(arrayList);
        System.out.println();

        arrayList.add(4, "f");
        arrayList.add(1, "1");
        System.out.println("size: "+arrayList.getSize());
        System.out.println("capacity: "+arrayList.getCapacity());
        System.out.println(arrayList);
        System.out.println();

        System.out.println(arrayList.indexOf("1"));
        System.out.println(arrayList.get(3));
        System.out.println();

        System.out.println(arrayList.remove("f"));
        System.out.println(arrayList.remove("ggg"));
        System.out.println(arrayList.remove("e"));
        System.out.println("size: "+arrayList.getSize());
        System.out.println("capacity: "+arrayList.getCapacity());
        System.out.println(arrayList);

        System.out.println(arrayList.contains("T"));
        System.out.println(arrayList.contains("e"));
        System.out.println();


    }

}
