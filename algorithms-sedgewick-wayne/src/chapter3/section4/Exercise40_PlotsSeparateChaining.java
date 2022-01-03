package chapter3.section4;

import edu.princeton.cs.algs4.Queue;
import util.Constants;
import util.FileUtil;
import util.VisualAccumulator;

import java.util.Arrays;

/**
 * Created by Rene Argento on 29/07/17.
 */
@SuppressWarnings("unchecked")
public class Exercise40_PlotsSeparateChaining {

    private class SeparateChainingHashTableCost<Key, Value> {

        class SequentialSearchSymbolTable<Key, Value> {

            private class Node {
                Key key;
                Value value;
                Node next;

                public Node(Key key, Value value, Node next) {
                    this.key = key;
                    this.value = value;
                    this.next = next;
                }
            }

            private Node first;
            private int size;

            public int size() {
                return size;
            }

            public boolean isEmpty() {
                return size == 0;
            }

            public boolean contains(Key key) {
                return get(key) != null;
            }

            public Value get(Key key) {
                costOfPutCompares++;

                for(Node node = first; node != null; node = node.next) {
                    costOfPutCompares++;

                    if (key.equals(node.key)) {
                        return node.value;
                    }
                }

                return null;
            }

            public int putAndComputeCost(Key key, Value value) {
                int costOfCompares = 1;

                for(Node node = first; node != null; node = node.next) {
                    costOfCompares++;

                    if (key.equals(node.key)) {
                        node.value = value;
                        return costOfCompares;
                    }
                }

                first = new Node(key, value, first);
                size++;
                return costOfCompares;
            }

            public void delete(Key key) {
                if (first.key.equals(key)) {
                    first = first.next;
                    size--;
                    return;
                }

                for(Node node = first; node != null; node = node.next) {
                    if (node.next != null && node.next.key.equals(key)) {
                        node.next = node.next.next;
                        size--;
                        return;
                    }
                }
            }

            public Iterable<Key> keys() {
                Queue<Key> keys = new Queue<>();

                for(Node node = first; node != null; node = node.next) {
                    keys.enqueue(node.key);
                }

                return keys;
            }

        }

        private int averageListSize;

        private int size;
        private int keysSize;
        private SequentialSearchSymbolTable<Key, Value>[] symbolTable;

        private int costOfPutCompares;

        private static final int DEFAULT_HASH_TABLE_SIZE = 997;
        private static final int DEFAULT_AVERAGE_LIST_SIZE = 5;

        //The largest prime <= 2^i for i = 1 to 31
        //Used to distribute keys uniformly in the hash table after resizes
        //PRIMES[n] = 2^k - Ak where k is the power of 2 and Ak is the value to subtract to reach the previous prime number
        private final int[] PRIMES = {
                1, 1, 3, 7, 13, 31, 61, 127, 251, 509, 1021, 2039, 4093, 8191, 16381,
                32749, 65521, 131071, 262139, 524287, 1048573, 2097143, 4194301,
                8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
                536870909, 1073741789, 2147483647
        };

        //The lg of the hash table size
        //Used in combination with PRIMES[] to distribute keys uniformly in the hash function after resizes
        protected int lgM;

        public SeparateChainingHashTableCost() {
            this(DEFAULT_HASH_TABLE_SIZE, DEFAULT_AVERAGE_LIST_SIZE);
        }

        public SeparateChainingHashTableCost(int initialSize, int averageListSize) {
            this.size = initialSize;
            this.averageListSize = averageListSize;
            symbolTable = new SequentialSearchSymbolTable[size];

            for(int i = 0; i < size; i++) {
                symbolTable[i] = new SequentialSearchSymbolTable<>();
            }

            lgM = (int) (Math.log(size) / Math.log(2));
        }

        public int size() {
            return keysSize;
        }

        public boolean isEmpty() {
            return keysSize == 0;
        }

        private int hash(Key key) {
            int hash = key.hashCode() & 0x7fffffff;

            if (lgM < 26) {
                hash = hash % PRIMES[lgM + 5];
            }

            return hash % size;
        }

        private double getLoadFactor() {
            return ((double) keysSize) / (double) size;
        }

        public boolean contains(Key key) {
            if (key == null) {
                throw new IllegalArgumentException("Argument to contains() cannot be null");
            }

            return get(key) != null;
        }

        public void resize(int newSize) {
            SeparateChainingHashTableCost<Key, Value> separateChainingHashTableTemp =
                    new SeparateChainingHashTableCost<>(newSize, averageListSize);

            for(Key key : keys()) {
                separateChainingHashTableTemp.putAndComputeCost(key, get(key), false);
            }

            symbolTable = separateChainingHashTableTemp.symbolTable;
            size = separateChainingHashTableTemp.size;
            keysSize = separateChainingHashTableTemp.keysSize;

            costOfPutCompares += separateChainingHashTableTemp.costOfPutCompares;
        }

        public Value get(Key key) {
            if (key == null) {
                throw new IllegalArgumentException("Argument to get() cannot be null");
            }

            return symbolTable[hash(key)].get(key);
        }

        public int putAndComputeCost(Key key, Value value, boolean resetCostOfPutCompares) {
            if (key == null) {
                throw new IllegalArgumentException("Key cannot be null");
            }

            if (value == null) {
                delete(key);
                return 0;
            }

            if (resetCostOfPutCompares) {
                costOfPutCompares = 0;
            }

            int hashIndex = hash(key);
            int currentSize = symbolTable[hashIndex].size;
            costOfPutCompares += symbolTable[hashIndex].putAndComputeCost(key, value);

            if (currentSize < symbolTable[hashIndex].size) {
                keysSize++;
            }

            if (getLoadFactor() > averageListSize) {
                resize(size * 2);
                lgM++;
            }

            return costOfPutCompares;
        }

        public void delete(Key key) {
            if (key == null) {
                throw new IllegalArgumentException("Argument to delete() cannot be null");
            }

            if (isEmpty() || !contains(key)) {
                return;
            }

            symbolTable[hash(key)].delete(key);
            keysSize--;

            if (size > 1 && getLoadFactor() <= averageListSize / (double) 4) {
                resize(size / 2);
                lgM--;
            }
        }

        public Iterable<Key> keys() {
            Queue<Key> keys = new Queue<>();

            for(SequentialSearchSymbolTable<Key, Value> sequentialSearchST : symbolTable) {
                for(Key key : sequentialSearchST.keys()) {
                    keys.enqueue(key);
                }
            }

            if (!keys.isEmpty() && keys.peek() instanceof Comparable) {
                Key[] keysToBeSorted = (Key[]) new Comparable[keys.size()];
                for(int i = 0; i < keysToBeSorted.length; i++) {
                    keysToBeSorted[i] = keys.dequeue();
                }

                Arrays.sort(keysToBeSorted);

                for(Key key : keysToBeSorted) {
                    keys.enqueue(key);
                }
            }

            return keys;
        }

    }

    private static final String TALE_FILE_PATH = Constants.FILES_PATH + Constants.TALE_OF_TWO_CITIES_FILE;

    public static void main(String[] args) {
        String[] wordsInTale = FileUtil.getAllStringsFromFile(TALE_FILE_PATH);
        int minLength = 8; //Same as the book analysis
        new Exercise40_PlotsSeparateChaining().frequencyCounter(wordsInTale, minLength);
    }

    private String frequencyCounter(String[] words, int minLength) {

        String title = "Separate-chaining hash table costs using put() in FrequencyCounter";
        String xAxisLabel = "operations";
        String yAxisLabel = "equality tests";
        double maxNumberOfOperations = 18000;
        double maxCost = 25;
        int originValue = 0;

        VisualAccumulator visualAccumulator = new VisualAccumulator(originValue, maxNumberOfOperations, maxCost, title,
                xAxisLabel, yAxisLabel);
        SeparateChainingHashTableCost<String, Integer> separateChainingHashTableCost =
                new SeparateChainingHashTableCost<>(10, 10);

        for(String word : words) {

            if (word.length() < minLength) {
                continue;
            }

            int cost;
            if (!separateChainingHashTableCost.contains(word)) {
                cost = separateChainingHashTableCost.putAndComputeCost(word, 1, true);
            } else {
                cost = separateChainingHashTableCost.
                        putAndComputeCost(word, separateChainingHashTableCost.get(word) + 1, true);
            }
            visualAccumulator.addDataValue(cost, true);
        }

        String max = "";
        int cost = separateChainingHashTableCost.putAndComputeCost(max, 0, true);
        visualAccumulator.addDataValue(cost, true);

        for(String word : separateChainingHashTableCost.keys()) {
            if (separateChainingHashTableCost.get(word) > separateChainingHashTableCost.get(max)) {
                max = word;
            }
        }

        visualAccumulator.writeExactFinalMean();

        return max + " " + separateChainingHashTableCost.get(max);
    }

}
