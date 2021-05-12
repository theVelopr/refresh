package ch05.s14.p03;

public class Main {
    public static void main(String[] args) {
        Thread p1 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("P1!");
        });
        System.out.println(p1); // Thread[Thread-0,5,main]

        Thread p2 = new Thread (() -> {
            try {
            Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("P2!");
            // 기존 동작을 방해하고 반응을 강제하는 메소드
            //p1.interrupt();  // 주로 임베디드에서 많이 사용함.
        });
        System.out.println(p2); // Thread[Thread-1,5,main]

        p1.start(); // 10000mills 가 끝나고 나옴. (v)
        p2.start(); // 먼저 나오고 (v)
    }
}
