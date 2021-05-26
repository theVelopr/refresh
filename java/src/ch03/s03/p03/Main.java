package ch03.s03.p03;

/**
 * Method Overrding (매소드 재정의)
 * Override -> 덮어 씌우다. 해킹해서 뭔가 달라지게 한다
 * 다형성의 근간이 됨
 */

class Person {
    public void writeCode() {
        System.out.println("아무 코드나 일단 적어봄");
    }
}

class Student extends Person {
    @Override
    public void writeCode() {
        System.out.println("능숙하게 코드를 작성해봄");
    }

    public void sleep() {
        System.out.println("잘 잤다.");
    }
}

class Developer extends Person {
    @Override
    public void writeCode() {
        System.out.println("코드 작성 하기 싫어서 안함");
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.writeCode(); // 능숙하게 코드를 작성해봄

        Person person = new Person();
        person.writeCode(); // 아무 코드나 일단 적어봄

        Person person1 = new Developer();
        person1.writeCode(); // 코드 작성 하기 싫어서 안함

        Developer developer = new Developer();
        developer.writeCode(); // 코드 작성 하기 싫어서 안함

        // 부모클래스 자료형으로 자식 클래스를 받을 수 있다.
        Person p = (Person)developer;
        p.writeCode(); // 코드 작성 하기 싫어서 안함
        p = (Person)student;
        p.writeCode(); // 능숙하게 코드를 작성해봄
        System.out.println();

        // 다형성의 구현 중 하나
        Person[] people = new Person[] {new Developer(), new Student()};
        for (Person person2: people) {
            person2.writeCode();
            // 코드 작성 하기 싫어서 안함
            // 능숙하게 코드를 작성해봄
        }

        student.sleep();
        p = (Person)student;
//        p.sleep();
        // 부모 클래스로 캐스팅이 되면, 자식 클래으세만 있는 메소드는 실행이 안된다. 
    }
}
