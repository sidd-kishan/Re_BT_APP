/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Network
 *  android.net.Uri
 */
package androidx.work;

import android.net.Network;
import android.net.Uri;
import java.util.Collections;
import java.util.List;

public static class WorkerParameters.RuntimeExtras {
    public Network network;
    public List<String> triggeredContentAuthorities = Collections.emptyList();
    public List<Uri> triggeredContentUris = Collections.emptyList();
}
