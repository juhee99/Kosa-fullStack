package day16.mvclab.view;

import java.util.Scanner;

import day16.mvclab.controller.StudentController;

public class StudentApp {

	public static void main(String[] args) {
		StudentController stController = new StudentController();

		Scanner sc = new Scanner(System.in);
		int option = 0, score = 0;
		String name = "";
	Loop1: 	while (true) {
			try {
				System.out.println("==========[메뉴]=========");
				System.out.println("처리하려는 기능을 선책하세요.");
				System.out.println("1. 학생 정보 출력");
				System.out.println("2. 학생 정보 입력");
				System.out.println("3. 학생 정보 삭제");
				System.out.println("4. 학생 정보 수정");
				System.out.println("5. 학생 정보 확인");
				System.out.println("6. 종료");
				System.out.print("입력 : ");
				option = Integer.parseInt(sc.nextLine());
				

				if (option > 6 || option < 1) {
					System.out.println("옵션을 다시 선택해 주세요.");
					continue;
				}  else {
					switch (option) {
					case 6 : 
						System.out.println("학생정보 시스템을 종료합니다.");
						break Loop1;
					case 1:
						stController.printAll();
						break;
					case 2:
						System.out.print("추가 하려는 학생의 이름을 입력하세요 : ");
						name = sc.nextLine();
						System.out.print("추가 하려는 학생의 점수를 입력하세요 : ");
						score = Integer.parseInt(sc.nextLine());
						stController.insert(name, score);
						break;
					case 3 :
						System.out.print("삭제 하려는 학생의 이름을 입력하세요 : ");
						name = sc.nextLine();
						stController.delete(name);
						break;
					case 4 :
						System.out.print("수정 할 학생의 이름을 입력하세요. : ");
						name = sc.nextLine();
						System.out.print("수정 할 학생의 점수를 입력하세요 : ");
						score = Integer.parseInt(sc.nextLine());
						stController.update(name, score);
					case 5 :
						System.out.print("점수를 확인 할 학생의 이름을 입력하세요. : ");
						name = sc.nextLine();
						stController.printScore(name);
					}
					
				}

			} catch (NumberFormatException ne) {
				System.out.println("입력값이 잘못 되었습니다. 다시 입력해 주세요.");
			}
		}
		sc.close();
	}

}
