/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.StaticLayout$Builder
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper
 */
package androidx.appcompat.widget;

import android.text.StaticLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper;

/*
 * Exception performing whole class analysis ignored.
 */
private static class AppCompatTextViewAutoSizeHelper.Impl {
    AppCompatTextViewAutoSizeHelper.Impl() {
    }

    void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
    }

    boolean isHorizontallyScrollable(TextView textView) {
        return (Boolean)AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault((Object)textView, (String)"getHorizontallyScrolling", (Object)false);
    }
}
