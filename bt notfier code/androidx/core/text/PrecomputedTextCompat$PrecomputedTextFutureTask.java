/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.core.text.PrecomputedTextCompat
 *  androidx.core.text.PrecomputedTextCompat$Params
 *  androidx.core.text.PrecomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback
 */
package androidx.core.text;

import androidx.core.text.PrecomputedTextCompat;
import java.util.concurrent.FutureTask;

private static class PrecomputedTextCompat.PrecomputedTextFutureTask
extends FutureTask<PrecomputedTextCompat> {
    PrecomputedTextCompat.PrecomputedTextFutureTask(PrecomputedTextCompat.Params params, CharSequence charSequence) {
        super(new PrecomputedTextCallback(params, charSequence));
    }
}
