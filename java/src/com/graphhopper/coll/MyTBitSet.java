package com.graphhopper.coll;

import gnu.trove.iterator.TIntIterator;
import gnu.trove.set.hash.TIntHashSet;

/**
 * Implements the bitset interface via a trove THashSet. More efficient for a few entries.
 *
 * @author Peter Karich,
 */
public class MyTBitSet implements MyBitSet {

    private final TIntHashSet tHash;

    public MyTBitSet(int no) {
        tHash = new TIntHashSet(no, 0.7f, -1);
    }

    public MyTBitSet() {
        this(1000);
    }

    @Override public boolean contains(int index) {
        return tHash.contains(index);
    }

    @Override public void add(int index) {
        tHash.add(index);
    }

    @Override public String toString() {
        return tHash.toString();
    }

    @Override
    public int cardinality() {
        return tHash.size();
    }

    @Override
    public void clear() {
        tHash.clear();
    }

    @Override
    public void ensureCapacity(int index) {
    }

    @Override
    public MyBitSet copyTo(MyBitSet bs) {
        bs.clear();
        if (bs instanceof MyTBitSet) {
            ((MyTBitSet) bs).tHash.addAll(this.tHash);
        } else {
            TIntIterator iter = tHash.iterator();
            while (iter.hasNext()) {
                bs.add(iter.next());
            }
        }
        return bs;
    }

    @Override
    public int next(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}