/*
 * Decompiled with CFR 0.152.
 */
package androidx.startup;

public final class StartupException
extends RuntimeException {
    public StartupException(String string) {
        super(string);
    }

    public StartupException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public StartupException(Throwable throwable) {
        super(throwable);
    }
}
