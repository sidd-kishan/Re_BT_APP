/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.StateObservable$ErrorWrapper
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.StateObservable;

final class AutoValue_StateObservable_ErrorWrapper
extends StateObservable.ErrorWrapper {
    private final Throwable error;

    AutoValue_StateObservable_ErrorWrapper(Throwable throwable) {
        if (throwable == null) throw new NullPointerException("Null error");
        this.error = throwable;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof StateObservable.ErrorWrapper)) return false;
        object = (StateObservable.ErrorWrapper)object;
        return this.error.equals(object.getError());
    }

    public Throwable getError() {
        return this.error;
    }

    public int hashCode() {
        return this.error.hashCode() ^ 0xF4243;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ErrorWrapper{error=");
        stringBuilder.append(this.error);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
