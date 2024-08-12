/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzagm
 *  com.google.android.gms.internal.ads.zzajx
 *  com.google.android.gms.internal.ads.zzake
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzajx;
import com.google.android.gms.internal.ads.zzake;
import com.google.android.gms.internal.ads.zzamq;
import java.util.ArrayList;
import java.util.List;

public final class zzakf
extends zzajx {
    public static final Parcelable.Creator<zzakf> CREATOR = new zzake();
    public final String zza;
    public final String zzb;

    zzakf(Parcel parcel) {
        String string = parcel.readString();
        int n = zzamq.zza;
        super(string);
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
    }

    public zzakf(String string, String string2, String string3) {
        super(string);
        this.zza = string2;
        this.zzb = string3;
    }

    private static List<Integer> zzb(String string) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        try {
            if (string.length() >= 10) {
                arrayList.add(Integer.parseInt(string.substring(0, 4)));
                arrayList.add(Integer.parseInt(string.substring(5, 7)));
                arrayList.add(Integer.parseInt(string.substring(8, 10)));
            } else if (string.length() >= 7) {
                arrayList.add(Integer.parseInt(string.substring(0, 4)));
                arrayList.add(Integer.parseInt(string.substring(5, 7)));
            } else {
                if (string.length() < 4) return arrayList;
                arrayList.add(Integer.parseInt(string.substring(0, 4)));
            }
            return arrayList;
        }
        catch (NumberFormatException numberFormatException) {
            return new ArrayList<Integer>();
        }
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (((Object)((Object)this)).getClass() != object.getClass()) {
            return false;
        }
        object = (zzakf)((Object)object);
        if (!zzamq.zzc((Object)this.zzf, (Object)((zzakf)((Object)object)).zzf)) return false;
        if (!zzamq.zzc((Object)this.zza, (Object)((zzakf)((Object)object)).zza)) return false;
        if (!zzamq.zzc((Object)this.zzb, (Object)((zzakf)((Object)object)).zzb)) return false;
        return true;
    }

    public final int hashCode() {
        int n = this.zzf.hashCode();
        String string = this.zza;
        int n2 = 0;
        int n3 = string != null ? string.hashCode() : 0;
        string = this.zzb;
        if (string == null) return ((n + 527) * 31 + n3) * 31 + n2;
        n2 = string.hashCode();
        return ((n + 527) * 31 + n3) * 31 + n2;
    }

    public final String toString() {
        String string = this.zzf;
        String string2 = this.zza;
        String string3 = this.zzb;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 22 + String.valueOf(string2).length() + String.valueOf(string3).length());
        stringBuilder.append(string);
        stringBuilder.append(": description=");
        stringBuilder.append(string2);
        stringBuilder.append(": value=");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    public final void zza(zzagm zzagm2) {
        int n;
        block52: {
            String string = this.zzf;
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 2590194: {
                    if (!string.equals("TYER")) break;
                    n = 11;
                    break block52;
                }
                case 2583398: {
                    if (!string.equals("TRCK")) break;
                    n = 9;
                    break block52;
                }
                case 2581514: {
                    if (!string.equals("TPE3")) break;
                    n = 19;
                    break block52;
                }
                case 2581513: {
                    if (!string.equals("TPE2")) break;
                    n = 5;
                    break block52;
                }
                case 2581512: {
                    if (!string.equals("TPE1")) break;
                    n = 3;
                    break block52;
                }
                case 2575251: {
                    if (!string.equals("TIT2")) break;
                    n = 1;
                    break block52;
                }
                case 2571565: {
                    if (!string.equals("TEXT")) break;
                    n = 21;
                    break block52;
                }
                case 2570410: {
                    if (!string.equals("TDRL")) break;
                    n = 15;
                    break block52;
                }
                case 2570401: {
                    if (!string.equals("TDRC")) break;
                    n = 14;
                    break block52;
                }
                case 2569891: {
                    if (!string.equals("TDAT")) break;
                    n = 13;
                    break block52;
                }
                case 2569357: {
                    if (!string.equals("TCOM")) break;
                    n = 17;
                    break block52;
                }
                case 2567331: {
                    if (!string.equals("TALB")) break;
                    n = 7;
                    break block52;
                }
                case 83552: {
                    if (!string.equals("TYE")) break;
                    n = 10;
                    break block52;
                }
                case 83536: {
                    if (!string.equals("TXT")) break;
                    n = 20;
                    break block52;
                }
                case 83378: {
                    if (!string.equals("TT2")) break;
                    n = 0;
                    break block52;
                }
                case 83341: {
                    if (!string.equals("TRK")) break;
                    n = 8;
                    break block52;
                }
                case 83255: {
                    if (!string.equals("TP3")) break;
                    n = 18;
                    break block52;
                }
                case 83254: {
                    if (!string.equals("TP2")) break;
                    n = 4;
                    break block52;
                }
                case 83253: {
                    if (!string.equals("TP1")) break;
                    n = 2;
                    break block52;
                }
                case 82897: {
                    if (!string.equals("TDA")) break;
                    n = 12;
                    break block52;
                }
                case 82878: {
                    if (!string.equals("TCM")) break;
                    n = 16;
                    break block52;
                }
                case 82815: {
                    if (!string.equals("TAL")) break;
                    n = 6;
                    break block52;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return;
            }
            case 20: 
            case 21: {
                zzagm2.zzG((CharSequence)this.zzb);
                return;
            }
            case 18: 
            case 19: {
                zzagm2.zzI((CharSequence)this.zzb);
                return;
            }
            case 16: 
            case 17: {
                zzagm2.zzH((CharSequence)this.zzb);
                return;
            }
            case 15: {
                List<Integer> list = zzakf.zzb(this.zzb);
                n = list.size();
                if (n != 1) {
                    if (n != 2) {
                        if (n != 3) {
                            return;
                        }
                        zzagm2.zzF(list.get(2));
                    }
                    zzagm2.zzE(list.get(1));
                }
                zzagm2.zzD(list.get(0));
                return;
            }
            case 14: {
                List<Integer> list = zzakf.zzb(this.zzb);
                n = list.size();
                if (n != 1) {
                    if (n != 2) {
                        if (n != 3) {
                            return;
                        }
                        zzagm2.zzC(list.get(2));
                    }
                    zzagm2.zzB(list.get(1));
                }
                zzagm2.zzA(list.get(0));
                return;
            }
            case 12: 
            case 13: {
                int n2 = Integer.parseInt(this.zzb.substring(2, 4));
                n = Integer.parseInt(this.zzb.substring(0, 2));
                zzagm2.zzB(Integer.valueOf(n2));
                zzagm2.zzC(Integer.valueOf(n));
                return;
            }
            case 10: 
            case 11: {
                zzagm2.zzA(Integer.valueOf(Integer.parseInt(this.zzb)));
                return;
            }
            case 8: 
            case 9: {
                void var4_11;
                String[] stringArray = zzamq.zzt((String)this.zzb, (String)"/");
                n = Integer.parseInt(stringArray[0]);
                if (stringArray.length > 1) {
                    Integer n3 = Integer.parseInt(stringArray[1]);
                } else {
                    Object var4_10 = null;
                }
                zzagm2.zzy(Integer.valueOf(n));
                zzagm2.zzz((Integer)var4_11);
                return;
            }
            case 6: 
            case 7: {
                zzagm2.zzu((CharSequence)this.zzb);
                return;
            }
            case 4: 
            case 5: {
                zzagm2.zzv((CharSequence)this.zzb);
                return;
            }
            case 2: 
            case 3: {
                zzagm2.zzt((CharSequence)this.zzb);
                return;
            }
            case 0: 
            case 1: 
        }
        zzagm2.zzs((CharSequence)this.zzb);
        return;
        catch (NumberFormatException | StringIndexOutOfBoundsException runtimeException) {
            return;
        }
        catch (NumberFormatException numberFormatException) {
            return;
        }
        catch (NumberFormatException numberFormatException) {
            return;
        }
    }
}
