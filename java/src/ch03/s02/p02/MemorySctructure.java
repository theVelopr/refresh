package ch03.s02.p02;

/**
 * 클래스와 객체의 메모리 구조
 * - 클래스 영역 (Class area, method area, code area, static atrea)
 *  -> field 정보, method 정보, type 정보, constant pool
 *
 * - 스택 영역 (Stack area)
 *  -> method 호출 시 선언된 로컬 변수 (임시로 있다가 사라짐)
 * - 힙 영역 (Heap area)
 *  -> new 키워드로 생성된 객체
 *  -> garbage collection이 등장하는 영역(gc)
 *     더 이상 사용하지 않는 메모리를 알아서 반환하는 JVM의 기능
 *
 */

public class MemorySctructure { // class area
    int x, y; // heap area
    String string = "String!"; // heap area & constant pool

    public void method (int valeu) { // class area

        char c = 'w'; // stack area
    }
}
