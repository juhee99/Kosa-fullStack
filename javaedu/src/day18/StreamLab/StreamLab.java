package day18.StreamLab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLab {

	public static void main(String[] args) {
		Trainee[] sa = new Trainee[] { new Trainee("나자바", true, 1, 1, 300), new Trainee("김지미", false, 1, 1, 250),
				new Trainee("김자바", true, 1, 1, 200), new Trainee("이지미", false, 1, 2, 150),
				new Trainee("남자바", true, 1, 2, 100), new Trainee("안지미", false, 1, 2, 50),
				new Trainee("황지미", false, 1, 3, 100), new Trainee("강지미", false, 1, 3, 150),
				new Trainee("이자바", true, 1, 3, 200), new Trainee("나자바", true, 2, 1, 300),
				new Trainee("김지미", false, 2, 1, 250), new Trainee("김자바", true, 2, 1, 200),
				new Trainee("이지미", false, 2, 2, 150), new Trainee("남자바", true, 2, 2, 100),
				new Trainee("안지미", false, 2, 2, 50), new Trainee("황지미", false, 2, 3, 100),
				new Trainee("강지미", false, 2, 3, 150), new Trainee("이자바", true, 2, 3, 200) };

// 모든 문제들은 위의 배열 객체를 가지고 스트림 객체를 만든 다음에 해결한다.
		
		// (1) Trainee 객체들을 화면에 출력한다.
		System.out.println("객체를 출력합니다.");
		Arrays.stream(sa).forEach(s -> {
			System.out.println(s);
		});
		System.out.println();
		
// (2) 성적이 높은 순으로 Trainee 객체들을 화면에 출력한다.
		System.out.println("성적이 높은 순으로 출력합니다.");
		Arrays.stream(sa).sorted((t1, t2) -> t1.getScore() - t2.getScore()).forEach(System.out::println);

// (3) 성적이 200 이상인 Trainee 객체들을 화면에 출력한다.
		System.out.println("성적이 200 이상인 사람을 출력합니다.");
		Arrays.stream(sa).filter(s -> s.getScore() > 200).forEach(System.out::println);

// (4) 성적이 200 이상인 수강생들의 인원을 출력한다.
		long sum = Arrays.stream(sa).filter(s -> s.getScore() > 200).count();
		System.out.println("성적이 200 이상인 수강생들 인원은" + sum + "입니다.");

// (5) 남학생의 Trainee 객체들을 화면에 출력한다.
		System.out.println("남학생을 출력합니다.");
		Arrays.stream(sa).filter(s -> s.isMale()).forEach(s -> System.out.println(s));

// (6) 남학생의 인원을 출력한다.
		System.out.println();
		long maleCnt = Arrays.stream(sa).filter(s -> s.isMale()).count();
		System.out.println("남학생의 인원은" + maleCnt + "입니다.");

// (7) 모든 학생들의 스코어만 출력한다.
		System.out.println("모든 학생들의 스코어를 출력합니다.");
		Arrays.stream(sa).forEach(s -> System.out.print( s.getName()+"학생의 점수는"+s.getScore() + "입니다."));
// (8) 모든 학생들의 스코어 합을 출력한다.
		int scoreSum= Arrays.stream(sa).mapToInt(s -> s.getScore()).sum();
		System.out.println("모든 학생들의 스코어 합은"+scoreSum+"입니다.");
		
	}

}
