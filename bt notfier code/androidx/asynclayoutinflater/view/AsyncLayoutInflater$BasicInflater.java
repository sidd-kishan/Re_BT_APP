/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 */
package androidx.asynclayoutinflater.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

private static class AsyncLayoutInflater.BasicInflater
extends LayoutInflater {
    private static final String[] sClassPrefixList = new String[]{"android.widget.", "android.webkit.", "android.app."};

    AsyncLayoutInflater.BasicInflater(Context context) {
        super(context);
    }

    public LayoutInflater cloneInContext(Context context) {
        return new AsyncLayoutInflater.BasicInflater(context);
    }

    protected View onCreateView(String string, AttributeSet attributeSet) throws ClassNotFoundException {
        String[] stringArray = sClassPrefixList;
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            String string2 = stringArray[n2];
            try {
                string2 = this.createView(string, string2, attributeSet);
                if (string2 != null) {
                    return string2;
                }
            }
            catch (ClassNotFoundException classNotFoundException) {}
            ++n2;
        }
        return super.onCreateView(string, attributeSet);
    }
}
