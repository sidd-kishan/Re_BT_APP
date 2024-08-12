/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.CompositeException$PrintStreamOrWriter
 */
package io.reactivex.exceptions;

import io.reactivex.exceptions.CompositeException;
import java.io.PrintStream;

static final class CompositeException.WrappedPrintStream
extends CompositeException.PrintStreamOrWriter {
    private final PrintStream printStream;

    CompositeException.WrappedPrintStream(PrintStream printStream) {
        this.printStream = printStream;
    }

    void println(Object object) {
        this.printStream.println(object);
    }
}
