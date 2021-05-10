package ch05.s07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 정규표현식 (Regular Expression)
 * - 문자열을 다루는 패턴화된 작업을 정의하는 수식
 * - 문자열 매칭, 템플릿 일치 여부 확인, 템플릿 매칭 검색
 * - 정규표현식은 느리기 때문에 남용하면 안된다.
 *     EX) 알고리즘 문제를 푸는데 정규 표현식을 쓰는건 안됨.
 */
public class Main {
    public static void main(String[] args) {
        String regex = "(xyz)+";
        String str = "xyzxy";

        System.out.println(Pattern.matches(regex, str)); // false

        // boundary는 문자열의 시작, 끝, 공백, 문장기호로 구분되는지 여부를 확인함.
        Pattern pattern = Pattern.compile("\\bJava\\b", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(
                "Java is Javac and Java will be Java.");

        // todo 조금 더 이해할 필요가 있음. 머릿속에 안그려짐
        while (matcher.find()) {
            System.out.println(matcher.start() + ", " + matcher.end());
        }
        System.out.println();

        Pattern pattern1 = Pattern.compile(
                "^(?<field>\\w+):(?<name>\\w+)\\.(?<ext>\\w+)$");
        Matcher matcher1 = pattern1.matcher("filename:temp.png");

        matcher1.find();
        // matching된 전체가 출력됨.
        System.out.println(matcher1.group()); // filename:temp.png
        // 매칭된 전체가 출력됨.
        System.out.println(matcher1.group(0)); // filename:temp.png
        // 첫번째 그룹만 출력됨.
        System.out.println(matcher1.group(1)); // filename
        System.out.println(matcher1.group(2)); // temp
        System.out.println(matcher1.group(3)); // png
        System.out.println();

        // named group
        System.out.println(matcher1.group("field")); // filename
        System.out.println(matcher1.group("name")); // temp
        System.out.println(matcher1.group("ext")); // png

    }
}
