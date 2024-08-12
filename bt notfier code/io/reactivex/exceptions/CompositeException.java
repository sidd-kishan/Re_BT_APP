/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.CompositeException$CompositeExceptionCausalChain
 *  io.reactivex.exceptions.CompositeException$PrintStreamOrWriter
 *  io.reactivex.exceptions.CompositeException$WrappedPrintStream
 *  io.reactivex.exceptions.CompositeException$WrappedPrintWriter
 */
package io.reactivex.exceptions;

import io.reactivex.exceptions.CompositeException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class CompositeException
extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List<Throwable> exceptions;
    private final String message;

    public CompositeException(Iterable<? extends Throwable> object) {
        LinkedHashSet<Throwable> linkedHashSet = new LinkedHashSet<Throwable>();
        ArrayList<Throwable> arrayList = new ArrayList<Throwable>();
        if (object == null) {
            linkedHashSet.add(new NullPointerException("errors was null"));
        } else {
            object = object.iterator();
            while (object.hasNext()) {
                Throwable throwable = (Throwable)object.next();
                if (throwable instanceof CompositeException) {
                    linkedHashSet.addAll(((CompositeException)throwable).getExceptions());
                    continue;
                }
                if (throwable != null) {
                    linkedHashSet.add(throwable);
                    continue;
                }
                linkedHashSet.add(new NullPointerException("Throwable was null!"));
            }
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            this.exceptions = Collections.unmodifiableList(arrayList);
            object = new StringBuilder();
            ((StringBuilder)object).append(this.exceptions.size());
            ((StringBuilder)object).append(" exceptions occurred. ");
            this.message = ((StringBuilder)object).toString();
            return;
        }
        object = new IllegalArgumentException("errors is empty");
        throw object;
    }

    public CompositeException(Throwable ... object) {
        object = object == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(object);
        this((Iterable<? extends Throwable>)object);
    }

    private void appendStackTrace(StringBuilder stringBuilder, Throwable throwable, String stackTraceElementArray) {
        stringBuilder.append((String)stackTraceElementArray);
        stringBuilder.append(throwable);
        stringBuilder.append('\n');
        stackTraceElementArray = throwable.getStackTrace();
        int n = stackTraceElementArray.length;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                if (throwable.getCause() == null) return;
                stringBuilder.append("\tCaused by: ");
                this.appendStackTrace(stringBuilder, throwable.getCause(), "");
                return;
            }
            StackTraceElement stackTraceElement = stackTraceElementArray[n2];
            stringBuilder.append("\t\tat ");
            stringBuilder.append(stackTraceElement);
            stringBuilder.append('\n');
            ++n2;
        }
    }

    private List<Throwable> getListOfCauses(Throwable throwable) {
        ArrayList<Throwable> arrayList = new ArrayList<Throwable>();
        Throwable throwable2 = throwable.getCause();
        if (throwable2 == null) return arrayList;
        Throwable throwable3 = throwable2;
        if (throwable2 == throwable) return arrayList;
        while (true) {
            arrayList.add(throwable3);
            throwable = throwable3.getCause();
            if (throwable == null) return arrayList;
            if (throwable == throwable3) return arrayList;
            throwable3 = throwable;
        }
    }

    private void printStackTrace(PrintStreamOrWriter printStreamOrWriter) {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(this);
        stringBuilder.append('\n');
        for (StackTraceElement stackTraceElement : this.getStackTrace()) {
            stringBuilder.append("\tat ");
            stringBuilder.append(stackTraceElement);
            stringBuilder.append('\n');
        }
        Iterator<Throwable> iterator = this.exceptions.iterator();
        int n = 1;
        while (true) {
            if (!iterator.hasNext()) {
                printStreamOrWriter.println((Object)stringBuilder.toString());
                return;
            }
            Throwable throwable = iterator.next();
            stringBuilder.append("  ComposedException ");
            stringBuilder.append(n);
            stringBuilder.append(" :\n");
            this.appendStackTrace(stringBuilder, throwable, "\t");
            ++n;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    @Override
    public Throwable getCause() {
        synchronized (this) {
            if (this.cause != null) return this.cause;
            CompositeExceptionCausalChain compositeExceptionCausalChain = new CompositeExceptionCausalChain();
            HashSet<Throwable> hashSet = new HashSet<Throwable>();
            Iterator<Throwable> iterator = this.exceptions.iterator();
            Throwable throwable = compositeExceptionCausalChain;
            while (true) {
                Iterator<Throwable> iterator2;
                Throwable throwable2;
                if (iterator.hasNext()) {
                    throwable2 = iterator.next();
                    if (hashSet.contains(throwable2)) continue;
                    hashSet.add(throwable2);
                    iterator2 = this.getListOfCauses(throwable2).iterator();
                } else {
                    this.cause = compositeExceptionCausalChain;
                    return this.cause;
                }
                while (iterator2.hasNext()) {
                    Throwable throwable3 = iterator2.next();
                    if (hashSet.contains(throwable3)) {
                        throwable2 = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                        continue;
                    }
                    hashSet.add(throwable3);
                }
                try {
                    throwable.initCause(throwable2);
                }
                catch (Throwable throwable4) {}
                throwable = this.getRootCause(throwable);
            }
        }
    }

    public List<Throwable> getExceptions() {
        return this.exceptions;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    Throwable getRootCause(Throwable throwable) {
        Throwable throwable2 = throwable.getCause();
        if (throwable2 == null) return throwable;
        Throwable throwable3 = throwable2;
        if (throwable == throwable2) {
            return throwable;
        }
        while ((throwable = throwable3.getCause()) != null) {
            if (throwable == throwable3) {
                return throwable3;
            }
            throwable3 = throwable;
        }
        return throwable3;
    }

    @Override
    public void printStackTrace() {
        this.printStackTrace(System.err);
    }

    @Override
    public void printStackTrace(PrintStream printStream) {
        this.printStackTrace((PrintStreamOrWriter)new WrappedPrintStream(printStream));
    }

    @Override
    public void printStackTrace(PrintWriter printWriter) {
        this.printStackTrace((PrintStreamOrWriter)new WrappedPrintWriter(printWriter));
    }

    public int size() {
        return this.exceptions.size();
    }
}
