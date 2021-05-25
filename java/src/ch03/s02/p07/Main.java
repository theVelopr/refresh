package ch03.s02.p07;

/**
 * 초기화 블럭(Initializer)
 */
public class Main {
    static int classVar;
    static int instanceCount;
    int instanceVar;

    // static initializer
    static {
        System.out.println("static block1");
        classVar = 20;
    }

    // object initializer
    {
        System.out.println("block1");
        instanceVar = 30;
        classVar = 50; // 비추천
        instanceCount++; // 이러한 패턴은 사용됨
    }

    static {
        System.out.println("static block2");
        classVar = 5;
    }

    {
        System.out.println("block2");
        instanceVar = 6;
    }
}

class MainTest {
    public static void main(String[] args) {
        System.out.println(Main.classVar); // static block1\r static block2\r 5
        Main main = new Main();
        System.out.println(Main.instanceCount); // block1\r block2\r 1
        System.out.println();

        System.out.println(main.instanceVar); // 6
        System.out.println(Main.classVar); // 50
        System.out.println();

        Main main2 = new Main();
        System.out.println(Main.instanceCount);  // block1\r block2\r 2
        Main main3 = new Main();
        System.out.println(Main.instanceCount); // block1\r block2\r 3

    }
}
