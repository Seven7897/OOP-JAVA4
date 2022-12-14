package WaveAlgorithmApp;

public class Main {
    public static void main(String[] args) {
        MapBuilder map1 = new MapBuilder(6);

        map1.setObstacle(1, 1);
        map1.setObstacle(2, 1);
        map1.setObstacle(3, 1);
        map1.setObstacle(1, 2);
        map1.setObstacle(2, 4);
        map1.setObstacle(3, 4);

        map1.print();
        System.out.println();

        MapPoint startPoint = new MapPoint(0, 0, 1);
        MapPoint exitPoint = new MapPoint(5, 3);

        new WaveAlgorithm(map1, startPoint);
        map1.print();
        System.out.println();

        exitPoint.setPointValue(map1.getValue(exitPoint));

        PathFinder path1 = new PathFinder(map1, exitPoint);
        path1.findShortestPath();
        for (MapPoint point : path1.getPath()) {
            System.out.println(point.toString());
        }
    }
}
