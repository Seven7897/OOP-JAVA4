package WaveAlgorithmApp;

import java.util.ArrayList;

public class PathFinder {
    private MapBuilder map;
    private MapPoint exitPoint;
    private ArrayList<MapPoint> resultPath;
    private int[][] routeRule = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public PathFinder(MapBuilder map, MapPoint exitPoint) {
        this.map = map;
        this.exitPoint = exitPoint;
    }

    public void findShortestPath() {
        this.resultPath = new ArrayList<>();
        resultPath.add(exitPoint);
        int rowNumber = map.getRowNumber();
        int colNumber = map.getColNumber();

        MapPoint currentPoint = new MapPoint(exitPoint.getX(), exitPoint.getY(), exitPoint.getPointValue());
        MapPoint prevPoint = new MapPoint();

        while (currentPoint.getPointValue() != 1) {

            for (int[] step : routeRule) {
                prevPoint.setX(currentPoint.getX() + step[0]);
                prevPoint.setY(currentPoint.getY() + step[1]);
                if (prevPoint.getX() >= 0 && prevPoint.getY() >= 0 && prevPoint.getX() < rowNumber && prevPoint.getY() < colNumber) {
                    prevPoint.setPointValue(map.getValue(prevPoint));

                    if (prevPoint.getPointValue() == currentPoint.getPointValue() - 1) {
                        resultPath.add(new MapPoint(prevPoint.getX(), prevPoint.getY(), prevPoint.getPointValue()));
                        break;
                    }
                }


            }
            currentPoint.setX(prevPoint.getX());
            currentPoint.setY(prevPoint.getY());
            currentPoint.setPointValue(prevPoint.getPointValue());
        }

    }

    public ArrayList<MapPoint> getPath() {
        return resultPath;
    }
}
