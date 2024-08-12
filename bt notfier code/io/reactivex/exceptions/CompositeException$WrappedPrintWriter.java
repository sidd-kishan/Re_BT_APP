/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.CompositeException$PrintStreamOrWriter
 */
package io.reactivex.exceptions;

import io.reactivex.exceptions.CompositeException;
import java.io.PrintWriter;

static final class CompositeException.WrappedPrintWriter
extends CompositeException.PrintStreamOrWriter {
    private final PrintWriter printWriter;

    CompositeException.WrappedPrintWriter(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    void println(Object object) {
        this.printWriter.println(object);
    }
}
