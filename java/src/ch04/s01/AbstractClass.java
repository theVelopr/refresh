package ch04.s01;

/**
 * 추상 클래스(Abstract Class)
 * - 일부 메소드가 구현되지 않고, 선언만 되어 있는 클래스
 *  - 자식 클래스에서 이것을 반드시 구현하게끔 강제하는 것
 *  - 필요한 모든 클래스가 구현될 수 있또록 하여 안정성을 높임
 */

abstract class AbstractFoo {
    int x, y;

    public void method() {
        System.out.println("method");
    }

    public abstract void abstractMethod();
}

class Foo extends AbstractFoo {

    @Override
    public void abstractMethod() {
        System.out.println("implemented abstractMethod");
    }
}
public class AbstractClass {
    public static void main(String[] args) {
//        AbstractFoo afoo = new AbstractFoo()  추상 클래스는 객체 생성이 불가.


        Foo foo = new Foo();
        foo.abstractMethod();

        AbstractFoo afoo = (AbstractFoo)foo;
        afoo.abstractMethod(); // virtual method call

        // 추상클래스 객체 생성은 불가하지만 구현된 자식 클래스의 객체는 받을 수 있음.
    }
}
