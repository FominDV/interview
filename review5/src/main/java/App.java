import dao.StudentDao;
import entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    public static void main(String[] args) {
        App app = new App();
        StudentDao studentDao = new StudentDao();
        app.createStudents(studentDao);
        Long id = studentDao.getAll().get(99).getId();
        app.printStudentsCount(studentDao);
        Student student;
        System.out.println(student = studentDao.get(id));
        student.setName("NEW_STUDENT_NAME");
        studentDao.update(student);
        System.out.println(studentDao.get(id));
        studentDao.delete(id + 1);
        studentDao.delete(student);
        Student newStudent = new Student("MARK_O_POLO", 4);
        studentDao.save(newStudent);
        System.out.println(studentDao.get(session -> session.createQuery("from Student where name='MARK_O_POLO'").getSingleResult()).toString());
        app.printStudentsCount(studentDao);
        studentDao.deleteAll();
        app.printStudentsCount(studentDao);
    }

    private void printStudentsCount(StudentDao studentDao) {
        System.out.println("Count of student is " + studentDao.getAll().size());
    }

    private void createStudents(StudentDao studentDao) {
        studentDao.deleteAll();
        List<Student> studentList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            studentList.add(
                    new Student(getRandomUniqueName(random, studentList), random.nextInt(4) + 1)
            );
        }
        studentDao.saveAll(studentList);
    }

    private String getRandomUniqueName(Random random, List<Student> studentList) {
        String newName;
        do {
            char[] chars = new char[random.nextInt(19) + 1];
            for (int i = 0; i < chars.length; i++) {
                chars[i] = (char) (random.nextInt(26) + 'a');
            }
            newName = new String(chars);
        } while (isDuplicateName(newName, studentList));
        return newName;
    }

    private boolean isDuplicateName(String newName, List<Student> studentList) {
        return studentList.stream()
                .anyMatch(student -> student.getName().equals(newName));
    }

}
