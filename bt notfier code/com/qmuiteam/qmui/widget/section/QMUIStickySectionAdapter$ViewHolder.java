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

public static class QMUIStickySectionAdapter.ViewHolder
extends RecyclerView.ViewHolder {
    public boolean isForStickyHeader = false;
    public boolean isLoadBefore = false;
    public boolean isLoadError = false;

    public QMUIStickySectionAdapter.ViewHolder(View view) {
        super(view);
    }
}
