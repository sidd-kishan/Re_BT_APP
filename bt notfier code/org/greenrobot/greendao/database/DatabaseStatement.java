/*
 * Decompiled with CFR 0.152.
 */
package org.greenrobot.greendao.database;

public interface DatabaseStatement {
    public void bindBlob(int var1, byte[] var2);

    public void bindDouble(int var1, double var2);

    public void bindLong(int var1, long var2);

    public void bindNull(int var1);

    public void bindString(int var1, String var2);

    public void clearBindings();

    public void close();

    public void execute();

    public long executeInsert();

    public Object getRawStatement();

    public long simpleQueryForLong();
}
