package ch05.s14.p07;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;


/**
 * 세마포 (Semaphore)
 * - 사전적 의미는 횟대 (깃발)
 * n개의 깃발을 놓고, 여러 스레드가 경쟁하도록 하는 sync 기법
 * n = 1이면, BinarySemaphore라고 하며, Lock과 유사하게 동작함.
 */

//todo 강의 참조해야함.(아마 offline이었던걸로 기억함)
public class Main {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);

        System.out.println(sem.availablePermits()); // 1

        /*
        try {
            sem.acquire(12);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // interrupt()에 반응하지 않음
        //sem.acquireUninterruptibly();
        */
        // Blocking 하지 않고, 실패하면 false 리턴
        System.out.println(sem.tryAcquire());

        try {
            System.out.println(sem.tryAcquire(2000, TimeUnit.MILLISECONDS)); // true 찍고 false가 나옴
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(sem.availablePermits()); // 0

        sem.release();

        System.out.println(sem.availablePermits()); // 1
    }
}
