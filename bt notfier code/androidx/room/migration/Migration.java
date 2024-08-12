/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.sqlite.db.SupportSQLiteDatabase
 */
package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;

public abstract class Migration {
    public final int endVersion;
    public final int startVersion;

    public Migration(int n, int n2) {
        this.startVersion = n;
        this.endVersion = n2;
    }

    public abstract void migrate(SupportSQLiteDatabase var1);
}
