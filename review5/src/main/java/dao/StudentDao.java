package dao;

import entities.Student;
import factory.SessionFactoryFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class StudentDao {

    public Student get(Long id) {
        return get(session -> session.get(Student.class, id));
    }

    public List<Student> getAll() {
        //noinspection unchecked
        return get(session -> session.createQuery("from Student").list());
    }

    public void delete(Long id) {
        delete(get(id));
    }

    public void delete(Student student) {
        update(session -> session.delete(student));
    }

    public void deleteAll() {
        getAll().forEach(this::delete);
    }

    public void save(Student student) {
        update(session -> session.save(student));
    }

    public void saveAll(List<Student> studentList) {
        update(session -> studentList.forEach(this::save));
    }

    public void update(Student student) {
        update(session -> session.update(student));
    }

    public Session getSession() {
        return SessionFactoryFactory.getSessionFactory().openSession();
    }

    public <T> T get(Function<Session, T> function) {
        Session session = getSession();
        T result = function.apply(session);
        session.close();
        return result;
    }

    public void update(Consumer<Session> consumer) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        consumer.accept(session);
        transaction.commit();
        session.close();
    }

}
