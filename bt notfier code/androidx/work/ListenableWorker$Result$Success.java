/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.Data
 *  androidx.work.ListenableWorker$Result
 */
package androidx.work;

import androidx.work.Data;
import androidx.work.ListenableWorker;

public static final class ListenableWorker.Result.Success
extends ListenableWorker.Result {
    private final Data mOutputData;

    public ListenableWorker.Result.Success() {
        this(Data.EMPTY);
    }

    public ListenableWorker.Result.Success(Data data) {
        this.mOutputData = data;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (((Object)((Object)this)).getClass() != object.getClass()) {
            return false;
        }
        object = (ListenableWorker.Result.Success)((Object)object);
        return this.mOutputData.equals((Object)((ListenableWorker.Result.Success)((Object)object)).mOutputData);
    }

    public Data getOutputData() {
        return this.mOutputData;
    }

    public int hashCode() {
        return -1876823561 + this.mOutputData.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Success {mOutputData=");
        stringBuilder.append(this.mOutputData);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
