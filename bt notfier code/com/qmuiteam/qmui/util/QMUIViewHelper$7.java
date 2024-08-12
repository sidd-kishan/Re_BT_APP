/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.qmuiteam.qmui.util.QMUIDirection
 */
package com.qmuiteam.qmui.util;

import com.qmuiteam.qmui.util.QMUIDirection;

static class QMUIViewHelper.7 {
    static final int[] $SwitchMap$com$qmuiteam$qmui$util$QMUIDirection;

    /*
     * Enabled force condition propagation
     */
    static {
        int[] nArray = new int[QMUIDirection.values().length];
        $SwitchMap$com$qmuiteam$qmui$util$QMUIDirection = nArray;
        try {
            nArray[QMUIDirection.LEFT_TO_RIGHT.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            QMUIViewHelper.7.$SwitchMap$com$qmuiteam$qmui$util$QMUIDirection[QMUIDirection.TOP_TO_BOTTOM.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            QMUIViewHelper.7.$SwitchMap$com$qmuiteam$qmui$util$QMUIDirection[QMUIDirection.RIGHT_TO_LEFT.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            QMUIViewHelper.7.$SwitchMap$com$qmuiteam$qmui$util$QMUIDirection[QMUIDirection.BOTTOM_TO_TOP.ordinal()] = 4;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}
