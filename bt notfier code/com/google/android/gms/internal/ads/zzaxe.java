/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public abstract class zzaxe {
    private static MessageDigest zzb;
    protected final Object zza = new Object();

    abstract byte[] zza(String var1);

    /*
     * Unable to fully structure code
     */
    protected final MessageDigest zzb() {
        var2_1 = this.zza;
        synchronized (var2_1) {
            block10: {
                if (zzaxe.zzb != null) {
                    var3_2 = zzaxe.zzb;
                    return var3_2;
                }
                var1_6 = 0;
lbl8:
                // 2 sources

                while (var1_6 < 2) {
                    zzaxe.zzb = MessageDigest.getInstance("MD5");
                    break block9;
                }
                break block10;
                {
                    block9: {
                        catch (Throwable var3_5) {
                            throw var3_5;
                        }
                    }
lbl16:
                    // 2 sources

                    while (true) {
                        ++var1_6;
                        ** GOTO lbl8
                        break;
                    }
                }
                catch (NoSuchAlgorithmException var3_3) {
                    ** continue;
                }
            }
            var3_4 = zzaxe.zzb;
            return var3_4;
        }
    }
}
