package service;

import dao.h2.StudentH2DaoService;
import domain.Student;
import exceptions.DaoException;

public class StudentFacade {

    public Student getStudentById(int id) throws DaoException {
        StudentH2DaoService studentH2DaoService = new StudentH2DaoService();
        Student student = studentH2DaoService.getStudentById(id);
        return student;

    }
}
