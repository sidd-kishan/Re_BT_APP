/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.database.Database
 *  org.greenrobot.greendao.database.DatabaseStatement
 *  org.greenrobot.greendao.internal.SqlUtils
 */
package org.greenrobot.greendao.internal;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.SqlUtils;

public class TableStatements {
    private final String[] allColumns;
    private DatabaseStatement countStatement;
    private final Database db;
    private DatabaseStatement deleteStatement;
    private DatabaseStatement insertOrReplaceStatement;
    private DatabaseStatement insertStatement;
    private final String[] pkColumns;
    private volatile String selectAll;
    private volatile String selectByKey;
    private volatile String selectByRowId;
    private volatile String selectKeys;
    private final String tablename;
    private DatabaseStatement updateStatement;

    public TableStatements(Database database, String string, String[] stringArray, String[] stringArray2) {
        this.db = database;
        this.tablename = string;
        this.allColumns = stringArray;
        this.pkColumns = stringArray2;
    }

    public DatabaseStatement getCountStatement() {
        if (this.countStatement != null) return this.countStatement;
        String string = SqlUtils.createSqlCount((String)this.tablename);
        this.countStatement = this.db.compileStatement(string);
        return this.countStatement;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public DatabaseStatement getDeleteStatement() {
        if (this.deleteStatement != null) return this.deleteStatement;
        String string = SqlUtils.createSqlDelete((String)this.tablename, (String[])this.pkColumns);
        string = this.db.compileStatement(string);
        synchronized (this) {
            if (this.deleteStatement == null) {
                this.deleteStatement = string;
            }
        }
        if (this.deleteStatement == string) return this.deleteStatement;
        string.close();
        return this.deleteStatement;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public DatabaseStatement getInsertOrReplaceStatement() {
        if (this.insertOrReplaceStatement != null) return this.insertOrReplaceStatement;
        String string = SqlUtils.createSqlInsert((String)"INSERT OR REPLACE INTO ", (String)this.tablename, (String[])this.allColumns);
        string = this.db.compileStatement(string);
        synchronized (this) {
            if (this.insertOrReplaceStatement == null) {
                this.insertOrReplaceStatement = string;
            }
        }
        if (this.insertOrReplaceStatement == string) return this.insertOrReplaceStatement;
        string.close();
        return this.insertOrReplaceStatement;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public DatabaseStatement getInsertStatement() {
        if (this.insertStatement != null) return this.insertStatement;
        String string = SqlUtils.createSqlInsert((String)"INSERT INTO ", (String)this.tablename, (String[])this.allColumns);
        string = this.db.compileStatement(string);
        synchronized (this) {
            if (this.insertStatement == null) {
                this.insertStatement = string;
            }
        }
        if (this.insertStatement == string) return this.insertStatement;
        string.close();
        return this.insertStatement;
    }

    public String getSelectAll() {
        if (this.selectAll != null) return this.selectAll;
        this.selectAll = SqlUtils.createSqlSelect((String)this.tablename, (String)"T", (String[])this.allColumns, (boolean)false);
        return this.selectAll;
    }

    public String getSelectByKey() {
        if (this.selectByKey != null) return this.selectByKey;
        StringBuilder stringBuilder = new StringBuilder(this.getSelectAll());
        stringBuilder.append("WHERE ");
        SqlUtils.appendColumnsEqValue((StringBuilder)stringBuilder, (String)"T", (String[])this.pkColumns);
        this.selectByKey = stringBuilder.toString();
        return this.selectByKey;
    }

    public String getSelectByRowId() {
        if (this.selectByRowId != null) return this.selectByRowId;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getSelectAll());
        stringBuilder.append("WHERE ROWID=?");
        this.selectByRowId = stringBuilder.toString();
        return this.selectByRowId;
    }

    public String getSelectKeys() {
        if (this.selectKeys != null) return this.selectKeys;
        this.selectKeys = SqlUtils.createSqlSelect((String)this.tablename, (String)"T", (String[])this.pkColumns, (boolean)false);
        return this.selectKeys;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public DatabaseStatement getUpdateStatement() {
        if (this.updateStatement != null) return this.updateStatement;
        String string = SqlUtils.createSqlUpdate((String)this.tablename, (String[])this.allColumns, (String[])this.pkColumns);
        string = this.db.compileStatement(string);
        synchronized (this) {
            if (this.updateStatement == null) {
                this.updateStatement = string;
            }
        }
        if (this.updateStatement == string) return this.updateStatement;
        string.close();
        return this.updateStatement;
    }
}
