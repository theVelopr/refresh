package ch05.s05.p08;

import java.util.function.BinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.function.IntBinaryOperator;

/**
 * Operation Type
 * - 입력받은 타입과 동일한 타입의 출력을 하는 함수형 인터페이스
 * - Function계열과 달리 입출력 타입이 다를 수 없다.
 */
public class Main {
    public static void main(String[] args) {
        // 입력이 1개인 것을 Unary를 붙여서 표현
        UnaryOperator<String> operator = s -> s + ".";
        System.out.println(operator.apply("1"));

        BinaryOperator<String> operatorTwo = (s1, s2) -> s1 + s2;
        System.out.println(operatorTwo.apply("I'm ", "here."));

        IntUnaryOperator op = value -> value * 10;
        System.out.println(op.applyAsInt(5)); // 50

        IntBinaryOperator op2 = (v1, v2) -> v1 * v2;
        System.out.println(op2.applyAsInt(3,5));

        IntBinaryOperator gugudan = (v1, v2) -> v1 * v2;
        for(int i = 2; i < 10; i++) {
            System.out.printf("%d 단\n", i);
            for(int j = 1; j< 10; j++) {
                System.out.printf("%d x %d = %d\n", i, j, op2.applyAsInt(i,j));
            }
        }
    }
}
