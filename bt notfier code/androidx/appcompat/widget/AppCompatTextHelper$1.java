/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.os.Build$VERSION
 *  androidx.appcompat.widget.AppCompatTextHelper
 *  androidx.core.content.res.ResourcesCompat$FontCallback
 */
package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.os.Build;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.core.content.res.ResourcesCompat;
import java.lang.ref.WeakReference;

class AppCompatTextHelper.1
extends ResourcesCompat.FontCallback {
    final AppCompatTextHelper this$0;
    final int val$fontWeight;
    final int val$style;
    final WeakReference val$textViewWeak;

    AppCompatTextHelper.1(AppCompatTextHelper appCompatTextHelper, int n, int n2, WeakReference weakReference) {
        this.this$0 = appCompatTextHelper;
        this.val$fontWeight = n;
        this.val$style = n2;
        this.val$textViewWeak = weakReference;
    }

    public void onFontRetrievalFailed(int n) {
    }

    public void onFontRetrieved(Typeface typeface) {
        Typeface typeface2 = typeface;
        if (Build.VERSION.SDK_INT >= 28) {
            int n = this.val$fontWeight;
            typeface2 = typeface;
            if (n != -1) {
                boolean bl = (this.val$style & 2) != 0;
                typeface2 = Typeface.create((Typeface)typeface, (int)n, (boolean)bl);
            }
        }
        this.this$0.onAsyncTypefaceReceived(this.val$textViewWeak, typeface2);
    }
}
