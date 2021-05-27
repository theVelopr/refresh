package ch03.s04.p02;

/**
 * 멤버 변수의 재정의는 선언된 객체의 타입을 따른다. (문법적으로 본다)
 * 메소드 오버라이딩은 메모리상의 객체 타입을 따른다. (실제 객체로 본다)
 * (가상 메소드 호출 : Virtual method call)
 */

class Foo {
    static public String y = "Super class";
    public String x = "Super";

    public void methodA() {
        System.out.println("Super Method");
    }
}

class Bar extends Foo {
    static public String y = "Sub class";
    public String x = "Sub";

    @Override
    public void methodA() {
        System.out.println("Sub Method");
    }
}

public class Poly02 {
    public static void main(String[] args) {
        Bar bar = new Bar();
        Foo foo = (Foo)bar;

        System.out.println(bar.x); // sub
        bar.methodA(); // sub method

        System.out.println(foo.x); // super
        foo.methodA(); // sub method (virtual method call)

        System.out.println(Foo.y); // super class
        System.out.println(Bar.y); // sub class

        System.out.println(foo.y); // super class
        System.out.println(bar.y); // sub class
    }
}
