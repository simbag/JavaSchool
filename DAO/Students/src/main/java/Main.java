import dao.h2.StudentH2DaoService;
import domain.Student;
import exceptions.DaoException;
import service.Journal;

public class Main {
    public static void main(String[] args) throws DaoException {
        Journal.printJournal();
    }
}
