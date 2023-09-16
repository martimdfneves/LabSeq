package com.example.labseqcalculator;

import java.math.BigInteger;
import org.springframework.stereotype.Service;

@Service
public class LabseqService {

    public String calculateLabseq(int n) {
        if (n == 0) return "0";
        if (n == 1) return "1";
        if (n == 2) return "0";
        if (n == 3) return "1";

        BigInteger[] results = new BigInteger[n + 1];
        results[0] = BigInteger.ZERO;
        results[1] = BigInteger.ONE;
        results[2] = BigInteger.ZERO;
        results[3] = BigInteger.ONE;

        for (int i = 4; i <= n; i++) {
            results[i] = results[i - 4].add(results[i - 3]);
        }

        return results[n].toString();
    }
}