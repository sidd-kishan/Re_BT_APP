/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal.ads;

public final class zzoo {
    private static final String[] zza = new String[]{"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] zzb = new int[]{44100, 48000, 32000};
    private static final int[] zzc = new int[]{32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
    private static final int[] zzd = new int[]{32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
    private static final int[] zze = new int[]{32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
    private static final int[] zzf = new int[]{32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
    private static final int[] zzg = new int[]{8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    static /* synthetic */ String[] zza() {
        return zza;
    }

    static /* synthetic */ int[] zzb() {
        return zzb;
    }

    static /* synthetic */ int[] zzc() {
        return zzc;
    }

    static /* synthetic */ int[] zzd() {
        return zzd;
    }

    static /* synthetic */ int[] zze() {
        return zze;
    }

    static /* synthetic */ int[] zzf() {
        return zzf;
    }

    static /* synthetic */ int[] zzg() {
        return zzg;
    }

    public static int zzh(int n) {
        if (!zzoo.zzl(n)) {
            return -1;
        }
        int n2 = n >>> 19 & 3;
        if (n2 == 1) {
            return -1;
        }
        int n3 = n >>> 17 & 3;
        if (n3 == 0) {
            return -1;
        }
        int n4 = n >>> 12 & 0xF;
        if (n4 == 0) return -1;
        if (n4 == 15) {
            return -1;
        }
        int n5 = n >>> 10 & 3;
        if (n5 == 3) {
            return -1;
        }
        int n6 = zzb[n5];
        if (n2 == 2) {
            n5 = n6 / 2;
        } else {
            n5 = n6;
            if (n2 == 0) {
                n5 = n6 / 4;
            }
        }
        int n7 = n >>> 9 & 1;
        if (n3 == 3) {
            n = n2 == 3 ? zzc[n4 - 1] : zzd[n4 - 1];
            return (n * 12 / n5 + n7) * 4;
        }
        n = n2 == 3 ? (n3 == 2 ? zze[n4 - 1] : zzf[n4 - 1]) : zzg[n4 - 1];
        n6 = 144;
        if (n2 == 3) {
            return n * 144 / n5 + n7;
        }
        if (n3 != 1) return n6 * n / n5 + n7;
        n6 = 72;
        return n6 * n / n5 + n7;
    }

    public static int zzi(int n) {
        if (!zzoo.zzl(n)) {
            return -1;
        }
        int n2 = n >>> 19 & 3;
        if (n2 == 1) {
            return -1;
        }
        int n3 = n >>> 17 & 3;
        if (n3 == 0) {
            return -1;
        }
        int n4 = n >>> 12 & 0xF;
        if (n4 == 0) return -1;
        if (n4 == 15) return -1;
        if ((n >>> 10 & 3) != 3) return zzoo.zzm(n2, n3);
        return -1;
    }

    static /* synthetic */ boolean zzj(int n) {
        return zzoo.zzl(n);
    }

    static /* synthetic */ int zzk(int n, int n2) {
        return zzoo.zzm(n, n2);
    }

    private static boolean zzl(int n) {
        if ((n & 0xFFE00000) != -2097152) return false;
        return true;
    }

    private static int zzm(int n, int n2) {
        if (n2 != 1) {
            if (n2 == 2) return 1152;
            return 384;
        }
        if (n != 3) return 576;
        return 1152;
    }
}
