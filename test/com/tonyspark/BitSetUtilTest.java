package com.tonyspark;

import org.junit.jupiter.api.Test;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

class BitSetUtilTest
{
    @Test
    void toBitSetOneFirst() {
        BitSet expected = new BitSet(4);
        expected.set(0, true);
        expected.set(2, true);

        assertEquals(expected, BitSetUtil.toBitSet(1, 0, 1, 0));
        assertNotEquals(expected, BitSetUtil.toBitSet(0, 0, 0, 0));
    }

    @Test
    void toBitSetZeroFirst() {
        BitSet expected = new BitSet(4);
        expected.set(1, true);
        expected.set(3, true);

        assertEquals(expected, BitSetUtil.toBitSet(0, 1, 0, 1));
        assertNotEquals(expected, BitSetUtil.toBitSet(0, 0, 0, 0));
    }
}