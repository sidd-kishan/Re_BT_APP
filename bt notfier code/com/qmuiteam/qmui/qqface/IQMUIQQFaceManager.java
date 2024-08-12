/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 */
package com.qmuiteam.qmui.qqface;

import android.graphics.drawable.Drawable;

public interface IQMUIQQFaceManager {
    public int getDoubleUnicodeEmoji(int var1, int var2);

    public int getEmojiResource(int var1);

    public int getQQfaceResource(CharSequence var1);

    public int getSoftbankEmojiResource(char var1);

    public Drawable getSpecialBoundsDrawable(CharSequence var1);

    public int getSpecialDrawableMaxHeight();

    public boolean maybeEmoji(int var1);

    public boolean maybeSoftBankEmoji(char var1);
}
