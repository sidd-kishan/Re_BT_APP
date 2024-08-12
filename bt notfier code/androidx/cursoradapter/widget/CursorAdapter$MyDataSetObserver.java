/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.DataSetObserver
 *  androidx.cursoradapter.widget.CursorAdapter
 */
package androidx.cursoradapter.widget;

import android.database.DataSetObserver;
import androidx.cursoradapter.widget.CursorAdapter;

private class CursorAdapter.MyDataSetObserver
extends DataSetObserver {
    final CursorAdapter this$0;

    CursorAdapter.MyDataSetObserver(CursorAdapter cursorAdapter) {
        this.this$0 = cursorAdapter;
    }

    public void onChanged() {
        this.this$0.mDataValid = true;
        this.this$0.notifyDataSetChanged();
    }

    public void onInvalidated() {
        this.this$0.mDataValid = false;
        this.this$0.notifyDataSetInvalidated();
    }
}
