/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.sqlite.db.SupportSQLiteProgram
 */
package androidx.sqlite.db;

import androidx.sqlite.db.SupportSQLiteProgram;

public interface SupportSQLiteStatement
extends SupportSQLiteProgram {
    public void execute();

    public long executeInsert();

    public int executeUpdateDelete();

    public long simpleQueryForLong();

    public String simpleQueryForString();
}
