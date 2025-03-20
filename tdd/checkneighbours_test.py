import unittest
from tdd.checkneighbours import get_same_neighbours_ids


class TestFunctions(unittest.TestCase):
    def testIndexOutOfBounds(self):
        # Arrange
        voorbeeld_grid = [0, 1,
                          2, 3]
        # Act en assert
        with self.assertRaises(IndexError):
            get_same_neighbours_ids(voorbeeld_grid, 2, 2, 4)

    def testLinkerRand(self):
        # Arrange
        voorbeeld_grid = [1, 0, 1, 0,
                        1, 1, 0, 2,
                        2, 0, 1, 3,
                        0, 1, 1, 1]
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 4)
        # Assert
        self.assertEqual(result, [0,5])

    def testLinksBoven(self):
        # Arrange
        voorbeeld_grid = [1, 1, 1, 0,
                        1, 1, 0, 2,
                        2, 0, 1, 3,
                        0, 1, 1, 1]
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 0)
        # Assert
        self.assertEqual(result, [1,4,5])

    def testGeenNeighbours(self):
        # Arrange
        voorbeeld_grid = [0, 1, 2, 3,
                        4, 5, 6, 7,
                        8, 9, 10, 11,
                        12, 13, 14, 15]
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 5)
        # Assert
        self.assertEqual(result, [])    

    def testInvalidGridSize(self):
        # Arrange
        voorbeeld_grid = [0, 1, 2]  

        # Act & Assert (ValueError)
        with self.assertRaises(ValueError):
            get_same_neighbours_ids(voorbeeld_grid, 2, 2, 0)

    def test1ElementGridBuren(self):
        # Arrange
        voorbeeld_grid = [1]  

        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 1, 1, 0)
        # Assert
        self.assertEqual(result, [])
if __name__ == '__main__':
    unittest.main()