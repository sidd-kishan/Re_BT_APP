/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ClipData$Item
 *  android.content.Context
 *  android.text.Spanned
 */
package androidx.core.widget;

import android.content.ClipData;
import android.content.Context;
import android.text.Spanned;

private static final class TextViewOnReceiveContentListener.ApiImpl {
    private TextViewOnReceiveContentListener.ApiImpl() {
    }

    static CharSequence coerce(Context object, ClipData.Item object2, int n) {
        object2 = object2.coerceToText(object);
        object = object2;
        if ((n & 1) == 0) return object;
        object = object2;
        if (!(object2 instanceof Spanned)) return object;
        object = object2.toString();
        return object;
    }
}
