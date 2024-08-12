/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package com.qmuiteam.qmui.widget.section;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public static interface QMUIStickySectionAdapter.ViewCallback {
    public RecyclerView.ViewHolder findViewHolderForAdapterPosition(int var1);

    public void requestChildFocus(View var1);

    public void scrollToPosition(int var1, boolean var2, boolean var3);
}
