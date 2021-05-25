package ch03.s03.p01;

/**
 * 상속 (Inheritence)
 * 'IS-A' 관계
 */

class Person {
    String name;

    public void work() {
        System.out.println("일하기");
    }
    public void sleep() {
        System.out.println("잠자기");
    }
}

class Developer extends Person {
    String mainLang;

    public void writeCode() {
        System.out.println("돈 받은 만큼 코딩하기");
    }
}

class Student extends Person {
    String major;

    public void writeCode() {
        System.out.println("밤새 코딩하기");
    }
}

public class Main {
    public static void main(String[] args) {
        // 클래스를 상속하면, 모든 멤버 변수와 모든 메솓를 상속받는다.
        Developer dev = new Developer();
        dev.name = "나개발"; // 상속받은 멤버 변수
        System.out.println(dev.name); // 나개발
        dev.work(); // 일하기 (상속받은 메소드)
        dev.sleep(); // 잠자기 (상속받은 메소드)

        dev.mainLang = "Java";
        dev.writeCode(); // 객체 자체의 메소드

        Student stud = new Student(); // 'IS-A' 관계
        stud.writeCode(); // 밤새 코딩하기
    }
}
