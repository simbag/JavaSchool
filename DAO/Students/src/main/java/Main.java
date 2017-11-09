import dao.h2.StudentH2DaoService;
import domain.Student;
import exceptions.DaoException;

public class Main {
    public static void main(String[] args) throws DaoException {

        StudentH2DaoService studentH2DaoService = new StudentH2DaoService();
        Student student = studentH2DaoService.getStudentById(1);
        System.out.println(student);
    }
}
