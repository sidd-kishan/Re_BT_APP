/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.widget.Filter
 *  android.widget.Filter$FilterResults
 *  androidx.cursoradapter.widget.CursorFilter$CursorFilterClient
 */
package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;
import androidx.cursoradapter.widget.CursorFilter;

class CursorFilter
extends Filter {
    CursorFilterClient mClient;

    CursorFilter(CursorFilterClient cursorFilterClient) {
        this.mClient = cursorFilterClient;
    }

    public CharSequence convertResultToString(Object object) {
        return this.mClient.convertToString((Cursor)object);
    }

    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        charSequence = this.mClient.runQueryOnBackgroundThread(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (charSequence != null) {
            filterResults.count = charSequence.getCount();
            filterResults.values = charSequence;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        charSequence = this.mClient.getCursor();
        if (filterResults.values == null) return;
        if (filterResults.values == charSequence) return;
        this.mClient.changeCursor((Cursor)filterResults.values);
    }
}
