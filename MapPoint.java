package WaveAlgorithmApp;

public class MapPoint {
    private int x;
    private int y;
    private int pointValue;

    public MapPoint(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.pointValue = value;
    }

    public MapPoint(int x, int y) {
        this(x, y, 0);
    }

    public MapPoint(int x) {
        this(x, x);
    }

    public MapPoint() {
        this(0);
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int value) {
        this.x = value;
    }

    public void setY(int value) {
        this.y = value;
    }

    public void setPointValue(int value) {
        this.pointValue = value;
    }

    public int getPointValue() {
        return pointValue;
    }

    @Override
    public String toString() {
        return "Point(" + x + ", " + y + "), value: " + pointValue;
    }
}
