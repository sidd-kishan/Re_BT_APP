/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.drawerlayout.widget;

import android.view.View;

public static interface DrawerLayout.DrawerListener {
    public void onDrawerClosed(View var1);

    public void onDrawerOpened(View var1);

    public void onDrawerSlide(View var1, float var2);

    public void onDrawerStateChanged(int var1);
}
