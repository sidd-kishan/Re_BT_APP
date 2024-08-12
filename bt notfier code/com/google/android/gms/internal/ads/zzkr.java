/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.SystemClock
 *  com.google.android.gms.internal.ads.zzaj
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zzaku
 *  com.google.android.gms.internal.ads.zzalz
 *  com.google.android.gms.internal.ads.zzamd
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzay
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfok
 *  com.google.android.gms.internal.ads.zzfol
 *  com.google.android.gms.internal.ads.zzfon
 *  com.google.android.gms.internal.ads.zzkg
 *  com.google.android.gms.internal.ads.zzkh
 *  com.google.android.gms.internal.ads.zzki
 *  com.google.android.gms.internal.ads.zzkp
 *  com.google.android.gms.internal.ads.zzkq
 *  com.google.android.gms.internal.ads.zzlo
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zzaku;
import com.google.android.gms.internal.ads.zzalz;
import com.google.android.gms.internal.ads.zzamd;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzay;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfok;
import com.google.android.gms.internal.ads.zzfol;
import com.google.android.gms.internal.ads.zzfon;
import com.google.android.gms.internal.ads.zzkg;
import com.google.android.gms.internal.ads.zzkh;
import com.google.android.gms.internal.ads.zzki;
import com.google.android.gms.internal.ads.zzkp;
import com.google.android.gms.internal.ads.zzkq;
import com.google.android.gms.internal.ads.zzlo;
import java.util.HashMap;
import java.util.Map;

public final class zzkr
implements zzki,
zzay {
    public static final zzfol<String, Integer> zza;
    public static final zzfoj<Long> zzb;
    public static final zzfoj<Long> zzc;
    public static final zzfoj<Long> zzd;
    public static final zzfoj<Long> zze;
    public static final zzfoj<Long> zzf;
    public static final zzfoj<Long> zzg;
    private static zzkr zzh;
    private final zzfon<Integer, Long> zzi;
    private final zzkg zzj;
    private final zzlo zzk;
    private final zzaku zzl;
    private final boolean zzm;
    private int zzn;
    private long zzo;
    private long zzp;
    private int zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;

    static {
        zzfok zzfok2 = new zzfok();
        Integer n = 1;
        Number number = 2;
        Number number2 = 0;
        zzfok2.zza((Object)"AD", (Object[])new Integer[]{n, number, number2, number2, number, number});
        Integer n2 = 4;
        zzfok2.zza((Object)"AE", (Object[])new Integer[]{n, n2, n2, n2, number, number});
        Number number3 = 3;
        zzfok2.zza((Object)"AF", (Object[])new Integer[]{n2, n2, number3, n2, number, number});
        zzfok2.zza((Object)"AG", (Object[])new Integer[]{n2, number, n, n2, number, number});
        zzfok2.zza((Object)"AI", (Object[])new Integer[]{n, number, number, number, number, number});
        zzfok2.zza((Object)"AL", (Object[])new Integer[]{n, n, n, n, number, number});
        zzfok2.zza((Object)"AM", (Object[])new Integer[]{number, number, n, number3, number, number});
        zzfok2.zza((Object)"AO", (Object[])new Integer[]{number3, n2, number3, n, number, number});
        zzfok2.zza((Object)"AR", (Object[])new Integer[]{number, n2, number, n, number, number});
        zzfok2.zza((Object)"AS", (Object[])new Integer[]{number, number, number3, number3, number, number});
        zzfok2.zza((Object)"AT", (Object[])new Integer[]{number2, n, number2, number2, number2, number});
        zzfok2.zza((Object)"AU", (Object[])new Integer[]{number2, number, number2, n, n, number});
        zzfok2.zza((Object)"AW", (Object[])new Integer[]{n, number, number2, n2, number, number});
        zzfok2.zza((Object)"AX", (Object[])new Integer[]{number2, number, number, number, number, number});
        zzfok2.zza((Object)"AZ", (Object[])new Integer[]{number3, number3, number3, n2, n2, number});
        zzfok2.zza((Object)"BA", (Object[])new Integer[]{n, n, number2, n, number, number});
        zzfok2.zza((Object)"BB", (Object[])new Integer[]{number2, number, number2, number2, number, number});
        zzfok2.zza((Object)"BD", (Object[])new Integer[]{number, number2, number3, number3, number, number});
        zzfok2.zza((Object)"BE", (Object[])new Integer[]{number2, number2, number, number3, number, number});
        zzfok2.zza((Object)"BF", (Object[])new Integer[]{n2, n2, n2, number, number, number});
        zzfok2.zza((Object)"BG", (Object[])new Integer[]{number2, n, number2, number2, number, number});
        zzfok2.zza((Object)"BH", (Object[])new Integer[]{n, number2, number, n2, number, number});
        zzfok2.zza((Object)"BI", (Object[])new Integer[]{n2, n2, n2, n2, number, number});
        zzfok2.zza((Object)"BJ", (Object[])new Integer[]{n2, n2, n2, n2, number, number});
        zzfok2.zza((Object)"BL", (Object[])new Integer[]{n, number, number, number, number, number});
        zzfok2.zza((Object)"BM", (Object[])new Integer[]{number2, number, number2, number2, number, number});
        zzfok2.zza((Object)"BN", (Object[])new Integer[]{number3, number, n, number2, number, number});
        zzfok2.zza((Object)"BO", (Object[])new Integer[]{n, number, n2, number, number, number});
        zzfok2.zza((Object)"BQ", (Object[])new Integer[]{n, number, n, number, number, number});
        zzfok2.zza((Object)"BR", (Object[])new Integer[]{number, n2, number3, number, number, number});
        zzfok2.zza((Object)"BS", (Object[])new Integer[]{number, number, n, number3, number, number});
        zzfok2.zza((Object)"BT", (Object[])new Integer[]{number3, number2, number3, number, number, number});
        zzfok2.zza((Object)"BW", (Object[])new Integer[]{number3, n2, n, n, number, number});
        zzfok2.zza((Object)"BY", (Object[])new Integer[]{n, n, n, number, number, number});
        zzfok2.zza((Object)"BZ", (Object[])new Integer[]{number, number, number, number, number, number});
        zzfok2.zza((Object)"CA", (Object[])new Integer[]{number2, number3, n, number, n2, number});
        zzfok2.zza((Object)"CD", (Object[])new Integer[]{n2, number, number, n, number, number});
        zzfok2.zza((Object)"CF", (Object[])new Integer[]{n2, number, number3, number, number, number});
        zzfok2.zza((Object)"CG", (Object[])new Integer[]{number3, n2, number, number, number, number});
        zzfok2.zza((Object)"CH", (Object[])new Integer[]{number2, number2, number2, number2, n, number});
        zzfok2.zza((Object)"CI", (Object[])new Integer[]{number3, number3, number3, number3, number, number});
        zzfok2.zza((Object)"CK", (Object[])new Integer[]{number, number, number3, number2, number, number});
        zzfok2.zza((Object)"CL", (Object[])new Integer[]{n, n, number, number, number, number});
        zzfok2.zza((Object)"CM", (Object[])new Integer[]{number3, n2, number3, number, number, number});
        zzfok2.zza((Object)"CN", (Object[])new Integer[]{number, number, number, n, number3, number});
        zzfok2.zza((Object)"CO", (Object[])new Integer[]{number, number3, n2, number, number, number});
        zzfok2.zza((Object)"CR", (Object[])new Integer[]{number, number3, n2, n2, number, number});
        zzfok2.zza((Object)"CU", (Object[])new Integer[]{n2, n2, number, number, number, number});
        zzfok2.zza((Object)"CV", (Object[])new Integer[]{number, number3, n, number2, number, number});
        zzfok2.zza((Object)"CW", (Object[])new Integer[]{n, number, number2, number2, number, number});
        zzfok2.zza((Object)"CY", (Object[])new Integer[]{n, n, number2, number2, number, number});
        zzfok2.zza((Object)"CZ", (Object[])new Integer[]{number2, n, number2, number2, n, number});
        zzfok2.zza((Object)"DE", (Object[])new Integer[]{number2, number2, n, n, number2, number});
        zzfok2.zza((Object)"DJ", (Object[])new Integer[]{n2, number2, n2, n2, number, number});
        zzfok2.zza((Object)"DK", (Object[])new Integer[]{number2, number2, n, number2, number2, number});
        zzfok2.zza((Object)"DM", (Object[])new Integer[]{n, number, number, number, number, number});
        zzfok2.zza((Object)"DO", (Object[])new Integer[]{number3, n2, n2, n2, number, number});
        zzfok2.zza((Object)"DZ", (Object[])new Integer[]{number3, number3, n2, n2, number, n2});
        zzfok2.zza((Object)"EC", (Object[])new Integer[]{number, n2, number3, n, number, number});
        zzfok2.zza((Object)"EE", (Object[])new Integer[]{number2, n, number2, number2, number, number});
        zzfok2.zza((Object)"EG", (Object[])new Integer[]{number3, n2, number3, number3, number, number});
        zzfok2.zza((Object)"EH", (Object[])new Integer[]{number, number, number, number, number, number});
        zzfok2.zza((Object)"ER", (Object[])new Integer[]{n2, number, number, number, number, number});
        zzfok2.zza((Object)"ES", (Object[])new Integer[]{number2, n, n, n, number, number});
        zzfok2.zza((Object)"ET", (Object[])new Integer[]{n2, n2, n2, n, number, number});
        zzfok2.zza((Object)"FI", (Object[])new Integer[]{number2, number2, number2, number2, number2, number});
        zzfok2.zza((Object)"FJ", (Object[])new Integer[]{number3, number2, number, number3, number, number});
        zzfok2.zza((Object)"FK", (Object[])new Integer[]{n2, number, number, number, number, number});
        zzfok2.zza((Object)"FM", (Object[])new Integer[]{number3, number, n2, n2, number, number});
        zzfok2.zza((Object)"FO", (Object[])new Integer[]{n, number, number2, n, number, number});
        zzfok2.zza((Object)"FR", (Object[])new Integer[]{n, n, number, number2, n, number});
        zzfok2.zza((Object)"GA", (Object[])new Integer[]{number3, n2, n, n, number, number});
        zzfok2.zza((Object)"GB", (Object[])new Integer[]{number2, number2, n, n, n, number});
        zzfok2.zza((Object)"GD", (Object[])new Integer[]{n, number, number, number, number, number});
        zzfok2.zza((Object)"GE", (Object[])new Integer[]{n, n, n, number, number, number});
        zzfok2.zza((Object)"GF", (Object[])new Integer[]{number, number, number, number3, number, number});
        zzfok2.zza((Object)"GG", (Object[])new Integer[]{n, number, number2, number2, number, number});
        zzfok2.zza((Object)"GH", (Object[])new Integer[]{number3, n, number3, number, number, number});
        zzfok2.zza((Object)"GI", (Object[])new Integer[]{number2, number, number2, number2, number, number});
        zzfok2.zza((Object)"GL", (Object[])new Integer[]{n, number, number2, number2, number, number});
        zzfok2.zza((Object)"GM", (Object[])new Integer[]{n2, number3, number, n2, number, number});
        zzfok2.zza((Object)"GN", (Object[])new Integer[]{n2, number3, n2, number, number, number});
        zzfok2.zza((Object)"GP", (Object[])new Integer[]{number, n, number, number3, number, number});
        zzfok2.zza((Object)"GQ", (Object[])new Integer[]{n2, number, number, n2, number, number});
        zzfok2.zza((Object)"GR", (Object[])new Integer[]{n, number, number2, number2, number, number});
        zzfok2.zza((Object)"GT", (Object[])new Integer[]{number3, number, number3, n, number, number});
        zzfok2.zza((Object)"GU", (Object[])new Integer[]{n, number, number3, n2, number, number});
        zzfok2.zza((Object)"GW", (Object[])new Integer[]{n2, n2, n2, n2, number, number});
        zzfok2.zza((Object)"GY", (Object[])new Integer[]{number3, number3, number3, n2, number, number});
        zzfok2.zza((Object)"HK", (Object[])new Integer[]{number2, n, number, number3, number, number2});
        zzfok2.zza((Object)"HN", (Object[])new Integer[]{number3, n, number3, number3, number, number});
        zzfok2.zza((Object)"HR", (Object[])new Integer[]{n, n, number2, number2, number3, number});
        zzfok2.zza((Object)"HT", (Object[])new Integer[]{n2, n2, n2, n2, number, number});
        zzfok2.zza((Object)"HU", (Object[])new Integer[]{number2, number2, number2, number2, number2, number});
        zzfok2.zza((Object)"ID", (Object[])new Integer[]{number3, number, number3, number3, number, number});
        zzfok2.zza((Object)"IE", (Object[])new Integer[]{number2, number2, n, n, number3, number});
        zzfok2.zza((Object)"IL", (Object[])new Integer[]{n, number2, number, number3, n2, number});
        zzfok2.zza((Object)"IM", (Object[])new Integer[]{number2, number, number2, n, number, number});
        zzfok2.zza((Object)"IN", (Object[])new Integer[]{number, n, number3, number3, number, number});
        zzfok2.zza((Object)"IO", (Object[])new Integer[]{n2, number, number, n2, number, number});
        zzfok2.zza((Object)"IQ", (Object[])new Integer[]{number3, number3, n2, n2, number, number});
        zzfok2.zza((Object)"IR", (Object[])new Integer[]{number3, number, number3, number, number, number});
        zzfok2.zza((Object)"IS", (Object[])new Integer[]{number2, number, number2, number2, number, number});
        zzfok2.zza((Object)"IT", (Object[])new Integer[]{number2, n2, number2, n, number, number});
        zzfok2.zza((Object)"JE", (Object[])new Integer[]{number, number, n, number, number, number});
        zzfok2.zza((Object)"JM", (Object[])new Integer[]{number3, number3, n2, n2, number, number});
        zzfok2.zza((Object)"JO", (Object[])new Integer[]{number, number, n, n, number, number});
        zzfok2.zza((Object)"JP", (Object[])new Integer[]{number2, number2, number2, number2, number, n});
        zzfok2.zza((Object)"KE", (Object[])new Integer[]{number3, n2, number, number, number, number});
        zzfok2.zza((Object)"KG", (Object[])new Integer[]{number, number2, n, n, number, number});
        zzfok2.zza((Object)"KH", (Object[])new Integer[]{n, number2, n2, number3, number, number});
        zzfok2.zza((Object)"KI", (Object[])new Integer[]{n2, number, n2, number3, number, number});
        zzfok2.zza((Object)"KM", (Object[])new Integer[]{n2, number3, number, number3, number, number});
        zzfok2.zza((Object)"KN", (Object[])new Integer[]{n, number, number, number, number, number});
        zzfok2.zza((Object)"KP", (Object[])new Integer[]{n2, number, number, number, number, number});
        zzfok2.zza((Object)"KR", (Object[])new Integer[]{number2, number2, n, number3, n, number});
        zzfok2.zza((Object)"KW", (Object[])new Integer[]{n, number3, n, n, n, number});
        zzfok2.zza((Object)"KY", (Object[])new Integer[]{n, number, number2, number, number, number});
        zzfok2.zza((Object)"KZ", (Object[])new Integer[]{number, number, number, number3, number, number});
        zzfok2.zza((Object)"LA", (Object[])new Integer[]{n, number, n, n, number, number});
        zzfok2.zza((Object)"LB", (Object[])new Integer[]{number3, number, number2, number2, number, number});
        zzfok2.zza((Object)"LC", (Object[])new Integer[]{n, number, number2, number2, number, number});
        zzfok2.zza((Object)"LI", (Object[])new Integer[]{number2, number, number, number, number, number});
        zzfok2.zza((Object)"LK", (Object[])new Integer[]{number, number2, number, number3, number, number});
        zzfok2.zza((Object)"LR", (Object[])new Integer[]{number3, n2, n2, number3, number, number});
        zzfok2.zza((Object)"LS", (Object[])new Integer[]{number3, number3, number, number3, number, number});
        zzfok2.zza((Object)"LT", (Object[])new Integer[]{number2, number2, number2, number2, number, number});
        zzfok2.zza((Object)"LU", (Object[])new Integer[]{n, number2, n, n, number, number});
        zzfok2.zza((Object)"LV", (Object[])new Integer[]{number2, number2, number2, number2, number, number});
        zzfok2.zza((Object)"LY", (Object[])new Integer[]{n2, number, n2, number3, number, number});
        zzfok2.zza((Object)"MA", (Object[])new Integer[]{number3, number, number, n, number, number});
        zzfok2.zza((Object)"MC", (Object[])new Integer[]{number2, number, number2, number2, number, number});
        zzfok2.zza((Object)"MD", (Object[])new Integer[]{n, number, number2, number2, number, number});
        zzfok2.zza((Object)"ME", (Object[])new Integer[]{n, number, number2, n, number, number});
        zzfok2.zza((Object)"MF", (Object[])new Integer[]{number, number, n, n, number, number});
        zzfok2.zza((Object)"MG", (Object[])new Integer[]{number3, n2, number, number, number, number});
        zzfok2.zza((Object)"MH", (Object[])new Integer[]{n2, number, number, n2, number, number});
        zzfok2.zza((Object)"MK", (Object[])new Integer[]{n, n, number2, number2, number, number});
        zzfok2.zza((Object)"ML", (Object[])new Integer[]{n2, n2, number, number, number, number});
        zzfok2.zza((Object)"MM", (Object[])new Integer[]{number, number3, number3, number3, number, number});
        zzfok2.zza((Object)"MN", (Object[])new Integer[]{number, n2, number, number, number, number});
        zzfok2.zza((Object)"MO", (Object[])new Integer[]{number2, number, n2, n2, number, number});
        zzfok2.zza((Object)"MP", (Object[])new Integer[]{number2, number, number, number, number, number});
        zzfok2.zza((Object)"MQ", (Object[])new Integer[]{number, number, number, number3, number, number});
        zzfok2.zza((Object)"MR", (Object[])new Integer[]{number3, number2, n2, number3, number, number});
        zzfok2.zza((Object)"MS", (Object[])new Integer[]{n, number, number, number, number, number});
        zzfok2.zza((Object)"MT", (Object[])new Integer[]{number2, number, number2, number2, number, number});
        zzfok2.zza((Object)"MU", (Object[])new Integer[]{number, n, n, number, number, number});
        zzfok2.zza((Object)"MV", (Object[])new Integer[]{n2, number3, number, n2, number, number});
        zzfok2.zza((Object)"MW", (Object[])new Integer[]{n2, number, n, number2, number, number});
        zzfok2.zza((Object)"MX", (Object[])new Integer[]{number, n2, n2, n2, n2, number});
        zzfok2.zza((Object)"MY", (Object[])new Integer[]{n, number2, number3, number, number, number});
        zzfok2.zza((Object)"MZ", (Object[])new Integer[]{number3, number3, number, n, number, number});
        zzfok2.zza((Object)"NA", (Object[])new Integer[]{n2, number3, number3, number, number, number});
        zzfok2.zza((Object)"NC", (Object[])new Integer[]{number3, number2, n2, n2, number, number});
        zzfok2.zza((Object)"NE", (Object[])new Integer[]{n2, n2, n2, n2, number, number});
        zzfok2.zza((Object)"NF", (Object[])new Integer[]{number, number, number, number, number, number});
        zzfok2.zza((Object)"NG", (Object[])new Integer[]{number3, number3, number, number3, number, number});
        zzfok2.zza((Object)"NI", (Object[])new Integer[]{number, n, n2, n2, number, number});
        zzfok2.zza((Object)"NL", (Object[])new Integer[]{number2, number, number3, number, number2, number});
        zzfok2.zza((Object)"NO", (Object[])new Integer[]{number2, n, number, number2, number2, number});
        zzfok2.zza((Object)"NP", (Object[])new Integer[]{number, number2, n2, number, number, number});
        zzfok2.zza((Object)"NR", (Object[])new Integer[]{number3, number, number3, n, number, number});
        zzfok2.zza((Object)"NU", (Object[])new Integer[]{n2, number, number, number, number, number});
        zzfok2.zza((Object)"NZ", (Object[])new Integer[]{number2, number, n, number, n2, number});
        zzfok2.zza((Object)"OM", (Object[])new Integer[]{number, number, n, number3, number3, number});
        zzfok2.zza((Object)"PA", (Object[])new Integer[]{n, number3, number3, number3, number, number});
        zzfok2.zza((Object)"PE", (Object[])new Integer[]{number, number3, n2, n2, number, number});
        zzfok2.zza((Object)"PF", (Object[])new Integer[]{number, number, number, n, number, number});
        zzfok2.zza((Object)"PG", (Object[])new Integer[]{n2, n2, number3, number, number, number});
        zzfok2.zza((Object)"PH", (Object[])new Integer[]{number, n, number3, number3, number3, number});
        zzfok2.zza((Object)"PK", (Object[])new Integer[]{number3, number, number3, number3, number, number});
        zzfok2.zza((Object)"PL", (Object[])new Integer[]{n, number2, n, number, number3, number});
        zzfok2.zza((Object)"PM", (Object[])new Integer[]{number2, number, number, number, number, number});
        zzfok2.zza((Object)"PR", (Object[])new Integer[]{number, n, number, number, n2, number3});
        zzfok2.zza((Object)"PS", (Object[])new Integer[]{number3, number3, number, number, number, number});
        zzfok2.zza((Object)"PT", (Object[])new Integer[]{number2, n, n, number2, number, number});
        zzfok2.zza((Object)"PW", (Object[])new Integer[]{n, number, n2, n, number, number});
        zzfok2.zza((Object)"PY", (Object[])new Integer[]{number, number2, number3, number, number, number});
        zzfok2.zza((Object)"QA", (Object[])new Integer[]{number, number3, n, number, number3, number});
        zzfok2.zza((Object)"RE", (Object[])new Integer[]{n, number2, number, number, number, number});
        zzfok2.zza((Object)"RO", (Object[])new Integer[]{number2, n, number2, n, number2, number});
        zzfok2.zza((Object)"RS", (Object[])new Integer[]{n, number, number2, number2, number, number});
        zzfok2.zza((Object)"RU", (Object[])new Integer[]{number2, n, number2, n, n2, number});
        zzfok2.zza((Object)"RW", (Object[])new Integer[]{number3, number3, number3, n, number, number});
        zzfok2.zza((Object)"SA", (Object[])new Integer[]{number, number, number, n, n, number});
        zzfok2.zza((Object)"SB", (Object[])new Integer[]{n2, number, number3, number, number, number});
        zzfok2.zza((Object)"SC", (Object[])new Integer[]{n2, number, n, number3, number, number});
        zzfok2.zza((Object)"SD", (Object[])new Integer[]{n2, n2, n2, n2, number, number});
        zzfok2.zza((Object)"SE", (Object[])new Integer[]{number2, number2, number2, number2, number2, number});
        zzfok2.zza((Object)"SG", (Object[])new Integer[]{n, number2, n, number, number3, number});
        zzfok2.zza((Object)"SH", (Object[])new Integer[]{n2, number, number, number, number, number});
        zzfok2.zza((Object)"SI", (Object[])new Integer[]{number2, number2, number2, number2, number, number});
        zzfok2.zza((Object)"SJ", (Object[])new Integer[]{number, number, number, number, number, number});
        zzfok2.zza((Object)"SK", (Object[])new Integer[]{number2, n, number2, number2, number, number});
        zzfok2.zza((Object)"SL", (Object[])new Integer[]{n2, number3, n2, number2, number, number});
        zzfok2.zza((Object)"SM", (Object[])new Integer[]{number2, number, number, number, number, number});
        zzfok2.zza((Object)"SN", (Object[])new Integer[]{n2, n2, n2, n2, number, number});
        zzfok2.zza((Object)"SO", (Object[])new Integer[]{number3, number3, number3, n2, number, number});
        zzfok2.zza((Object)"SR", (Object[])new Integer[]{number3, number, number, number, number, number});
        zzfok2.zza((Object)"SS", (Object[])new Integer[]{n2, n2, number3, number3, number, number});
        zzfok2.zza((Object)"ST", (Object[])new Integer[]{number, number, n, number, number, number});
        zzfok2.zza((Object)"SV", (Object[])new Integer[]{number, n, n2, number3, number, number});
        zzfok2.zza((Object)"SX", (Object[])new Integer[]{number, number, n, number2, number, number});
        zzfok2.zza((Object)"SY", (Object[])new Integer[]{n2, number3, number3, number, number, number});
        zzfok2.zza((Object)"SZ", (Object[])new Integer[]{number3, number3, number, n2, number, number});
        zzfok2.zza((Object)"TC", (Object[])new Integer[]{number, number, number, number2, number, number});
        zzfok2.zza((Object)"TD", (Object[])new Integer[]{n2, number3, n2, n2, number, number});
        zzfok2.zza((Object)"TG", (Object[])new Integer[]{number3, number, number, n2, number, number});
        zzfok2.zza((Object)"TH", (Object[])new Integer[]{number2, number3, number, number3, number, number});
        zzfok2.zza((Object)"TJ", (Object[])new Integer[]{n2, n2, n2, n2, number, number});
        zzfok2.zza((Object)"TL", (Object[])new Integer[]{n2, number2, n2, n2, number, number});
        zzfok2.zza((Object)"TM", (Object[])new Integer[]{n2, number, n2, number3, number, number});
        zzfok2.zza((Object)"TN", (Object[])new Integer[]{number, n, n, number, number, number});
        zzfok2.zza((Object)"TO", (Object[])new Integer[]{number3, number3, n2, number3, number, number});
        zzfok2.zza((Object)"TR", (Object[])new Integer[]{n, number, n, n, number, number});
        zzfok2.zza((Object)"TT", (Object[])new Integer[]{n, n2, number2, n, number, number});
        zzfok2.zza((Object)"TV", (Object[])new Integer[]{number3, number, number, n2, number, number});
        zzfok2.zza((Object)"TW", (Object[])new Integer[]{number2, number2, number2, number2, n, number2});
        zzfok2.zza((Object)"TZ", (Object[])new Integer[]{number3, number3, number3, number, number, number});
        zzfok2.zza((Object)"UA", (Object[])new Integer[]{number2, number3, n, n, number, number});
        zzfok2.zza((Object)"UG", (Object[])new Integer[]{number3, number, number3, number3, number, number});
        zzfok2.zza((Object)"US", (Object[])new Integer[]{n, n, number, number, n2, number});
        zzfok2.zza((Object)"UY", (Object[])new Integer[]{number, number, n, n, number, number});
        zzfok2.zza((Object)"UZ", (Object[])new Integer[]{number, n, number3, n2, number, number});
        zzfok2.zza((Object)"VC", (Object[])new Integer[]{n, number, number, number, number, number});
        zzfok2.zza((Object)"VE", (Object[])new Integer[]{n2, n2, n2, n2, number, number});
        zzfok2.zza((Object)"VG", (Object[])new Integer[]{number, number, n, n, number, number});
        zzfok2.zza((Object)"VI", (Object[])new Integer[]{n, number, n, number, number, number});
        zzfok2.zza((Object)"VN", (Object[])new Integer[]{number2, n, number3, n2, number, number});
        zzfok2.zza((Object)"VU", (Object[])new Integer[]{n2, number2, number3, n, number, number});
        zzfok2.zza((Object)"WF", (Object[])new Integer[]{n2, number, number, n2, number, number});
        zzfok2.zza((Object)"WS", (Object[])new Integer[]{number3, n, number3, n, number, number});
        zzfok2.zza((Object)"XK", (Object[])new Integer[]{number2, n, n, number2, number, number});
        zzfok2.zza((Object)"YE", (Object[])new Integer[]{n2, n2, n2, number3, number, number});
        zzfok2.zza((Object)"YT", (Object[])new Integer[]{n2, number, number, number3, number, number});
        zzfok2.zza((Object)"ZA", (Object[])new Integer[]{number3, number3, number, n, number, number});
        zzfok2.zza((Object)"ZM", (Object[])new Integer[]{number3, number, number3, number3, number, number});
        zzfok2.zza((Object)"ZW", (Object[])new Integer[]{number3, number, n2, number3, number, number});
        zza = zzfok2.zzb();
        number3 = 2300000L;
        number2 = 1300000L;
        zzb = zzfoj.zzm((Object)6200000L, (Object)3900000L, (Object)number3, (Object)number2, (Object)620000L);
        zzc = zzfoj.zzm((Object)248000L, (Object)160000L, (Object)142000L, (Object)127000L, (Object)113000L);
        number = 2200000L;
        zzd = zzfoj.zzm((Object)number, (Object)number2, (Object)950000L, (Object)760000L, (Object)520000L);
        number2 = 1500000L;
        zze = zzfoj.zzm((Object)4400000L, (Object)number3, (Object)number2, (Object)1100000L, (Object)640000L);
        zzf = zzfoj.zzm((Object)10000000L, (Object)0x6DDD00L, (Object)5000000L, (Object)2700000L, (Object)1600000L);
        zzg = zzfoj.zzm((Object)2600000L, (Object)number, (Object)2000000L, (Object)number2, (Object)470000L);
    }

    @Deprecated
    public zzkr() {
        zzfon.zza();
        zzaku zzaku2 = zzaku.zza;
        throw null;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    /* synthetic */ zzkr(Context context, Map map, int n, zzaku zzaku2, boolean bl, zzkq zzkq2) {
        this.zzi = zzfon.zzb((Map)map);
        this.zzj = new zzkg();
        this.zzk = new zzlo(2000);
        this.zzl = zzaku2;
        this.zzm = true;
        if (context != null) {
            context = zzamd.zza((Context)context);
            this.zzq = n = context.zzc();
            this.zzt = this.zzk(n);
            context.zzb((zzalz)new zzkp(this));
            return;
        }
        this.zzq = 0;
        this.zzt = this.zzk(0);
    }

    public static zzkr zzg(Context object) {
        synchronized (zzkr.class) {
            if (zzh == null) {
                zzkr zzkr2;
                Object object2;
                Context context = object == null ? null : object.getApplicationContext();
                object = zzamq.zzX((Context)object);
                object = object2 = zza.zza(object);
                if (object2.isEmpty()) {
                    object = 2;
                    object = zzfoj.zzn((Object)object, (Object)object, (Object)object, (Object)object, (Object)object, (Object)object);
                }
                object2 = new HashMap(8);
                object2.put(0, 1000000L);
                object2.put(2, (Long)zzb.get(((Integer)object.get(0)).intValue()));
                object2.put(3, (Long)zzc.get(((Integer)object.get(1)).intValue()));
                object2.put(4, (Long)zzd.get(((Integer)object.get(2)).intValue()));
                object2.put(5, (Long)zze.get(((Integer)object.get(3)).intValue()));
                object2.put(10, (Long)zzf.get(((Integer)object.get(4)).intValue()));
                object2.put(9, (Long)zzg.get(((Integer)object.get(5)).intValue()));
                object2.put(7, (Long)zzb.get(((Integer)object.get(0)).intValue()));
                object = zzaku.zza;
                zzh = zzkr2 = new zzkr(context, (Map)object2, 2000, (zzaku)object, true, null);
            }
            object = zzh;
            return object;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final void zzi(int n) {
        synchronized (this) {
            int n2 = this.zzq;
            if (n2 != 0) {
                boolean bl = this.zzm;
                if (!bl) return;
            }
            if (n2 == n) {
                return;
            }
            this.zzq = n;
            if (n == 1) return;
            if (n == 0) return;
            if (n == 8) {
                return;
            }
            this.zzt = this.zzk(n);
            long l = SystemClock.elapsedRealtime();
            n = this.zzn > 0 ? (int)(l - this.zzo) : 0;
            this.zzj(n, this.zzp, this.zzt);
            this.zzo = l;
            this.zzp = 0L;
            this.zzs = 0L;
            this.zzr = 0L;
            this.zzk.zza();
            return;
        }
    }

    private final void zzj(int n, long l, long l2) {
        if (n == 0) {
            if (l == 0L) {
                if (l2 == this.zzu) return;
            }
            n = 0;
        }
        this.zzu = l2;
        this.zzj.zzc(n, l, l2);
    }

    private final long zzk(int n) {
        Long l;
        Long l2 = l = (Long)this.zzi.get((Object)n);
        if (l == null) {
            l2 = (Long)this.zzi.get((Object)0);
        }
        l = l2;
        if (l2 != null) return l;
        l = 1000000L;
        return l;
    }

    private static boolean zzl(zzan zzan2, boolean bl) {
        if (!bl) return false;
        if (zzan2.zzb(8)) return false;
        return true;
    }

    public final void zza(zzaj zzaj2, zzan zzan2, boolean bl) {
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void zzb(zzaj zzaj2, zzan zzan2, boolean bl) {
        synchronized (this) {
            boolean bl2;
            void var2_2;
            bl2 = zzkr.zzl((zzan)var2_2, bl2);
            if (!bl2) {
                return;
            }
            if (this.zzn == 0) {
                this.zzo = SystemClock.elapsedRealtime();
            }
            ++this.zzn;
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void zzc(zzaj zzaj2, zzan zzan2, boolean bl, int n) {
        synchronized (this) {
            void var4_4;
            boolean bl2;
            void var2_2;
            bl2 = zzkr.zzl((zzan)var2_2, bl2);
            if (!bl2) {
                return;
            }
            this.zzp += (long)var4_4;
            return;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void zzd(zzaj zzaj2, zzan zzan2, boolean bl) {
        synchronized (this) {
            boolean bl2;
            void var2_2;
            bl2 = zzkr.zzl((zzan)var2_2, bl2);
            if (!bl2) {
                return;
            }
            bl2 = this.zzn > 0;
            zzakt.zzd((boolean)bl2);
            long l = SystemClock.elapsedRealtime();
            int n = (int)(l - this.zzo);
            this.zzr += (long)n;
            long l2 = this.zzs;
            long l3 = this.zzp;
            this.zzs = l2 + l3;
            if (n > 0) {
                this.zzk.zzb((int)Math.sqrt(l3), (float)l3 * 8000.0f / (float)n);
                if (this.zzr >= 2000L || this.zzs >= 524288L) {
                    this.zzt = (long)this.zzk.zzc(0.5f);
                }
                this.zzj(n, this.zzp, this.zzt);
                this.zzo = l;
                this.zzp = 0L;
            }
            --this.zzn;
            return;
        }
    }

    public final void zze(Handler handler, zzkh zzkh2) {
        this.zzj.zza(handler, zzkh2);
    }

    public final void zzf(zzkh zzkh2) {
        this.zzj.zzb(zzkh2);
    }
}
