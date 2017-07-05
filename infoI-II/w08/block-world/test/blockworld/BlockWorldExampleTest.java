package blockworld;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BlockWorldExampleTest {

    @Test
    public void testMinimalWorld() {
        List<Block> bs = Collections.singletonList(new Block (0, 0, 1, 'x'));
        BlockWorld w = new BlockWorld(1, 2, bs, '.');
        assertFalse(w.isDead());
        assertArrayEquals(new char[][]{ new char[]{ 'x', '.'}}, w.observe());
        w.step();
        assertTrue(w.isDead());
        assertArrayEquals(new char[][]{ new char[]{ '.', 'x'}}, w.observe());
    }

    @Test
    public void test2() {
        List<Block> blocks = new ArrayList<Block>();
        blocks.add(new Block(0, 0, 2, 'x'));
        blocks.add(new Block(1, 0, 1, 'o'));
        BlockWorld w1 = new BlockWorld(2, 3, blocks, '.'); w1.step();
        assertArrayEquals(new char[][]{ new char[] {'.', '.', 'x'}, new char[] {'.', 'o', '.'}}, w1.observe());
        BlockWorld w2 = new BlockWorld(2, 3, blocks, '.');
        assertArrayEquals(new char[][] { new char[] {'x', '.', '.'}, new char[] {'o', '.', '.'}}, w2.observe());
        BlockWorld w3 = new BlockWorld(2, 3, blocks, '.'); w3.step(); assertEquals(false, w3.isDead());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFailingBlockConstruction() {
        new Block(-1, 0, 1, 'x');
    }

}