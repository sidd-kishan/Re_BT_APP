/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.widget.section.QMUISection
 *  com.qmuiteam.qmui.widget.section.QMUISection$Model
 *  com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter$ViewHolder
 */
package com.qmuiteam.qmui.widget.section;

import com.qmuiteam.qmui.widget.section.QMUISection;
import com.qmuiteam.qmui.widget.section.QMUIStickySectionAdapter;

public static interface QMUIStickySectionAdapter.Callback<H extends QMUISection.Model<H>, T extends QMUISection.Model<T>> {
    public void loadMore(QMUISection<H, T> var1, boolean var2);

    public void onItemClick(QMUIStickySectionAdapter.ViewHolder var1, int var2);

    public boolean onItemLongClick(QMUIStickySectionAdapter.ViewHolder var1, int var2);
}
