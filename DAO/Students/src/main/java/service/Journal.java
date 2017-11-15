package service;

import dao.StudentVisitDaoService;
import dao.h2.StudentH2DaoService;
import dao.h2.StudentVisitH2DaoService;
import domain.Lesson;
import domain.Student;
import domain.StudentVisit;
import exceptions.DaoException;

import java.util.List;

public class Journal {

    public static void printJournal() throws DaoException{
        StudentVisitH2DaoService studentVisitH2DaoService = new StudentVisitH2DaoService();
        List<StudentVisit> visits = studentVisitH2DaoService.getAllVisits();

        StudentFacade studentFacade = new StudentFacade();
        LessonFacade lessonFacade = new LessonFacade();

        for (StudentVisit visit : visits) {
            Student student = studentFacade.getStudentById(visit.getStudentId());
            Lesson lesson = lessonFacade.getLessonById(visit.getLessonId());
            System.out.println(student.getFirstName() + " " + student.getLastName() + " | " + lesson.getName() + " | " + lesson.getDate());
        }
    }
}
