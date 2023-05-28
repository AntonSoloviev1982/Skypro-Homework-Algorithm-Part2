package com.example.skyprohomeworkalgorithmpart2;


import com.example.skyprohomeworkalgorithmpart2.exception.ElementNotFoundException;
import com.example.skyprohomeworkalgorithmpart2.exception.NoSuchIndexException;

import java.util.Arrays;
import java.util.Objects;

public class IntegerArrayList implements IntegerList {

    private Integer[] integerArrayList;

    public IntegerArrayList(int size) {
        integerArrayList = new Integer[size];
    }

    public Integer[] getIntegerArrayList() {
        return integerArrayList;
    }


    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new NullPointerException("String is null");
        }
        if (isArrayFull()) {
            increasedStringArrayList();
        }
        for (int i = 0; i < integerArrayList.length; i++) {
            if (integerArrayList[i] == null) {
                integerArrayList[i] = item;
                break;
            }
        }
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index >= integerArrayList.length || index >= size()) {
            throw new NoSuchIndexException("Index is more then array's length");
        }
        if (item == null) {
            throw new NullPointerException("Integer is null");
        }
        if (isArrayFull()) {
            increasedStringArrayList();
        }
        moveElementsToTheRight(index);
        integerArrayList[index] = item;
        return item;
    }


    @Override
    public Integer set(int index, Integer item) {
        if (index >= integerArrayList.length || index >= size()) {
            throw new NoSuchIndexException("Index is more then array's length or array's size");
        }
        if (item == null) {
            throw new NullPointerException("Integer is null");
        }
        integerArrayList[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        int index = 0;
        if (contains(item)) {
            for (int i = 0; i < size(); i++) {
                if (integerArrayList[i] == item) {
                    index = i;
                    integerArrayList[i] = null;
                }
            }
            moveElementsToTheLeft(index);
        } else {
            throw new ElementNotFoundException();
        }
        return item;
    }

    @Override
    public Integer remove(int index) {
        if (index >= size()) {
            throw new NoSuchIndexException("Index is more then array's size");
        }
        Integer result = integerArrayList[index];
        integerArrayList[index] = null;
        moveElementsToTheLeft(index);
        return result;
    }

    @Override
    public boolean contains(Integer item) {
        boolean result = false;
        for (int i = 0; i < integerArrayList.length; i++) {
            if (integerArrayList[i] == item) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public int indexOf(Integer item) {
        int result = -1;
        for (int i = 0; i < size(); i++) {
            if (integerArrayList[i] == item) {
                result = i;
            }
        }
        return result;
    }

    @Override
    public int lastIndexOf(Integer item) {
        int result = -1;
        for (int i = (size() - 1); i > 0; i--) {
            if (integerArrayList[i] == item) {
                result = i;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer get(int index) {
        if (index >= size()) {
            throw new NoSuchIndexException("Index is more then array's size");
        }
        return integerArrayList[index];
    }

    @Override
    public boolean equals(IntegerArrayList otherList) {

        if (this.getIntegerArrayList()==otherList.getIntegerArrayList())
            return true;
        if (this.getIntegerArrayList()==null || otherList.getIntegerArrayList()==null)
            return false;

        int length = this.getIntegerArrayList().length;
        if (otherList.getIntegerArrayList().length != length)
            return false;

        for (int i=0; i<length; i++) {
            if (!Objects.equals(this.getIntegerArrayList()[i], otherList.getIntegerArrayList()[i]))
                return false;
        }
        return true;
    }

    @Override
    public int size() {
        return (int) Arrays.stream(integerArrayList).filter(e -> e != null).count();
    }

    @Override
    public boolean isEmpty() {
        boolean result = false;
        if (size() == 0) {
            result = true;
        }
        return result;
    }

    @Override
    public void clear() {
        integerArrayList = Arrays.stream(integerArrayList).map(e -> e = null).toArray(Integer []::new);
    }

    @Override
    public Integer[] toArray() {
        Integer [] newArray = integerArrayList.clone();
        return newArray;
    }




    public boolean isArrayFull() {
        boolean isFull = false;
        if (integerArrayList[integerArrayList.length - 1] != null) {
            isFull = true;
        }
        return isFull;
    }

    public void increasedStringArrayList() {
        Integer[] newArray = new Integer[integerArrayList.length * 2];
        System.arraycopy(integerArrayList, 0, newArray, 0, integerArrayList.length);
        integerArrayList = newArray;
    }

    public void moveElementsToTheRight(int index) {
        for (int i = integerArrayList.length - 1; i > index; i--) {
            integerArrayList[i] = integerArrayList[i - 1];
        }
    }


    public void moveElementsToTheLeft(int index) {
        for (int i = index; i < size(); i++) {
            integerArrayList[i] = integerArrayList[i + 1];
            integerArrayList[i + 1] = null;
        }
    }

}
