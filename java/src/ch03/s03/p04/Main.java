package ch03.s03.p04;

/**
 * Super Keyword
 *  - this가 자기 자신의 객체를 참조하듯,
 *  super는 부모 객체를 참조한다.
 *
 *  super.super 식으로 부모의 부모는 참조할 수 없다.
 */

class Foo {
    String x = "Foo";

    public Foo(String x) {
        this.x = x;
    }
}

class Bar extends Foo {
    String x = "Bar"; // 멤버변수명이 부모의 멤버변수명과 겹치면 재정의 된다.

    // 부모클래스에 기본 생성자를 사용하는 경우에는 호출 안해줘도 된다.
    // 부모클래스에 파라미터 생성자가 있으면 호출해 줘야 한다.
    public Bar(String x, String x1) {
        super(x);
        this.x = x1;
    }

    public void method() {
        String x = "Method";
        System.out.println(x); // 로컬 변수 -> 멤버 변수 -> 부모의 멤버 변수
        System.out.println(this.x); // 멤버 변수 -> 부모의 멤버 변수
        System.out.println(super.x); // 부모의 멤버 변수
    }
}

// 아무것도 상속하지 않은 경우, Object 클래스를 상속하는 것과 같다.
class Jaemi extends Object {
    public void method() {

    }
}
public class Main {
    public static void main(String[] args) {
        Bar bar = new Bar("1","2");
        bar.method(); // 자식 객체 생성을 하면, 부모 객체를 먼저 생성하고, 그 다음에 자식 객체를 생성한다.
        // Method
        // 2
        // 1

    }

}
