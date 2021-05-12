package ch05.s14.p09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Thread, SynchronizedLIst 예시
 */

// todo 정확이 어떻게 돌아가는지 이해못함.
    
public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list1 = new Vector<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = Collections.synchronizedList(list2);
        // list3 - list2의 싱크된 버전

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    list1.add(1);
                }
            }).start();
        }

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    list3.add(1);
                }
            }).start();
        }

        Thread.sleep(1000);

        System.out.println("list1 : " + list1.size());
        System.out.println("list2 : " + list2.size());

        //
    }
}
