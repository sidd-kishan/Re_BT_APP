/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.api.internal.StatusExceptionMapper
 *  com.google.firebase.FirebaseApiNotAvailableException
 *  com.google.firebase.FirebaseException
 */
package com.google.firebase;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseException;

public class FirebaseExceptionMapper
implements StatusExceptionMapper {
    public final Exception getException(Status status) {
        if (status.getStatusCode() != 8) return new FirebaseApiNotAvailableException(status.zza());
        return new FirebaseException(status.zza());
    }
}
