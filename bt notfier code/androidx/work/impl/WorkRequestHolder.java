/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.WorkRequest
 *  androidx.work.impl.model.WorkSpec
 */
package androidx.work.impl;

import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.util.Set;
import java.util.UUID;

public class WorkRequestHolder
extends WorkRequest {
    public WorkRequestHolder(UUID uUID, WorkSpec workSpec, Set<String> set) {
        super(uUID, workSpec, set);
    }
}
