/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzia
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzia;
import java.io.IOException;

public class zzib
extends IOException {
    public zzib(String string) {
        super(string);
    }

    static zzib zza() {
        return new zzib("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzib zzb() {
        return new zzib("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzib zzc() {
        return new zzib("Protocol message contained an invalid tag (zero).");
    }

    static zzia zzd() {
        return new zzia("Protocol message tag had invalid wire type.");
    }

    static zzib zze() {
        return new zzib("Failed to parse the message.");
    }

    static zzib zzf() {
        return new zzib("Protocol message had invalid UTF-8.");
    }
}
