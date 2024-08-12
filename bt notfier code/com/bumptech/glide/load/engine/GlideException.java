/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.bumptech.glide.load.DataSource
 *  com.bumptech.glide.load.Key
 *  com.bumptech.glide.load.engine.GlideException$IndentedAppendable
 */
package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.GlideException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class GlideException
extends Exception {
    private static final StackTraceElement[] EMPTY_ELEMENTS = new StackTraceElement[0];
    private static final long serialVersionUID = 1L;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private Key key;

    public GlideException(String string) {
        this(string, Collections.emptyList());
    }

    public GlideException(String string, Throwable throwable) {
        this(string, Collections.singletonList(throwable));
    }

    public GlideException(String string, List<Throwable> list) {
        this.detailMessage = string;
        this.setStackTrace(EMPTY_ELEMENTS);
        this.causes = list;
    }

    private void addRootCauses(Throwable object, List<Throwable> list) {
        if (!(object instanceof GlideException)) {
            list.add((Throwable)object);
            return;
        }
        object = ((GlideException)object).getCauses().iterator();
        while (object.hasNext()) {
            this.addRootCauses((Throwable)object.next(), list);
        }
    }

    private static void appendCauses(List<Throwable> list, Appendable appendable) {
        try {
            GlideException.appendCausesWrapped(list, appendable);
            return;
        }
        catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
    }

    private static void appendCausesWrapped(List<Throwable> list, Appendable appendable) throws IOException {
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            Object object = appendable.append("Cause (");
            int n3 = n2 + 1;
            object.append(String.valueOf(n3)).append(" of ").append(String.valueOf(n)).append("): ");
            object = list.get(n2);
            if (object instanceof GlideException) {
                ((GlideException)object).printStackTrace(appendable);
            } else {
                GlideException.appendExceptionMessage((Throwable)object, appendable);
            }
            n2 = n3;
        }
    }

    private static void appendExceptionMessage(Throwable throwable, Appendable appendable) {
        try {
            appendable.append(throwable.getClass().toString()).append(": ").append(throwable.getMessage()).append('\n');
            return;
        }
        catch (IOException iOException) {
            throw new RuntimeException(throwable);
        }
    }

    private void printStackTrace(Appendable appendable) {
        GlideException.appendExceptionMessage(this, appendable);
        GlideException.appendCauses(this.getCauses(), (Appendable)new IndentedAppendable(appendable));
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    @Override
    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder(71);
        stringBuilder.append(this.detailMessage);
        Iterator iterator = this.dataClass;
        Object object = "";
        if (iterator != null) {
            iterator = new StringBuilder();
            ((StringBuilder)((Object)iterator)).append(", ");
            ((StringBuilder)((Object)iterator)).append(this.dataClass);
            iterator = ((StringBuilder)((Object)iterator)).toString();
        } else {
            iterator = "";
        }
        stringBuilder.append((String)((Object)iterator));
        if (this.dataSource != null) {
            iterator = new StringBuilder();
            ((StringBuilder)((Object)iterator)).append(", ");
            ((StringBuilder)((Object)iterator)).append(this.dataSource);
            iterator = ((StringBuilder)((Object)iterator)).toString();
        } else {
            iterator = "";
        }
        stringBuilder.append((String)((Object)iterator));
        iterator = object;
        if (this.key != null) {
            iterator = new StringBuilder();
            ((StringBuilder)((Object)iterator)).append(", ");
            ((StringBuilder)((Object)iterator)).append(this.key);
            iterator = ((StringBuilder)((Object)iterator)).toString();
        }
        stringBuilder.append((String)((Object)iterator));
        iterator = this.getRootCauses();
        if (iterator.isEmpty()) {
            return stringBuilder.toString();
        }
        if (iterator.size() == 1) {
            stringBuilder.append("\nThere was 1 cause:");
        } else {
            stringBuilder.append("\nThere were ");
            stringBuilder.append(iterator.size());
            stringBuilder.append(" causes:");
        }
        iterator = iterator.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                stringBuilder.append("\n call GlideException#logRootCauses(String) for more detail");
                return stringBuilder.toString();
            }
            object = (Throwable)iterator.next();
            stringBuilder.append('\n');
            stringBuilder.append(object.getClass().getName());
            stringBuilder.append('(');
            stringBuilder.append(((Throwable)object).getMessage());
            stringBuilder.append(')');
        }
    }

    public List<Throwable> getRootCauses() {
        ArrayList<Throwable> arrayList = new ArrayList<Throwable>();
        this.addRootCauses(this, arrayList);
        return arrayList;
    }

    public void logRootCauses(String string) {
        List<Throwable> list = this.getRootCauses();
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Root cause (");
            int n3 = n2 + 1;
            stringBuilder.append(n3);
            stringBuilder.append(" of ");
            stringBuilder.append(n);
            stringBuilder.append(")");
            Log.i((String)string, (String)stringBuilder.toString(), (Throwable)list.get(n2));
            n2 = n3;
        }
    }

    @Override
    public void printStackTrace() {
        this.printStackTrace(System.err);
    }

    @Override
    public void printStackTrace(PrintStream printStream) {
        this.printStackTrace((Appendable)printStream);
    }

    @Override
    public void printStackTrace(PrintWriter printWriter) {
        this.printStackTrace((Appendable)printWriter);
    }

    void setLoggingDetails(Key key, DataSource dataSource) {
        this.setLoggingDetails(key, dataSource, null);
    }

    void setLoggingDetails(Key key, DataSource dataSource, Class<?> clazz) {
        this.key = key;
        this.dataSource = dataSource;
        this.dataClass = clazz;
    }
}
