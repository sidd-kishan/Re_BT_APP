/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.sqlite.db.SimpleSQLiteQuery
 *  androidx.sqlite.db.SupportSQLiteQuery
 */
package androidx.sqlite.db;

import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.util.regex.Pattern;

public final class SupportSQLiteQueryBuilder {
    private static final Pattern sLimitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private Object[] mBindArgs;
    private String[] mColumns = null;
    private boolean mDistinct = false;
    private String mGroupBy = null;
    private String mHaving = null;
    private String mLimit = null;
    private String mOrderBy = null;
    private String mSelection;
    private final String mTable;

    private SupportSQLiteQueryBuilder(String string) {
        this.mTable = string;
    }

    private static void appendClause(StringBuilder stringBuilder, String string, String string2) {
        if (SupportSQLiteQueryBuilder.isEmpty(string2)) return;
        stringBuilder.append(string);
        stringBuilder.append(string2);
    }

    private static void appendColumns(StringBuilder stringBuilder, String[] stringArray) {
        int n = stringArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                stringBuilder.append(' ');
                return;
            }
            String string = stringArray[n2];
            if (n2 > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(string);
            ++n2;
        }
    }

    public static SupportSQLiteQueryBuilder builder(String string) {
        return new SupportSQLiteQueryBuilder(string);
    }

    private static boolean isEmpty(String string) {
        boolean bl = string == null || string.length() == 0;
        return bl;
    }

    public SupportSQLiteQueryBuilder columns(String[] stringArray) {
        this.mColumns = stringArray;
        return this;
    }

    public SupportSQLiteQuery create() {
        String[] stringArray;
        if (SupportSQLiteQueryBuilder.isEmpty(this.mGroupBy)) {
            if (!SupportSQLiteQueryBuilder.isEmpty(this.mHaving)) throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        }
        StringBuilder stringBuilder = new StringBuilder(120);
        stringBuilder.append("SELECT ");
        if (this.mDistinct) {
            stringBuilder.append("DISTINCT ");
        }
        if ((stringArray = this.mColumns) != null && stringArray.length != 0) {
            SupportSQLiteQueryBuilder.appendColumns(stringBuilder, stringArray);
        } else {
            stringBuilder.append(" * ");
        }
        stringBuilder.append(" FROM ");
        stringBuilder.append(this.mTable);
        SupportSQLiteQueryBuilder.appendClause(stringBuilder, " WHERE ", this.mSelection);
        SupportSQLiteQueryBuilder.appendClause(stringBuilder, " GROUP BY ", this.mGroupBy);
        SupportSQLiteQueryBuilder.appendClause(stringBuilder, " HAVING ", this.mHaving);
        SupportSQLiteQueryBuilder.appendClause(stringBuilder, " ORDER BY ", this.mOrderBy);
        SupportSQLiteQueryBuilder.appendClause(stringBuilder, " LIMIT ", this.mLimit);
        return new SimpleSQLiteQuery(stringBuilder.toString(), this.mBindArgs);
    }

    public SupportSQLiteQueryBuilder distinct() {
        this.mDistinct = true;
        return this;
    }

    public SupportSQLiteQueryBuilder groupBy(String string) {
        this.mGroupBy = string;
        return this;
    }

    public SupportSQLiteQueryBuilder having(String string) {
        this.mHaving = string;
        return this;
    }

    public SupportSQLiteQueryBuilder limit(String string) {
        if (!SupportSQLiteQueryBuilder.isEmpty(string) && !sLimitPattern.matcher(string).matches()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid LIMIT clauses:");
            stringBuilder.append(string);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.mLimit = string;
        return this;
    }

    public SupportSQLiteQueryBuilder orderBy(String string) {
        this.mOrderBy = string;
        return this;
    }

    public SupportSQLiteQueryBuilder selection(String string, Object[] objectArray) {
        this.mSelection = string;
        this.mBindArgs = objectArray;
        return this;
    }
}
