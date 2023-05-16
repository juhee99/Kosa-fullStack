package exam2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudyApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean2.xml");
        Student [] st = new Student[3];

        for (int i = 0 ; i<st.length ;i++){
            st[i] = (Student)context.getBean("st"+(i+1));
        }
        for (Student s: st) {
            System.out.println(s.getName()+"는 "+s.getMyHomework().getHomeworkName()+"를 학습합니다.");
        }

        ((ClassPathXmlApplicationContext)context).close();
    }
}
