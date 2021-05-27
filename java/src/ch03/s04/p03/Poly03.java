package ch03.s04.p03;

/**
 * 공변 반환 타입 (Covariant return type)
 */

class Foo {
    public Foo getInstance() {
        return this;
    }
}

class Bar extends Foo {
    @Override
    public Bar getInstance() { // 오버라이딩이지만, 리턴타입이 달라질 수 있다.
        return this;
    }
}
public class Poly03 {
}
