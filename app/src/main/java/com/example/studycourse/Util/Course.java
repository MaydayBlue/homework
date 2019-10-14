package com.example.studycourse.Util;

public class Course {
    private int imageId;
    private String courseId;
    private String teacher;
    private String school;
    private String courseDate;
    private String courseDescription;

    public Course(int imageId,String courseId,String teacher,String school){
        super();
        this.imageId=imageId;
        this.courseId=courseId;
        this.teacher=teacher;
        this.school=school;
    }

    public Course(int imageId, String courseId, String teacher, String school,
                  String courseDate, String courseDescription){
        super();
        this.imageId=imageId;
        this.courseId=courseId;
        this.teacher=teacher;
        this.school=school;
        this.courseDate=courseDate;
        this.courseDescription=courseDescription;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getCourseId(){
        return courseId;
    }

    public void setCourseId(String courseId){
        this.courseId=courseId;
    }

    public String getTeacher(){
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSchool(){
        return school;
    }

    public void setSchool(String school){
        this.school=school;
    }

    public String getCourseDate(){
        return courseDate;
    }

    public void setCourseDate(String courseDate){
        this.courseDate=courseDate;
    }

    public String getCourseDescription(){
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription){
        this.courseDescription=courseDescription;
    }
}
