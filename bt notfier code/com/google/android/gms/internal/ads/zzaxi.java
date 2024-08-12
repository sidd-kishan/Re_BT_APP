/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.common.util.MurmurHash3
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.MurmurHash3;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzaxi {
    public static int zza(String object) {
        block2: {
            byte[] byArray;
            try {
                byArray = ((String)object).getBytes("UTF-8");
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                object = ((String)object).getBytes();
                break block2;
            }
            object = byArray;
        }
        return MurmurHash3.murmurhash3_x86_32((byte[])object, (int)0, (int)((Object)object).length, (int)0);
    }

    public static String[] zzb(String object, boolean bl) {
        if (object == null) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        char[] cArray = ((String)object).toCharArray();
        int n = ((String)object).length();
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (true) {
            int n5;
            int n6;
            int n7;
            block16: {
                block14: {
                    block15: {
                        block12: {
                            block11: {
                                block13: {
                                    block10: {
                                        if (n2 >= n) {
                                            if (n3 == 0) return arrayList.toArray(new String[arrayList.size()]);
                                            arrayList.add(new String(cArray, n4, n2 - n4));
                                            return arrayList.toArray(new String[arrayList.size()]);
                                        }
                                        n7 = Character.codePointAt(cArray, n2);
                                        n6 = Character.charCount(n7);
                                        if (!Character.isLetter(n7) || (object = Character.UnicodeBlock.of(n7)) != Character.UnicodeBlock.BOPOMOFO && object != Character.UnicodeBlock.BOPOMOFO_EXTENDED && object != Character.UnicodeBlock.CJK_COMPATIBILITY && object != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS && object != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS_SUPPLEMENT && object != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS && object != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A && object != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B && object != Character.UnicodeBlock.ENCLOSED_CJK_LETTERS_AND_MONTHS && object != Character.UnicodeBlock.HANGUL_JAMO && object != Character.UnicodeBlock.HANGUL_SYLLABLES && object != Character.UnicodeBlock.HIRAGANA && object != Character.UnicodeBlock.KATAKANA && object != Character.UnicodeBlock.KATAKANA_PHONETIC_EXTENSIONS && (n7 < 65382 || n7 > 65437) && (n7 < 65441 || n7 > 65500)) break block10;
                                        if (n3 != 0) {
                                            arrayList.add(new String(cArray, n4, n2 - n4));
                                        }
                                        arrayList.add(new String(cArray, n2, n6));
                                        break block11;
                                    }
                                    if (Character.isLetterOrDigit(n7) || Character.getType(n7) == 6 || Character.getType(n7) == 8) break block12;
                                    if (!bl || Character.charCount(n7) != 1 || Character.toChars(n7)[0] != '\'') break block13;
                                    if (1 == n3) break block14;
                                    break block15;
                                }
                                n7 = n3;
                                n5 = n4;
                                if (n3 == 0) break block16;
                                arrayList.add(new String(cArray, n4, n2 - n4));
                            }
                            n7 = 0;
                            n5 = n4;
                            break block16;
                        }
                        if (true == n3) break block14;
                    }
                    n4 = n2;
                }
                n7 = 1;
                n5 = n4;
            }
            n2 += n6;
            n3 = n7;
            n4 = n5;
        }
    }
}
