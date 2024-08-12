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

public static final class ListenableWorker.Result.Retry
extends ListenableWorker.Result {
    public boolean equals(Object object) {
        boolean bl = true;
        if (this == object) {
            return true;
        }
        if (object != null && ((Object)((Object)this)).getClass() == object.getClass()) return bl;
        bl = false;
        return bl;
    }

    public Data getOutputData() {
        return Data.EMPTY;
    }

    public int hashCode() {
        return 25945934;
    }

    public String toString() {
        return "Retry";
    }
}
