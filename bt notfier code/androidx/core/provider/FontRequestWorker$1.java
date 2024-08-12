/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.core.provider.FontRequest
 *  androidx.core.provider.FontRequestWorker
 *  androidx.core.provider.FontRequestWorker$TypefaceResult
 */
package androidx.core.provider;

import android.content.Context;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontRequestWorker;
import java.util.concurrent.Callable;

/*
 * Exception performing whole class analysis ignored.
 */
class FontRequestWorker.1
implements Callable<FontRequestWorker.TypefaceResult> {
    final Context val$context;
    final String val$id;
    final FontRequest val$request;
    final int val$style;

    FontRequestWorker.1(String string, Context context, FontRequest fontRequest, int n) {
        this.val$id = string;
        this.val$context = context;
        this.val$request = fontRequest;
        this.val$style = n;
    }

    @Override
    public FontRequestWorker.TypefaceResult call() {
        return FontRequestWorker.getFontSync((String)this.val$id, (Context)this.val$context, (FontRequest)this.val$request, (int)this.val$style);
    }
}
