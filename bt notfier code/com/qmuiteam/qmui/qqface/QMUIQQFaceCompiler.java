/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.text.Spannable
 *  android.util.LruCache
 *  com.qmuiteam.qmui.qqface.IQMUIQQFaceManager
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler$Element
 *  com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler$ElementList
 *  com.qmuiteam.qmui.span.QMUITouchableSpan
 *  com.qmuiteam.qmui.util.QMUILangHelper
 */
package com.qmuiteam.qmui.qqface;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.util.LruCache;
import com.qmuiteam.qmui.qqface.IQMUIQQFaceManager;
import com.qmuiteam.qmui.qqface.QMUIQQFaceCompiler;
import com.qmuiteam.qmui.span.QMUITouchableSpan;
import com.qmuiteam.qmui.util.QMUILangHelper;
import java.util.Arrays;

public class QMUIQQFaceCompiler {
    private static final int SPAN_COLUMN = 2;
    private static volatile QMUIQQFaceCompiler sInstance;
    private LruCache<CharSequence, ElementList> mCache = new LruCache(30);
    private IQMUIQQFaceManager mQQFaceManager;

    private QMUIQQFaceCompiler(IQMUIQQFaceManager iQMUIQQFaceManager) {
        this.mQQFaceManager = iQMUIQQFaceManager;
    }

    static /* synthetic */ ElementList access$000(QMUIQQFaceCompiler qMUIQQFaceCompiler, CharSequence charSequence, int n, int n2, boolean bl) {
        return qMUIQQFaceCompiler.compile(charSequence, n, n2, bl);
    }

    private ElementList compile(CharSequence object, int n, int n2, boolean bl) {
        boolean bl2 = QMUILangHelper.isNullOrEmpty((CharSequence)object);
        ElementList elementList = null;
        if (bl2) {
            return null;
        }
        if (n >= 0 && n < object.length()) {
            Object object2;
            QMUITouchableSpan[] qMUITouchableSpanArray;
            if (n2 <= n) throw new IllegalArgumentException("end must > start");
            int n3 = object.length();
            if (n2 <= n3) {
                n3 = n2;
            }
            n2 = 0;
            int n4 = 0;
            if (!bl && object instanceof Spannable) {
                Spannable spannable = (Spannable)object;
                qMUITouchableSpanArray = (QMUITouchableSpan[])spannable.getSpans(0, object.length() - 1, QMUITouchableSpan.class);
                Arrays.sort(qMUITouchableSpanArray, new /* Unavailable Anonymous Inner Class!! */);
                n2 = qMUITouchableSpanArray.length > 0 ? 1 : 0;
                if (n2 != 0) {
                    object2 = new int[qMUITouchableSpanArray.length * 2];
                    while (true) {
                        elementList = object2;
                        if (n4 < qMUITouchableSpanArray.length) {
                            int n5 = n4 * 2;
                            object2[n5] = (ElementList)spannable.getSpanStart((Object)qMUITouchableSpanArray[n4]);
                            object2[n5 + 1] = (ElementList)spannable.getSpanEnd((Object)qMUITouchableSpanArray[n4]);
                            ++n4;
                            continue;
                        }
                        break;
                    }
                }
            } else {
                qMUITouchableSpanArray = null;
                elementList = null;
            }
            object2 = (ElementList)this.mCache.get(object);
            if (n2 == 0 && object2 != null && n == object2.getStart() && n3 == object2.getEnd()) {
                return object2;
            }
            elementList = this.realCompile((CharSequence)object, n, n3, qMUITouchableSpanArray, (int[])elementList);
            this.mCache.put(object, (Object)elementList);
            return elementList;
        }
        object = new IllegalArgumentException("start must >= 0 and < text.length");
        throw object;
    }

    public static QMUIQQFaceCompiler getInstance(IQMUIQQFaceManager iQMUIQQFaceManager) {
        if (sInstance != null) return sInstance;
        synchronized (QMUIQQFaceCompiler.class) {
            QMUIQQFaceCompiler qMUIQQFaceCompiler;
            if (sInstance != null) return sInstance;
            sInstance = qMUIQQFaceCompiler = new QMUIQQFaceCompiler(iQMUIQQFaceManager);
        }
        return sInstance;
    }

    /*
     * Unable to fully structure code
     */
    private ElementList realCompile(CharSequence var1_1, int var2_2, int var3_3, QMUITouchableSpan[] var4_4, int[] var5_5) {
        var19_6 = var4_4;
        var16_7 = var1_1.length();
        if (var19_6 != null && var19_6.length > 0) {
            var10_8 = var5_5[0];
            var11_9 = var5_5[1];
            var9_10 = 0;
        } else {
            var9_10 = -1;
            var10_8 = 0x7FFFFFFF;
            var11_9 = 0x7FFFFFFF;
        }
        var20_11 = new ElementList(var2_2, var3_3);
        if (var2_2 > 0) {
            var20_11.add(Element.createTextElement((CharSequence)var1_1.subSequence(0, var2_2)));
        }
        var7_13 = var8_12 = var2_2;
        var12_14 = var10_8;
        var15_15 = var9_10;
        block0: while (true) {
            var9_10 = 0;
            var10_8 = var11_9;
            var11_9 = var12_14;
            while (true) {
                block34: {
                    block33: {
                        block32: {
                            block31: {
                                block27: {
                                    block28: {
                                        block30: {
                                            block29: {
                                                if (var8_12 >= var3_3) {
                                                    if (var7_13 >= var3_3) return var20_11;
                                                    var20_11.add(Element.createTextElement((CharSequence)var1_1.subSequence(var7_13, var16_7)));
                                                    return var20_11;
                                                }
                                                if (var8_12 == var11_9) {
                                                    var12_14 = var9_10;
                                                    if (var8_12 - var7_13 > 0) {
                                                        var13_17 = var7_13;
                                                        var12_14 = var9_10;
                                                        if (var9_10 != 0) {
                                                            var13_17 = var7_13 - 1;
                                                            var12_14 = 0;
                                                        }
                                                        var20_11.add(Element.createTextElement((CharSequence)var1_1.subSequence(var13_17, var8_12)));
                                                    }
                                                    var20_11.add(Element.createTouchSpanElement((CharSequence)var1_1.subSequence(var11_9, var10_8), (QMUITouchableSpan)var19_6[var15_15], (QMUIQQFaceCompiler)this));
                                                    if (++var15_15 >= var19_6.length) {
                                                        var7_13 = var8_12 = var10_8;
                                                        var11_9 = 0x7FFFFFFF;
                                                        var10_8 = 0x7FFFFFFF;
                                                        var9_10 = var12_14;
                                                        continue;
                                                    }
                                                    var7_13 = var15_15 * 2;
                                                    var11_9 = var5_5[var7_13];
                                                    var8_12 = var5_5[var7_13 + 1];
                                                    var7_13 = var10_8;
                                                    var10_8 = var8_12;
                                                    var8_12 = var7_13;
                                                    var9_10 = var12_14;
                                                    continue;
                                                }
                                                var6_16 = var1_1.charAt(var8_12);
                                                if (var6_16 == '[') {
                                                    if (var8_12 - var7_13 > 0) {
                                                        var20_11.add(Element.createTextElement((CharSequence)var1_1.subSequence(var7_13, var8_12)));
                                                    }
                                                    var7_13 = var8_12++;
                                                    var9_10 = 1;
                                                    continue;
                                                }
                                                if (var6_16 != ']' || var9_10 == 0) break block27;
                                                var9_10 = var7_13;
                                                if (++var8_12 - var7_13 <= 0) break block28;
                                                var21_21 = var1_1.subSequence(var7_13, var8_12).toString();
                                                var22_22 = this.mQQFaceManager.getSpecialBoundsDrawable((CharSequence)var21_21);
                                                if (var22_22 == null) break block29;
                                                var20_11.add(Element.createSpeaicalBoundsDrawableElement((Drawable)var22_22));
                                                break block30;
                                            }
                                            var12_14 = this.mQQFaceManager.getQQfaceResource((CharSequence)var21_21);
                                            var9_10 = var7_13;
                                            if (var12_14 == 0) break block28;
                                            var20_11.add(Element.createDrawableElement((int)var12_14));
                                        }
                                        var9_10 = var8_12;
                                    }
                                    var12_14 = var11_9;
                                    var11_9 = var10_8;
                                    var7_13 = var9_10;
                                    continue block0;
                                }
                                if (var6_16 == '\n') {
                                    var12_14 = var9_10;
                                    if (var9_10 != 0) {
                                        var12_14 = 0;
                                    }
                                    if (var8_12 - var7_13 > 0) {
                                        var20_11.add(Element.createTextElement((CharSequence)var1_1.subSequence(var7_13, var8_12)));
                                    }
                                    var20_11.add(Element.createNextLineElement());
                                    var8_12 = var7_13 = var8_12 + 1;
                                    var9_10 = var12_14;
                                    continue;
                                }
                                var12_14 = var9_10;
                                if (var9_10 != 0) {
                                    if (var8_12 - var7_13 > 8) {
                                        var12_14 = 0;
                                    } else {
                                        ++var8_12;
                                        continue;
                                    }
                                }
                                if (!this.mQQFaceManager.maybeSoftBankEmoji(var6_16)) break block31;
                                var9_10 = this.mQQFaceManager.getSoftbankEmojiResource(var6_16);
                                if (var9_10 == 0) break block32;
                                var14_18 = 1;
                                break block33;
                            }
                            var9_10 = 0;
                        }
                        var14_18 = 0;
                    }
                    var13_17 = var9_10;
                    if (var9_10 != 0) break block34;
                    var17_19 = Character.codePointAt(var1_1, var8_12);
                    var14_18 = Character.charCount(var17_19);
                    var13_17 = var9_10;
                    if (this.mQQFaceManager.maybeEmoji(var17_19)) {
                        var13_17 = this.mQQFaceManager.getEmojiResource(var17_19);
                    }
                    var9_10 = var13_17;
                    if (var13_17 != 0) ** GOTO lbl-1000
                    var18_20 = var2_2 + var14_18;
                    var9_10 = var13_17;
                    if (var18_20 >= var3_3) ** GOTO lbl-1000
                    var18_20 = Character.codePointAt(var1_1, var18_20);
                    var9_10 = var13_17 = this.mQQFaceManager.getDoubleUnicodeEmoji(var17_19, var18_20);
                    if (var13_17 != 0) {
                        var14_18 += Character.charCount(var18_20);
                    } else lbl-1000:
                    // 3 sources

                    {
                        var13_17 = var9_10;
                    }
                }
                if (var13_17 != 0) {
                    if (var7_13 != var8_12) {
                        var20_11.add(Element.createTextElement((CharSequence)var1_1.subSequence(var7_13, var8_12)));
                    }
                    var20_11.add(Element.createDrawableElement((int)var13_17));
                    var7_13 = var8_12 += var14_18;
                } else {
                    ++var8_12;
                }
                var19_6 = var4_4;
                var9_10 = var12_14;
            }
            break;
        }
    }

    public ElementList compile(CharSequence charSequence) {
        if (!QMUILangHelper.isNullOrEmpty((CharSequence)charSequence)) return this.compile(charSequence, 0, charSequence.length());
        return null;
    }

    public ElementList compile(CharSequence charSequence, int n, int n2) {
        return this.compile(charSequence, n, n2, false);
    }

    public int getSpecialBoundsMaxHeight() {
        return this.mQQFaceManager.getSpecialDrawableMaxHeight();
    }

    public void setCache(LruCache<CharSequence, ElementList> lruCache) {
        this.mCache = lruCache;
    }
}
