package problem.extreme;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Problem91 {

    /**
     * 주어진 정수 리스트에서 연속된 숫자들의 그룹의 합이 특정 조건을 만족하는 첫 번째 경우를 찾습니다.
     * 연속된 숫자들의 그룹의 합이 정확히 100이 되는 첫 번째 경우를 반환합니다.
     * 예를 들어, 리스트 [10, 20, 30, 40, 50, 60]에서는 [20, 30, 50]이 조건을 만족합니다.
     *
     * @param numbers 정수 리스트
     * @return 연속된 숫자들의 그룹 중 합이 100이 되는 첫 번째 그룹. 없으면 빈 Optional 반환.
     */
    public static Optional<List<Integer>> findFirstSublistSummingTo100(List<Integer> numbers) {
        // 여기에 코드 작성
        int n = numbers.size();

        return IntStream.range(0, n)                    // start: 0..n-1
                .boxed()                                // Stream<Integer>
                .flatMap(start ->
                        IntStream.range(start + 1, n + 1)
                                .mapToObj(end -> numbers.subList(start, end)) // Stream<List<Integer>>
                )                                       // 전체: Stream<List<Integer>>
                .filter(subList ->
                        subList.stream()
                                .mapToInt(Integer::intValue)
                                .sum() == 100
                )
                .findFirst();
    }
}
