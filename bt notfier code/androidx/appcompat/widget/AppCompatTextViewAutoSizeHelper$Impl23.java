/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.StaticLayout$Builder
 *  android.text.TextDirectionHeuristic
 *  android.text.TextDirectionHeuristics
 *  android.widget.TextView
 *  androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper
 *  androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper$Impl
 */
package androidx.appcompat.widget;

import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper;

/*
 * Exception performing whole class analysis ignored.
 */
private static class AppCompatTextViewAutoSizeHelper.Impl23
extends AppCompatTextViewAutoSizeHelper.Impl {
    AppCompatTextViewAutoSizeHelper.Impl23() {
    }

    void computeAndSetTextDirection(StaticLayout.Builder builder, TextView textView) {
        builder.setTextDirection((TextDirectionHeuristic)AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault((Object)textView, (String)"getTextDirectionHeuristic", (Object)TextDirectionHeuristics.FIRSTSTRONG_LTR));
    }
}
