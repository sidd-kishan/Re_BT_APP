/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package kotlin;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0000\u001a\u000f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0087\b\u00a8\u0006\u0003"}, d2={"hashCode", "", "", "kotlin-stdlib"}, k=2, mv={1, 5, 1})
public final class HashCodeKt {
    private static final int hashCode(Object object) {
        int n = object != null ? object.hashCode() : 0;
        return n;
    }
}
