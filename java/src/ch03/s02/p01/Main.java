package ch03.s02.p01;

/**
 * 클래스
 *  - 객체를 생성하기 위한 설계도
 * 객체
 *  - 글래스를 구체화하여 값으로 생성된 것 (Object. Instance)
 * 클래스를 객체로 만드는 과정 -> Instantiation
 */

class Car {
    int speed = 0; // Attribute,field(속성), Member Variable

    void move() { // method
        speed = 10; // 행위를 구현, 속성을 변경
    }
}

public class Main {
    public static void main(String[] args) {
        Car carOne = new Car(); // new 키워드로 클래스에서 객체를 생성
        System.out.println(carOne.speed); // 0 >>>>> .으로 속성 접근 가능
        carOne.move(); // method call
        System.out.println(carOne.speed); // 10

        Car carTwo = new Car();
        System.out.println(carTwo.speed); // 0 >>>>> 독립적인 객체

        Car carThree = carOne; // 참조형 객체이므로 새 객체를 만들지 않음
        System.out.println(carThree.speed); // 10
        carThree.speed = 5;
        System.out.println(carThree.speed); // 5
        System.out.println(carOne.speed); // 5
    }
}
