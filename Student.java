package StudentInformationSystem;

public class Student {
    private int Studentid;
    private String Name;
    private int Age;
    private int Gender;
    private float StudyTime;
    private int Absences;
    private int Tutoring;
    private int Extracurricular;
    private int Sports;
    private int Music;
    private int Volunteering;
    private float GPA;

    public Student(int studentid,String name, int age, int gender, float studyTime, int absences, int tutoring, int extracurricular, int sports, int music, int volunteering, float GPA) {
        this.Studentid = studentid;
        this.Name=name;
        this.Age = age;
        this.Gender = gender;
        StudyTime = studyTime;
        Absences = absences;
        Tutoring = tutoring;
        Extracurricular = extracurricular;
        Sports = sports;
        Music = music;
        Volunteering = volunteering;
        this.GPA = GPA;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStudentid() {
        return Studentid;
    }

    public void setStudentid(int studentid) {
        Studentid = studentid;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }


    public float getStudyTime() {
        return StudyTime;
    }

    public void setStudyTime(float studyTime) {
        StudyTime = studyTime;
    }

    public int getAbsences() {
        return Absences;
    }

    public void setAbsences(int absences) {
        Absences = absences;
    }

    public int getTutoring() {
        return Tutoring;
    }

    public void setTutoring(int tutoring) {
        Tutoring = tutoring;
    }

    public int getExtracurricular() {
        return Extracurricular;
    }

    public void setExtracurricular(int extracurricular) {
        Extracurricular = extracurricular;
    }

    public int getSports() {
        return Sports;
    }

    public void setSports(int sports) {
        Sports = sports;
    }

    public int getMusic() {
        return Music;
    }

    public void setMusic(int music) {
        Music = music;
    }

    public int getVolunteering() {
        return Volunteering;
    }

    public void setVolunteering(int volunteering) {
        Volunteering = volunteering;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

}
