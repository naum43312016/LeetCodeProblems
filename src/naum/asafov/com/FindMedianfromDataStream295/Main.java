package naum.asafov.com.FindMedianfromDataStream295;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.


Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3)
findMedian() -> 2

 */
public class Main {
    public static void main(String[] args) {
        MedianFinder m = new MedianFinder();
        m.addNum(2);
        m.addNum(3);
        m.addNum(4);
        System.out.println(m.findMedian());
    }
}


class MedianFinder {
    private List<Integer> data;
    /** initialize your data structure here. */
    public MedianFinder() {
        data = new ArrayList<>();
    }

    public void addNum(int num) {
        data.add(num);
    }

    public double findMedian() {
        data.sort(Integer::compareTo);
        int len = data.size();
        if (len%2==0){
            double res = (data.get(len/2-1)+data.get(len/2))/2.0;
            return res;
        }else {
            double res = data.get(len/2);
            return res;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */