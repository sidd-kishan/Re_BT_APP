/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.contrarywind.adapter.WheelAdapter
 */
package com.bigkoo.pickerview.adapter;

import com.contrarywind.adapter.WheelAdapter;
import java.util.List;

public class ArrayWheelAdapter<T>
implements WheelAdapter {
    private List<T> items;

    public ArrayWheelAdapter(List<T> list) {
        this.items = list;
    }

    public Object getItem(int n) {
        if (n < 0) return "";
        if (n >= this.items.size()) return "";
        return this.items.get(n);
    }

    public int getItemsCount() {
        return this.items.size();
    }

    public int indexOf(Object object) {
        return this.items.indexOf(object);
    }
}
