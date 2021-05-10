package ch05.s05.p12;

import java.util.function.BinaryOperator;

/**
 * BinaryOperator 인터페이스의 클래스 메소드
 * - minBy, maxBy : Comparator를 입력받아 min, max 값 출력
 * minBy()
 * - returns the lesser of two elements
 *      return (a, b) -> comparator.compare(a, b) <= 0 ? a : b;
 * maxBy()
 * - returns the greater of two elements
 *      return (a, b) -> comparator.compare(a, b) >= 0 ? a : b;
 */
public class Main {
    public static void main(String[] args) {
        //todo 정확히 어떻게 작동하는지 이해못함.
        BinaryOperator<String> minBy = BinaryOperator.minBy((o1, o2) ->
                o1.length() > o2.length() ? 1 : -1);
        BinaryOperator<String> maxBy = BinaryOperator.maxBy((o1, o2) ->
                o1.length() > o2.length() ? 1 : -1);

        System.out.println(minBy.apply("abc", "de")); // de
        System.out.println(maxBy.apply("abc", "de")); // abc

        System.out.println(minBy.apply("abc", "def")); // abc

    }
}
