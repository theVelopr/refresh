package ch05.s10;

import java.util.*;

/**
 * Java Collections Framework(JCF)
 * - java.util에 속한 일련의 클래스, 자료구조를 담당
 *  - 자료구조 : 자료의 집합 또는 그 집합의 동작을 정의하는 수학적 모델
 * - 제네릭 클래스로 되어 있어, 다양한 객체를 요소(Element)로 담을 수 있다.
 *  - 요소 : 자료구조를 구성하는 하나하나의 자료
 */

public class Main {
    public static void main(String[] args) {
        // List Interface
        // - Collection 인터페이스 상속
        //  - 순서가 있는 데이터의 집합. 데이터 중복 허용
        //  - 데이터의 순서(Index)가 유일한 데이터의 구분자(identifier)로 사용
        // [1, 4, 2, 5, 6, 2, 1] -> 같은 값은 있으나  index가 다름
        List<String> stringList = new ArrayList<>(); // 가장 많이 쓰이는, 배열 기반의 리스트
        List<String> stringList1 = new LinkedList<>(); // 노드의 연결로 구성된 리스트
        List<String> stringList2 = new Vector<>(); // 멀티스레드 환경에서 안전하게 동작... But 무지 느림(잘 안씀)
        List<String> stringList3 = new Stack<>(); // Stack 자료구조 구현

        // List의 맨 뒤에 자료를 추가한다.
        // List는 맨 뒤에 자료 추가(순차처리)가 가장 빠르다.
        List<Integer> intList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            intList.add(i);
        }
        System.out.println(intList); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println(intList.size()); // 10
        System.out.println();

        List<Integer> intList2 = new LinkedList<>();
        for (int i = 5; i < 10; i++) {
            intList2.add(i);
        }
        System.out.println(intList2); // [5, 6, 7, 8, 9]
        System.out.println();

        // 입력된 Collection 내용 전체를 한번에 add하는 메소드
        // index를 입력받아 위치도 지정 가능
        intList.addAll(1, intList2);
        System.out.println(intList); // [0, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        System.out.println();

        // remove() 메소드는 index에서 obj를 제거하고 그것을 반환
        // 요소가 제거되면, 그 뒤 요소들은 모두 index가 하나씩 앞으로 당겨진다.
        System.out.println("index 9 was: " + intList.remove(9)); // index 9 was: 4
        System.out.println(intList); // [0, 5, 6, 7, 8, 9, 1, 2, 3, 5, 6, 7, 8, 9]
        System.out.println();

        // 배열처럼 index의 값을 value로 대체한다.
        intList.set(1, 100);
        System.out.println(intList); // [0, 100, 6, 7, 8, 9, 1, 2, 3, 5, 6, 7, 8, 9]
        System.out.println();

        // inclusive, exclusive
        List<Integer> list3 = intList.subList(2, 5);
        System.out.println(list3); // [6, 7, 8]
        System.out.println();

        // for를 이용한 접근
        for(int i = 0; i < list3.size(); i++) {
            System.out.println(list3.get(i)); // 6\n 7\n 8\n
        }
        System.out.println();

        // foreach를 이용한 접근
        for(int value: list3) {
            System.out.println(value); // 6\n, 7\n, 8\n
        }
        System.out.println();

        // listIterator 를 이용한 접근 - foreach문은 사실 이것을 짧게 쓴 것이다.
        ListIterator<Integer> iterator = list3.listIterator();
        while(iterator.hasNext()) { // true일때만 다음 요소가 있음
            Integer integer = iterator.next(); // 다음 요소를 반환
            System.out.println(integer);  // 6\n, 7\n, 8\n
        }
        System.out.println();

        // set 인터페이스
        //  - Collection 인터페이스 상속
        //  - 순서가 없는 데이터 (집합)을 다루는 인터페이스
        //  - 중복되는 데이터를 효율적으로 제거하는데에 사용 가능
        //  - hash를 빠르게 계산해서 hash 만 비교
        //  - 그 다음에 판정이 안나면 equals()로 추가 비교

        Set<String> stringSet1 = new HashSet<>(); // 기본적인 집합
        stringSet1.add("A");
        stringSet1.add("B");
        stringSet1.add("B");
        stringSet1.add("F");
        System.out.println(stringSet1); // [A, B, F]
        System.out.println();

        /**
         * List -> 증복되는 것을 제거
         *  이중 for문을 이용해서 모두 비교/삭제 O(n^2)
         * List -> Set으로 한번씩만 옮기면 중복이 제거됨
         *  1중 for문을 이용해서 비교할 필요 없이 알아서 삭제됨 O(n)
         */


        // 이진 탐색 트리
        NavigableSet<String> stringSet2 = new TreeSet<>();

        class Foo {
            int x, y;

            public Foo(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return x + ", " + y;
            }
        }
        NavigableSet<Foo> set = new TreeSet<>(
                Comparator.comparingInt(o -> o.x));
        set.add(new Foo(1, 100));
        set.add(new Foo(4, 50));
        set.add(new Foo(0, 170));
        set.add(new Foo(-2, 3300));

        System.out.println(set.first()); // -2, 3300
        System.out.println(set.last()); // 4, 50
        System.out.println(set.lower(new Foo(1, 500))); // 0, 170
        System.out.println(set.floor(new Foo(1, 500))); // 1, 100
        System.out.println(set.higher(new Foo(2, 500))); // 4, 50
        System.out.println(set.ceiling(new Foo(1, 500))); // 1, 100
        System.out.println();

        // poll -> 셋에서 삭제도 같이 한다.
        System.out.println(set.pollFirst()); // -2, 3300
        System.out.println(set.pollFirst()); // 0, 170
        System.out.println(set.pollFirst()); // 1, 100
        System.out.println(set.pollFirst()); // 4, 50
        System.out.println(set.pollFirst()); // null
        System.out.println();

        /**
         * Map 인터페이스
         *  - Collection 인터페이스를 상속받지 않음.
         *  - Key, Value 쌍으로 구성된 자료의 집합을 다루는 인터페이스
         *      - Map.Entry<K,V>
         *  - Key는 중복될 수 없으며, Value는 중복이 가능
         *      - Key가 identifier 역할을 한다.
         */

        Map<String, Integer> map = new HashMap<>();

        // put은 기존에 동일 Key가 있었으면, 기존 value를 반환, 없었으면 null
        // 동시에 기존값이 없었던 부분에 그 값을 입력함.
        System.out.println(map.put("ABCDE", 5)); // null
        System.out.println(map.put("CDEF", 1023)); // null
        System.out.println(map.put("ABCDE", 1023)); // 5
        System.out.println(map.put("ABCDE", 1023)); // 1023 <- Overwritten
        System.out.println();

        // query(질의) ???
        //todo 질의라니?
        System.out.println(map.get("CDEF")); // 1023
        System.out.println(map.getOrDefault("CDEF", 0)); // 1023
        // Key가 없기에 Default값을 반환.
        System.out.println(map.getOrDefault("ZZZZZ", 0)); // 0
        System.out.println();

        // 이렇게 기존 값이 없을 때 0과 같은 기본 값을 설정하고 싶을떄 편리하게 사용가능
        map.put("ABCDE", map.getOrDefault("ABCDE", 0) + 1);

        // KeySet 사용
        for (String key: map.keySet()) {
            System.out.println(key + ":" + map.get(key));
            /**
             * ABCDE:1024
             * CDEF:1023
             */
        }
        System.out.println();

        // EntrySet 사용
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
            /**
             * ABCDE:1024
             * CDEF:1023
             */
        }
        System.out.println();

        NavigableMap<String, Integer> map2 = new TreeMap<>();
        map2.put("a", 10);
        map2.put("g", 12);
        map2.put("z", 14);
        map2.put("z", 114);
        map2.put("c", 165);

        System.out.println(map2.ceilingKey("b")); // c
        System.out.println(map2.ceilingEntry("b").getValue()); // 165
        System.out.println(map2.pollFirstEntry().getValue()); // 10
        System.out.println(map2.pollFirstEntry().getValue()); //165
        System.out.println(map2.pollFirstEntry().getValue()); // 12
        System.out.println(map2.pollFirstEntry().getValue()); // 114

        System.out.println(map2); // {}
        System.out.println();

        // 번외
        // Vector처럼 옛날 구현 synchronized
        Map<String, Integer> map3 = new Hashtable<>();
        // Hashtable<String, String>을 상속
        Properties prop = new Properties();
        // System의 Property가 이 형식으로 제공됨.
        prop = System.getProperties();

        System.out.println(map3); // {}
        System.out.println(prop); // { properties content }

    }

}
