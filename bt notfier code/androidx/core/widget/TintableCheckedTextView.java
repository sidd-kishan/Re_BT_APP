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

public interface TintableCheckedTextView {
    public ColorStateList getSupportCheckMarkTintList();

    public PorterDuff.Mode getSupportCheckMarkTintMode();

    public void setSupportCheckMarkTintList(ColorStateList var1);

    public void setSupportCheckMarkTintMode(PorterDuff.Mode var1);
}
