 import java.util.ArrayList;
import java.util.List;

public class Title {
    public enum Alignment {CX, RX, LX}
    private Alignment alignment;
    private List<Line> lines;

    public Title(Alignment a) { this(a, new ArrayList<>()); }
    public Title(Alignment a, List<Line> lines) {
        alignment = a;
        this.lines = lines;
    }
    public void add(Line l) { lines.add(l); }
    public boolean isCentered() { return alignment == Alignment.CX; }
    @Override
    public String toString() { return lines.toString(); }
    public Alignment getAlignment() { return alignment; }
    public List<Line> getLines() { return new ArrayList<>(lines); }

    static public class Line {
        private String line;
        private int number;
        public Line(String line, int number) {
            this.line = line;
            this.number = number;
        }
        public Line(String line) { this(line, -1); }
        @Override
        public String toString() { return (number == -1) ? "" : number + ": " + line;}
    }
}
