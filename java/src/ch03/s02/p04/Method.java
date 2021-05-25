package ch03.s02.p04;

/**
 * 메소드 (Methods)
 * 객체가 하는 동작을 정의하는 작업을 수행하는 코듸의 집합, 나열
 * 코드의 중복을 방지, 유지보수성을 향성, 코드의 가독성 개선
 */

class Foo {
    int value;
}

class Bar {
    // 인스턴스 메소드 (보통 그냥 메소드)
        // return type(출력의 차료형)
    public int add(int x, int y) {
        return x + y;
    }

    // 선언(Declaration) -  ~ 한 것이다 이지만 실제 구현은 x
    // 정의(Definition) - 선언 + 구현(초기화)

    // 정적 메소드(static method), 클래스 메소드
    // void 리턴 타입은 아무것도 반환하지 않는다.
    public static void classMethod() {
        System.out.println("Bar's 클래스 메소드 호출");
    }

    public static void swapPrimitive(int x, int y) {
        // call by value
        int temp = x;
        x = y;
        y = temp;
    }

    public static void swapReference(Foo x, Foo y) {
        // Foo -> class (class는 참조형 변수)
        int temp = x.value;
        x.value = y.value;
        y.value = temp;
    }

    // 여러개의 int를 입력 받는다
    // 입력 받은 결과를 배열로 주어진다.
                            // 가변인자 (variable arguemts)
    public static int sumAll(int... params) {
        int sum = 0;
        for (int value: params) {
            sum += value;
        }
        return sum;
    }

    // Method Overloading
    // 함수명은 같고, 입력 인자가 달라야한다.
    // 입력 인자의 개수도 다를 수 있다.
    public static float sumAll(float... params) {
        float sum = 0;
        for (float value: params) {
            sum += value;
        }
        return sum;
    }
}

class Person {
    static  String korWord = "사람";
    boolean isHungry = true; // instance member variable

    // class method
    public static void describe() {
        System.out.println(korWord + "입니다.");
        // 클래스 메소드는 클래스 변수를 사용할 수 있다.
        // 단, 객체에 속하는 속성은 사용할 수 없다.
    }

    // instance method
    public void eat() {
        isHungry = false;
    }
}

public class Method {
    public static void classMethod() {
        System.out.println("Method's 클래스 메소드 호출");
    }
    public void instanceMethod() {
        System.out.println("인스턴스 메소드 호출");
    }

    public static void main(String[] args) {
        Bar.classMethod();
        Bar bar = new Bar();
        System.out.println(bar.add(1,2));

        Person p1 = new Person();
        Person p2 = new Person();

        // 인스턴스 메소드는 객체의 속성을 변화시킨다.
        p1.eat();
        System.out.println(p1.isHungry);
        System.out.println(p2.isHungry);

        // 클래스 메소드는 객체의 속성과 상관이 없다.
        Person.describe(); // 사람입니다.

        int x = 10;
        int y = 20;
        Bar.swapPrimitive(x, y);
        System.out.println(x + ", " + y); // 10, 20

        Foo f1 = new Foo();
        Foo f2 = new Foo();

        f1.value = 10;
        f2.value = 20;
        Bar.swapReference(f1, f2);
        System.out.println(f1.value + ", " + f2.value); // 20, 10

        System.out.println(Bar.sumAll(1,2,3,4,5)); // 15
        System.out.println(Bar.sumAll(1.0f, 2.0f, 3.3f)); // 6.3

        classMethod(); // 동일 클래스에 속한 클래스 메소드 호출
        Method.classMethod();
        Method m = new Method();
        m.instanceMethod(); // 인스턴스 메소드 호출
    }
}
