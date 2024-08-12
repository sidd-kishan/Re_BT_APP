/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package androidx.core.database;

import android.text.TextUtils;

@Deprecated
public final class DatabaseUtilsCompat {
    private DatabaseUtilsCompat() {
    }

    @Deprecated
    public static String[] appendSelectionArgs(String[] stringArray, String[] stringArray2) {
        if (stringArray == null) return stringArray2;
        if (stringArray.length == 0) {
            return stringArray2;
        }
        String[] stringArray3 = new String[stringArray.length + stringArray2.length];
        System.arraycopy(stringArray, 0, stringArray3, 0, stringArray.length);
        System.arraycopy(stringArray2, 0, stringArray3, stringArray.length, stringArray2.length);
        return stringArray3;
    }

    @Deprecated
    public static String concatenateWhere(String string, String string2) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return string2;
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(string);
        stringBuilder.append(") AND (");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
