package ch03.s02.p03;

/**
 * 변수 (Variables)
 * 클래스에 쓰이는 다양한 변수
 *  - 클래스 멤버 변수 (static variable, class variable)
 *  - 인스턴스 멤버 변수 (member variable, attribute, ...)
 *  - 로컬 변수 (local variable)
 *  - 로컬 파라미터 변수 (local parameter variable, arguments)
 */

public class Variables {
    static int classVar; // class member variable
    int instanceVar; // instance member variable , field, attribute

    public void method(int paramVar) { // local parameter variable
        System.out.println(paramVar);
        int localVar; // Local variable

//        System.out.println(localVar); 로컬변수는 초기화 안됨
        localVar = 10;
        System.out.println(localVar);

        {
            localVar = 30;
            int localVar2 = 20;
        }
        System.out.println(localVar); // 블럭 내에서 수정된것도 반영됨
//        localVar2 = 40; 접근 불가. 생명주기가 끝났다.

    }
}

class VariableTest {
    public static void main(String[] args) {
        System.out.println("클래스 변수");
        System.out.println(Variables.classVar); // 0으로 초기화됨
        // 클래스 변수는 클래스 이름으로 바로 접근 가능
        Variables.classVar = 10; // 클래스 이름, 변수명으로 접근 가능
        System.out.println(Variables.classVar); // 10
        System.out.println("");

        System.out.println("인스턴스 멤버 변수");
        Variables var = new Variables();
        System.out.println(var.instanceVar); // 0으로 초기화됨
        var.instanceVar = 20;
        System.out.println(var.instanceVar); // 20

        Variables var2 = new Variables();
        System.out.println(var2.instanceVar); // 0

//        System.out.println(var2.classVar); // 가능하나 권장하지 않음
//        Variables.instanceVar 접근 불가

        System.out.println("로컬 변수");
        var.method(9);
        // 9
        // 10
        // 30
    }
}