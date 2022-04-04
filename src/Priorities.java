import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }
}

class Priorities {

    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    private List<Student> myStudentList = new ArrayList<>();

    public void addStudentToList(Student newStudent) {
        if (myStudentList.isEmpty()) {
            myStudentList.add(newStudent);
            return;
        }
        for (int i = 0; i < myStudentList.size(); i++) {
            if (newStudent.getCgpa() > myStudentList.get(i).getCgpa()) {
                myStudentList.add(i, newStudent);
                return;
            }
            if (newStudent.getCgpa() == myStudentList.get(i).getCgpa() && newStudent.getName().compareTo(myStudentList.get(i).getName()) < 0) {
                myStudentList.add(i, newStudent);
                return;
            }
            if (newStudent.getCgpa() == myStudentList.get(i).getCgpa() && newStudent.getName().compareTo(myStudentList.get(i).getName()) == 0 && newStudent.getId() < myStudentList.get(i).getId()) {
                myStudentList.add(i, newStudent);
                return;
            }
        }
        myStudentList.add(newStudent);
    }

    public void removeStudentFromList() {
        if (myStudentList.size() > 0)
            myStudentList.remove(0);
    }

    public List<Student> getStudents(List<String> events) {
        String[] result;
        for (String event : events) {
            result = event.split(" ");
            if (result.length > 1) {
                this.addStudentToList(new Student(Integer.parseInt(result[3]), result[1], Double.parseDouble(result[2])));
            } else {
                this.removeStudentFromList();
            }
        }
        return this.myStudentList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("/home/janayna/Documents/teste.txt"));
        int totalEvents = Integer.parseInt(br.readLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = br.readLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
