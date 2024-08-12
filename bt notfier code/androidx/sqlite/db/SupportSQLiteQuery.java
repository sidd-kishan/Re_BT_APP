/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.sqlite.db.SupportSQLiteProgram
 */
package androidx.sqlite.db;

import androidx.sqlite.db.SupportSQLiteProgram;

public interface SupportSQLiteQuery {
    public void bindTo(SupportSQLiteProgram var1);

    public int getArgCount();

    public String getSql();
}
