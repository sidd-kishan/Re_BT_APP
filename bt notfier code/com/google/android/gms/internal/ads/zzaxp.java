/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzaxd
 *  com.google.android.gms.internal.ads.zzaxe
 *  com.google.android.gms.internal.ads.zzaxg
 *  com.google.android.gms.internal.ads.zzaxi
 *  com.google.android.gms.internal.ads.zzaxn
 *  com.google.android.gms.internal.ads.zzaxo
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzaxd;
import com.google.android.gms.internal.ads.zzaxe;
import com.google.android.gms.internal.ads.zzaxg;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzaxn;
import com.google.android.gms.internal.ads.zzaxo;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;

public final class zzaxp {
    private final zzaxe zza;
    private final int zzb;
    private String zzc;
    private final int zzd;

    public zzaxp(int n, int n2, int n3) {
        block3: {
            block2: {
                this.zzb = n;
                if (n2 > 64) break block2;
                n = n2;
                if (n2 >= 0) break block3;
            }
            n = 64;
        }
        this.zzd = n3 <= 0 ? 1 : n3;
        this.zza = new zzaxn(n);
    }

    public final String zza(ArrayList<String> zzaxg2, ArrayList<zzaxd> object) {
        Object object2;
        Collections.sort(object, new zzaxo(this));
        HashSet<Object> hashSet = new HashSet<Object>();
        block2: for (int i = 0; i < ((ArrayList)object).size(); ++i) {
            String[] stringArray = Normalizer.normalize((CharSequence)zzaxg2.get(((ArrayList)object).get(i).zze()), Normalizer.Form.NFKC).toLowerCase(Locale.US).split("\n");
            if (stringArray.length == 0) continue;
            int n = 0;
            while (true) {
                int n2;
                int n3;
                int n4;
                if (n >= stringArray.length) continue block2;
                String[] stringArray2 = stringArray[n];
                Object object3 = stringArray2;
                if (stringArray2.contains("'")) {
                    int n5;
                    object2 = new StringBuilder((String)stringArray2);
                    n4 = 1;
                    n3 = 0;
                    while ((n5 = n4 + 2) <= ((StringBuilder)object2).length()) {
                        n2 = n4;
                        if (((StringBuilder)object2).charAt(n4) == '\'') {
                            if (!(((StringBuilder)object2).charAt(n4 - 1) == ' ' || ((StringBuilder)object2).charAt(n3 = n4 + 1) != 's' && ((StringBuilder)object2).charAt(n3) != 'S' || n5 != ((StringBuilder)object2).length() && ((StringBuilder)object2).charAt(n5) != ' ')) {
                                ((StringBuilder)object2).insert(n4, ' ');
                                n4 = n5;
                            } else {
                                ((StringBuilder)object2).setCharAt(n4, ' ');
                            }
                            n3 = 1;
                            n2 = n4;
                        }
                        n4 = n2 + 1;
                    }
                    object2 = n3 != 0 ? ((StringBuilder)object2).toString() : null;
                    object3 = stringArray2;
                    if (object2 != null) {
                        this.zzc = object2;
                        object3 = object2;
                    }
                }
                if ((stringArray2 = zzaxi.zzb((String)object3, (boolean)true)).length >= this.zzd) {
                    block5: for (n4 = 0; n4 < stringArray2.length; ++n4) {
                        object2 = "";
                        for (n3 = 0; n3 < this.zzd; ++n3) {
                            n2 = n4 + n3;
                            if (n2 >= stringArray2.length) break block5;
                            object3 = object2;
                            if (n3 > 0) {
                                object3 = String.valueOf(object2).concat(" ");
                            }
                            object3 = String.valueOf(object3);
                            object2 = String.valueOf(stringArray2[n2]);
                            object2 = ((String)object2).length() != 0 ? ((String)object3).concat((String)object2) : new String((String)object3);
                        }
                        hashSet.add(object2);
                        if (hashSet.size() >= this.zzb) break block2;
                    }
                    if (hashSet.size() >= this.zzb) break block2;
                }
                ++n;
            }
        }
        zzaxg2 = new zzaxg();
        object = hashSet.iterator();
        while (object.hasNext()) {
            object2 = (String)object.next();
            try {
                object2 = this.zza.zza((String)object2);
                zzaxg2.zzb.write((byte[])object2);
            }
            catch (IOException iOException) {
                zze.zzg((String)"Error while writing hash to byteStream", (Throwable)iOException);
                break;
            }
        }
        return zzaxg2.toString();
    }
}
