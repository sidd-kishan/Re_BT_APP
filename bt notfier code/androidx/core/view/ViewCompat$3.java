/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.view.View
 *  androidx.core.view.ViewCompat$AccessibilityViewProperty
 */
package androidx.core.view;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;

class ViewCompat.3
extends ViewCompat.AccessibilityViewProperty<CharSequence> {
    ViewCompat.3(int n, Class clazz, int n2, int n3) {
        super(n, clazz, n2, n3);
    }

    CharSequence frameworkGet(View view) {
        return view.getAccessibilityPaneTitle();
    }

    void frameworkSet(View view, CharSequence charSequence) {
        view.setAccessibilityPaneTitle(charSequence);
    }

    boolean shouldUpdate(CharSequence charSequence, CharSequence charSequence2) {
        return TextUtils.equals((CharSequence)charSequence, (CharSequence)charSequence2) ^ true;
    }
}