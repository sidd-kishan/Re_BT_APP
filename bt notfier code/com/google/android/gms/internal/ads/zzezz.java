/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.JsonReader
 *  com.google.android.gms.ads.internal.util.zzbx
 *  com.google.android.gms.internal.ads.zzbdn
 *  com.google.android.gms.internal.ads.zzbzw
 *  com.google.android.gms.internal.ads.zzccl
 *  com.google.android.gms.internal.ads.zzcdv
 *  com.google.android.gms.internal.ads.zzfaa
 *  com.google.android.gms.internal.ads.zzfae
 *  com.google.android.gms.internal.ads.zzfau
 *  com.google.android.gms.internal.ads.zzfoj
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.internal.ads.zzbdn;
import com.google.android.gms.internal.ads.zzbzw;
import com.google.android.gms.internal.ads.zzccl;
import com.google.android.gms.internal.ads.zzcdv;
import com.google.android.gms.internal.ads.zzfaa;
import com.google.android.gms.internal.ads.zzfae;
import com.google.android.gms.internal.ads.zzfau;
import com.google.android.gms.internal.ads.zzfoj;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzezz {
    public final zzcdv zzA;
    public final String zzB;
    public final JSONObject zzC;
    public final JSONObject zzD;
    public final String zzE;
    public final boolean zzF;
    public final boolean zzG;
    public final boolean zzH;
    public final boolean zzI;
    public final boolean zzJ;
    public final boolean zzK;
    public final boolean zzL;
    public final int zzM;
    public final int zzN;
    public final boolean zzO;
    public final boolean zzP;
    public final String zzQ;
    public final zzfau zzR;
    public final boolean zzS;
    public final boolean zzT;
    public final int zzU;
    public final String zzV;
    public final int zzW;
    public final String zzX;
    public final boolean zzY;
    public final zzbzw zzZ;
    public final List<String> zza;
    public final boolean zzaa;
    public final zzbdn zzab;
    public final String zzac;
    public final boolean zzad;
    public final JSONObject zzae;
    public final boolean zzaf;
    public final JSONObject zzag;
    public final boolean zzah;
    public final String zzai;
    public final boolean zzaj;
    public final int zzb;
    public final List<String> zzc;
    public final List<String> zzd;
    public final List<String> zze;
    public final int zzf;
    public final List<String> zzg;
    public final List<String> zzh;
    public final List<String> zzi;
    public final List<String> zzj;
    public final String zzk;
    public final String zzl;
    public final zzccl zzm;
    public final List<String> zzn;
    public final List<String> zzo;
    public final List<String> zzp;
    public final int zzq;
    public final List<zzfaa> zzr;
    public final zzfae zzs;
    public final List<String> zzt;
    public final List<zzfaa> zzu;
    public final JSONObject zzv;
    public final String zzw;
    public final String zzx;
    public final String zzy;
    public final String zzz;

    zzezz(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        String string8;
        String string9;
        String string10;
        String string11;
        List list = Collections.emptyList();
        List list2 = Collections.emptyList();
        List list3 = Collections.emptyList();
        List list4 = Collections.emptyList();
        List list5 = Collections.emptyList();
        Collections.emptyList();
        List list6 = Collections.emptyList();
        List list7 = Collections.emptyList();
        List list8 = Collections.emptyList();
        List list9 = Collections.emptyList();
        List list10 = Collections.emptyList();
        List list11 = Collections.emptyList();
        List list12 = Collections.emptyList();
        List list13 = Collections.emptyList();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        JSONObject jSONObject4 = new JSONObject();
        JSONObject jSONObject5 = new JSONObject();
        JSONObject jSONObject6 = new JSONObject();
        Object object = zzfoj.zzi();
        jsonReader.beginObject();
        zzfae zzfae2 = null;
        String string12 = string11 = (string10 = (string9 = null));
        String string13 = "";
        String string14 = string8 = (string7 = (string6 = (string5 = (string4 = (string3 = (string2 = (string = "")))))));
        int n = 0;
        boolean bl = false;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        boolean bl7 = false;
        int n2 = -1;
        int n3 = 0;
        boolean bl8 = false;
        boolean bl9 = false;
        boolean bl10 = false;
        int n4 = 0;
        int n5 = -1;
        boolean bl11 = false;
        boolean bl12 = true;
        boolean bl13 = false;
        boolean bl14 = false;
        boolean bl15 = false;
        boolean bl16 = false;
        boolean bl17 = false;
        String string15 = string12;
        String string16 = string14;
        int n6 = 0;
        int n7 = 0;
        String string17 = string16;
        block130: while (true) {
            int n8;
            block133: {
                if (!jsonReader.hasNext()) {
                    jsonReader.endObject();
                    this.zza = list;
                    this.zzb = n7;
                    this.zzc = list2;
                    this.zzd = list3;
                    this.zzg = list4;
                    this.zzf = n6;
                    this.zzh = list5;
                    this.zzi = list6;
                    this.zzj = list7;
                    this.zzk = string16;
                    this.zzl = string17;
                    this.zzm = string15;
                    this.zzn = list8;
                    this.zzo = list9;
                    this.zzp = list10;
                    this.zzq = n;
                    this.zzr = list11;
                    this.zzs = zzfae2;
                    this.zzt = list12;
                    this.zzu = list13;
                    this.zzw = string13;
                    this.zzv = jSONObject;
                    this.zzx = string;
                    this.zzy = string2;
                    this.zzz = string3;
                    this.zzA = string9;
                    this.zzB = string4;
                    this.zzC = jSONObject2;
                    this.zzD = jSONObject3;
                    this.zzF = bl;
                    this.zzG = bl2;
                    this.zzH = bl3;
                    this.zzI = bl4;
                    this.zzJ = bl5;
                    this.zzK = bl6;
                    this.zzL = bl7;
                    this.zzM = n2;
                    this.zzN = n3;
                    this.zzP = bl8;
                    this.zzQ = string5;
                    this.zzR = new zzfau(jSONObject4);
                    this.zzS = bl9;
                    this.zzT = bl10;
                    this.zzU = n4;
                    this.zzV = string6;
                    this.zzW = n5;
                    this.zzX = string7;
                    this.zzY = bl11;
                    this.zzZ = string10;
                    this.zzaa = bl12;
                    this.zzab = string11;
                    this.zzac = string8;
                    this.zzad = bl13;
                    this.zzae = jSONObject5;
                    this.zzE = string14;
                    this.zzaf = bl14;
                    this.zzag = jSONObject6;
                    this.zzah = bl15;
                    this.zzai = string12;
                    this.zzaj = bl16;
                    this.zze = object;
                    this.zzO = bl17;
                    return;
                }
                String string18 = jsonReader.nextName();
                if (string18 == null) {
                    string18 = "";
                }
                switch (string18.hashCode()) {
                    default: {
                        break;
                    }
                    case 2072888499: {
                        if (!string18.equals("manual_tracking_urls")) break;
                        n8 = 15;
                        break block133;
                    }
                    case 2068142375: {
                        if (!string18.equals("rule_line_external_id")) break;
                        n8 = 52;
                        break block133;
                    }
                    case 1875425491: {
                        if (!string18.equals("is_analytics_logging_enabled")) break;
                        n8 = 42;
                        break block133;
                    }
                    case 1839650832: {
                        if (!string18.equals("renderers")) break;
                        n8 = 0;
                        break block133;
                    }
                    case 1799285870: {
                        if (!string18.equals("use_third_party_container_height")) break;
                        n8 = 48;
                        break block133;
                    }
                    case 1688341040: {
                        if (!string18.equals("video_reward_urls")) break;
                        n8 = 8;
                        break block133;
                    }
                    case 1686319423: {
                        if (!string18.equals("ad_network_class_name")) break;
                        n8 = 55;
                        break block133;
                    }
                    case 1638957285: {
                        if (!string18.equals("video_start_urls")) break;
                        n8 = 6;
                        break block133;
                    }
                    case 1637553475: {
                        if (!string18.equals("bid_response")) break;
                        n8 = 40;
                        break block133;
                    }
                    case 1321720943: {
                        if (!string18.equals("allow_pub_owned_ad_view")) break;
                        n8 = 31;
                        break block133;
                    }
                    case 1186014765: {
                        if (!string18.equals("cache_hit_urls")) break;
                        n8 = 61;
                        break block133;
                    }
                    case 1100650276: {
                        if (!string18.equals("rewards")) break;
                        n8 = 12;
                        break block133;
                    }
                    case 1010584092: {
                        if (!string18.equals("transaction_id")) break;
                        n8 = 10;
                        break block133;
                    }
                    case 791122864: {
                        if (!string18.equals("impression_type")) break;
                        n8 = 5;
                        break block133;
                    }
                    case 754887508: {
                        if (!string18.equals("container_sizes")) break;
                        n8 = 17;
                        break block133;
                    }
                    case 673261304: {
                        if (!string18.equals("reward_granted_urls")) break;
                        n8 = 7;
                        break block133;
                    }
                    case 597473788: {
                        if (!string18.equals("debug_dialog_string")) break;
                        n8 = 27;
                        break block133;
                    }
                    case 549176928: {
                        if (!string18.equals("presentation_error_timeout_ms")) break;
                        n8 = 16;
                        break block133;
                    }
                    case 418392395: {
                        if (!string18.equals("is_closable_area_disabled")) break;
                        n8 = 36;
                        break block133;
                    }
                    case 230323073: {
                        if (!string18.equals("ad_load_urls")) break;
                        n8 = 4;
                        break block133;
                    }
                    case 107433883: {
                        if (!string18.equals("qdata")) break;
                        n8 = 24;
                        break block133;
                    }
                    case 63195984: {
                        if (!string18.equals("render_test_label")) break;
                        n8 = 33;
                        break block133;
                    }
                    case 3076010: {
                        if (!string18.equals("data")) break;
                        n8 = 22;
                        break block133;
                    }
                    case 3355: {
                        if (!string18.equals("id")) break;
                        n8 = 23;
                        break block133;
                    }
                    case 3107: {
                        if (!string18.equals("ad")) break;
                        n8 = 18;
                        break block133;
                    }
                    case -29338502: {
                        if (!string18.equals("allow_custom_click_gesture")) break;
                        n8 = 32;
                        break block133;
                    }
                    case -154616268: {
                        if (!string18.equals("is_offline_ad")) break;
                        n8 = 56;
                        break block133;
                    }
                    case -180214626: {
                        if (!string18.equals("native_required_asset_viewability")) break;
                        n8 = 58;
                        break block133;
                    }
                    case -213424028: {
                        if (!string18.equals("watermark")) break;
                        n8 = 46;
                        break block133;
                    }
                    case -213449460: {
                        if (!string18.equals("force_disable_hardware_acceleration")) break;
                        n8 = 60;
                        break block133;
                    }
                    case -369773488: {
                        if (!string18.equals("is_close_button_enabled")) break;
                        n8 = 50;
                        break block133;
                    }
                    case -388807511: {
                        if (!string18.equals("content_url")) break;
                        n8 = 59;
                        break block133;
                    }
                    case -397704715: {
                        if (!string18.equals("ad_close_time_ms")) break;
                        n8 = 45;
                        break block133;
                    }
                    case -404326515: {
                        if (!string18.equals("render_timeout_ms")) break;
                        n8 = 38;
                        break block133;
                    }
                    case -404433734: {
                        if (!string18.equals("rtb_native_required_assets")) break;
                        n8 = 57;
                        break block133;
                    }
                    case -437057161: {
                        if (!string18.equals("imp_urls")) break;
                        n8 = 3;
                        break block133;
                    }
                    case -544216775: {
                        if (!string18.equals("safe_browsing")) break;
                        n8 = 26;
                        break block133;
                    }
                    case -776859333: {
                        if (!string18.equals("click_urls")) break;
                        n8 = 2;
                        break block133;
                    }
                    case -982608540: {
                        if (!string18.equals("valid_from_timestamp")) break;
                        n8 = 11;
                        break block133;
                    }
                    case -1051269058: {
                        if (!string18.equals("active_view")) break;
                        n8 = 25;
                        break block133;
                    }
                    case -1078050970: {
                        if (!string18.equals("video_complete_urls")) break;
                        n8 = 9;
                        break block133;
                    }
                    case -1081936678: {
                        if (!string18.equals("allocation_id")) break;
                        n8 = 21;
                        break block133;
                    }
                    case -1115838944: {
                        if (!string18.equals("fill_urls")) break;
                        n8 = 13;
                        break block133;
                    }
                    case -1146534047: {
                        if (!string18.equals("is_scroll_aware")) break;
                        n8 = 43;
                        break block133;
                    }
                    case -1152230954: {
                        if (!string18.equals("ad_type")) break;
                        n8 = 1;
                        break block133;
                    }
                    case -1168140544: {
                        if (!string18.equals("presentation_error_urls")) break;
                        n8 = 14;
                        break block133;
                    }
                    case -1234181075: {
                        if (!string18.equals("allow_pub_rendered_attribution")) break;
                        n8 = 30;
                        break block133;
                    }
                    case -1240082064: {
                        if (!string18.equals("ad_event_value")) break;
                        n8 = 51;
                        break block133;
                    }
                    case -1289032093: {
                        if (!string18.equals("extras")) break;
                        n8 = 29;
                        break block133;
                    }
                    case -1303332046: {
                        if (!string18.equals("test_mode_enabled")) break;
                        n8 = 34;
                        break block133;
                    }
                    case -1306015996: {
                        if (!string18.equals("adapters")) break;
                        n8 = 20;
                        break block133;
                    }
                    case -1360811658: {
                        if (!string18.equals("ad_sizes")) break;
                        n8 = 19;
                        break block133;
                    }
                    case -1375413093: {
                        if (!string18.equals("ad_cover")) break;
                        n8 = 54;
                        break block133;
                    }
                    case -1403779768: {
                        if (!string18.equals("showable_impression_type")) break;
                        n8 = 44;
                        break block133;
                    }
                    case -1406227629: {
                        if (!string18.equals("buffer_click_url_as_ready_to_ping")) break;
                        n8 = 62;
                        break block133;
                    }
                    case -1428969291: {
                        if (!string18.equals("enable_omid")) break;
                        n8 = 39;
                        break block133;
                    }
                    case -1439500848: {
                        if (!string18.equals("orientation")) break;
                        n8 = 37;
                        break block133;
                    }
                    case -1440104884: {
                        if (!string18.equals("is_custom_close_blocked")) break;
                        n8 = 35;
                        break block133;
                    }
                    case -1620470467: {
                        if (!string18.equals("backend_query_id")) break;
                        n8 = 47;
                        break block133;
                    }
                    case -1662989631: {
                        if (!string18.equals("is_interscroller")) break;
                        n8 = 53;
                        break block133;
                    }
                    case -1812055556: {
                        if (!string18.equals("play_prewarm_options")) break;
                        n8 = 49;
                        break block133;
                    }
                    case -1965512151: {
                        if (!string18.equals("omid_settings")) break;
                        n8 = 41;
                        break block133;
                    }
                    case -1980587809: {
                        if (!string18.equals("debug_signals")) break;
                        n8 = 28;
                        break block133;
                    }
                }
                n8 = -1;
            }
            switch (n8) {
                default: {
                    jsonReader.skipValue();
                    continue block130;
                }
                case 62: {
                    bl17 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 61: {
                    object = zzbx.zzb((JsonReader)jsonReader);
                    continue block130;
                }
                case 60: {
                    bl16 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 59: {
                    string12 = jsonReader.nextString();
                    continue block130;
                }
                case 58: {
                    bl15 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 57: {
                    jSONObject6 = zzbx.zzc((JsonReader)jsonReader);
                    continue block130;
                }
                case 56: {
                    bl14 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 55: {
                    string14 = jsonReader.nextString();
                    continue block130;
                }
                case 54: {
                    jSONObject5 = zzbx.zzc((JsonReader)jsonReader);
                    continue block130;
                }
                case 53: {
                    bl13 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 52: {
                    string8 = jsonReader.nextString();
                    continue block130;
                }
                case 51: {
                    string11 = zzbdn.zza((JSONObject)zzbx.zzc((JsonReader)jsonReader));
                    continue block130;
                }
                case 50: {
                    bl12 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 49: {
                    string10 = zzbzw.zza((JSONObject)zzbx.zzc((JsonReader)jsonReader));
                    continue block130;
                }
                case 48: {
                    bl11 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 47: {
                    string7 = jsonReader.nextString();
                    continue block130;
                }
                case 46: {
                    string6 = jsonReader.nextString();
                    continue block130;
                }
                case 45: {
                    n5 = jsonReader.nextInt();
                    continue block130;
                }
                case 44: {
                    n4 = jsonReader.nextInt();
                    continue block130;
                }
                case 43: {
                    bl10 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 42: {
                    bl9 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 41: {
                    jSONObject4 = zzbx.zzc((JsonReader)jsonReader);
                    continue block130;
                }
                case 40: {
                    string5 = jsonReader.nextString();
                    continue block130;
                }
                case 39: {
                    bl8 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 38: {
                    n3 = jsonReader.nextInt();
                    continue block130;
                }
                case 37: {
                    n2 = zzezz.zzd(jsonReader.nextString());
                    continue block130;
                }
                case 36: {
                    bl7 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 35: {
                    bl6 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 34: {
                    bl5 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 33: {
                    bl4 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 32: {
                    bl3 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 31: {
                    bl2 = jsonReader.nextBoolean();
                    continue block130;
                }
                case 30: {
                    bl = jsonReader.nextBoolean();
                    continue block130;
                }
                case 29: {
                    jSONObject3 = zzbx.zzc((JsonReader)jsonReader);
                    continue block130;
                }
                case 28: {
                    jSONObject2 = zzbx.zzc((JsonReader)jsonReader);
                    continue block130;
                }
                case 27: {
                    string4 = jsonReader.nextString();
                    continue block130;
                }
                case 26: {
                    string9 = zzcdv.zza((JSONObject)zzbx.zzc((JsonReader)jsonReader));
                    continue block130;
                }
                case 25: {
                    string3 = zzbx.zzc((JsonReader)jsonReader).toString();
                    continue block130;
                }
                case 24: {
                    string2 = jsonReader.nextString();
                    continue block130;
                }
                case 23: {
                    string = jsonReader.nextString();
                    continue block130;
                }
                case 22: {
                    jSONObject = zzbx.zzc((JsonReader)jsonReader);
                    continue block130;
                }
                case 21: {
                    string13 = jsonReader.nextString();
                    continue block130;
                }
                case 20: {
                    list12 = zzbx.zzb((JsonReader)jsonReader);
                    continue block130;
                }
                case 19: {
                    list13 = zzfaa.zza((JsonReader)jsonReader);
                    continue block130;
                }
                case 18: {
                    zzfae2 = new zzfae(jsonReader);
                    continue block130;
                }
                case 17: {
                    list11 = zzfaa.zza((JsonReader)jsonReader);
                    continue block130;
                }
                case 16: {
                    n = jsonReader.nextInt();
                    continue block130;
                }
                case 15: {
                    list10 = zzbx.zzb((JsonReader)jsonReader);
                    continue block130;
                }
                case 14: {
                    list9 = zzbx.zzb((JsonReader)jsonReader);
                    continue block130;
                }
                case 13: {
                    list8 = zzbx.zzb((JsonReader)jsonReader);
                    continue block130;
                }
                case 12: {
                    string15 = zzccl.zza((JSONArray)zzbx.zzd((JsonReader)jsonReader));
                    continue block130;
                }
                case 11: {
                    string17 = jsonReader.nextString();
                    continue block130;
                }
                case 10: {
                    string16 = jsonReader.nextString();
                    continue block130;
                }
                case 9: {
                    list7 = zzbx.zzb((JsonReader)jsonReader);
                    continue block130;
                }
                case 8: {
                    list6 = zzbx.zzb((JsonReader)jsonReader);
                    continue block130;
                }
                case 7: {
                    zzbx.zzb((JsonReader)jsonReader);
                    continue block130;
                }
                case 6: {
                    list5 = zzbx.zzb((JsonReader)jsonReader);
                    continue block130;
                }
                case 5: {
                    n6 = zzezz.zzc(jsonReader.nextInt());
                    continue block130;
                }
                case 4: {
                    list4 = zzbx.zzb((JsonReader)jsonReader);
                    continue block130;
                }
                case 3: {
                    list3 = zzbx.zzb((JsonReader)jsonReader);
                    continue block130;
                }
                case 2: {
                    list2 = zzbx.zzb((JsonReader)jsonReader);
                    continue block130;
                }
                case 1: {
                    n7 = zzezz.zzb(jsonReader.nextString());
                    continue block130;
                }
                case 0: 
            }
            list = zzbx.zzb((JsonReader)jsonReader);
        }
    }

    public static String zza(int n) {
        switch (n) {
            default: {
                return "UNKNOWN";
            }
            case 7: {
                return "REWARDED_INTERSTITIAL";
            }
            case 6: {
                return "APP_OPEN_AD";
            }
            case 5: {
                return "REWARDED";
            }
            case 4: {
                return "NATIVE";
            }
            case 3: {
                return "NATIVE_EXPRESS";
            }
            case 2: {
                return "INTERSTITIAL";
            }
            case 1: 
        }
        return "BANNER";
    }

    private static int zzb(String string) {
        if ("banner".equals(string)) {
            return 1;
        }
        if ("interstitial".equals(string)) {
            return 2;
        }
        if ("native_express".equals(string)) {
            return 3;
        }
        if ("native".equals(string)) {
            return 4;
        }
        if ("rewarded".equals(string)) {
            return 5;
        }
        if ("app_open_ad".equals(string)) return 6;
        if ("app_open_ad_v2".equals(string)) {
            return 6;
        }
        if (!"rewarded_interstitial".equals(string)) return 0;
        return 7;
    }

    private static int zzc(int n) {
        int n2 = n;
        if (n == 0) return n2;
        n2 = n == 1 ? n : 0;
        return n2;
    }

    private static final int zzd(String string) {
        if ("landscape".equalsIgnoreCase(string)) {
            return 6;
        }
        if (!"portrait".equalsIgnoreCase(string)) return -1;
        return 7;
    }
}
