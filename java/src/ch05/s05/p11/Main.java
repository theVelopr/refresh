package ch05.s05.p11;

import java.util.function.DoublePredicate;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Predicate;

/**
 * Predicate 계열 기본/클래스 메소드
 *  - and(), or(), negate() : 기본 메소드
 *  - isEqual() : 클래스 메소드
 *
 *  and ()
 *  - represents a short-circuiting logical AND of this predicate and another.
 *  or()
 *  - represents a short-circuiting logical OR of this predicate and another.
 *  negate()
 *  - represents the logical negation of this predicate.
 */
public class Main {
    public static void main(String[] args) {
        // 기본메소드
        DoublePredicate p0 = x -> x > 0.5;
        DoublePredicate p1 = x -> x < 0.7;
        DoublePredicate p2 = p0.and(p1);
        DoublePredicate p3 = p0.or(p1);
        DoublePredicate p4 = p0.negate(); // not

        System.out.println(p0.test(0.9)); // true(v)
        System.out.println(p1.test(0.9)); // false(v)
        System.out.println(p2.test(0.9)); // false(v)
        System.out.println(p3.test(0.9)); // true(v)
        System.out.println(p4.test(0.9)); // false(v)
        System.out.println("");

        // 클래스 메소드
        Predicate<String> eq = Predicate.isEqual("String");
        System.out.println(eq.test("String")); // true
        System.out.println(eq.test("String!")); // false

    }
}
