package ch05.s14.p02;

/**
 * .yield()
 * - A hint to the scheduler that the current thread is willing to yield
 *   its current use of a processor.
 * - Yield is a heuristic(trial-and-error) attempt to improve relative progression
 *   between threads that would otherwise over-utilise a CPU.
 * - Its use should be combined with detailed profiling and benchmarking to
 *   ensure that it actually has the desired effect.
 * - It may be useful for debugging or testing purposes,
 *   designing concurrency control constructs such as the ones in the
 *   {@link java.util.concurrent.locks} package
 *
 * .sleep()
 * - Causes the currently executing thread to sleep (temporarily cease execution)
 *   for the specified number of milliseconds, subject to the precision and accuracy of
 *   system timers and schedulers. The thread does not lose ownership of any monitors.
 *
 * //todo Define it.(2021.5.13)
 * priority
 * - How can we define this in the point of 'thread'?
 *
 * .start()
 * - Causes this thread to begin execution; the Java Virtual Machine calls the run method of this thread.
 *   The result is that two threads are running concurrently: the current thread (which returns from the call
 *   to the start method) and the other thread (which executes its run method).
 * - It is never legal to start a thread more than once.
 *   In particular, a thread may not be restarted once it has completed execution.
 *
 */

public class Main {
    public static void main(String[] args) {

        // todo 강의 참고 (이해못함)
        Thread p1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("~");
                Thread.yield(); // 다른 스레드로 양보하고 바로 실행 대기
                    try {
                        Thread.sleep(1); // Running 상태에서 Timed_Waiting 상태로 이동
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });
        System.out.println(p1); // Thread[Thread-0,5,main]

        Thread p2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("*");
                Thread.yield();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(p2); // Thread[Thread-1,5,main]

        // Priority 기능은 있으나, 보장되지 않는다.
        // 이유는 Starving 하는 Thread가 없게 하기 위해서 OS가 조절하기 때문이다.

        // 우선순위 - 값이 높을수록 우선순위가 높다.
        System.out.println(p1.getPriority()); // 5

        // todo 정확히 뭐가 일이났는지 이해 못함. 강의 참고
        p1.setPriority(Thread.MAX_PRIORITY);
        p2.setPriority(Thread.MIN_PRIORITY);

        p1.start();
        p2.start();
    }
}
