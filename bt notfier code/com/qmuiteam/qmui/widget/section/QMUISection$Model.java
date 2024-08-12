/*
 * Decompiled with CFR 0.152.
 */
package com.qmuiteam.qmui.widget.section;

public static interface QMUISection.Model<T> {
    public T cloneForDiff();

    public boolean isSameContent(T var1);

    public boolean isSameItem(T var1);
}
