package sg.edu.rp.c346.id22014114.enrolment;

public class SingaporePolytechnic {

    private int year;
    private String type;
    private int enrollment_count;

    public SingaporePolytechnic(int year, String type, int enrollment_count){
        this.year = year;
        this.type = type;
        this.enrollment_count = enrollment_count;
    }

    public int getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    public int getEnrollment_count() {
        return enrollment_count;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEnrollment_count(int enrollment_count) {
        this.enrollment_count = enrollment_count;
    }

    @Override
    public String toString() {
        String msg = "Year: " + year + "\n" + "Type of Study: " + type + "\n" + "Enrolment(count): " + enrollment_count;
        return msg;
    }
}
