/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.UserHandle
 */
package androidx.core.os;

import android.os.UserHandle;

private static class UserHandleCompat.Api24Impl {
    private UserHandleCompat.Api24Impl() {
    }

    static UserHandle getUserHandleForUid(int n) {
        return UserHandle.getUserHandleForUid((int)n);
    }
}
