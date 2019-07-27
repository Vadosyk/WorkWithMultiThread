package ua.kiev.prog.MultiThreadArraySum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        long result = 0;

        int[] array = new int[100000000];
        System.out.println("Please wait...");
        Random random = new Random();
        for(int i = 0; i < array.length; i ++){
            array[i] = random.nextInt(100);
        }

        List<MultiThreadArraySum> threads = new ArrayList<>();

        for(int i = 0; i < 2; i ++){
            int part = array.length / 2;
            threads.add(new MultiThreadArraySum(array, part * i, part * (i + 1)));
        }
        long time = System.currentTimeMillis();
        for (MultiThreadArraySum thread : threads){
            thread.start();
        }
        for (MultiThreadArraySum thread : threads){
            try {
                thread.join();
                result += thread.sum;
                System.out.println(thread.getName()); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Multi thread sum = " + result);
        System.out.println("Multi thread sum finished on - " + (System.currentTimeMillis() - time) + " ms");

        time = System.currentTimeMillis();
        MultiThreadArraySum thread = new MultiThreadArraySum(array, 0, array.length);
        thread.start();
        try {
        	thread.join();
            System.out.println(thread.getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result = thread.sum;
        System.out.println("Single thread sum = " + result);
        System.out.println("Single thread sum finished on - " + (System.currentTimeMillis() - time) + " ms");
    }
}