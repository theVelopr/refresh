package ch05.s05.p05;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;

/**
 * Consumer Type
 * - 파라미터를 입력 받아서 그것을 소비하는 Functional Interface
 * - accept Method를 사용 : Return이 Void
 * - Consumer인 이유
 *  - 리턴이 되지 않고 함수내에서 사용되고 없어짐
 */

public class Main {
    public static void main(String[] args) {
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept("It's a String.");

        BiConsumer<String, String> biConsumer = (t, u) -> System.out.println(t + "," + u);
        biConsumer.accept("StringA","StringB");

        // Autoboxing을 이용
        Consumer<Integer> integerConsumer = (x) -> System.out.println(x);
        integerConsumer.accept(5);

        IntConsumer intConsumer = (x) -> System.out.println(x);
        intConsumer.accept(10);

        ObjIntConsumer<String> objIntConsumer = (t, x) -> System.out.println(t+ ": " + x);
        objIntConsumer.accept("x", 1324);
    }
}
