package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayStatsTest {
    @Test
    void testMinMaxAverageMedianOdd() {
        int[] arr = {3, 1, 4, 1, 5};
        assertEquals(1, ArrayStats.min(arr));
        assertEquals(5, ArrayStats.max(arr));
        assertEquals((3+1+4+1+5)/5.0, ArrayStats.average(arr));
        assertEquals(3.0, ArrayStats.median(arr));
    }

    @Test
    void testMedianEven() {
        int[] arr = {4, 1, 2, 3};
        assertEquals(2.5, ArrayStats.median(arr));
    }

    @Test
    void testSingleElement() {
        int[] arr = {7};
        assertEquals(7, ArrayStats.min(arr));
        assertEquals(7, ArrayStats.max(arr));
        assertEquals(7.0, ArrayStats.average(arr));
        assertEquals(7.0, ArrayStats.median(arr));
    }

    @Test
    void testNullOrEmptyThrows() {
        assertThrows(IllegalArgumentException.class, () -> ArrayStats.min(null));
        assertThrows(IllegalArgumentException.class, () -> ArrayStats.min(new int[]{}));
    }
}
