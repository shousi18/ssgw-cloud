package com.shousi.ssgw.cloud.order.retryer;

import feign.RetryableException;
import feign.Retryer;

public class FeignClientRetryer implements Retryer {

    private int start = 1;

    private int max = 3;
    @Override
    public void continueOrPropagate(RetryableException e) {
        if (start > max) {
            throw e;
        } else {
            start++;
        }
    }

    @Override
    public Retryer clone() {
        return new FeignClientRetryer();
    }
}
