/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.StaticLayout$Builder
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper$Impl23
 */
package androidx.appcompat.widget;

import android.text.StaticLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper;

private static class AppCompatTextViewAutoSizeHelper.Impl29
extends AppCompatTextViewAutoSizeHelper.Impl23 {
    AppCompatTextViewAutoSizeHelper.Impl29() {
    }

    void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
        builder.setTextDirection(textView.getTextDirectionHeuristic());
    }

    boolean isHorizontallyScrollable(TextView textView) {
        return textView.isHorizontallyScrollable();
    }
}
