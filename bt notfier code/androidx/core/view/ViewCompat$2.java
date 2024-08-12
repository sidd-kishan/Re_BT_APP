/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.core.view.ViewCompat$AccessibilityViewProperty
 */
package androidx.core.view;

import android.view.View;
import androidx.core.view.ViewCompat;

class ViewCompat.2
extends ViewCompat.AccessibilityViewProperty<Boolean> {
    ViewCompat.2(int n, Class clazz, int n2) {
        super(n, clazz, n2);
    }

    Boolean frameworkGet(View view) {
        return view.isScreenReaderFocusable();
    }

    void frameworkSet(View view, Boolean bl) {
        view.setScreenReaderFocusable(bl.booleanValue());
    }

    boolean shouldUpdate(Boolean bl, Boolean bl2) {
        return this.booleanNullToFalseEquals(bl, bl2) ^ true;
    }
}
