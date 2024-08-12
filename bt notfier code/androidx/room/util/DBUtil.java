/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.AbstractWindowedCursor
 *  android.database.Cursor
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  androidx.room.RoomDatabase
 *  androidx.room.util.CursorUtil
 *  androidx.sqlite.db.SupportSQLiteDatabase
 *  androidx.sqlite.db.SupportSQLiteQuery
 */
package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.util.CursorUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.ArrayList;

public class DBUtil {
    private DBUtil() {
    }

    public static CancellationSignal createCancellationSignal() {
        if (Build.VERSION.SDK_INT < 16) return null;
        return new CancellationSignal();
    }

    public static void dropFtsSyncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        Object object = new ArrayList<String>();
        Object object2 = supportSQLiteDatabase.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        try {
            while (object2.moveToNext()) {
                object.add(object2.getString(0));
            }
        }
        finally {
            object2.close();
        }
        object = object.iterator();
        while (object.hasNext()) {
            String string = (String)object.next();
            if (!string.startsWith("room_fts_content_sync_")) continue;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("DROP TRIGGER IF EXISTS ");
            ((StringBuilder)object2).append(string);
            supportSQLiteDatabase.execSQL(((StringBuilder)object2).toString());
        }
    }

    @Deprecated
    public static Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean bl) {
        return DBUtil.query(roomDatabase, supportSQLiteQuery, bl, null);
    }

    public static Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean bl, CancellationSignal cancellationSignal) {
        supportSQLiteQuery = roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        roomDatabase = supportSQLiteQuery;
        if (!bl) return roomDatabase;
        roomDatabase = supportSQLiteQuery;
        if (!(supportSQLiteQuery instanceof AbstractWindowedCursor)) return roomDatabase;
        cancellationSignal = (AbstractWindowedCursor)supportSQLiteQuery;
        int n = cancellationSignal.getCount();
        int n2 = cancellationSignal.hasWindow() ? cancellationSignal.getWindow().getNumRows() : n;
        if (Build.VERSION.SDK_INT >= 23) {
            roomDatabase = supportSQLiteQuery;
            if (n2 >= n) return roomDatabase;
        }
        roomDatabase = CursorUtil.copyAndClose((Cursor)cancellationSignal);
        return roomDatabase;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public static int readVersion(File object) throws IOException {
        Object object2;
        Object object3;
        block3: {
            int n;
            object2 = object3 = null;
            try {
                ByteBuffer byteBuffer = ByteBuffer.allocate(4);
                object2 = object3;
                object2 = object3;
                FileInputStream fileInputStream = new FileInputStream((File)object);
                object2 = object3;
                object2 = object = fileInputStream.getChannel();
                ((FileChannel)object).tryLock(60L, 4L, true);
                object2 = object;
                ((FileChannel)object).position(60L);
                object2 = object;
                if (((FileChannel)object).read(byteBuffer) != 4) break block3;
                object2 = object;
                byteBuffer.rewind();
                object2 = object;
                n = byteBuffer.getInt();
                if (object == null) return n;
            }
            catch (Throwable throwable) {
                if (object2 == null) throw throwable;
                ((AbstractInterruptibleChannel)object2).close();
                throw throwable;
            }
            ((AbstractInterruptibleChannel)object).close();
            return n;
        }
        object2 = object;
        {
            object2 = object;
            object3 = new IOException("Bad database header, unable to read 4 bytes at offset 60");
            object2 = object;
            throw object3;
        }
    }
}
