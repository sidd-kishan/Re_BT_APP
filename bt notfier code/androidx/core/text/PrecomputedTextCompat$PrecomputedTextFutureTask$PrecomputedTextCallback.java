/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.text.PrecomputedTextCompat
 *  androidx.core.text.PrecomputedTextCompat$Params
 */
package androidx.core.text;

import androidx.core.text.PrecomputedTextCompat;
import java.util.concurrent.Callable;

/*
 * Exception performing whole class analysis ignored.
 */
private static class PrecomputedTextCompat.PrecomputedTextFutureTask.PrecomputedTextCallback
implements Callable<PrecomputedTextCompat> {
    private PrecomputedTextCompat.Params mParams;
    private CharSequence mText;

    PrecomputedTextCompat.PrecomputedTextFutureTask.PrecomputedTextCallback(PrecomputedTextCompat.Params params, CharSequence charSequence) {
        this.mParams = params;
        this.mText = charSequence;
    }

    @Override
    public PrecomputedTextCompat call() throws Exception {
        return PrecomputedTextCompat.create((CharSequence)this.mText, (PrecomputedTextCompat.Params)this.mParams);
    }
}
