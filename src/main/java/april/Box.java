package april;

public class Box {
    public int id;
    public double filled;
    public String name;
    public int seq;



    public Box(int id, String name, double filled, int seq) {
        this.id = id;
        this.name = name;
        this.filled = filled;
        this.seq = seq;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public double getPercentageMatch() {
        return filled;
    }

    public void setFilled(double filled) {
        this.filled = filled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}