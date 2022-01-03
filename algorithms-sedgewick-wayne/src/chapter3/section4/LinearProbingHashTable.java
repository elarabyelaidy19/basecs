package chapter3.section4;

import edu.princeton.cs.algs4.Queue;

import java.util.Arrays;

/**
 * Created by Rene Argento on 17/07/17.
 */
@SuppressWarnings("unchecked")
public class LinearProbingHashTable<Key, Value> {

    protected int keysSize;
    protected int size;
    protected Key[] keys;
    protected Value[] values;

    //The largest prime <= 2^i for i = 1 to 31
    //Used to distribute keys uniformly in the hash table after resizes
    //PRIMES[n] = 2^k - Ak where k is the power of 2 and Ak is the value to subtract to reach the previous prime number
    private static final int[] PRIMES = {
            1, 1, 3, 7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381,
            32749, 65521, 131071, 262139, 524287, 1048573, 2097143, 4194301,
            8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
            536870909, 1073741789, 2147483647
    };

    //The lg of the hash table size
    //Used in combination with PRIMES[] to distribute keys uniformly in the hash function after resizes
    protected int lgM;

    public LinearProbingHashTable(int size) {
        this.size = size;
        keys = (Key[]) new Object[size];
        values = (Value[]) new Object[size];

        lgM = (int) (Math.log(size) / Math.log(2));
    }

    public int size() {
        return keysSize;
    }

    public boolean isEmpty() {
        return keysSize == 0;
    }

    protected int hash(Key key) {
        int hash = key.hashCode() & 0x7fffffff;

        if (lgM < 26) {
            hash = hash % PRIMES[lgM + 5];
        }

        return hash % size;
    }

    protected double getLoadFactor() {
        return keysSize / (double) size;
    }

    private void resize(int newSize) {
        LinearProbingHashTable<Key, Value> tempHashTable = new LinearProbingHashTable<>(newSize);

        for(int i = 0; i < size; i++) {
            if (keys[i] != null) {
                tempHashTable.put(keys[i], values[i]);
            }
        }

        keys = tempHashTable.keys;
        values = tempHashTable.values;
        size = tempHashTable.size;
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to contains() cannot be null");
        }

        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to get() cannot be null");
        }

        for(int tableIndex = hash(key); keys[tableIndex] != null; tableIndex = (tableIndex + 1) % size) {
            if (keys[tableIndex].equals(key)) {
                return values[tableIndex];
            }
        }

        return null;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if (value == null) {
            delete(key);
            return;
        }

        if (keysSize >= size / (double) 2) {
            resize(size * 2);
            lgM++;
        }

        int tableIndex;
        for(tableIndex = hash(key); keys[tableIndex] != null; tableIndex = (tableIndex + 1) % size) {
            if (keys[tableIndex].equals(key)) {
                values[tableIndex] = value;
                return;
            }
        }

        keys[tableIndex] = key;
        values[tableIndex] = value;
        keysSize++;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to delete() cannot be null");
        }

        if (!contains(key)) {
            return;
        }

        int tableIndex = hash(key);
        while (!keys[tableIndex].equals(key)) {
            tableIndex = (tableIndex + 1) % size;
        }

        keys[tableIndex] = null;
        values[tableIndex] = null;
        keysSize--;

        tableIndex = (tableIndex + 1) % size;

        while (keys[tableIndex] != null) {
            Key keyToRedo = keys[tableIndex];
            Value valueToRedo = values[tableIndex];

            keys[tableIndex] = null;
            values[tableIndex] = null;
            keysSize--;

            put(keyToRedo, valueToRedo);
            tableIndex = (tableIndex + 1) % size;
        }

        if (keysSize > 1 && keysSize <= size / (double) 8) {
            resize(size / 2);
            lgM--;
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> keySet = new Queue<>();

        for(Object key : keys) {
            if (key != null) {
                keySet.enqueue((Key) key);
            }
        }

        if (!keySet.isEmpty() && keySet.peek() instanceof Comparable) {
            Key[] keysToBeSorted = (Key[]) new Comparable[keySet.size()];
            for(int i = 0; i < keysToBeSorted.length; i++) {
                keysToBeSorted[i] = keySet.dequeue();
            }

            Arrays.sort(keysToBeSorted);

            for(Key key : keysToBeSorted) {
                keySet.enqueue(key);
            }
        }

        return keySet;
    }

}
