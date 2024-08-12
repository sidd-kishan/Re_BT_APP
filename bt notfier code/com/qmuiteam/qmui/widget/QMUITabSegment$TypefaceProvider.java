/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 */
package com.qmuiteam.qmui.widget;

import android.graphics.Typeface;

public static interface QMUITabSegment.TypefaceProvider {
    public Typeface getTypeface();

    public boolean isNormalTabBold();

    public boolean isSelectedTabBold();
}
