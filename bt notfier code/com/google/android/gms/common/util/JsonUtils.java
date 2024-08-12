/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.common.util.zzc
 */
package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.util.zzc;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class JsonUtils {
    private static final Pattern zza = Pattern.compile("\\\\.");
    private static final Pattern zzb = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    private JsonUtils() {
    }

    /*
     * Exception decompiling
     */
    public static boolean areJsonValuesEquivalent(Object var0, Object var1_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[DOLOOP]], but top level block is 0[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static String escapeString(String string) {
        CharSequence charSequence = string;
        if (TextUtils.isEmpty((CharSequence)string)) return charSequence;
        Matcher matcher = zzb.matcher(string);
        CharSequence charSequence2 = null;
        block5: while (matcher.find()) {
            char c;
            charSequence = charSequence2;
            if (charSequence2 == null) {
                charSequence = new StringBuffer();
            }
            if ((c = matcher.group().charAt(0)) != '\f') {
                if (c != '\r') {
                    if (c != '\"') {
                        if (c != '/') {
                            if (c != '\\') {
                                switch (c) {
                                    default: {
                                        charSequence2 = charSequence;
                                        continue block5;
                                    }
                                    case '\n': {
                                        matcher.appendReplacement((StringBuffer)charSequence, "\\\\n");
                                        charSequence2 = charSequence;
                                        continue block5;
                                    }
                                    case '\t': {
                                        matcher.appendReplacement((StringBuffer)charSequence, "\\\\t");
                                        charSequence2 = charSequence;
                                        continue block5;
                                    }
                                    case '\b': 
                                }
                                matcher.appendReplacement((StringBuffer)charSequence, "\\\\b");
                                charSequence2 = charSequence;
                                continue;
                            }
                            matcher.appendReplacement((StringBuffer)charSequence, "\\\\\\\\");
                            charSequence2 = charSequence;
                            continue;
                        }
                        matcher.appendReplacement((StringBuffer)charSequence, "\\\\/");
                        charSequence2 = charSequence;
                        continue;
                    }
                    matcher.appendReplacement((StringBuffer)charSequence, "\\\\\\\"");
                    charSequence2 = charSequence;
                    continue;
                }
                matcher.appendReplacement((StringBuffer)charSequence, "\\\\r");
                charSequence2 = charSequence;
                continue;
            }
            matcher.appendReplacement((StringBuffer)charSequence, "\\\\f");
            charSequence2 = charSequence;
        }
        if (charSequence2 == null) {
            return string;
        }
        matcher.appendTail((StringBuffer)charSequence2);
        charSequence = charSequence2.toString();
        return charSequence;
    }

    public static String unescapeString(String string) {
        CharSequence charSequence = string;
        if (TextUtils.isEmpty((CharSequence)string)) return charSequence;
        String string2 = zzc.zza((String)string);
        Matcher matcher = zza.matcher(string2);
        string = null;
        while (matcher.find()) {
            char c;
            charSequence = string;
            if (string == null) {
                charSequence = new StringBuffer();
            }
            if ((c = matcher.group().charAt(1)) != '\"') {
                if (c != '/') {
                    if (c != '\\') {
                        if (c != 'b') {
                            if (c != 'f') {
                                if (c != 'n') {
                                    if (c != 'r') {
                                        if (c != 't') throw new IllegalStateException("Found an escaped character that should never be.");
                                        matcher.appendReplacement((StringBuffer)charSequence, "\t");
                                        string = charSequence;
                                        continue;
                                    }
                                    matcher.appendReplacement((StringBuffer)charSequence, "\r");
                                    string = charSequence;
                                    continue;
                                }
                                matcher.appendReplacement((StringBuffer)charSequence, "\n");
                                string = charSequence;
                                continue;
                            }
                            matcher.appendReplacement((StringBuffer)charSequence, "\f");
                            string = charSequence;
                            continue;
                        }
                        matcher.appendReplacement((StringBuffer)charSequence, "\b");
                        string = charSequence;
                        continue;
                    }
                    matcher.appendReplacement((StringBuffer)charSequence, "\\\\");
                    string = charSequence;
                    continue;
                }
                matcher.appendReplacement((StringBuffer)charSequence, "/");
                string = charSequence;
                continue;
            }
            matcher.appendReplacement((StringBuffer)charSequence, "\"");
            string = charSequence;
        }
        if (string == null) {
            return string2;
        }
        matcher.appendTail((StringBuffer)((Object)string));
        charSequence = ((StringBuffer)((Object)string)).toString();
        return charSequence;
    }
}
