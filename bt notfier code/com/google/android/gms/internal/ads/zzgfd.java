/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgel
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfc
 *  com.google.android.gms.internal.ads.zzgfj
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgft
 *  com.google.android.gms.internal.ads.zzggb
 *  com.google.android.gms.internal.ads.zzggk
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzggs
 *  com.google.android.gms.internal.ads.zzggx
 *  com.google.android.gms.internal.ads.zzght
 *  com.google.android.gms.internal.ads.zzghz
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgel;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfc;
import com.google.android.gms.internal.ads.zzgfj;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgft;
import com.google.android.gms.internal.ads.zzggb;
import com.google.android.gms.internal.ads.zzggk;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzggs;
import com.google.android.gms.internal.ads.zzggx;
import com.google.android.gms.internal.ads.zzght;
import com.google.android.gms.internal.ads.zzghz;
import java.io.IOException;
import java.util.List;

final class zzgfd
implements zzght {
    private final zzgfc zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzgfd(zzgfc zzgfc2) {
        zzggk.zzb((Object)zzgfc2, (String)"input");
        this.zza = zzgfc2;
        zzgfc2.zzc = this;
    }

    private final void zzP(int n) throws IOException {
        if ((this.zzb & 7) != n) throw zzggm.zzi();
    }

    private final <T> T zzQ(zzghz<T> zzgfc2, zzgfm zzgfm2) throws IOException {
        int n = this.zza.zzo();
        Object object = this.zza;
        if (object.zza >= object.zzb) throw new zzggm("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        n = object.zzz(n);
        object = zzgfc2.zza();
        zzgfc zzgfc3 = this.zza;
        ++zzgfc3.zza;
        zzgfc2.zzf(object, (zzght)this, zzgfm2);
        zzgfc2.zzj(object);
        this.zza.zzb(0);
        zzgfc2 = this.zza;
        --zzgfc2.zza;
        zzgfc2.zzA(n);
        return (T)object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    private final <T> T zzR(zzghz<T> zzghz2, zzgfm zzgfm2) throws IOException {
        Object object;
        int n = this.zzc;
        this.zzc = this.zzb >>> 3 << 3 | 4;
        try {
            object = zzghz2.zza();
            zzghz2.zzf(object, (zzght)this, zzgfm2);
            zzghz2.zzj(object);
            int n2 = this.zzb;
            int n3 = this.zzc;
            if (n2 != n3) throw zzggm.zzk();
            this.zzc = n;
        }
        catch (Throwable throwable) {
            this.zzc = n;
            throw throwable;
        }
        return (T)object;
    }

    private final void zzS(int n) throws IOException {
        if (this.zza.zzC() != n) throw zzggm.zzd();
    }

    private static final void zzT(int n) throws IOException {
        if ((n & 3) != 0) throw zzggm.zzk();
    }

    private static final void zzU(int n) throws IOException {
        if ((n & 7) != 0) throw zzggm.zzk();
    }

    public static zzgfd zza(zzgfc zzgfc2) {
        zzgfd zzgfd2 = zzgfc2.zzc;
        if (zzgfd2 == null) return new zzgfd(zzgfc2);
        return zzgfd2;
    }

    public final void zzA(List<Long> zzggx2) throws IOException {
        int n;
        if (!(zzggx2 instanceof zzggx)) {
            n = this.zzb & 7;
            if (n != 0) {
                if (n != 2) throw zzggm.zzi();
                n = this.zza.zzo();
                n = this.zza.zzC() + n;
                do {
                    zzggx2.add(this.zza.zzg());
                } while (this.zza.zzC() < n);
                this.zzS(n);
                return;
            }
        } else {
            zzggx2 = zzggx2;
            int n2 = this.zzb & 7;
            if (n2 != 0) {
                if (n2 != 2) throw zzggm.zzi();
                n2 = this.zza.zzo();
                n2 = this.zza.zzC() + n2;
                do {
                    zzggx2.zzg(this.zza.zzg());
                } while (this.zza.zzC() < n2);
                this.zzS(n2);
                return;
            }
            do {
                zzggx2.zzg(this.zza.zzg());
                if (!this.zza.zzB()) continue;
                return;
            } while ((n2 = this.zza.zza()) == this.zzb);
            this.zzd = n2;
            return;
        }
        do {
            zzggx2.add(this.zza.zzg());
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }

    public final void zzB(List<Integer> zzggb2) throws IOException {
        int n;
        if (!(zzggb2 instanceof zzggb)) {
            n = this.zzb & 7;
            if (n != 0) {
                if (n != 2) throw zzggm.zzi();
                n = this.zza.zzo();
                n = this.zza.zzC() + n;
                do {
                    zzggb2.add(this.zza.zzh());
                } while (this.zza.zzC() < n);
                this.zzS(n);
                return;
            }
        } else {
            zzggb2 = zzggb2;
            int n2 = this.zzb & 7;
            if (n2 != 0) {
                if (n2 != 2) throw zzggm.zzi();
                n2 = this.zza.zzo();
                n2 = this.zza.zzC() + n2;
                do {
                    zzggb2.zzh(this.zza.zzh());
                } while (this.zza.zzC() < n2);
                this.zzS(n2);
                return;
            }
            do {
                zzggb2.zzh(this.zza.zzh());
                if (!this.zza.zzB()) continue;
                return;
            } while ((n2 = this.zza.zza()) == this.zzb);
            this.zzd = n2;
            return;
        }
        do {
            zzggb2.add(this.zza.zzh());
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }

    public final void zzC(List<Long> zzggx2) throws IOException {
        int n;
        block9: {
            int n2;
            block7: {
                block8: {
                    block6: {
                        if (!(zzggx2 instanceof zzggx)) break block6;
                        zzggx2 = zzggx2;
                        n2 = this.zzb & 7;
                        if (n2 == 1) break block7;
                        if (n2 != 2) throw zzggm.zzi();
                        n2 = this.zza.zzo();
                        zzgfd.zzU(n2);
                        int n3 = this.zza.zzC();
                        do {
                            zzggx2.zzg(this.zza.zzi());
                        } while (this.zza.zzC() < n3 + n2);
                        break block8;
                    }
                    n = this.zzb & 7;
                    if (n == 1) break block9;
                    if (n != 2) throw zzggm.zzi();
                    n = this.zza.zzo();
                    zzgfd.zzU(n);
                    int n4 = this.zza.zzC();
                    do {
                        zzggx2.add(this.zza.zzi());
                    } while (this.zza.zzC() < n4 + n);
                }
                return;
            }
            do {
                zzggx2.zzg(this.zza.zzi());
                if (!this.zza.zzB()) continue;
                return;
            } while ((n2 = this.zza.zza()) == this.zzb);
            this.zzd = n2;
            return;
        }
        do {
            zzggx2.add(this.zza.zzi());
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }

    public final void zzD(List<Integer> zzggb2) throws IOException {
        int n;
        block9: {
            int n2;
            block7: {
                block8: {
                    block6: {
                        if (!(zzggb2 instanceof zzggb)) break block6;
                        zzggb2 = zzggb2;
                        n2 = this.zzb & 7;
                        if (n2 != 2) break block7;
                        n2 = this.zza.zzo();
                        zzgfd.zzT(n2);
                        int n3 = this.zza.zzC();
                        do {
                            zzggb2.zzh(this.zza.zzj());
                        } while (this.zza.zzC() < n3 + n2);
                        break block8;
                    }
                    n = this.zzb & 7;
                    if (n != 2) break block9;
                    int n4 = this.zza.zzo();
                    zzgfd.zzT(n4);
                    n = this.zza.zzC();
                    do {
                        zzggb2.add(this.zza.zzj());
                    } while (this.zza.zzC() < n + n4);
                }
                return;
            }
            if (n2 != 5) throw zzggm.zzi();
            do {
                zzggb2.zzh(this.zza.zzj());
                if (!this.zza.zzB()) continue;
                return;
            } while ((n2 = this.zza.zza()) == this.zzb);
            this.zzd = n2;
            return;
        }
        if (n != 5) throw zzggm.zzi();
        do {
            zzggb2.add(this.zza.zzj());
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }

    public final void zzE(List<Boolean> zzgel2) throws IOException {
        int n;
        if (!(zzgel2 instanceof zzgel)) {
            n = this.zzb & 7;
            if (n != 0) {
                if (n != 2) throw zzggm.zzi();
                n = this.zza.zzo();
                n = this.zza.zzC() + n;
                do {
                    zzgel2.add(this.zza.zzk());
                } while (this.zza.zzC() < n);
                this.zzS(n);
                return;
            }
        } else {
            zzgel2 = zzgel2;
            int n2 = this.zzb & 7;
            if (n2 != 0) {
                if (n2 != 2) throw zzggm.zzi();
                n2 = this.zza.zzo();
                n2 = this.zza.zzC() + n2;
                do {
                    zzgel2.zzd(this.zza.zzk());
                } while (this.zza.zzC() < n2);
                this.zzS(n2);
                return;
            }
            do {
                zzgel2.zzd(this.zza.zzk());
                if (!this.zza.zzB()) continue;
                return;
            } while ((n2 = this.zza.zza()) == this.zzb);
            this.zzd = n2;
            return;
        }
        do {
            zzgel2.add(this.zza.zzk());
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }

    public final void zzF(List<String> zzggl2, boolean bl) throws IOException {
        int n;
        if ((this.zzb & 7) != 2) {
            zzggl2 = zzggm.zzi();
            throw zzggl2;
        }
        if (zzggl2 instanceof zzggs && !bl) {
            int n2;
            zzggl2 = (zzggs)zzggl2;
            do {
                zzggl2.zzf(this.zzq());
                if (!this.zza.zzB()) continue;
                return;
            } while ((n2 = this.zza.zza()) == this.zzb);
            this.zzd = n2;
            return;
        }
        do {
            String string = bl ? this.zzn() : this.zzm();
            zzggl2.add(string);
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }

    public final <T> void zzG(List<T> zzggl2, zzghz<T> zzghz2, zzgfm zzgfm2) throws IOException {
        int n;
        int n2 = this.zzb;
        if ((n2 & 7) != 2) {
            zzggl2 = zzggm.zzi();
            throw zzggl2;
        }
        do {
            zzggl2.add(this.zzQ(zzghz2, zzgfm2));
            if (this.zza.zzB()) return;
            if (this.zzd != 0) return;
        } while ((n = this.zza.zza()) == n2);
        this.zzd = n;
    }

    public final <T> void zzH(List<T> zzggl2, zzghz<T> zzghz2, zzgfm zzgfm2) throws IOException {
        int n;
        int n2 = this.zzb;
        if ((n2 & 7) != 3) {
            zzggl2 = zzggm.zzi();
            throw zzggl2;
        }
        do {
            zzggl2.add(this.zzR(zzghz2, zzgfm2));
            if (this.zza.zzB()) return;
            if (this.zzd != 0) return;
        } while ((n = this.zza.zza()) == n2);
        this.zzd = n;
    }

    public final void zzI(List<zzgex> zzggl2) throws IOException {
        int n;
        if ((this.zzb & 7) != 2) {
            zzggl2 = zzggm.zzi();
            throw zzggl2;
        }
        do {
            zzggl2.add(this.zzq());
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }

    public final void zzJ(List<Integer> zzggb2) throws IOException {
        int n;
        if (!(zzggb2 instanceof zzggb)) {
            n = this.zzb & 7;
            if (n != 0) {
                if (n != 2) throw zzggm.zzi();
                n = this.zza.zzo();
                n = this.zza.zzC() + n;
                do {
                    zzggb2.add(this.zza.zzo());
                } while (this.zza.zzC() < n);
                this.zzS(n);
                return;
            }
        } else {
            zzggb2 = zzggb2;
            int n2 = this.zzb & 7;
            if (n2 != 0) {
                if (n2 != 2) throw zzggm.zzi();
                n2 = this.zza.zzo();
                n2 = this.zza.zzC() + n2;
                do {
                    zzggb2.zzh(this.zza.zzo());
                } while (this.zza.zzC() < n2);
                this.zzS(n2);
                return;
            }
            do {
                zzggb2.zzh(this.zza.zzo());
                if (!this.zza.zzB()) continue;
                return;
            } while ((n2 = this.zza.zza()) == this.zzb);
            this.zzd = n2;
            return;
        }
        do {
            zzggb2.add(this.zza.zzo());
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }

    public final void zzK(List<Integer> zzggb2) throws IOException {
        int n;
        if (!(zzggb2 instanceof zzggb)) {
            n = this.zzb & 7;
            if (n != 0) {
                if (n != 2) throw zzggm.zzi();
                n = this.zza.zzo();
                n = this.zza.zzC() + n;
                do {
                    zzggb2.add(this.zza.zzp());
                } while (this.zza.zzC() < n);
                this.zzS(n);
                return;
            }
        } else {
            zzggb2 = zzggb2;
            int n2 = this.zzb & 7;
            if (n2 != 0) {
                if (n2 != 2) throw zzggm.zzi();
                n2 = this.zza.zzo();
                n2 = this.zza.zzC() + n2;
                do {
                    zzggb2.zzh(this.zza.zzp());
                } while (this.zza.zzC() < n2);
                this.zzS(n2);
                return;
            }
            do {
                zzggb2.zzh(this.zza.zzp());
                if (!this.zza.zzB()) continue;
                return;
            } while ((n2 = this.zza.zza()) == this.zzb);
            this.zzd = n2;
            return;
        }
        do {
            zzggb2.add(this.zza.zzp());
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }

    public final void zzL(List<Integer> zzggb2) throws IOException {
        int n;
        block9: {
            int n2;
            block7: {
                block8: {
                    block6: {
                        if (!(zzggb2 instanceof zzggb)) break block6;
                        zzggb2 = zzggb2;
                        n2 = this.zzb & 7;
                        if (n2 != 2) break block7;
                        int n3 = this.zza.zzo();
                        zzgfd.zzT(n3);
                        n2 = this.zza.zzC();
                        do {
                            zzggb2.zzh(this.zza.zzq());
                        } while (this.zza.zzC() < n2 + n3);
                        break block8;
                    }
                    n = this.zzb & 7;
                    if (n != 2) break block9;
                    int n4 = this.zza.zzo();
                    zzgfd.zzT(n4);
                    n = this.zza.zzC();
                    do {
                        zzggb2.add(this.zza.zzq());
                    } while (this.zza.zzC() < n + n4);
                }
                return;
            }
            if (n2 != 5) throw zzggm.zzi();
            do {
                zzggb2.zzh(this.zza.zzq());
                if (!this.zza.zzB()) continue;
                return;
            } while ((n2 = this.zza.zza()) == this.zzb);
            this.zzd = n2;
            return;
        }
        if (n != 5) throw zzggm.zzi();
        do {
            zzggb2.add(this.zza.zzq());
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }

    public final void zzM(List<Long> zzggx2) throws IOException {
        int n;
        block9: {
            int n2;
            block7: {
                block8: {
                    block6: {
                        if (!(zzggx2 instanceof zzggx)) break block6;
                        zzggx2 = zzggx2;
                        n2 = this.zzb & 7;
                        if (n2 == 1) break block7;
                        if (n2 != 2) throw zzggm.zzi();
                        n2 = this.zza.zzo();
                        zzgfd.zzU(n2);
                        int n3 = this.zza.zzC();
                        do {
                            zzggx2.zzg(this.zza.zzr());
                        } while (this.zza.zzC() < n3 + n2);
                        break block8;
                    }
                    n = this.zzb & 7;
                    if (n == 1) break block9;
                    if (n != 2) throw zzggm.zzi();
                    n = this.zza.zzo();
                    zzgfd.zzU(n);
                    int n4 = this.zza.zzC();
                    do {
                        zzggx2.add(this.zza.zzr());
                    } while (this.zza.zzC() < n4 + n);
                }
                return;
            }
            do {
                zzggx2.zzg(this.zza.zzr());
                if (!this.zza.zzB()) continue;
                return;
            } while ((n2 = this.zza.zza()) == this.zzb);
            this.zzd = n2;
            return;
        }
        do {
            zzggx2.add(this.zza.zzr());
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }

    public final void zzN(List<Integer> zzggb2) throws IOException {
        int n;
        if (!(zzggb2 instanceof zzggb)) {
            n = this.zzb & 7;
            if (n != 0) {
                if (n != 2) throw zzggm.zzi();
                n = this.zza.zzo();
                n = this.zza.zzC() + n;
                do {
                    zzggb2.add(this.zza.zzs());
                } while (this.zza.zzC() < n);
                this.zzS(n);
                return;
            }
        } else {
            zzggb2 = zzggb2;
            int n2 = this.zzb & 7;
            if (n2 != 0) {
                if (n2 != 2) throw zzggm.zzi();
                n2 = this.zza.zzo();
                n2 = this.zza.zzC() + n2;
                do {
                    zzggb2.zzh(this.zza.zzs());
                } while (this.zza.zzC() < n2);
                this.zzS(n2);
                return;
            }
            do {
                zzggb2.zzh(this.zza.zzs());
                if (!this.zza.zzB()) continue;
                return;
            } while ((n2 = this.zza.zza()) == this.zzb);
            this.zzd = n2;
            return;
        }
        do {
            zzggb2.add(this.zza.zzs());
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }

    public final void zzO(List<Long> zzggx2) throws IOException {
        int n;
        if (!(zzggx2 instanceof zzggx)) {
            n = this.zzb & 7;
            if (n != 0) {
                if (n != 2) throw zzggm.zzi();
                n = this.zza.zzo();
                n = this.zza.zzC() + n;
                do {
                    zzggx2.add(this.zza.zzt());
                } while (this.zza.zzC() < n);
                this.zzS(n);
                return;
            }
        } else {
            zzggx2 = zzggx2;
            int n2 = this.zzb & 7;
            if (n2 != 0) {
                if (n2 != 2) throw zzggm.zzi();
                n2 = this.zza.zzo();
                n2 = this.zza.zzC() + n2;
                do {
                    zzggx2.zzg(this.zza.zzt());
                } while (this.zza.zzC() < n2);
                this.zzS(n2);
                return;
            }
            do {
                zzggx2.zzg(this.zza.zzt());
                if (!this.zza.zzB()) continue;
                return;
            } while ((n2 = this.zza.zza()) == this.zzb);
            this.zzd = n2;
            return;
        }
        do {
            zzggx2.add(this.zza.zzt());
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }

    public final int zzb() throws IOException {
        int n = this.zzd;
        if (n != 0) {
            this.zzb = n;
            this.zzd = 0;
        } else {
            this.zzb = n = this.zza.zza();
        }
        if (n == 0) return Integer.MAX_VALUE;
        if (n != this.zzc) return n >>> 3;
        return Integer.MAX_VALUE;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final boolean zzd() throws IOException {
        if (this.zza.zzB()) return false;
        int n = this.zzb;
        if (n != this.zzc) return this.zza.zzc(n);
        return false;
    }

    public final double zze() throws IOException {
        this.zzP(1);
        return this.zza.zzd();
    }

    public final float zzf() throws IOException {
        this.zzP(5);
        return this.zza.zze();
    }

    public final long zzg() throws IOException {
        this.zzP(0);
        return this.zza.zzf();
    }

    public final long zzh() throws IOException {
        this.zzP(0);
        return this.zza.zzg();
    }

    public final int zzi() throws IOException {
        this.zzP(0);
        return this.zza.zzh();
    }

    public final long zzj() throws IOException {
        this.zzP(1);
        return this.zza.zzi();
    }

    public final int zzk() throws IOException {
        this.zzP(5);
        return this.zza.zzj();
    }

    public final boolean zzl() throws IOException {
        this.zzP(0);
        return this.zza.zzk();
    }

    public final String zzm() throws IOException {
        this.zzP(2);
        return this.zza.zzl();
    }

    public final String zzn() throws IOException {
        this.zzP(2);
        return this.zza.zzm();
    }

    public final <T> T zzo(zzghz<T> zzghz2, zzgfm zzgfm2) throws IOException {
        this.zzP(2);
        return this.zzQ(zzghz2, zzgfm2);
    }

    public final <T> T zzp(zzghz<T> zzghz2, zzgfm zzgfm2) throws IOException {
        this.zzP(3);
        return this.zzR(zzghz2, zzgfm2);
    }

    public final zzgex zzq() throws IOException {
        this.zzP(2);
        return this.zza.zzn();
    }

    public final int zzr() throws IOException {
        this.zzP(0);
        return this.zza.zzo();
    }

    public final int zzs() throws IOException {
        this.zzP(0);
        return this.zza.zzp();
    }

    public final int zzt() throws IOException {
        this.zzP(5);
        return this.zza.zzq();
    }

    public final long zzu() throws IOException {
        this.zzP(1);
        return this.zza.zzr();
    }

    public final int zzv() throws IOException {
        this.zzP(0);
        return this.zza.zzs();
    }

    public final long zzw() throws IOException {
        this.zzP(0);
        return this.zza.zzt();
    }

    public final void zzx(List<Double> zzgfj2) throws IOException {
        int n;
        block9: {
            int n2;
            block7: {
                block8: {
                    block6: {
                        if (!(zzgfj2 instanceof zzgfj)) break block6;
                        zzgfj2 = zzgfj2;
                        n2 = this.zzb & 7;
                        if (n2 == 1) break block7;
                        if (n2 != 2) throw zzggm.zzi();
                        n2 = this.zza.zzo();
                        zzgfd.zzU(n2);
                        int n3 = this.zza.zzC();
                        do {
                            zzgfj2.zzd(this.zza.zzd());
                        } while (this.zza.zzC() < n3 + n2);
                        break block8;
                    }
                    n = this.zzb & 7;
                    if (n == 1) break block9;
                    if (n != 2) throw zzggm.zzi();
                    int n4 = this.zza.zzo();
                    zzgfd.zzU(n4);
                    n = this.zza.zzC();
                    do {
                        zzgfj2.add(this.zza.zzd());
                    } while (this.zza.zzC() < n + n4);
                }
                return;
            }
            do {
                zzgfj2.zzd(this.zza.zzd());
                if (!this.zza.zzB()) continue;
                return;
            } while ((n2 = this.zza.zza()) == this.zzb);
            this.zzd = n2;
            return;
        }
        do {
            zzgfj2.add(this.zza.zzd());
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }

    public final void zzy(List<Float> zzgft2) throws IOException {
        int n;
        block9: {
            int n2;
            block7: {
                block8: {
                    block6: {
                        if (!(zzgft2 instanceof zzgft)) break block6;
                        zzgft2 = zzgft2;
                        n2 = this.zzb & 7;
                        if (n2 != 2) break block7;
                        n2 = this.zza.zzo();
                        zzgfd.zzT(n2);
                        int n3 = this.zza.zzC();
                        do {
                            zzgft2.zzd(this.zza.zze());
                        } while (this.zza.zzC() < n3 + n2);
                        break block8;
                    }
                    n = this.zzb & 7;
                    if (n != 2) break block9;
                    n = this.zza.zzo();
                    zzgfd.zzT(n);
                    int n4 = this.zza.zzC();
                    do {
                        zzgft2.add(Float.valueOf(this.zza.zze()));
                    } while (this.zza.zzC() < n4 + n);
                }
                return;
            }
            if (n2 != 5) throw zzggm.zzi();
            do {
                zzgft2.zzd(this.zza.zze());
                if (!this.zza.zzB()) continue;
                return;
            } while ((n2 = this.zza.zza()) == this.zzb);
            this.zzd = n2;
            return;
        }
        if (n != 5) throw zzggm.zzi();
        do {
            zzgft2.add(Float.valueOf(this.zza.zze()));
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }

    public final void zzz(List<Long> zzggx2) throws IOException {
        int n;
        if (!(zzggx2 instanceof zzggx)) {
            n = this.zzb & 7;
            if (n != 0) {
                if (n != 2) throw zzggm.zzi();
                n = this.zza.zzo();
                n = this.zza.zzC() + n;
                do {
                    zzggx2.add(this.zza.zzf());
                } while (this.zza.zzC() < n);
                this.zzS(n);
                return;
            }
        } else {
            zzggx2 = zzggx2;
            int n2 = this.zzb & 7;
            if (n2 != 0) {
                if (n2 != 2) throw zzggm.zzi();
                n2 = this.zza.zzo();
                n2 = this.zza.zzC() + n2;
                do {
                    zzggx2.zzg(this.zza.zzf());
                } while (this.zza.zzC() < n2);
                this.zzS(n2);
                return;
            }
            do {
                zzggx2.zzg(this.zza.zzf());
                if (!this.zza.zzB()) continue;
                return;
            } while ((n2 = this.zza.zza()) == this.zzb);
            this.zzd = n2;
            return;
        }
        do {
            zzggx2.add(this.zza.zzf());
            if (!this.zza.zzB()) continue;
            return;
        } while ((n = this.zza.zza()) == this.zzb);
        this.zzd = n;
    }
}
