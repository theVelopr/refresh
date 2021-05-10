package ch05.s05.p09;

import java.util.function.BiPredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Predicate Type
 * - 논리 판단을 해주는 함수형 인터페이스
 * - 입력을 받아서 Boolean 타입 출력으로 반환
 */
public class Main {
    public static void main(String[] args) {
        Predicate<String> pred = (s) -> s.length() == 4;
        System.out.println(pred.test("abdc"));
        System.out.println(pred.test("abeds"));

        BiPredicate<String, Integer> pred2 = (s, v) -> s.length() == v;
        System.out.println(pred2.test("asdf", 6));
        System.out.println(pred2.test("asdf", 4));

        //todo - 쓸만한 예시 없나?
        IntPredicate pred3 = x -> x > 0;
        System.out.println(pred3.test(1));
    }
}
