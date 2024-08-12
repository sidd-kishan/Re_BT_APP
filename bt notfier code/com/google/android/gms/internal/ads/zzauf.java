/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaub
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaub;
import java.io.IOException;

public class zzauf
extends IOException {
    public final zzaub zza;

    public zzauf(IOException iOException, zzaub zzaub2, int n) {
        super(iOException);
        this.zza = zzaub2;
    }

    public zzauf(String string, zzaub zzaub2, int n) {
        super(string);
        this.zza = zzaub2;
    }

    public zzauf(String string, IOException iOException, zzaub zzaub2, int n) {
        super(string, iOException);
        this.zza = zzaub2;
    }
}
