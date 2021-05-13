package ch05.s14.p04;

/**
 * 데몬 스레드 (Daemon Thread)
 * - 다른 스레드가 모두 종료될 경우, 스스로 종료되는 스레드 (정의)
 * - 무한 루프로 대기하면서 동작하는 구현이 많음 (활용)
 *  - 일정 시간마다 동작, interrup등에 의해서 동작
 *
 * 정의
 * - 사용자가 직접적으로 제어하지 않고, 백그라운드에서 돌면서 여러 작업을 하는 프로그램을 말한다.
 *   시스템 로그를 남기는 syslogd처럼 보통 데몬을 뜻하는 ‘d’를 이름 끝에 달고 있으며, 일반적으로 프로세스로 실행된다.
 */


/**
 * Thread
 * - 프로세스 내에서 실행되는 흐름의 단위를 말한다.
 * - Every thread has a name for identification purposes.
 *   More than one thread may have the same name.
 *   If a name is not specified when a thread is created, a new name is generated for it.
 *
 * Creating a new thread of execution
 * 1. to declare a class to be a subclass of Thread. This subclass should override the run method of class Thread.
 *    An instance of the subclass can then be allocated and started.
 * 2. to declare a class that implements the Runnable interface. That class then implements the run method.
 *    An instance of the class can then be allocated, passed as an argument when creating Thread, and started.
 */

class AutoSaver extends Thread {
    public AutoSaver() {
        this.setDaemon(true); // 메인 스레드가 종료되면 스스로 종료되도록 데몬 설정
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Auto saved");
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        new AutoSaver().start();

        for (int i = 0; i < 15; i++) {
            Thread.sleep(1000);
            System.out.println("It's working");
        }

        /**
         * It's working
         * It's working
         * It's working
         * It's working
         * Auto saved
         * It's working
         * ... (v)
         */
    }
}
