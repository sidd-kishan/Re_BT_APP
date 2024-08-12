/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatTextHelper
 */
package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextHelper;

class AppCompatTextHelper.2
implements Runnable {
    final AppCompatTextHelper this$0;
    final int val$style;
    final TextView val$textView;
    final Typeface val$typeface;

    AppCompatTextHelper.2(AppCompatTextHelper appCompatTextHelper, TextView textView, Typeface typeface, int n) {
        this.this$0 = appCompatTextHelper;
        this.val$textView = textView;
        this.val$typeface = typeface;
        this.val$style = n;
    }

    @Override
    public void run() {
        this.val$textView.setTypeface(this.val$typeface, this.val$style);
    }
}
