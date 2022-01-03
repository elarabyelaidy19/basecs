package chapter3.section1;

import edu.princeton.cs.algs4.Queue;

import java.util.NoSuchElementException;

/**
 * Created by Rene Argento on 22/04/17.
 */
@SuppressWarnings("unchecked")
public class BinarySearchSymbolTable<Key extends Comparable<Key>, Value> implements SymbolTable<Key, Value>{

    private Key[] keys;
    private Value[] values;
    private int size;

    private static final int DEFAULT_INITIAL_CAPACITY = 2;

    public BinarySearchSymbolTable() {
        keys = (Key[]) new Comparable[DEFAULT_INITIAL_CAPACITY];
        values = (Value[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public BinarySearchSymbolTable(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to get() cannot be null");
        }

        if (isEmpty()) {
            return null;
        }

        int rank = rank(key);
        if (rank < size && keys[rank].compareTo(key) == 0) {
            return values[rank];
        } else {
            return null;
        }
    }

    public int rank(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            int comparison = key.compareTo(keys[middle]);
            if (comparison < 0) {
                high = middle - 1;
            } else if (comparison > 0) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return low;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if (value == null) {
            delete(key);
            return;
        }

        int rank = rank(key);

        if (rank < size && keys[rank].compareTo(key) == 0) {
            values[rank] = value;
            return;
        }

        if (size == keys.length) {
            resize(keys.length * 2);
        }

        for(int i = size; i > rank; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[rank] = key;
        values[rank] = value;
        size++;
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to contains() cannot be null");
        }
        return get(key) != null;
    }

    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("Argument to delete() cannot be null");
        }

        if (isEmpty() || !contains(key)) {
            return;
        }

        int rank = rank(key);
        for(int i = rank; i < size - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }

        keys[size - 1] = null;
        values[size - 1] = null;
        size--;

        if (size > 1 && size == keys.length / 4) {
            resize(keys.length / 2);
        }
    }

    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty symbol table");
        }

        return keys[0];
    }

    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty symbol table");
        }

        return keys[size - 1];
    }

    public Key select(int k) {
        if (isEmpty() || k >= size) {
            throw new IllegalArgumentException("Index " + k + " is higher than size");
        }

        return keys[k];
    }

    public Key ceiling(Key key) {
        int rank = rank(key);

        if (rank == size) {
            return null;
        }

        return keys[rank];
    }

    public Key floor(Key key) {
        if (contains(key)) {
            return key;
        }

        int rank = rank(key);

        if (rank == 0) {
            return null;
        }

        return keys[rank - 1];
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow error");
        }

        delete(min());
    }

    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow error");
        }

        delete(max());
    }

    public int size(Key low, Key high) {
        if (low == null || high == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        if (high.compareTo(low) < 0) {
            return 0;
        } else if (contains(high)) {
            return rank(high) - rank(low) + 1;
        } else {
            return rank(high) - rank(low);
        }
    }

    public Iterable<Key> keys(Key low, Key high) {
        if (low == null || high == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }

        Queue<Key> queue = new Queue<>();

        for(int i = rank(low); i < rank(high); i++) {
            queue.enqueue(keys[i]);
        }

        if (contains(high)) {
            queue.enqueue(keys[rank(high)]);
        }

        return queue;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    private void resize(int newSize) {
        Key[] tempKeys = (Key[]) new Comparable[newSize];
        Value[] tempValues = (Value[]) new Object[newSize];

        System.arraycopy(keys, 0, tempKeys, 0, size);
        System.arraycopy(values, 0, tempValues, 0, size);

        keys = tempKeys;
        values = tempValues;
    }
}
