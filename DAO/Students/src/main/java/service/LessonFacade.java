package service;

import dao.h2.LessonH2DaoService;
import domain.Lesson;
import exceptions.DaoException;

public class LessonFacade {

    public Lesson getLessonById(int id) throws DaoException {
        LessonH2DaoService lessonH2DaoService = new LessonH2DaoService();
        Lesson lesson = lessonH2DaoService.getLessonById(id);
        return lesson;
    }
}
