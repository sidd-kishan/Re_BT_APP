/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.ContentObserver
 *  android.os.Handler
 *  androidx.cursoradapter.widget.CursorAdapter
 */
package androidx.cursoradapter.widget;

import android.database.ContentObserver;
import android.os.Handler;
import androidx.cursoradapter.widget.CursorAdapter;

private class CursorAdapter.ChangeObserver
extends ContentObserver {
    final CursorAdapter this$0;

    CursorAdapter.ChangeObserver(CursorAdapter cursorAdapter) {
        this.this$0 = cursorAdapter;
        super(new Handler());
    }

    public boolean deliverSelfNotifications() {
        return true;
    }

    public void onChange(boolean bl) {
        this.this$0.onContentChanged();
    }
}
