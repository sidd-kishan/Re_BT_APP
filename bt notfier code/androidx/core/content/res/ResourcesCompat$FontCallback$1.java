/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  androidx.core.content.res.ResourcesCompat$FontCallback
 */
package androidx.core.content.res;

import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

class ResourcesCompat.FontCallback.1
implements Runnable {
    final ResourcesCompat.FontCallback this$0;
    final Typeface val$typeface;

    ResourcesCompat.FontCallback.1(ResourcesCompat.FontCallback fontCallback, Typeface typeface) {
        this.this$0 = fontCallback;
        this.val$typeface = typeface;
    }

    @Override
    public void run() {
        this.this$0.onFontRetrieved(this.val$typeface);
    }
}
