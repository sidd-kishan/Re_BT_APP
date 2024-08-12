/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.widget.section.QMUISection
 *  com.qmuiteam.qmui.widget.section.QMUISection$Model
 */
package com.qmuiteam.qmui.widget.section;

import com.qmuiteam.qmui.widget.section.QMUISection;

public static interface QMUIStickySectionAdapter.PositionFinder<H extends QMUISection.Model<H>, T extends QMUISection.Model<T>> {
    public boolean find(QMUISection<H, T> var1, T var2);
}
