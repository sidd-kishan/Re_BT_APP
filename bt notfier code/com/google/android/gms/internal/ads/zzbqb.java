/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ResolveInfo
 *  android.net.Uri
 *  android.view.View
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzaas
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzaas;
import java.util.ArrayList;
import java.util.List;

public final class zzbqb {
    public static final Intent zza(Uri uri, Context context, zzaas zzaas2, View view) {
        if (uri == null) {
            return null;
        }
        context = new Intent("android.intent.action.VIEW");
        context.addFlags(0x10000000);
        context.setData(uri);
        context.setAction("android.intent.action.VIEW");
        return context;
    }

    public static final ResolveInfo zzb(Intent intent, Context context, zzaas zzaas2, View view) {
        return zzbqb.zzc(intent, new ArrayList<ResolveInfo>(), context, zzaas2, view);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public static final ResolveInfo zzc(Intent intent, ArrayList<ResolveInfo> arrayList, Context context, zzaas zzaas2, View view) {
        block8: {
            List list;
            view = null;
            Object var6_6 = null;
            zzaas2 = view;
            try {
                context = context.getPackageManager();
                if (context == null) {
                    return null;
                }
                zzaas2 = view;
                list = context.queryIntentActivities(intent, 65536);
                zzaas2 = view;
                context = context.resolveActivity(intent, 65536);
                intent = var6_6;
                if (list != null) {
                    intent = var6_6;
                    if (context != null) {
                        int n = 0;
                        while (true) {
                            intent = var6_6;
                            zzaas2 = view;
                            if (n >= list.size()) break;
                            zzaas2 = view;
                            intent = (ResolveInfo)list.get(n);
                            zzaas2 = view;
                            if (context.activityInfo.name.equals(intent.activityInfo.name)) {
                                intent = context;
                                break;
                            }
                            ++n;
                        }
                    }
                }
                zzaas2 = intent;
            }
            catch (Throwable throwable) {
                zzt.zzg().zzk(throwable, "OpenSystemBrowserHandler.getDefaultBrowserResolverForIntent");
                intent = zzaas2;
                break block8;
            }
            {
                arrayList.addAll(list);
            }
        }
        return intent;
    }

    public static final Intent zzd(Intent intent, ResolveInfo resolveInfo, Context context, zzaas zzaas2, View view) {
        intent = new Intent(intent);
        intent.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
        return intent;
    }
}
