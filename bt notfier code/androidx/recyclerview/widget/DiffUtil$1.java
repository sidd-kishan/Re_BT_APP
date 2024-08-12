/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.DiffUtil$Diagonal
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil;
import java.util.Comparator;

class DiffUtil.1
implements Comparator<DiffUtil.Diagonal> {
    DiffUtil.1() {
    }

    @Override
    public int compare(DiffUtil.Diagonal diagonal, DiffUtil.Diagonal diagonal2) {
        return diagonal.x - diagonal2.x;
    }
}
