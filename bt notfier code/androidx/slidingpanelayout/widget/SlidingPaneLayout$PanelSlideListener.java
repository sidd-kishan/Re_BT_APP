/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.slidingpanelayout.widget;

import android.view.View;

public static interface SlidingPaneLayout.PanelSlideListener {
    public void onPanelClosed(View var1);

    public void onPanelOpened(View var1);

    public void onPanelSlide(View var1, float var2);
}
