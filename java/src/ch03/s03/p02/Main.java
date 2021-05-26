package ch03.s03.p02;

/**
 * Class Composition
 *  - 상속하고 유사하지만, 한 클래스가 다른 클래스의 객체를 포함하는 관계
 *  내부에 포함하고 있어 'Has-a' 관계로 표현됨.
 */

// MainMachine 'HAS-A' String.
class MainMachine {
    String model;
    boolean isBroken = false;

    public MainMachine(String model) {
        this.model = model;
    }
}

// Developer 'HAS-A' MainMachine
// Developer 클래스는 MainMachine의 객체 하나를 보유한다.
class Developer {
    String name;
    MainMachine mainMachine;

    public Developer(String name, MainMachine mainMachine) {
        this.name = name;
        this.mainMachine = mainMachine;
    }

    public void writeCode() {
        if (mainMachine.isBroken) {
            System.out.println("코딩을 할 수 없습니다.");
        } else {
            System.out.println(mainMachine.model + "(으)로 코딩하기");
        }
        if (Math.random() > 0.9) {
            breakMachine();
        }
    }

    public void breakMachine() {
        mainMachine.isBroken = true;
    }
}
public class Main {
    public static void main(String[] args) {
        MainMachine mac = new MainMachine("Macbook Pro");
        Developer developer = new Developer("나개발", mac);

        for (int i = 0; i < 10; i++) {
            developer.writeCode();
        }
    }
}
