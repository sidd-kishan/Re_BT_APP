/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.TrafficStats
 *  com.google.android.gms.common.util.ClientLibraryUtils
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzcgl
 *  com.google.android.gms.internal.ads.zzcgs
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzcgl;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcgt;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class zzcgy
implements zzcgl {
    private final String zza;

    public zzcgy() {
        this.zza = null;
    }

    public zzcgy(String string) {
        this.zza = string;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    public void zza(String string) {
        Throwable throwable322222;
        block14: {
            int n;
            int n2;
            CharSequence charSequence;
            Object object;
            block13: {
                if (ClientLibraryUtils.isPackageSide()) {
                    TrafficStats.setThreadStatsTag((int)263);
                }
                object = ((String)(object = String.valueOf(string))).length() != 0 ? "Pinging URL: ".concat((String)object) : new String("Pinging URL: ");
                zzcgt.zzd((String)object);
                object = new URL(string);
                object = (HttpURLConnection)((URL)object).openConnection();
                zzber.zza();
                charSequence = this.zza;
                ((URLConnection)object).setConnectTimeout(60000);
                ((HttpURLConnection)object).setInstanceFollowRedirects(true);
                ((URLConnection)object).setReadTimeout(60000);
                if (charSequence != null) {
                    ((URLConnection)object).setRequestProperty("User-Agent", (String)charSequence);
                }
                ((URLConnection)object).setUseCaches(false);
                charSequence = new zzcgs(null);
                charSequence.zza((HttpURLConnection)object, null);
                n2 = ((HttpURLConnection)object).getResponseCode();
                charSequence.zzc((HttpURLConnection)object, n2);
                if (n2 >= 200 && n2 < 300) break block13;
                n = String.valueOf(string).length();
                charSequence = new StringBuilder(n + 65);
                ((StringBuilder)charSequence).append("Received non-success response code ");
                ((StringBuilder)charSequence).append(n2);
                ((StringBuilder)charSequence).append(" from pinging URL: ");
                ((StringBuilder)charSequence).append(string);
                zzcgt.zzi((String)((StringBuilder)charSequence).toString());
            }
            ((HttpURLConnection)object).disconnect();
            if (!ClientLibraryUtils.isPackageSide()) return;
            TrafficStats.clearThreadStatsTag();
            return;
            catch (Throwable throwable2) {
                ((HttpURLConnection)object).disconnect();
                throw throwable2;
                {
                    StringBuilder stringBuilder;
                    block15: {
                        catch (Throwable throwable322222) {
                            break block14;
                        }
                        catch (RuntimeException runtimeException) {
                            break block15;
                        }
                        catch (IOException iOException) {
                            // empty catch block
                        }
                    }
                    charSequence = ((Throwable)((Object)stringBuilder)).getMessage();
                    n = String.valueOf(string).length();
                    n2 = String.valueOf(charSequence).length();
                    stringBuilder = new StringBuilder(n + 27 + n2);
                    stringBuilder.append("Error while pinging URL: ");
                    stringBuilder.append(string);
                    stringBuilder.append(". ");
                    stringBuilder.append((String)charSequence);
                    zzcgt.zzi((String)stringBuilder.toString());
                    if (!ClientLibraryUtils.isPackageSide()) return;
                    TrafficStats.clearThreadStatsTag();
                    return;
                    catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
                    {
                        charSequence = indexOutOfBoundsException.getMessage();
                        n2 = String.valueOf(string).length();
                        n = String.valueOf(charSequence).length();
                        StringBuilder stringBuilder2 = new StringBuilder(n2 + 32 + n);
                        stringBuilder2.append("Error while parsing ping URL: ");
                        stringBuilder2.append(string);
                        stringBuilder2.append(". ");
                        stringBuilder2.append((String)charSequence);
                        zzcgt.zzi((String)stringBuilder2.toString());
                    }
                    if (!ClientLibraryUtils.isPackageSide()) return;
                    TrafficStats.clearThreadStatsTag();
                }
            }
            return;
        }
        if (!ClientLibraryUtils.isPackageSide()) throw throwable322222;
        TrafficStats.clearThreadStatsTag();
        throw throwable322222;
    }
}
