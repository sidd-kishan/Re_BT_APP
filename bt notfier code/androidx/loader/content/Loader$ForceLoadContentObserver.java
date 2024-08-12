/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.ContentObserver
 *  android.os.Handler
 *  androidx.loader.content.Loader
 */
package androidx.loader.content;

import android.database.ContentObserver;
import android.os.Handler;
import androidx.loader.content.Loader;

public final class Loader.ForceLoadContentObserver
extends ContentObserver {
    final Loader this$0;

    public Loader.ForceLoadContentObserver(Loader loader) {
        this.this$0 = loader;
        super(new Handler());
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean bl) {
        this.this$0.onContentChanged();
    }
}
