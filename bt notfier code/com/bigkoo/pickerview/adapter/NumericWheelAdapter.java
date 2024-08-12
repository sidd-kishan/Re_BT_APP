/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.contrarywind.adapter.WheelAdapter
 */
package com.bigkoo.pickerview.adapter;

import com.contrarywind.adapter.WheelAdapter;

public class NumericWheelAdapter
implements WheelAdapter {
    private int maxValue;
    private int minValue;

    public NumericWheelAdapter(int n, int n2) {
        this.minValue = n;
        this.maxValue = n2;
    }

    public Object getItem(int n) {
        if (n < 0) return 0;
        if (n >= this.getItemsCount()) return 0;
        return this.minValue + n;
    }

    public int getItemsCount() {
        return this.maxValue - this.minValue + 1;
    }

    public int indexOf(Object object) {
        try {
            int n = (Integer)object;
            int n2 = this.minValue;
            return n - n2;
        }
        catch (Exception exception) {
            return -1;
        }
    }
}
