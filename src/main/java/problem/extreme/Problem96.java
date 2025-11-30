package problem.extreme;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import problem.extreme.resources.Employee;
import problem.extreme.resources.Project;

public class Problem96 {

    /**
     * 주어진 프로젝트 리스트와 직원 리스트를 사용하여, 각 프로젝트에 참여한 직원들의
     * 평균, 최대, 최소 근무 경력을 계산합니다.
     * 결과는 프로젝트 이름을 키로, 평균/최대/최소 근무 경력을 값으로 하는 Map으로 반환합니다.
     *
     * @param projects 프로젝트 리스트
     * @param employees 직원 리스트
     * @return 프로젝트별 근무 경력 통계
     */
    public static Map<String, Map<String, Double>> calculateEmployeeExperienceStatsByProject(List<Project> projects, List<Employee> employees) {
        // 여기에 코드 작성
        return projects.stream().collect(Collectors.toMap(
           Project::getTitle,
           project -> {
               LocalDate projectEndDate = project.getEndDate();

               DoubleSummaryStatistics stats = employees.stream()
                       .filter(employee -> employee.getProjects().stream()
                               .anyMatch(p -> p.getTitle().equals(project.getTitle())))
                       .mapToDouble(employee -> {
                           // 입사일부터 프로젝트 종료일까지의 연 단위 경력
                           long days = ChronoUnit.DAYS.between(
                                   employee.getJoiningDate(),
                                   projectEndDate
                           );
                           return days / 365.25;
                       })
                       .summaryStatistics();

               Map<String, Double> experienceStats = new HashMap<>();
               experienceStats.put("average", stats.getAverage());
               experienceStats.put("max", stats.getMax());
               experienceStats.put("min", stats.getMin());

               return experienceStats;
           }
        ));

    }
}
