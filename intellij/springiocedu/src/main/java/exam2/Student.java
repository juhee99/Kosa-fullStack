package exam2;

public class Student {
    private String name;
    private Homework myHomework;

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMyHomework(Homework myHomework) {
        this.myHomework = myHomework;
    }

    public Homework getMyHomework() {
        return myHomework;
    }
}
