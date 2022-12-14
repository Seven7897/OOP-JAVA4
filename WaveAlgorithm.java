package WaveAlgorithmApp;

import java.util.ArrayDeque;
import java.util.Queue;

public class WaveAlgorithm {
    private MapBuilder map;
    private Queue<MapPoint> queue;
    private MapPoint startPoint;
    private int[][] routeRule = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public WaveAlgorithm(MapBuilder map, MapPoint startPoint) {
        this.map = map;
        this.startPoint = startPoint;
        this.start();
    }

    public void start() {
        this.queue = new ArrayDeque<>();
        MapPoint currentPoint;
        MapPoint newPoint;
        int rowNumber = this.map.getRowNumber();
        int colNumber = this.map.getColNumber();

        this.queue.add(startPoint);
        this.map.setValue(startPoint, startPoint.getPointValue());

        while (!this.queue.isEmpty()) {
            currentPoint = this.queue.poll();
            for (int[] step : this.routeRule) {
                newPoint = new MapPoint(currentPoint.getX() + step[0], currentPoint.getY() + step[1], currentPoint.getPointValue() + 1);

                if (newPoint.getX() >= 0 && newPoint.getY() >= 0 && newPoint.getX() < rowNumber && newPoint.getY() < colNumber && this.map.getValue(newPoint) == 0) {
                    this.map.setValue(newPoint, newPoint.getPointValue());
                    this.queue.add(new MapPoint(newPoint.getX(), newPoint.getY(), newPoint.getPointValue()));
                }
            }
        }
    }
}
