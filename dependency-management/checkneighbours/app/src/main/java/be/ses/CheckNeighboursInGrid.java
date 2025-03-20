package be.ses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckNeighboursInGrid {
    public static Iterable<Integer> getSameNeighboursIds(Iterable<Integer> grid, int width, int height, int indexToCheck) {
        List<Integer> gridList = new ArrayList<>();
        for (Integer num : grid) {
            gridList.add(num);
        }

        if (indexToCheck < 0 || indexToCheck >= gridList.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + indexToCheck);
        }
        if (width * height != gridList.size()) {
            throw new IllegalArgumentException("Grid size does not match width * height");
        }
        
        List<Integer> result = new ArrayList<>();
        int row = indexToCheck / width;
        int col = indexToCheck % width;
        int valueToCheck = gridList.get(indexToCheck);
     
        int[] rowOffsets = {-1, -1, -1,  0, 0,  1, 1, 1};
        int[] colOffsets = {-1,  0,  1, -1, 1, -1, 0, 1};

        for (int i = 0; i < 8; i++) {
            int newRow = row + rowOffsets[i];
            int newCol = col + colOffsets[i];

            if (newRow >= 0 && newRow < height && newCol >= 0 && newCol < width) {
                int newIndex = newRow * width + newCol;
                if (gridList.get(newIndex) == valueToCheck) {
                    result.add(newIndex);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );

        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, 4, 4, 5);

        System.err.println(result);
    }
}
