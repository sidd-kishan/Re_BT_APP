/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.room.RoomDatabase
 *  androidx.room.RoomDatabase$Builder
 */
package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;

public class Room {
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";
    static final String LOG_TAG = "ROOM";
    public static final String MASTER_TABLE_NAME = "room_master_table";

    @Deprecated
    public Room() {
    }

    public static <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(Context context, Class<T> clazz, String string) {
        if (string == null) throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        if (string.trim().length() == 0) throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
        return new RoomDatabase.Builder(context, clazz, string);
    }

    static <T, C> T getGeneratedImplementation(Class<C> clazz, String charSequence) {
        String string = clazz.getPackage().getName();
        String string2 = clazz.getCanonicalName();
        if (!string.isEmpty()) {
            string2 = string2.substring(string.length() + 1);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2.replace('.', '_'));
        stringBuilder.append((String)charSequence);
        string2 = stringBuilder.toString();
        try {
            if (string.isEmpty()) {
                charSequence = string2;
            } else {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string);
                ((StringBuilder)charSequence).append(".");
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
            }
            charSequence = Class.forName((String)charSequence).newInstance();
        }
        catch (InstantiationException instantiationException) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Failed to create an instance of ");
            stringBuilder2.append(clazz.getCanonicalName());
            throw new RuntimeException(stringBuilder2.toString());
        }
        catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Cannot access the constructor");
            stringBuilder3.append(clazz.getCanonicalName());
            throw new RuntimeException(stringBuilder3.toString());
        }
        catch (ClassNotFoundException classNotFoundException) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("cannot find implementation for ");
            stringBuilder4.append(clazz.getCanonicalName());
            stringBuilder4.append(". ");
            stringBuilder4.append(string2);
            stringBuilder4.append(" does not exist");
            throw new RuntimeException(stringBuilder4.toString());
        }
        return (T)charSequence;
    }

    public static <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(Context context, Class<T> clazz) {
        return new RoomDatabase.Builder(context, clazz, null);
    }
}
