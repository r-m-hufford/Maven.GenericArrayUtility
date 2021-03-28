package com.zipcodewilmington.arrayutility;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<E> {

    E[] inputArray;

    public ArrayUtility(E[] inputArray) {
        this.inputArray = inputArray;
    }

    public E[] merge(E[] arrayToMerge) {
        Object[] merged = new Object[inputArray.length + arrayToMerge.length];

        for (int i = 0; i < inputArray.length; i++) {
            merged[i] = inputArray[i];
        }

        for (int i = inputArray.length, j = 0; i < merged.length; i++) {
            merged[i] = arrayToMerge[j];
            j++;
        }

        return (E[]) merged;
    }

    public Integer getNumberOfOccurrences(E valueToEvaluate) {
        Integer numberOfOccurences = 0;
        for (E element : inputArray) {
            if (element == valueToEvaluate) {
                numberOfOccurences++;
            }
        }
        return numberOfOccurences;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E valueToEvaluate) {
        E[] merged = merge(arrayToMerge);

        Integer numberOfOccurrences = 0;
        for (E element : merged) {
            if (element == valueToEvaluate) {
                numberOfOccurrences++;
            }
        }
        return numberOfOccurrences;
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        E[] merged = merge(arrayToMerge);

        E currentElement;
        Integer currentCount = 1;
        E mostCommon = null;
        Integer commonCount = 1;

        for (int i = 0; i < merged.length - 1; i++) {
            currentElement = merged[i];
            for (int j = i + 1; j < merged.length; j++) {
                if (merged[j].equals(currentElement)) {
                    currentCount++;
                }
            }
            if (currentCount > commonCount) {
                mostCommon = currentElement;
                commonCount = currentCount;
            }

        }
        return mostCommon;
    }

    public E[] removeValue(E valueToRemove) {
        Object[] valueRemoved = new Object[inputArray.length];
        Integer counter = 0;

        for (int i = 0, j = 0; i < inputArray.length; i++) {
            if (inputArray[i] == valueToRemove) {
                counter++;
                continue;
            } else {
                valueRemoved[j] = inputArray[i];
                j++;
            }
        }

        return (E[]) Arrays.copyOf(valueRemoved, inputArray.length - counter);
    }
}
