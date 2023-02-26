package org.tony.clarke.algo.heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeap {

    public static void main(String args[]) {
        MinHeap minHeap = new MinHeap(Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41));
        minHeap.remove();
    }

    List<Integer> heap = new ArrayList<Integer>();

    public MinHeap(List<Integer> array) {
        heap = buildHeap(array);
    }

    public List<Integer> buildHeap(List<Integer> array) {
        for (Integer i : array) {
            insert(i);
        }
        return heap;
    }

    public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
        int indexOfSmallestChild = getIndexOfSmallestChild(currentIdx);
        if (indexOfSmallestChild != -1) {
            if(heap.get(indexOfSmallestChild) < heap.get(currentIdx)) {
                int temp = heap.get(indexOfSmallestChild);
                ((ArrayList) heap).set(indexOfSmallestChild, heap.get(currentIdx));
                ((ArrayList) heap).set(currentIdx, temp);
                siftDown(indexOfSmallestChild, endIdx, heap);
            }
        }

        // Write your code here.
    }

    public void siftUp(int currentIdx, List<Integer> heap) {
        int parentIndex = getParentIndex(currentIdx);
        if (parentIndex < 0) {
            return;
        }
        if (heap.get(parentIndex) > heap.get(currentIdx)) {
            int temp = heap.get(parentIndex);
            ((ArrayList) heap).set(parentIndex, heap.get(currentIdx));
            ((ArrayList) heap).set(currentIdx, temp);
            siftUp(parentIndex, heap);
        }

    }

    public int peek() {
        return heap.get(0);
    }

    public int remove() {
        int smallest = peek();
        int last = heap.get(heap.size() - 1);
        ((ArrayList) heap).set(0, last);
        heap.remove(heap.size() - 1);
        siftDown(0, heap.size() - 1, heap);
        return smallest;
    }

    public void insert(int value) {
        heap.add(value);
        int childIndex = heap.size() - 1;
        siftUp(childIndex, heap);
    }

    private int getParentIndex(int i) {
        // 1st child index is index * 2 + 1
        // 2nd child index is index * 2 + 2
        // 1st child index is odd
        // 2nd child index is even
        // for first child, parent index is -1 / 2
        // for second child, parent index is -2 / 2
        boolean firstChild = true;
        if (i % 2 == 0) {
            return (i - 2) / 2;
        } else {
            return (i - 1) / 2;
        }
    }

    private int getFirstChild(int i) {
        return (i * 2) + 1;
    }

    private int getSecondChild(int i) {
        return (i * 2) + 2;
    }

    private int getIndexOfSmallestChild(int i) {
        int maxIndex = this.heap.size() - 1;
        int firstChild = getFirstChild(i);
        int secondChild = getSecondChild(i);
        if (firstChild <= maxIndex && secondChild <=maxIndex) {
            // has two child nodes
            if (heap.get(firstChild) < heap.get(secondChild)) {
                return firstChild;
            } else {
                return secondChild;
            }
        }
        if (firstChild <= maxIndex) {
            return firstChild;
        }
        if (secondChild <= maxIndex) {
            return secondChild;
        }
        return -1;
    }

}
