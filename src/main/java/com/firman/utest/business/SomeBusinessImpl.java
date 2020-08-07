package com.firman.utest.business;

import com.firman.utest.data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data) {

        return Arrays.stream(data).reduce(Integer::sum).orElse(0);

        /*int sum = 0;
        for (int value : data) {
            sum += value;
        }
        return sum;*/
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.retriveAllData();
        for (int value : data) {
            sum += value;
        }
        return sum;
    }

}
