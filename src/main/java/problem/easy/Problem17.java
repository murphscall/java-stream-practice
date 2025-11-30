package problem.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Problem17 {

    /**
     * 스트림을 사용하여 문자열 배열에서 HashMap을 생성합니다.
     * 배열의 각 요소를 key로 하고, 해당 요소의 길이를 value로 하는 HashMap을 반환합니다.
     *
     * @param strings 문자열 배열
     * @return 생성된 HashMap
     */
    public static Map<String, Integer> createHashMapFromStream(String[] strings) {
        // 여기에 코드 작성
        return Arrays.stream(strings)
                .collect(Collectors.toMap(
                        Function.identity(),  // key: 문자열 그대로
                        String::length,       // value: 문자열 길이
                        (oldValue, newValue) -> oldValue, // 중복 key 발생 시 기존 값 유지
                        HashMap::new        // 실제 구현체를 HashMap으로
                ));
    }
}
