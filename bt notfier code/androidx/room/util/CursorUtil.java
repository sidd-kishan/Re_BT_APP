/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.database.MatrixCursor
 */
package androidx.room.util;

import android.database.Cursor;
import android.database.MatrixCursor;

public class CursorUtil {
    private CursorUtil() {
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public static Cursor copyAndClose(Cursor cursor) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objectArray = new Object[cursor.getColumnCount()];
                for (int i = 0; i < cursor.getColumnCount(); ++i) {
                    int n = cursor.getType(i);
                    if (n != 0) {
                        if (n != 1) {
                            if (n != 2) {
                                if (n != 3) {
                                    if (n != 4) {
                                        IllegalStateException illegalStateException = new IllegalStateException();
                                        throw illegalStateException;
                                    }
                                    objectArray[i] = cursor.getBlob(i);
                                    continue;
                                }
                                objectArray[i] = cursor.getString(i);
                                continue;
                            }
                            objectArray[i] = cursor.getDouble(i);
                            continue;
                        }
                        objectArray[i] = cursor.getLong(i);
                        continue;
                    }
                    objectArray[i] = null;
                }
                matrixCursor.addRow(objectArray);
            }
            return matrixCursor;
        }
        finally {
            cursor.close();
        }
    }

    public static int getColumnIndex(Cursor cursor, String string) {
        int n = cursor.getColumnIndex(string);
        if (n >= 0) {
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("`");
        stringBuilder.append(string);
        stringBuilder.append("`");
        return cursor.getColumnIndex(stringBuilder.toString());
    }

    public static int getColumnIndexOrThrow(Cursor cursor, String string) {
        int n = cursor.getColumnIndex(string);
        if (n >= 0) {
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("`");
        stringBuilder.append(string);
        stringBuilder.append("`");
        return cursor.getColumnIndexOrThrow(stringBuilder.toString());
    }
}
