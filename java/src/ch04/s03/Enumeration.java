package ch04.s03;

/**
 * 열거형 (Enumeration)
 * enum 키워드로 표현
 * 내부적인 구현은 enum -> java.lang.Enum 클래스를 상속받음
 * enum은 다른 클래스를 상속하지 못함
 *
 * 열거형은 다른 클래스를 상속하지 못하지만, 인터페이스 구현은 가능
 * 열거형 타입에는 열거형 상수와 null 값 할당 가능
 */


enum Job { // 각 상수는 0부터 숫자를 가지지만, 심블로만 사용하고 숫자는 사용하지 않음.
    STUDENT, MARKETING, DEVELOPER, CEO;
}

class Foo { // 클래스 내부에서 메소드 구현
    enum Symbol {
        ONE, TWO, THREE, FOUR;

        public Symbol nextSymbol() {
            if(this.equals(ONE)) {
                return TWO;
            } else if (this.equals(TWO)) {
                return THREE;
            } else if (this.equals(THREE)) {
                return FOUR;
            } else {
                return ONE;
            }
        }
    }
}

// 열거형 생성자를 이용한 enum 상수 초기화
enum Family {
    FATHER("아버지"), MOTHER("어머니"), SON("아들"), DAUGHTER("딸"); // 열거형 상수(객체)
    private String koreanWord; // 멤버변수 (객체에 속하는 변수)

    // private은 생략 가능, public 불가능
    private Family(String koreanWord) {
        this.koreanWord = koreanWord;
    }

    public String getKoreanWord() {
        return koreanWord;
    }

    public void setKoreanWord (String koreanWord) {
        this.koreanWord = koreanWord;
    }
}
public class Enumeration {
    public static void main(String[] args) {
        Job job = Job.STUDENT; // 클래스 변수와 유사하게 사용

        if(job == Job.CEO) {
            System.out.println("Good morning, President");
        }

        char c = 'A';
        switch (c) {
            case 'A' :
                break;
            case 'B' :
                break;
            default:
        }

        switch (job) { // switch case문에는 열거형 자료형을 생략한다.
            case STUDENT:
                System.out.println("You will become a great one.");
                break;
            case MARKETING:
                System.out.println("Sell the product.");
                break;
            case DEVELOPER:
                System.out.println("Make things working.");
                break;
            case CEO:
                System.out.println("You choose");
                break;
            default:
                System.out.println("Who are you?");
        }

        System.out.println(Foo.Symbol.ONE);

        // 열거형 메소드
        Foo.Symbol sym = Foo.Symbol.ONE; // 열거형 상수는 객체이다.
        Foo.Symbol nextSym = sym.nextSymbol();
        System.out.println(nextSym); // TWO
        nextSym = nextSym.nextSymbol();
        System.out.println(nextSym); // THREE

        // 열거형 생성자와 멤버 변수 활용
        Family fam = Family.SON;
        System.out.println(fam.getKoreanWord()); // 아들
        fam.setKoreanWord("버린 자식");
        System.out.println(fam.getKoreanWord()); // 버린 자식
        System.out.println(Family.SON.getKoreanWord()); // 버린 자식 
    }
}
