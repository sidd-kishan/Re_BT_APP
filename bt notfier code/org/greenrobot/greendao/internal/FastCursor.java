/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.CharArrayBuffer
 *  android.database.ContentObserver
 *  android.database.Cursor
 *  android.database.CursorWindow
 *  android.database.DataSetObserver
 *  android.net.Uri
 *  android.os.Bundle
 */
package org.greenrobot.greendao.internal;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public final class FastCursor
implements Cursor {
    private final int count;
    private int position;
    private final CursorWindow window;

    public FastCursor(CursorWindow cursorWindow) {
        this.window = cursorWindow;
        this.count = cursorWindow.getNumRows();
    }

    public void close() {
        throw new UnsupportedOperationException();
    }

    public void copyStringToBuffer(int n, CharArrayBuffer charArrayBuffer) {
        throw new UnsupportedOperationException();
    }

    public void deactivate() {
        throw new UnsupportedOperationException();
    }

    public byte[] getBlob(int n) {
        return this.window.getBlob(this.position, n);
    }

    public int getColumnCount() {
        throw new UnsupportedOperationException();
    }

    public int getColumnIndex(String string) {
        throw new UnsupportedOperationException();
    }

    public int getColumnIndexOrThrow(String string) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public String getColumnName(int n) {
        throw new UnsupportedOperationException();
    }

    public String[] getColumnNames() {
        throw new UnsupportedOperationException();
    }

    public int getCount() {
        return this.window.getNumRows();
    }

    public double getDouble(int n) {
        return this.window.getDouble(this.position, n);
    }

    public Bundle getExtras() {
        throw new UnsupportedOperationException();
    }

    public float getFloat(int n) {
        return this.window.getFloat(this.position, n);
    }

    public int getInt(int n) {
        return this.window.getInt(this.position, n);
    }

    public long getLong(int n) {
        return this.window.getLong(this.position, n);
    }

    public Uri getNotificationUri() {
        return null;
    }

    public int getPosition() {
        return this.position;
    }

    public short getShort(int n) {
        return this.window.getShort(this.position, n);
    }

    public String getString(int n) {
        return this.window.getString(this.position, n);
    }

    public int getType(int n) {
        throw new UnsupportedOperationException();
    }

    public boolean getWantsAllOnMoveCalls() {
        throw new UnsupportedOperationException();
    }

    public boolean isAfterLast() {
        throw new UnsupportedOperationException();
    }

    public boolean isBeforeFirst() {
        throw new UnsupportedOperationException();
    }

    public boolean isClosed() {
        throw new UnsupportedOperationException();
    }

    public boolean isFirst() {
        boolean bl = this.position == 0;
        return bl;
    }

    public boolean isLast() {
        int n = this.position;
        int n2 = this.count;
        boolean bl = true;
        if (n == n2 - 1) return bl;
        bl = false;
        return bl;
    }

    public boolean isNull(int n) {
        return this.window.isNull(this.position, n);
    }

    public boolean move(int n) {
        return this.moveToPosition(this.position + n);
    }

    public boolean moveToFirst() {
        boolean bl = false;
        this.position = 0;
        if (this.count <= 0) return bl;
        bl = true;
        return bl;
    }

    public boolean moveToLast() {
        int n = this.count;
        if (n <= 0) return false;
        this.position = n - 1;
        return true;
    }

    public boolean moveToNext() {
        int n = this.position;
        if (n >= this.count - 1) return false;
        this.position = n + 1;
        return true;
    }

    public boolean moveToPosition(int n) {
        if (n < 0) return false;
        if (n >= this.count) return false;
        this.position = n;
        return true;
    }

    public boolean moveToPrevious() {
        int n = this.position;
        if (n <= 0) return false;
        this.position = n - 1;
        return true;
    }

    public void registerContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }

    public boolean requery() {
        throw new UnsupportedOperationException();
    }

    public Bundle respond(Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        throw new UnsupportedOperationException();
    }

    public void unregisterContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }
}
