/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.method.SingleLineTransformationMethod
 *  android.view.View
 */
package androidx.viewpager.widget;

import android.content.Context;
import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

private static class PagerTitleStrip.SingleLineAllCapsTransform
extends SingleLineTransformationMethod {
    private Locale mLocale;

    PagerTitleStrip.SingleLineAllCapsTransform(Context context) {
        this.mLocale = context.getResources().getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        charSequence = (charSequence = super.getTransformation(charSequence, view)) != null ? charSequence.toString().toUpperCase(this.mLocale) : null;
        return charSequence;
    }
}
