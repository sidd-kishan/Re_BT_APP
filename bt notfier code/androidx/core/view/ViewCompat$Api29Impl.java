/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.view.View
 */
package androidx.core.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

private static class ViewCompat.Api29Impl {
    private ViewCompat.Api29Impl() {
    }

    static void saveAttributeDataForStyleable(View view, Context context, int[] nArray, AttributeSet attributeSet, TypedArray typedArray, int n, int n2) {
        view.saveAttributeDataForStyleable(context, nArray, attributeSet, typedArray, n, n2);
    }
}
