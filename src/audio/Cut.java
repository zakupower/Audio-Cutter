package audio;

/**
 * Created by Tomov on 25.6.2018 г..
 */
public class Cut {
    private String name;
    private double from,to;

    public Cut(String name, double from, double to) {
        this.name = name;
        this.from = from;
        this.to = to;
    }

    public String getName() {
        return name;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }
}
