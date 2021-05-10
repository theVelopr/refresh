package ch05.s05.p06;

import java.util.function.BooleanSupplier;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * Supplier Type
 * - 아무런 입력을 받지 않고, 값을 하나 반환하는 함수형 인터페이스
 * - 자료를 '공급'하는 역할을 한다.
 */
public class Main {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Nothing was given.";
        System.out.println(supplier.get());

        // Supplier는 P Type에서 getAsP 메소드로 정의됨.
        BooleanSupplier boolSup = () -> true;
        System.out.println(boolSup.getAsBoolean());

        // ex
        IntSupplier rollDice = () -> (int)(Math.random() * 6);
        for (int i = 0 ; i < 10; i++) {
            System.out.println(rollDice.getAsInt());
        }
        /**
         * 우리가 람다식을 정의하는 순간 접촉할 수 잇는 모든 변수들을 활용이 가능함.
         * 그리고 여기서 fix된 동작을 하는게 아니더라도 주변상황에 따라
         * 동적으로 동작하는 무엇인가를 SUPPLY 할 수 있기 때문에 supplier type을 나름대로 의미가 있다고 봄
         */
        int x = 4;
        IntSupplier intsupp = () -> x;
        System.out.println(intsupp.getAsInt());

    }
}
