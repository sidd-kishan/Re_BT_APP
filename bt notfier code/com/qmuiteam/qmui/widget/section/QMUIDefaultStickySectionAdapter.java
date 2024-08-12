/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  com.qmuiteam.qmui.widget.section.QMUISection$Model
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter$ViewHolder
 */
package com.qmuiteam.qmui.widget.section;

import android.view.View;
import android.view.ViewGroup;
import com.qmuiteam.qmui.widget.section.QMUISection;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter;

public abstract class QMUIDefaultStickySectionAdapter<H extends QMUISection.Model<H>, T extends QMUISection.Model<T>>
extends QMUIStickySectionAdapter<H, T, QMUIStickySectionAdapter.ViewHolder> {
    protected QMUIStickySectionAdapter.ViewHolder onCreateCustomItemViewHolder(ViewGroup viewGroup, int n) {
        return new QMUIStickySectionAdapter.ViewHolder(new View(viewGroup.getContext()));
    }

    protected QMUIStickySectionAdapter.ViewHolder onCreateSectionLoadingViewHolder(ViewGroup viewGroup) {
        return new QMUIStickySectionAdapter.ViewHolder(new View(viewGroup.getContext()));
    }
}
