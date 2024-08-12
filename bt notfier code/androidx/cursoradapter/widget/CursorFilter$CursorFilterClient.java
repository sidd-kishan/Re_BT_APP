/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 */
package androidx.cursoradapter.widget;

import android.database.Cursor;

static interface CursorFilter.CursorFilterClient {
    public void changeCursor(Cursor var1);

    public CharSequence convertToString(Cursor var1);

    public Cursor getCursor();

    public Cursor runQueryOnBackgroundThread(CharSequence var1);
}
