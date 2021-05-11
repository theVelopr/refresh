package ch05.s13;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Stream API
 * - Java 8에 추가된 java.util.stream 패키지
 * - 컬랙션 요소를 람다식으로 처리할 수 있도록 돕는 함수형 프로그래밍 도구
 *  - 간결한 코드로 작성할 수 있다.
 *  - 데이터 소스에 대한 공통된 접근 방식을 제공한다.
 *      - stream으로 변경해주고나면, List, Set, Map 모두 동일한 방식으로 데이터를 처리
 */
public class Main {
    public static void main(String[] args) {
        // Java 7
        List<String> list = Arrays.asList("fast", "campus", "rocks");
        List<String> newList = new ArrayList<>();

        for (String s: list) {
            newList.add(s.toUpperCase());
        }

        for (String s: newList) {
            System.out.println(s); // FAST \n CAMPUS \n ROCKS \n
        }
        System.out.println();

        // JAVA 8 - Stream API (훨씬  더 간결한 코드로 작성
        List<String> list1 = Arrays.asList("fast", "campus", "rocks");
        Stream<String> stream = list1.stream();
        stream.map(String::toUpperCase)
                .forEach(System.out::println); // FAST \n CAMPUS \n ROCKS \n

        // Stream 생성방식 #01
        // 컬랙션의 인스턴스 메소드
        Stream<String> stream1 = list1.stream();

        // Stream 생성방식 #02
        int[] ints = { 4, 6, 2, 19, 2, 58, 4, 6, 5};

        // Arrays 클래스의 클래스 메소드 Stream
        // LongStream, DoubleStream도 있음.
        IntStream intStream = Arrays.stream(ints);

        // Stream 생성방식 #03
        // Stream 클래스의 클래스 메소드 of
        DoubleStream doubleStream = DoubleStream.of(0.4, 0.6, 0.2, 1.2, 0.94);

        // Range를 이용한 Stream
        // -> for 문을 대체하는 스트림 작성을 위해 필요
        IntStream intStream1 = IntStream.range(0, 10); // 10은 포함 x
        intStream1.forEach(System.out::println); // 0\n 1\n ... 9\n (v)
        IntStream intStream2 = IntStream.rangeClosed(0, 10); // 10포함
        intStream2.forEach(System.out::println); // 0\n 1\n ... 10\n (v)

        // Random 객체를 이용한 스트림
        Random random = new Random();
        // 개수 지정을 안해주면 제한 없이 무한히 출력 (v)
        //LongStream longStream = random.longs();
        //longStream.forEach(System.out::println);

        // 개수 제한 가능
        LongStream longStream1 = random.longs(100);
        longStream1.forEach(System.out::println); //(v)

        // 개수 제한 + 범위 제한 가능
        LongStream longStream2= random.longs(100, 0, 1000);
        longStream2.forEach(System.out::println); // (v)
        System.out.println();

        Stream<String> stringStream = Stream.of("Java", "Is", "Fun", "isn't", "it", "?", "Java", "Java");

        // 중간처리 메소드 - 스트림을 반환
        // 필터링 메소드
        // distinct() : 스트림에 같은 요소가 있을 경우 하나만 남기고 삭제하는 메소드
        stringStream.distinct().forEach(System.out::println); // 뒤에 Java 단어 중복을 없애고 나머지 출력해줌 (v)
        System.out.println();

        // filter() : Predicate 계열을 입력으로 받아, true인 요소만 남긴다.
        stringStream = Stream.of("Java", "is", "fun", "isn't", "it", "?");
        stringStream.filter(s -> s.length() >= 3)
                .forEach(System.out::println); // Java\n fun \n isn't\n (v)
        System.out.println();
        // 자르기 (cutting)
        // skip(long n): 스트림의 최초 n개를 생략하는 메소드
        // limit(long maxSize) : 스트림의 최대 요소 개수를 maxSize로 제한

        // 정렬 (Sorting)
        // Comaprable 인터페이스의 compareTo 메소드로 정렬
        stringStream = Stream.of("abc", "fwf", "twtie", "dnmov", "work");
        stringStream.sorted().forEach(System.out::println); // 알파벳 순서로 정렬해서 출력력. (v)
        System.out.println();
        // Comparator 인터페이스를 람다식으로 구현하여 정렬
        stringStream = Stream.of("abc", "fwf", "twtie", "dnmov", "work");
        stringStream.sorted((o1, o2) -> o1.length() - o2.length())
        .forEach(System.out::println);
        /**
         * abc
         * fwf
         * work
         * twtie
         * dnmov (???)
         */
        System.out.println();

        // 매핑(Mapping) 입력 1:1 출력
        // Function 계열의 인터페이스를 사용하여 스트림의 각 요소를 매핑
        stringStream = Stream.of("abc", "fwf", "twtie", "dnmov", "work");
        // Function 계열로 String -> Integer로 변환하는 매핑 (Function<String, Integer>)
        Stream<Integer> stream2 = stringStream.map(s -> s.length());
        stream2.forEach(System.out::println); // 3 3 5 5 4 (v)
        System.out.println();
        //PStream (기본형 타입의 스트림)은  Operator 계열로 처리 (자료형 변환x)
        IntStream intStream3 = IntStream.of(5, 2, 30, 8, 0, 2, -34);
        IntStream intStream4 = intStream3.map(value -> value * 10);
        intStream4.forEach(System.out::println);
        /**
         * 50
         * 20
         * 300
         * 80
         * 0
         * 20
         * -340 (v)
         */
        System.out.println();

        // flatMap 계열 매핑 입력 1:n 출력 (스트림 형태로 출력)
        // s.split("") : "java" -> { "j", "a", "v", "a" }
        List<String> list2 = Arrays.asList("java", "backend", "best", "course");
        list2.stream().flatMap(s -> {
            return Arrays.stream(s.split(""));
        }).forEach(System.out::println); // 한 문자씩 떼어내서 출력함.(v)

        //todo 조회
    }
}
