package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;


public class Main {


    private static void testListPerformance(List<Integer> list, int iterNum) {
        long addTime = evaluateOperationTime(list, iterNum, List::add);
        long getTime = evaluateOperationTime(list, iterNum, List::get);
        long deleteTime = evaluateOperationTime(list, iterNum, List::remove);

        System.out.println(list.getClass().getSimpleName() + ":add\t\t" + iterNum + "\t\t" + addTime);
        System.out.println(list.getClass().getSimpleName() + ":get\t\t" + iterNum + "\t\t" + getTime);
        System.out.println(list.getClass().getSimpleName() + ":delete\t" + iterNum + "\t\t" + deleteTime);
    }


    private static long evaluateOperationTime(List<Integer> list, int iterations, BiConsumer<List<Integer>, Integer> action) {
        long startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            action.accept(list, i);
        }
        return System.nanoTime() - startTime;
    }


    public static void main(String[] args) {
        final int ITERATION_NUM = 2000;

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println("Method\t\t\tIterations\tTime (ns)");
        testListPerformance(arrayList, ITERATION_NUM);
        testListPerformance(linkedList, ITERATION_NUM);
    }
}