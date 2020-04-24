package com.company;

import com.company.methods.ResultEntry;

public interface Solvable {
    ResultEntry solve();

    double getEpsilon();
}
