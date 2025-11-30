package problem.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem16 {

    /**
     * 스트림을 사용하여 주어진 정수 배열에서 HashSet을 생성합니다.
     *
     * @param numbers 정수 배열
     * @return 생성된 HashSet
     */
    public static Set<Integer> createHashSetFromStream(int[] numbers) {
        // 여기에 코드 작성
        return Arrays.stream(numbers).boxed().collect(Collectors.toCollection(HashSet::new));
    }
}