/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.orhanobut.logger.FormatStrategy
 *  com.orhanobut.logger.LogStrategy
 *  com.orhanobut.logger.Logger
 *  com.orhanobut.logger.LoggerPrinter
 *  com.orhanobut.logger.PrettyFormatStrategy$Builder
 *  com.orhanobut.logger.Utils
 */
package com.orhanobut.logger;

import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.LogStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.LoggerPrinter;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.orhanobut.logger.Utils;

public class PrettyFormatStrategy
implements FormatStrategy {
    private static final String BOTTOM_BORDER = "\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500";
    private static final char BOTTOM_LEFT_CORNER = '\u2514';
    private static final int CHUNK_SIZE = 4000;
    private static final String DOUBLE_DIVIDER = "\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500";
    private static final char HORIZONTAL_LINE = '\u2502';
    private static final String MIDDLE_BORDER = "\u251c\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504";
    private static final char MIDDLE_CORNER = '\u251c';
    private static final int MIN_STACK_OFFSET = 5;
    private static final String SINGLE_DIVIDER = "\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504\u2504";
    private static final String TOP_BORDER = "\u250c\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500";
    private static final char TOP_LEFT_CORNER = '\u250c';
    private final LogStrategy logStrategy;
    private final int methodCount;
    private final int methodOffset;
    private final boolean showThreadInfo;
    private final String tag;

    private PrettyFormatStrategy(Builder builder) {
        Utils.checkNotNull((Object)builder);
        this.methodCount = builder.methodCount;
        this.methodOffset = builder.methodOffset;
        this.showThreadInfo = builder.showThreadInfo;
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

    private String getSimpleClassName(String string) {
        Utils.checkNotNull((Object)string);
        return string.substring(string.lastIndexOf(".") + 1);
    }

    private int getStackOffset(StackTraceElement[] stackTraceElementArray) {
        Utils.checkNotNull((Object)stackTraceElementArray);
        int n = 5;
        while (n < stackTraceElementArray.length) {
            String string = stackTraceElementArray[n].getClassName();
            if (!string.equals(LoggerPrinter.class.getName()) && !string.equals(Logger.class.getName())) {
                return n - 1;
            }
            ++n;
        }
        return -1;
    }

    private void logBottomBorder(int n, String string) {
        this.logChunk(n, string, BOTTOM_BORDER);
    }

    private void logChunk(int n, String string, String string2) {
        Utils.checkNotNull((Object)string2);
        this.logStrategy.log(n, string, string2);
    }

    private void logContent(int n, String string, String stringArray) {
        Utils.checkNotNull((Object)stringArray);
        stringArray = stringArray.split(System.getProperty("line.separator"));
        int n2 = stringArray.length;
        int n3 = 0;
        while (n3 < n2) {
            String string2 = stringArray[n3];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\u2502 ");
            stringBuilder.append(string2);
            this.logChunk(n, string, stringBuilder.toString());
            ++n3;
        }
    }

    private void logDivider(int n, String string) {
        this.logChunk(n, string, MIDDLE_BORDER);
    }

    private void logHeaderContent(int n, String string, int n2) {
        CharSequence charSequence;
        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        if (this.showThreadInfo) {
            charSequence = new StringBuilder();
            charSequence.append("\u2502 Thread: ");
            charSequence.append(Thread.currentThread().getName());
            this.logChunk(n, string, charSequence.toString());
            this.logDivider(n, string);
        }
        int n3 = this.getStackOffset(stackTraceElementArray) + this.methodOffset;
        int n4 = n2;
        if (n2 + n3 > stackTraceElementArray.length) {
            n4 = stackTraceElementArray.length - n3 - 1;
        }
        charSequence = "";
        while (n4 > 0) {
            n2 = n4 + n3;
            if (n2 < stackTraceElementArray.length) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('\u2502');
                stringBuilder.append(' ');
                stringBuilder.append((String)charSequence);
                stringBuilder.append(this.getSimpleClassName(stackTraceElementArray[n2].getClassName()));
                stringBuilder.append(".");
                stringBuilder.append(stackTraceElementArray[n2].getMethodName());
                stringBuilder.append(" ");
                stringBuilder.append(" (");
                stringBuilder.append(stackTraceElementArray[n2].getFileName());
                stringBuilder.append(":");
                stringBuilder.append(stackTraceElementArray[n2].getLineNumber());
                stringBuilder.append(")");
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append((String)charSequence);
                stringBuilder2.append("   ");
                charSequence = stringBuilder2.toString();
                this.logChunk(n, string, stringBuilder.toString());
            }
            --n4;
        }
    }

    private void logTopBorder(int n, String string) {
        this.logChunk(n, string, TOP_BORDER);
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public void log(int n, String string, String string2) {
        Utils.checkNotNull((Object)string2);
        string = this.formatTag(string);
        this.logTopBorder(n, string);
        this.logHeaderContent(n, string, this.methodCount);
        byte[] byArray = string2.getBytes();
        int n2 = byArray.length;
        if (n2 <= 4000) {
            if (this.methodCount > 0) {
                this.logDivider(n, string);
            }
            this.logContent(n, string, string2);
            this.logBottomBorder(n, string);
            return;
        }
        if (this.methodCount > 0) {
            this.logDivider(n, string);
        }
        int n3 = 0;
        while (true) {
            if (n3 >= n2) {
                this.logBottomBorder(n, string);
                return;
            }
            this.logContent(n, string, new String(byArray, n3, Math.min(n2 - n3, 4000)));
            n3 += 4000;
        }
    }
}
