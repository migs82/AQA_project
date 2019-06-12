package lesson_2;

public class Student extends Person {
    private int groupnum;
    private int rating;

    public int getGroupNum() {
        return groupnum;
    }

    protected void setGroupNum(int groupnum) {
        this.groupnum = groupnum;
    }

    int getRating() {
        return rating;
    }

    private void setRating(int rating) {
        this.rating = rating;
    }
}
