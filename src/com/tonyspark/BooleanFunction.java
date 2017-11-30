package com.tonyspark;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class BooleanFunction
{
    private int arity;

    private Set<BitSet> trueArguments = new HashSet<>();

    BooleanFunction(int arity) {
        this.arity = arity;
    }

    public int getArity() {
        return arity;
    }

    public void setTrue(BitSet argument) {
        trueArguments.add(argument);
    }

    public void setTrue(int... intArrayArgument) {
        trueArguments.add(BitSetUtil.toBitSet(intArrayArgument));
    }

    public void setFalse(BitSet argument) {
        trueArguments.remove(argument);
    }

    public void setFalse(int... intArrayArgument) {
        trueArguments.remove(BitSetUtil.toBitSet(intArrayArgument));
    }

    public boolean call(BitSet argument) {
        return trueArguments.contains(argument);
    }

    public boolean call(int... intArrayArgument) {
        if (intArrayArgument.length != arity) {
            throw new IllegalArgumentException("Int array length should be equal to the function's arity.");
        }

        return trueArguments.contains(BitSetUtil.toBitSet(intArrayArgument));
    }
}
