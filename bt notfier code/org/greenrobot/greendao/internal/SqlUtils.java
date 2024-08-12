/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.greenrobot.greendao.DaoException
 *  org.greenrobot.greendao.Property
 */
package org.greenrobot.greendao.internal;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.Property;

public class SqlUtils {
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static StringBuilder appendColumn(StringBuilder stringBuilder, String string) {
        stringBuilder.append('\"');
        stringBuilder.append(string);
        stringBuilder.append('\"');
        return stringBuilder;
    }

    public static StringBuilder appendColumn(StringBuilder stringBuilder, String string, String string2) {
        stringBuilder.append(string);
        stringBuilder.append(".\"");
        stringBuilder.append(string2);
        stringBuilder.append('\"');
        return stringBuilder;
    }

    public static StringBuilder appendColumns(StringBuilder stringBuilder, String string, String[] stringArray) {
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            SqlUtils.appendColumn(stringBuilder, string, stringArray[n2]);
            if (n2 < n - 1) {
                stringBuilder.append(',');
            }
            ++n2;
        }
        return stringBuilder;
    }

    public static StringBuilder appendColumns(StringBuilder stringBuilder, String[] stringArray) {
        int n = stringArray.length;
        int n2 = 0;
        while (n2 < n) {
            stringBuilder.append('\"');
            stringBuilder.append(stringArray[n2]);
            stringBuilder.append('\"');
            if (n2 < n - 1) {
                stringBuilder.append(',');
            }
            ++n2;
        }
        return stringBuilder;
    }

    public static StringBuilder appendColumnsEqValue(StringBuilder stringBuilder, String string, String[] stringArray) {
        int n = 0;
        while (n < stringArray.length) {
            SqlUtils.appendColumn(stringBuilder, string, stringArray[n]).append("=?");
            if (n < stringArray.length - 1) {
                stringBuilder.append(',');
            }
            ++n;
        }
        return stringBuilder;
    }

    public static StringBuilder appendColumnsEqualPlaceholders(StringBuilder stringBuilder, String[] stringArray) {
        int n = 0;
        while (n < stringArray.length) {
            SqlUtils.appendColumn(stringBuilder, stringArray[n]).append("=?");
            if (n < stringArray.length - 1) {
                stringBuilder.append(',');
            }
            ++n;
        }
        return stringBuilder;
    }

    public static StringBuilder appendPlaceholders(StringBuilder stringBuilder, int n) {
        int n2 = 0;
        while (n2 < n) {
            if (n2 < n - 1) {
                stringBuilder.append("?,");
            } else {
                stringBuilder.append('?');
            }
            ++n2;
        }
        return stringBuilder;
    }

    public static StringBuilder appendProperty(StringBuilder stringBuilder, String string, Property property) {
        if (string != null) {
            stringBuilder.append(string);
            stringBuilder.append('.');
        }
        stringBuilder.append('\"');
        stringBuilder.append(property.columnName);
        stringBuilder.append('\"');
        return stringBuilder;
    }

    public static String createSqlCount(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SELECT COUNT(*) FROM \"");
        stringBuilder.append(string);
        stringBuilder.append('\"');
        return stringBuilder.toString();
    }

    public static String createSqlDelete(String charSequence, String[] stringArray) {
        CharSequence charSequence2 = new StringBuilder();
        charSequence2.append('\"');
        charSequence2.append((String)charSequence);
        charSequence2.append('\"');
        charSequence2 = charSequence2.toString();
        charSequence = new StringBuilder("DELETE FROM ");
        ((StringBuilder)charSequence).append((String)charSequence2);
        if (stringArray == null) return ((StringBuilder)charSequence).toString();
        if (stringArray.length <= 0) return ((StringBuilder)charSequence).toString();
        ((StringBuilder)charSequence).append(" WHERE ");
        SqlUtils.appendColumnsEqValue((StringBuilder)charSequence, (String)charSequence2, stringArray);
        return ((StringBuilder)charSequence).toString();
    }

    public static String createSqlInsert(String charSequence, String string, String[] stringArray) {
        charSequence = new StringBuilder((String)charSequence);
        ((StringBuilder)charSequence).append('\"');
        ((StringBuilder)charSequence).append(string);
        ((StringBuilder)charSequence).append('\"');
        ((StringBuilder)charSequence).append(" (");
        SqlUtils.appendColumns((StringBuilder)charSequence, stringArray);
        ((StringBuilder)charSequence).append(") VALUES (");
        SqlUtils.appendPlaceholders((StringBuilder)charSequence, stringArray.length);
        ((StringBuilder)charSequence).append(')');
        return ((StringBuilder)charSequence).toString();
    }

    public static String createSqlSelect(String string, String string2, String[] stringArray, boolean bl) {
        if (string2 == null) throw new DaoException("Table alias required");
        if (string2.length() < 0) throw new DaoException("Table alias required");
        CharSequence charSequence = bl ? "SELECT DISTINCT " : "SELECT ";
        charSequence = new StringBuilder((String)charSequence);
        SqlUtils.appendColumns((StringBuilder)charSequence, string2, stringArray).append(" FROM ");
        ((StringBuilder)charSequence).append('\"');
        ((StringBuilder)charSequence).append(string);
        ((StringBuilder)charSequence).append('\"');
        ((StringBuilder)charSequence).append(' ');
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(' ');
        return ((StringBuilder)charSequence).toString();
    }

    public static String createSqlSelectCountStar(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder("SELECT COUNT(*) FROM ");
        stringBuilder.append('\"');
        stringBuilder.append(string);
        stringBuilder.append('\"');
        stringBuilder.append(' ');
        if (string2 == null) return stringBuilder.toString();
        stringBuilder.append(string2);
        stringBuilder.append(' ');
        return stringBuilder.toString();
    }

    public static String createSqlUpdate(String charSequence, String[] stringArray, String[] stringArray2) {
        CharSequence charSequence2 = new StringBuilder();
        charSequence2.append('\"');
        charSequence2.append((String)charSequence);
        charSequence2.append('\"');
        charSequence2 = charSequence2.toString();
        charSequence = new StringBuilder("UPDATE ");
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append(" SET ");
        SqlUtils.appendColumnsEqualPlaceholders((StringBuilder)charSequence, stringArray);
        ((StringBuilder)charSequence).append(" WHERE ");
        SqlUtils.appendColumnsEqValue((StringBuilder)charSequence, (String)charSequence2, stringArray2);
        return ((StringBuilder)charSequence).toString();
    }

    public static String escapeBlobArgument(byte[] byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("X'");
        stringBuilder.append(SqlUtils.toHex(byArray));
        stringBuilder.append('\'');
        return stringBuilder.toString();
    }

    public static String toHex(byte[] byArray) {
        char[] cArray = new char[byArray.length * 2];
        int n = 0;
        while (n < byArray.length) {
            int n2 = byArray[n] & 0xFF;
            int n3 = n * 2;
            char[] cArray2 = HEX_ARRAY;
            cArray[n3] = cArray2[n2 >>> 4];
            cArray[n3 + 1] = cArray2[n2 & 0xF];
            ++n;
        }
        return new String(cArray);
    }
}
