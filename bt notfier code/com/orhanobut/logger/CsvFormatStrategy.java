/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.orhanobut.logger.CsvFormatStrategy$Builder
 *  com.orhanobut.logger.FormatStrategy
 *  com.orhanobut.logger.LogStrategy
 *  com.orhanobut.logger.Utils
 */
package com.orhanobut.logger;

import com.orhanobut.logger.CsvFormatStrategy;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.LogStrategy;
import com.orhanobut.logger.Utils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CsvFormatStrategy
implements FormatStrategy {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static final String NEW_LINE_REPLACEMENT = " <br> ";
    private static final String SEPARATOR = ",";
    private final Date date;
    private final SimpleDateFormat dateFormat;
    private final LogStrategy logStrategy;
    private final String tag;

    private CsvFormatStrategy(Builder builder) {
        Utils.checkNotNull((Object)builder);
        this.date = builder.date;
        this.dateFormat = builder.dateFormat;
        this.logStrategy = builder.logStrategy;
        this.tag = builder.tag;
    }

    private String formatTag(String string) {
        if (Utils.isEmpty((CharSequence)string)) return this.tag;
        if (Utils.equals((CharSequence)this.tag, (CharSequence)string)) return this.tag;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.tag);
        stringBuilder.append("-");
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public void log(int n, String string, String string2) {
        Utils.checkNotNull((Object)string2);
        String string3 = this.formatTag(string);
        this.date.setTime(System.currentTimeMillis());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Long.toString(this.date.getTime()));
        stringBuilder.append(SEPARATOR);
        stringBuilder.append(this.dateFormat.format(this.date));
        stringBuilder.append(SEPARATOR);
        stringBuilder.append(Utils.logLevel((int)n));
        stringBuilder.append(SEPARATOR);
        stringBuilder.append(string3);
        string = string2;
        if (string2.contains(NEW_LINE)) {
            string = string2.replaceAll(NEW_LINE, NEW_LINE_REPLACEMENT);
        }
        stringBuilder.append(SEPARATOR);
        stringBuilder.append(string);
        stringBuilder.append(NEW_LINE);
        this.logStrategy.log(n, string3, stringBuilder.toString());
    }
}
