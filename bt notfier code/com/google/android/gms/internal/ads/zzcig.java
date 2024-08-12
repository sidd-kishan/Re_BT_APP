/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnBufferingUpdateListener
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnInfoListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.media.MediaPlayer$OnVideoSizeChangedListener
 *  android.media.MediaPlayer$TrackInfo
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.view.Surface
 *  android.view.TextureView$SurfaceTextureListener
 *  android.view.View$MeasureSpec
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzayn
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzchx
 *  com.google.android.gms.internal.ads.zzchy
 *  com.google.android.gms.internal.ads.zzchz
 *  com.google.android.gms.internal.ads.zzcia
 *  com.google.android.gms.internal.ads.zzcib
 *  com.google.android.gms.internal.ads.zzcic
 *  com.google.android.gms.internal.ads.zzcid
 *  com.google.android.gms.internal.ads.zzcie
 *  com.google.android.gms.internal.ads.zzcif
 *  com.google.android.gms.internal.ads.zzcih
 *  com.google.android.gms.internal.ads.zzcii
 *  com.google.android.gms.internal.ads.zzciz
 *  com.google.android.gms.internal.ads.zzcja
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcjc
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzayn;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzchx;
import com.google.android.gms.internal.ads.zzchy;
import com.google.android.gms.internal.ads.zzchz;
import com.google.android.gms.internal.ads.zzcia;
import com.google.android.gms.internal.ads.zzcib;
import com.google.android.gms.internal.ads.zzcic;
import com.google.android.gms.internal.ads.zzcid;
import com.google.android.gms.internal.ads.zzcie;
import com.google.android.gms.internal.ads.zzcif;
import com.google.android.gms.internal.ads.zzcih;
import com.google.android.gms.internal.ads.zzcii;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzcja;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcjc;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class zzcig
extends zzcii
implements TextureView.SurfaceTextureListener,
MediaPlayer.OnBufferingUpdateListener,
MediaPlayer.OnCompletionListener,
MediaPlayer.OnErrorListener,
MediaPlayer.OnInfoListener,
MediaPlayer.OnPreparedListener,
MediaPlayer.OnVideoSizeChangedListener {
    private static final Map<Integer, String> zzc = new HashMap<Integer, String>();
    private final zzcjb zzd;
    private final zzcjc zze;
    private final boolean zzf;
    private int zzg = 0;
    private int zzh = 0;
    private MediaPlayer zzi;
    private Uri zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private zzciz zzp;
    private final boolean zzq;
    private int zzr;
    private zzcih zzs;
    private boolean zzt = false;
    private Integer zzu = null;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            zzc.put(-1004, "MEDIA_ERROR_IO");
            zzc.put(-1007, "MEDIA_ERROR_MALFORMED");
            zzc.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            zzc.put(-110, "MEDIA_ERROR_TIMED_OUT");
            zzc.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        zzc.put(100, "MEDIA_ERROR_SERVER_DIED");
        Map<Integer, String> map = zzc;
        Integer n = 1;
        map.put(n, "MEDIA_ERROR_UNKNOWN");
        zzc.put(n, "MEDIA_INFO_UNKNOWN");
        zzc.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzc.put(701, "MEDIA_INFO_BUFFERING_START");
        zzc.put(702, "MEDIA_INFO_BUFFERING_END");
        zzc.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzc.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzc.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT < 19) return;
        zzc.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        zzc.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    public zzcig(Context context, zzcjb zzcjb2, boolean bl, boolean bl2, zzcja zzcja2, zzcjc zzcjc2) {
        super(context);
        this.setSurfaceTextureListener(this);
        this.zzd = zzcjb2;
        this.zze = zzcjc2;
        this.zzq = bl;
        this.zzf = bl2;
        zzcjc2.zza((zzcii)this);
    }

    /*
     * WARNING - void declaration
     */
    private final void zzC() {
        void var1_6;
        com.google.android.gms.ads.internal.util.zze.zza((String)"AdMediaPlayerView init MediaPlayer");
        Object object = this.getSurfaceTexture();
        if (this.zzj == null) return;
        if (object == null) return;
        this.zzE(false);
        try {
            MediaPlayer mediaPlayer;
            com.google.android.gms.ads.internal.zzt.zzs();
            this.zzi = mediaPlayer = new MediaPlayer();
            mediaPlayer.setOnBufferingUpdateListener((MediaPlayer.OnBufferingUpdateListener)this);
            this.zzi.setOnCompletionListener((MediaPlayer.OnCompletionListener)this);
            this.zzi.setOnErrorListener((MediaPlayer.OnErrorListener)this);
            this.zzi.setOnInfoListener((MediaPlayer.OnInfoListener)this);
            this.zzi.setOnPreparedListener((MediaPlayer.OnPreparedListener)this);
            this.zzi.setOnVideoSizeChangedListener((MediaPlayer.OnVideoSizeChangedListener)this);
            this.zzm = 0;
            mediaPlayer = object;
            if (this.zzq) {
                mediaPlayer = new zzciz(this.getContext());
                this.zzp = mediaPlayer;
                mediaPlayer.zzb(object, this.getWidth(), this.getHeight());
                this.zzp.start();
                mediaPlayer = this.zzp.zze();
                if (mediaPlayer == null) {
                    this.zzp.zzd();
                    this.zzp = null;
                    mediaPlayer = object;
                }
            }
            this.zzi.setDataSource(this.getContext(), this.zzj);
            com.google.android.gms.ads.internal.zzt.zzt();
            object = new Surface((SurfaceTexture)mediaPlayer);
            this.zzi.setSurface((Surface)object);
            this.zzi.setAudioStreamType(3);
            this.zzi.setScreenOnWhilePlaying(true);
            this.zzi.prepareAsync();
            this.zzH(1);
            return;
        }
        catch (IllegalStateException illegalStateException) {
        }
        catch (IllegalArgumentException illegalArgumentException) {
        }
        catch (IOException iOException) {
            // empty catch block
        }
        object = String.valueOf(this.zzj);
        String.valueOf(object).length();
        com.google.android.gms.ads.internal.util.zze.zzj((String)"Failed to initialize MediaPlayer at ".concat(String.valueOf(object)), (Throwable)var1_6);
        this.onError(this.zzi, 1, 0);
    }

    private final void zzD() {
        if (!this.zzf) {
            return;
        }
        if (!this.zzF()) return;
        if (this.zzi.getCurrentPosition() <= 0) return;
        if (this.zzh == 3) return;
        com.google.android.gms.ads.internal.util.zze.zza((String)"AdMediaPlayerView nudging MediaPlayer");
        this.zzG(0.0f);
        this.zzi.start();
        int n = this.zzi.getCurrentPosition();
        long l = com.google.android.gms.ads.internal.zzt.zzj().currentTimeMillis();
        while (this.zzF() && this.zzi.getCurrentPosition() == n && com.google.android.gms.ads.internal.zzt.zzj().currentTimeMillis() - l <= 250L) {
        }
        this.zzi.pause();
        this.zzt();
    }

    private final void zzE(boolean bl) {
        com.google.android.gms.ads.internal.util.zze.zza((String)"AdMediaPlayerView release");
        zzciz zzciz2 = this.zzp;
        if (zzciz2 != null) {
            zzciz2.zzd();
            this.zzp = null;
        }
        if ((zzciz2 = this.zzi) == null) return;
        zzciz2.reset();
        this.zzi.release();
        this.zzi = null;
        this.zzH(0);
        if (!bl) return;
        this.zzh = 0;
    }

    private final boolean zzF() {
        if (this.zzi == null) return false;
        int n = this.zzg;
        if (n == -1) return false;
        if (n == 0) return false;
        if (n == 1) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    private final void zzG(float f) {
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer == null) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
            return;
        }
        try {
            mediaPlayer.setVolume(f, f);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            return;
        }
    }

    private final void zzH(int n) {
        if (n == 3) {
            this.zze.zze();
            this.zzb.zzd();
        } else if (this.zzg == 3) {
            this.zze.zzf();
            this.zzb.zze();
        }
        this.zzg = n;
    }

    static /* synthetic */ zzcih zza(zzcig zzcig2) {
        return zzcig2.zzs;
    }

    static /* synthetic */ boolean zzb(zzcig zzcig2) {
        return zzcig2.zzt;
    }

    static /* synthetic */ boolean zzc(zzcig zzcig2, boolean bl) {
        zzcig2.zzt = true;
        return true;
    }

    static /* synthetic */ void zzu(zzcig zzcig2, MediaPlayer object) {
        MediaPlayer.TrackInfo[] trackInfoArray = zzbjl.zzbl;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)trackInfoArray) == false) return;
        if (zzcig2.zzd == null) return;
        if (object == null) return;
        if (Build.VERSION.SDK_INT < 19) return;
        trackInfoArray = object.getTrackInfo();
        if (trackInfoArray == null) return;
        object = new HashMap();
        for (MediaPlayer.TrackInfo trackInfo : trackInfoArray) {
            Serializable serializable;
            if (trackInfo == null) continue;
            int n = trackInfo.getTrackType();
            if (n != 1) {
                if (n != 2 || (trackInfo = trackInfo.getFormat()) == null) continue;
                if (trackInfo.containsKey("mime")) {
                    object.put("audioMime", trackInfo.getString("mime"));
                }
                if (Build.VERSION.SDK_INT < 30 || !trackInfo.containsKey("codecs-string")) continue;
                object.put("audioCodec", trackInfo.getString("codecs-string"));
                continue;
            }
            if ((trackInfo = trackInfo.getFormat()) == null) continue;
            if (trackInfo.containsKey("frame-rate")) {
                try {
                    object.put("frameRate", String.valueOf(trackInfo.getFloat("frame-rate")));
                }
                catch (ClassCastException classCastException) {
                    object.put("frameRate", String.valueOf(trackInfo.getInteger("frame-rate")));
                }
            }
            if (trackInfo.containsKey("bitrate")) {
                serializable = Integer.valueOf(trackInfo.getInteger("bitrate"));
                zzcig2.zzu = serializable;
                object.put("bitRate", String.valueOf(serializable));
            }
            if (trackInfo.containsKey("width") && trackInfo.containsKey("height")) {
                int n2 = trackInfo.getInteger("width");
                n = trackInfo.getInteger("height");
                serializable = new StringBuilder(23);
                ((StringBuilder)serializable).append(n2);
                ((StringBuilder)serializable).append("x");
                ((StringBuilder)serializable).append(n);
                object.put("resolution", ((StringBuilder)serializable).toString());
            }
            if (trackInfo.containsKey("mime")) {
                object.put("videoMime", trackInfo.getString("mime"));
            }
            if (Build.VERSION.SDK_INT < 30 || !trackInfo.containsKey("codecs-string")) continue;
            object.put("videoCodec", trackInfo.getString("codecs-string"));
        }
        if (object.isEmpty()) return;
        zzcig2.zzd.zze("onMetadataEvent", (Map)object);
    }

    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int n) {
        this.zzm = n;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        com.google.android.gms.ads.internal.util.zze.zza((String)"AdMediaPlayerView completion");
        this.zzH(5);
        this.zzh = 5;
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzchz(this));
    }

    public final boolean onError(MediaPlayer object, int n, int n2) {
        object = zzc.get(n);
        String string = zzc.get(n2);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 38 + String.valueOf(string).length());
        stringBuilder.append("AdMediaPlayerView MediaPlayer error: ");
        stringBuilder.append((String)object);
        stringBuilder.append(":");
        stringBuilder.append(string);
        com.google.android.gms.ads.internal.util.zze.zzi((String)stringBuilder.toString());
        this.zzH(-1);
        this.zzh = -1;
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcia(this, (String)object, string));
        return true;
    }

    public final boolean onInfo(MediaPlayer object, int n, int n2) {
        object = zzc.get(n);
        String string = zzc.get(n2);
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 37 + String.valueOf(string).length());
        stringBuilder.append("AdMediaPlayerView MediaPlayer info: ");
        stringBuilder.append((String)object);
        stringBuilder.append(":");
        stringBuilder.append(string);
        com.google.android.gms.ads.internal.util.zze.zza((String)stringBuilder.toString());
        return true;
    }

    /*
     * Unable to fully structure code
     */
    protected final void onMeasure(int var1_1, int var2_2) {
        block6: {
            block12: {
                block10: {
                    block11: {
                        block7: {
                            block8: {
                                block9: {
                                    var5_3 = zzcig.getDefaultSize((int)this.zzk, (int)var1_1);
                                    var6_4 = zzcig.getDefaultSize((int)this.zzl, (int)var2_2);
                                    var3_5 = var5_3;
                                    var4_6 = var6_4;
                                    if (this.zzk <= 0) break block6;
                                    var3_5 = var5_3;
                                    var4_6 = var6_4;
                                    if (this.zzl <= 0) break block6;
                                    var3_5 = var5_3;
                                    var4_6 = var6_4;
                                    if (this.zzp != null) break block6;
                                    var3_5 = View.MeasureSpec.getMode((int)var1_1);
                                    var5_3 = View.MeasureSpec.getSize((int)var1_1);
                                    var4_6 = View.MeasureSpec.getMode((int)var2_2);
                                    var2_2 = View.MeasureSpec.getSize((int)var2_2);
                                    var6_4 = var3_5;
                                    if (var3_5 != 0x40000000) break block7;
                                    if (var4_6 != 0x40000000) break block8;
                                    var1_1 = this.zzk;
                                    var4_6 = var1_1 * var2_2;
                                    var3_5 = this.zzl;
                                    var6_4 = var5_3 * var3_5;
                                    if (var4_6 >= var6_4) break block9;
                                    var1_1 = var4_6 / var3_5;
                                    ** GOTO lbl67
                                }
                                if (var4_6 <= var6_4) break block10;
                                var1_1 = var6_4 / var1_1;
                                ** GOTO lbl63
                            }
                            var6_4 = 0x40000000;
                        }
                        if (var6_4 != 0x40000000) break block11;
                        var1_1 = this.zzl * var5_3 / this.zzk;
                        if (var4_6 != -2147483648 || var1_1 <= var2_2) ** GOTO lbl63
                        break block10;
                    }
                    if (var4_6 != 0x40000000) break block12;
                    var1_1 = var4_6 = this.zzk * var2_2 / this.zzl;
                    var3_5 = var2_2;
                    if (var6_4 != -2147483648) ** GOTO lbl-1000
                    var1_1 = var4_6;
                    var3_5 = var2_2;
                    if (var4_6 <= var5_3) ** GOTO lbl-1000
                }
                var1_1 = var5_3;
                ** GOTO lbl67
            }
            var8_7 = this.zzk;
            var7_8 = this.zzl;
            if (var4_6 == -2147483648 && var7_8 > var2_2) {
                var4_6 = var2_2 * var8_7 / var7_8;
            } else {
                var4_6 = var8_7;
                var2_2 = var7_8;
            }
            var1_1 = var4_6;
            var3_5 = var2_2;
            if (var6_4 != -2147483648) ** GOTO lbl-1000
            var1_1 = var4_6;
            var3_5 = var2_2;
            if (var4_6 > var5_3) {
                var1_1 = var7_8 * var5_3 / var8_7;
lbl63:
                // 3 sources

                var3_5 = var5_3;
                var4_6 = var1_1;
            } else lbl-1000:
            // 4 sources

            {
                var2_2 = var3_5;
lbl67:
                // 3 sources

                var3_5 = var1_1;
                var4_6 = var2_2;
            }
        }
        this.setMeasuredDimension(var3_5, var4_6);
        var9_9 = this.zzp;
        if (var9_9 != null) {
            var9_9.zzc(var3_5, var4_6);
        }
        if (Build.VERSION.SDK_INT != 16) return;
        var1_1 = this.zzn;
        if (var1_1 > 0 && var1_1 != var3_5 || (var1_1 = this.zzo) > 0 && var1_1 != var4_6) {
            this.zzD();
        }
        this.zzn = var3_5;
        this.zzo = var4_6;
    }

    public final void onPrepared(MediaPlayer object) {
        com.google.android.gms.ads.internal.util.zze.zza((String)"AdMediaPlayerView prepared");
        this.zzH(2);
        this.zze.zzb();
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzchy(this, (MediaPlayer)object));
        this.zzk = object.getVideoWidth();
        this.zzl = object.getVideoHeight();
        int n = this.zzr;
        if (n != 0) {
            this.zzl(n);
        }
        this.zzD();
        int n2 = this.zzk;
        n = this.zzl;
        object = new StringBuilder(62);
        ((StringBuilder)object).append("AdMediaPlayerView stream dimensions: ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(" x ");
        ((StringBuilder)object).append(n);
        com.google.android.gms.ads.internal.util.zze.zzh((String)((StringBuilder)object).toString());
        if (this.zzh == 3) {
            this.zzh();
        }
        this.zzt();
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int n, int n2) {
        com.google.android.gms.ads.internal.util.zze.zza((String)"AdMediaPlayerView surface created");
        this.zzC();
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcib(this));
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        com.google.android.gms.ads.internal.util.zze.zza((String)"AdMediaPlayerView surface destroyed");
        surfaceTexture = this.zzi;
        if (surfaceTexture != null && this.zzr == 0) {
            this.zzr = surfaceTexture.getCurrentPosition();
        }
        if ((surfaceTexture = this.zzp) != null) {
            surfaceTexture.zzd();
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcid(this));
        this.zzE(true);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int n, int n2) {
        int n3;
        com.google.android.gms.ads.internal.util.zze.zza((String)"AdMediaPlayerView surface changed");
        int n4 = this.zzh;
        int n5 = this.zzk;
        int n6 = n3 = 0;
        if (n5 == n) {
            n6 = n3;
            if (this.zzl == n2) {
                n6 = 1;
            }
        }
        if (this.zzi != null && n4 == 3 && n6 != 0) {
            n6 = this.zzr;
            if (n6 != 0) {
                this.zzl(n6);
            }
            this.zzh();
        }
        if ((surfaceTexture = this.zzp) != null) {
            surfaceTexture.zzc(n, n2);
        }
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcic(this, n, n2));
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zze.zzd((zzcii)this);
        this.zza.zzb(surfaceTexture, this.zzs);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder(57);
        stringBuilder.append("AdMediaPlayerView size changed: ");
        stringBuilder.append(n);
        stringBuilder.append(" x ");
        stringBuilder.append(n2);
        com.google.android.gms.ads.internal.util.zze.zza((String)stringBuilder.toString());
        this.zzk = mediaPlayer.getVideoWidth();
        this.zzl = n = mediaPlayer.getVideoHeight();
        if (this.zzk == 0) return;
        if (n == 0) return;
        this.requestLayout();
    }

    protected final void onWindowVisibilityChanged(int n) {
        StringBuilder stringBuilder = new StringBuilder(58);
        stringBuilder.append("AdMediaPlayerView window visibility changed to ");
        stringBuilder.append(n);
        com.google.android.gms.ads.internal.util.zze.zza((String)stringBuilder.toString());
        com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzchx(this, n));
        super.onWindowVisibilityChanged(n);
    }

    public final String toString() {
        String string = ((Object)((Object)this)).getClass().getName();
        String string2 = Integer.toHexString(((Object)((Object)this)).hashCode());
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 1 + String.valueOf(string2).length());
        stringBuilder.append(string);
        stringBuilder.append("@");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public final String zzd() {
        String string = true != this.zzq ? "" : " spherical";
        string = string.length() != 0 ? "MediaPlayer".concat(string) : new String("MediaPlayer");
        return string;
    }

    public final void zze(zzcih zzcih2) {
        this.zzs = zzcih2;
    }

    public final void zzf(String string) {
        zzayn zzayn2 = zzayn.zza((Uri)(string = Uri.parse((String)string)));
        if (zzayn2 != null) {
            if (zzayn2.zza == null) return;
        }
        if (zzayn2 != null) {
            string = Uri.parse((String)zzayn2.zza);
        }
        this.zzj = string;
        this.zzr = 0;
        this.zzC();
        this.requestLayout();
        this.invalidate();
    }

    public final void zzg() {
        com.google.android.gms.ads.internal.util.zze.zza((String)"AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzi.release();
            this.zzi = null;
            this.zzH(0);
            this.zzh = 0;
        }
        this.zze.zzc();
    }

    public final void zzh() {
        com.google.android.gms.ads.internal.util.zze.zza((String)"AdMediaPlayerView play");
        if (this.zzF()) {
            this.zzi.start();
            this.zzH(3);
            this.zza.zza();
            com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcie(this));
        }
        this.zzh = 3;
    }

    public final void zzi() {
        com.google.android.gms.ads.internal.util.zze.zza((String)"AdMediaPlayerView pause");
        if (this.zzF() && this.zzi.isPlaying()) {
            this.zzi.pause();
            this.zzH(4);
            com.google.android.gms.ads.internal.util.zzs.zza.post((Runnable)new zzcif(this));
        }
        this.zzh = 4;
    }

    public final int zzj() {
        if (!this.zzF()) return -1;
        return this.zzi.getDuration();
    }

    public final int zzk() {
        if (!this.zzF()) return 0;
        return this.zzi.getCurrentPosition();
    }

    public final void zzl(int n) {
        StringBuilder stringBuilder = new StringBuilder(34);
        stringBuilder.append("AdMediaPlayerView seek ");
        stringBuilder.append(n);
        com.google.android.gms.ads.internal.util.zze.zza((String)stringBuilder.toString());
        if (this.zzF()) {
            this.zzi.seekTo(n);
            this.zzr = 0;
            return;
        }
        this.zzr = n;
    }

    public final void zzm(float f, float f2) {
        zzciz zzciz2 = this.zzp;
        if (zzciz2 == null) return;
        zzciz2.zzf(f, f2);
    }

    public final int zzn() {
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer == null) return 0;
        return mediaPlayer.getVideoWidth();
    }

    public final int zzo() {
        MediaPlayer mediaPlayer = this.zzi;
        if (mediaPlayer == null) return 0;
        return mediaPlayer.getVideoHeight();
    }

    public final long zzp() {
        if (this.zzu == null) return -1L;
        return this.zzr() * (long)this.zzm / 100L;
    }

    public final long zzq() {
        return 0L;
    }

    public final long zzr() {
        if (this.zzu == null) return -1L;
        return (long)this.zzj() * (long)this.zzu.intValue();
    }

    public final int zzs() {
        if (Build.VERSION.SDK_INT < 26) return -1;
        if (!this.zzF()) return -1;
        return this.zzi.getMetrics().getInt("android.media.mediaplayer.dropped");
    }

    public final void zzt() {
        this.zzG(this.zzb.zzc());
    }

    final /* synthetic */ void zzv(int n) {
        zzcih zzcih2 = this.zzs;
        if (zzcih2 == null) return;
        zzcih2.onWindowVisibilityChanged(n);
    }
}
