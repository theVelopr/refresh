package ch05.s05.p07;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

/**
 * Function Type
 * - Mapping : 입력 -> 출력
 * - 입력 타입과 출력 타입은 다를 수 있다.
 */

public class Main {
    public static void main(String[] args) {
        // Function은 기본적으로 t와 r을 입력받게 되어 있다.

        Function<String, Integer> func = (s) -> s.length();
        System.out.println(func.apply("Four"));

        BiFunction<String, String, Integer> funcTwo = (s, u) -> s.length() + u.length() + 7;
        System.out.println(funcTwo.apply("A", "BC"));

        // P Type Function
        IntFunction<String> funcThree = value -> String.valueOf(value);
        System.out.println(funcThree.apply(512));

        // ToP Type Function
        ToIntFunction<String> funcFour = (s) -> s.length();
        System.out.println(funcFour.applyAsInt("ABCD"));

    }
}
