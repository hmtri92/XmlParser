package com.XMLReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntegerSortedSearch
{
    public static int[] sortSearch(int[] sortedArray, int lessThan)
    {
    	Set<Integer> result = new HashSet<Integer>();
		for (int item : sortedArray) {
			if (item < lessThan) {
				result.add(item);
			}
		}
		
		List<Integer> lstResult = new ArrayList<Integer>();
		
		
		for (Integer i : result) {
			lstResult.add(i);
		}
		
		Collections.sort(lstResult, Collections.reverseOrder());
		int[] rr = new int[lstResult.size()];
		
		for (int i = 0; i < lstResult.size(); i++) {
			rr[i] = lstResult.get(i);
		}
		
        return rr;
    }

    public static void main(String[] args) {
//        int[] results = IntegerSortedSearch.sortSearch(new int[] { 1, 2, 3, 1, 0, 0 ,0, 3 ,98, 98, 2, 2, 2, 0, 0, 0, 2 }, 4);
    	int[] results = IntegerSortedSearch.sortSearch(new int[] { 1, 2, 3 }, 3);
        for(int item : results) {
            System.out.print(item + " ");
        }
    }
}