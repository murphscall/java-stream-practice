package problem.extreme;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import problem.extreme.resources.Department;
import problem.extreme.resources.Project;

public class Problem97 {

    /**
     * 주어진 부서 리스트에서 각 부서별로 직원들이 참여한 프로젝트의 총 기간을 계산합니다.
     *
     * @param departments 부서 리스트
     * @return 부서별 직원들이 참여한 프로젝트의 총 기간
     */
    public static Map<String, Long> calculateTotalProjectDurationByDepartment(List<Department> departments) {
        // 여기에 코드 작성
        return departments.stream().collect(Collectors.toMap(
           Department::getName,
           department -> department.getEmployees().stream()
                   .flatMap(employee -> employee.getProjects().stream())
                   .mapToLong(Project::getProjectDuration)
                   .sum()
        ));
    }
}
