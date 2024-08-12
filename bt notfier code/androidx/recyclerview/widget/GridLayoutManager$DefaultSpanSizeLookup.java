/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.GridLayoutManager;

public static final class GridLayoutManager.DefaultSpanSizeLookup
extends GridLayoutManager.SpanSizeLookup {
    public int getSpanIndex(int n, int n2) {
        return n % n2;
    }

    public int getSpanSize(int n) {
        return 1;
    }
}
