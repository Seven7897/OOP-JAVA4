package WaveAlgorithmApp;

import java.util.Arrays;
import java.util.Random;

public class MapBuilder {

    private int[][] map;

    public MapBuilder(int rows, int columns) {
        this.map = new int[rows][columns];
    }

    public MapBuilder(int size) {
        this(size, size);
    }

    public MapBuilder() {
        this(1, 1);
    }

    public int getValue(MapPoint point) {
        return map[point.getX()][point.getY()];
    }

    public int getRowNumber() {
        return map.length;
    }

    public int getColNumber() {
        return map[0].length;
    }

    public void setValue(MapPoint point, int value) {
        map[point.getX()][point.getY()] = value;
    }

    public void addObstacles(int obsNumber) {
        if (obsNumber < (this.map.length + this.map[0].length) / 2 + 1) {
            int rowIndex;
            int columnIndex;
            Random rnd = new Random();
            while (obsNumber > 0) {
                rowIndex = rnd.nextInt(this.map.length);
                columnIndex = rnd.nextInt(this.map[0].length);
                if (this.map[rowIndex][columnIndex] == 0) {
                    this.map[rowIndex][columnIndex] = -1;
                    obsNumber -= 1;
                } else {
                    continue;
                }
            }
        } else {
            System.out.println("Задайте меньше препятствий!");
        }
    }

    public void setObstacle(int row, int column) {
        if (row < this.map.length && column < this.map[0].length) {
            this.map[row][column] = -1;
        } else {
            System.out.println("Клетки [" + row + "][" + column + "] на поле нет!");
        }
    }

    public void print() {
        for (int[] row : map) {
            System.out.println(Arrays.toString(row));
        }
    }
}
