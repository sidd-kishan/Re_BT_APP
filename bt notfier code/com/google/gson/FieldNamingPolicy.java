/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson;

import com.google.gson.FieldNamingStrategy;
import java.lang.reflect.Field;
import java.util.Locale;

public abstract class FieldNamingPolicy
extends Enum<FieldNamingPolicy>
implements FieldNamingStrategy {
    private static final FieldNamingPolicy[] $VALUES;
    public static final /* enum */ FieldNamingPolicy IDENTITY;
    public static final /* enum */ FieldNamingPolicy LOWER_CASE_WITH_DASHES;
    public static final /* enum */ FieldNamingPolicy LOWER_CASE_WITH_DOTS;
    public static final /* enum */ FieldNamingPolicy LOWER_CASE_WITH_UNDERSCORES;
    public static final /* enum */ FieldNamingPolicy UPPER_CAMEL_CASE;
    public static final /* enum */ FieldNamingPolicy UPPER_CAMEL_CASE_WITH_SPACES;

    static {
        FieldNamingPolicy fieldNamingPolicy;
        IDENTITY = new FieldNamingPolicy(){

            @Override
            public String translateName(Field f) {
                return f.getName();
            }
        };
        UPPER_CAMEL_CASE = new FieldNamingPolicy(){

            @Override
            public String translateName(Field f) {
                return 2.upperCaseFirstLetter(f.getName());
            }
        };
        UPPER_CAMEL_CASE_WITH_SPACES = new FieldNamingPolicy(){

            @Override
            public String translateName(Field f) {
                return 3.upperCaseFirstLetter(3.separateCamelCase((String)f.getName(), (char)' '));
            }
        };
        LOWER_CASE_WITH_UNDERSCORES = new FieldNamingPolicy(){

            @Override
            public String translateName(Field f) {
                return 4.separateCamelCase((String)f.getName(), (char)'_').toUpperCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DASHES = new FieldNamingPolicy(){

            @Override
            public String translateName(Field f) {
                return 5.separateCamelCase((String)f.getName(), (char)'_').toLowerCase(Locale.ENGLISH);
            }
        };
        LOWER_CASE_WITH_DOTS = fieldNamingPolicy = new FieldNamingPolicy(){

            @Override
            public String translateName(Field f) {
                return 6.separateCamelCase((String)f.getName(), (char)'-').toLowerCase(Locale.ENGLISH);
            }
        };
        $VALUES = new FieldNamingPolicy[]{IDENTITY, UPPER_CAMEL_CASE, UPPER_CAMEL_CASE_WITH_SPACES, LOWER_CASE_WITH_UNDERSCORES, LOWER_CASE_WITH_DASHES, fieldNamingPolicy};
    }

    static String separateCamelCase(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = string.length();
        int n2 = 0;
        while (n2 < n) {
            char c = string.charAt(n2);
            if (Character.isUpperCase(c) && stringBuilder.length() != 0) {
                stringBuilder.append(string2);
            }
            stringBuilder.append(c);
            ++n2;
        }
        return stringBuilder.toString();
    }

    static String upperCaseFirstLetter(String string) {
        int n;
        int n2 = string.length();
        for (n = 0; !Character.isLetter(string.charAt(n)) && n < n2 - 1; ++n) {
        }
        char c = string.charAt(n);
        if (Character.isUpperCase(c)) {
            return string;
        }
        c = Character.toUpperCase(c);
        if (n == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(c);
            stringBuilder.append(string.substring(1));
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.substring(0, n));
        stringBuilder.append(c);
        stringBuilder.append(string.substring(n + 1));
        return stringBuilder.toString();
    }

    public static FieldNamingPolicy valueOf(String string) {
        return Enum.valueOf(FieldNamingPolicy.class, string);
    }

    public static FieldNamingPolicy[] values() {
        return (FieldNamingPolicy[])$VALUES.clone();
    }
}
