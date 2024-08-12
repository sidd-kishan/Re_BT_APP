/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.tasks.Task
 */
package com.google.android.gms.tasks;

import com.google.android.gms.tasks.Task;

public final class DuplicateTaskCompletionException
extends IllegalStateException {
    private DuplicateTaskCompletionException(String string, Throwable throwable) {
        super(string, throwable);
    }

    public static IllegalStateException of(Task<?> object) {
        if (!object.isComplete()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception exception = object.getException();
        if (exception != null) {
            object = "failure";
        } else if (object.isSuccessful()) {
            object = String.valueOf(object.getResult());
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 7);
            stringBuilder.append("result ");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        } else {
            object = object.isCanceled() ? "cancellation" : "unknown issue";
        }
        object = String.valueOf(object);
        object = object.length() != 0 ? "Complete with: ".concat((String)object) : new String("Complete with: ");
        return new DuplicateTaskCompletionException((String)object, exception);
    }
}
