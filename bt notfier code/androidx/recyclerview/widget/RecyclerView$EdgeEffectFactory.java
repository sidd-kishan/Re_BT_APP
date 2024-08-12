/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.EdgeEffect
 *  androidx.recyclerview.widget.RecyclerView
 */
package androidx.recyclerview.widget;

import android.widget.EdgeEffect;
import androidx.recyclerview.widget.RecyclerView;

public static class RecyclerView.EdgeEffectFactory {
    public static final int DIRECTION_BOTTOM = 3;
    public static final int DIRECTION_LEFT = 0;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_TOP = 1;

    protected EdgeEffect createEdgeEffect(RecyclerView recyclerView, int n) {
        return new EdgeEffect(recyclerView.getContext());
    }
}
