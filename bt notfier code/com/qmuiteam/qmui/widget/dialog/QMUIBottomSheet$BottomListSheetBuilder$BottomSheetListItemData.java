/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 */
package com.qmuiteam.qmui.widget.dialog;

import android.graphics.drawable.Drawable;

private static class QMUIBottomSheet.BottomListSheetBuilder.BottomSheetListItemData {
    boolean hasRedPoint = false;
    Drawable image = null;
    boolean isDisabled = false;
    String tag = "";
    String text;

    public QMUIBottomSheet.BottomListSheetBuilder.BottomSheetListItemData(Drawable drawable, String string, String string2) {
        this.image = drawable;
        this.text = string;
        this.tag = string2;
    }

    public QMUIBottomSheet.BottomListSheetBuilder.BottomSheetListItemData(Drawable drawable, String string, String string2, boolean bl) {
        this.image = drawable;
        this.text = string;
        this.tag = string2;
        this.hasRedPoint = bl;
    }

    public QMUIBottomSheet.BottomListSheetBuilder.BottomSheetListItemData(Drawable drawable, String string, String string2, boolean bl, boolean bl2) {
        this.image = drawable;
        this.text = string;
        this.tag = string2;
        this.hasRedPoint = bl;
        this.isDisabled = bl2;
    }

    public QMUIBottomSheet.BottomListSheetBuilder.BottomSheetListItemData(String string, String string2) {
        this.text = string;
        this.tag = string2;
    }
}
