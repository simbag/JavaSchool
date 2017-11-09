package domain;

public class StudentVisit {
    Integer id;
    Integer StudentId;
    Integer LessonId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return StudentId;
    }

    public void setStudentId(Integer studentId) {
        StudentId = studentId;
    }

    public Integer getLessonId() {
        return LessonId;
    }

    public void setLessonId(Integer lessonId) {
        LessonId = lessonId;
    }
}
