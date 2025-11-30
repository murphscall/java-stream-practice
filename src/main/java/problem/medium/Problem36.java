package problem.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Problem36 {

    /**
     * 주어진 정수 리스트에서 연속된 3개의 숫자가 모두 짝수인 첫 번째 연속 부분을 찾습니다.
     * 만약 해당하는 부분이 없다면 빈 리스트를 반환합니다.
     *
     * @param numbers 정수 리스트
     * @return 연속된 3개의 숫자가 모두 짝수인 첫 번째 부분의 리스트
     */
    public static List<Integer> findFirstTripleEvenSequence(List<Integer> numbers) {
        // 여기에 코드 작성
        return IntStream.range(0 , numbers.size() - 2)
                .filter(i -> {
                    int first = numbers.get(i);
                    int second = numbers.get(i + 1);
                    int third = numbers.get(i + 2);
                    return first % 2 == 0 && second % 2 == 0 && third % 2 == 0;
                })
                .mapToObj(i -> Arrays.asList(
                        numbers.get(i),
                        numbers.get(i+1),
                        numbers.get(i+2)
                ))
                .findFirst()
                .orElse(Collections.emptyList());
    }
}
