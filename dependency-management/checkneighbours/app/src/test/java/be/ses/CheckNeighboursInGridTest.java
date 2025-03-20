package be.ses;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

public class CheckNeighboursInGridTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBounds() {
        // Arrange: Maak een eenvoudige grid
        List<Integer> grid = Arrays.asList(
            0, 1,
            2, 3
        );

        // Act & Assert
        CheckNeighboursInGrid.getSameNeighboursIds(grid, 2, 2, 4);
    }

    @Test
    public void testLinkerRand() {
        // Arrange
        List<Integer> grid = Arrays.asList(
            1, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, 4, 4, 4);

        // Assert
        assertEquals(Arrays.asList(0,5), result);
    }

    @Test
    public void testLinksBoven() {
        // Arrange
        List<Integer> grid = Arrays.asList(
            1, 1, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, 4, 4, 0);

        // Assert
        assertEquals(Arrays.asList(1, 4, 5), result);
    }

    @Test
    public void testGeenNeighbours() {
        // Arrange
        List<Integer> grid = Arrays.asList(
            0, 1, 2, 3,
            4, 5, 6, 7,
            8, 9, 10, 11,
            12, 13, 14, 15
        );

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, 4, 4, 5);

        // Assert
        assertTrue(((List<Integer>) result).isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidGridSize() {
        List<Integer> grid = Arrays.asList(0, 1, 2); // 3 elementen, maar verwacht 2x2 

        CheckNeighboursInGrid.getSameNeighboursIds(grid, 2, 2, 1);
    }


    @Test
    public void test1ElementGridBuren() {
        // Arrange
        List<Integer> grid = Arrays.asList(1);

        // Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, 1, 1, 0);

        // Assert
        assertTrue(((List<Integer>) result).isEmpty());
    }
}
