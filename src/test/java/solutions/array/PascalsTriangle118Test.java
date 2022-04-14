package solutions.array;

import org.junit.Test;

import solutions.array.PascalsTriangle118;

import static org.junit.Assert.*;

public class PascalsTriangle118Test {

    @Test
    public void generate() {
        PascalsTriangle118 testInstance = new PascalsTriangle118();
        System.out.println(testInstance.generate(6));
    }
}