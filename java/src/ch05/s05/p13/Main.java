package ch05.s05.p13;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * 람다식에 기존 메소드/생성자 사용
 *  - 람다식에 기존에 구현되어 있는 내용을 재사용하고자 할 때 사용
 *  compareTo
 *  - The comparison is based on the Unicode value of each character in the strings.
 *  -
 */
public class Main {
    public static void main(String[] args) {
        // 클래스::인스턴스_메소드
        //todo 다른 예시가 필요함.
        String [] strings = {"fast", "campus", "best", "academy"};
        // Comparator 인터페이스는 2개의 args를 받음
        // compare(o1, o2) -> o1.compareTo(o2)
        // o1.인스턴스_메소드(o2) 로 호출되는 메소드가 사용됨.
        Arrays.sort(strings, String::compareTo);
        System.out.println(Arrays.toString(strings));

        // 클래스::클래스_메소드
        // todo 예시?
        Function<String, Integer> func = Integer::parseInt;

        // 인스턴스::인스턴스_메소드(v)
        String s = "String";
        Predicate<String> pred = s::equals;
        System.out.println(pred.test("String")); // true
        System.out.println(pred.test("String!")); // false

        // 생성자를 andThen, compose 등과 함께 사용 가능

        // 클래스::new
        UnaryOperator<String> fnc = String::new;
        System.out.println(fnc.apply("클래스::NEW"));

        // 클래스[]::new -> 배열 생성
        // Int입력받아서 String[]을 출력
        IntFunction<String[]> fnc2 = String[]::new;
        String [] strings1 = fnc2.apply(100);
        //todo How...?
        System.out.println(strings1.length); // 100 (?) Why???

    }
}
