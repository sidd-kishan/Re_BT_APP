/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzit
 *  com.google.android.gms.internal.measurement.zziw
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzit;
import com.google.android.gms.internal.measurement.zziw;

final class zzjg
implements zzit {
    private final zziw zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    zzjg(zziw object, String object2, Object[] object3) {
        IllegalStateException illegalStateException;
        char[] cArray;
        block13: {
            block14: {
                int n;
                this.zza = object;
                this.zzb = object2;
                this.zzc = object3;
                int n2 = 1;
                try {
                    n = ((String)object2).charAt(0);
                }
                catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
                    cArray = ((String)object2).toCharArray();
                    object3 = new String(cArray);
                    try {
                        n = ((String)object3).charAt(0);
                        object2 = object3;
                    }
                    catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException2) {
                        try {
                            object = new char[((String)object3).length()];
                            ((String)object3).getChars(0, ((String)object3).length(), (char[])object, 0);
                            object2 = new String((char[])object);
                        }
                        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                            break block13;
                        }
                        catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException3) {
                            // empty catch block
                            break block13;
                        }
                        try {
                            n = ((String)object2).charAt(0);
                        }
                        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                            break block14;
                        }
                        catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException4) {
                            // empty catch block
                            break block14;
                        }
                    }
                }
                if (n < 55296) {
                    this.zzd = n;
                    return;
                }
                int n3 = n & 0x1FFF;
                int n4 = 13;
                n = n2;
                n2 = n4;
                while (true) {
                    if ((n4 = (int)((String)object2).charAt(n)) < 55296) {
                        this.zzd = n4 << n2 | n3;
                        return;
                    }
                    n3 |= (n4 & 0x1FFF) << n2;
                    n2 += 13;
                    ++n;
                }
            }
            object3 = object2;
        }
        illegalStateException = new IllegalStateException(String.format("Failed parsing '%s' with charArray.length of %d", object3, cArray.length), illegalStateException);
        throw illegalStateException;
    }

    public final boolean zza() {
        if ((this.zzd & 2) != 2) return false;
        return true;
    }

    public final zziw zzb() {
        return this.zza;
    }

    public final int zzc() {
        if ((this.zzd & 1) != 1) return 2;
        return 1;
    }

    final String zzd() {
        return this.zzb;
    }

    final Object[] zze() {
        return this.zzc;
    }
}
