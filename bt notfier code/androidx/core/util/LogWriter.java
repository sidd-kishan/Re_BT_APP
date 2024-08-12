/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.core.util;

import android.util.Log;
import java.io.Writer;

@Deprecated
public class LogWriter
extends Writer {
    private StringBuilder mBuilder = new StringBuilder(128);
    private final String mTag;

    public LogWriter(String string) {
        this.mTag = string;
    }

    private void flushBuilder() {
        if (this.mBuilder.length() <= 0) return;
        Log.d((String)this.mTag, (String)this.mBuilder.toString());
        StringBuilder stringBuilder = this.mBuilder;
        stringBuilder.delete(0, stringBuilder.length());
    }

    @Override
    public void close() {
        this.flushBuilder();
    }

    @Override
    public void flush() {
        this.flushBuilder();
    }

    @Override
    public void write(char[] cArray, int n, int n2) {
        int n3 = 0;
        while (n3 < n2) {
            char c = cArray[n + n3];
            if (c == '\n') {
                this.flushBuilder();
            } else {
                this.mBuilder.append(c);
            }
            ++n3;
        }
    }
}
