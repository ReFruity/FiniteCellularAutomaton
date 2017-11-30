package com.tonyspark;

import java.util.BitSet;

public class BitSetUtil
{
    public static BitSet toBitSet(int... intArray) {
        int intArrayLength = intArray.length;

        BitSet result = new BitSet(intArrayLength);

        for (int i = 0; i < intArrayLength; i++) {
            if (intArray[i] == 1) {
                result.set(i, true);
            }
        }

        return result;
    }

}
