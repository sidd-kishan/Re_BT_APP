/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 */
package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;

public interface TintableCompoundButton {
    public ColorStateList getSupportButtonTintList();

    public PorterDuff.Mode getSupportButtonTintMode();

    public void setSupportButtonTintList(ColorStateList var1);

    public void setSupportButtonTintMode(PorterDuff.Mode var1);
}
