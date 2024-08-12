/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;

static interface ViewBoundsCheck.Callback {
    public View getChildAt(int var1);

    public int getChildEnd(View var1);

    public int getChildStart(View var1);

    public int getParentEnd();

    public int getParentStart();
}
