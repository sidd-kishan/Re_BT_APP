/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  demo.Pinyin4jAppletDemo
 *  net.sourceforge.pinyin4j.PinyinHelper
 *  net.sourceforge.pinyin4j.format.HanyuPinyinCaseType
 *  net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat
 *  net.sourceforge.pinyin4j.format.HanyuPinyinToneType
 *  net.sourceforge.pinyin4j.format.HanyuPinyinVCharType
 *  net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination
 */
package demo;

import demo.Pinyin4jAppletDemo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

final class Pinyin4jAppletDemo$2
implements ActionListener {
    private final Pinyin4jAppletDemo this$0;

    Pinyin4jAppletDemo$2(Pinyin4jAppletDemo pinyin4jAppletDemo) {
        this.this$0 = pinyin4jAppletDemo;
    }

    private String concatPinyinStringArray(String[] stringArray) {
        StringBuffer stringBuffer = new StringBuffer();
        if (stringArray == null) return stringBuffer.toString();
        if (stringArray.length <= 0) return stringBuffer.toString();
        int n = 0;
        while (n < stringArray.length) {
            stringBuffer.append(stringArray[n]);
            stringBuffer.append(System.getProperty("line.separator"));
            ++n;
        }
        return stringBuffer.toString();
    }

    private void updateFormattedTextField(char c, String object, String stringArray, String string) {
        HanyuPinyinOutputFormat hanyuPinyinOutputFormat;
        block18: {
            block17: {
                block16: {
                    block15: {
                        block13: {
                            block14: {
                                block12: {
                                    block11: {
                                        block9: {
                                            block10: {
                                                block8: {
                                                    hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
                                                    if (this.this$0.toneTypes[0] != object) break block8;
                                                    object = HanyuPinyinToneType.WITH_TONE_NUMBER;
                                                    break block9;
                                                }
                                                if (this.this$0.toneTypes[1] != object) break block10;
                                                object = HanyuPinyinToneType.WITHOUT_TONE;
                                                break block9;
                                            }
                                            if (this.this$0.toneTypes[2] != object) break block11;
                                            object = HanyuPinyinToneType.WITH_TONE_MARK;
                                        }
                                        hanyuPinyinOutputFormat.setToneType((HanyuPinyinToneType)object);
                                    }
                                    if (this.this$0.vCharTypes[0] != stringArray) break block12;
                                    object = HanyuPinyinVCharType.WITH_U_AND_COLON;
                                    break block13;
                                }
                                if (this.this$0.vCharTypes[1] != stringArray) break block14;
                                object = HanyuPinyinVCharType.WITH_V;
                                break block13;
                            }
                            if (this.this$0.vCharTypes[2] != stringArray) break block15;
                            object = HanyuPinyinVCharType.WITH_U_UNICODE;
                        }
                        hanyuPinyinOutputFormat.setVCharType((HanyuPinyinVCharType)object);
                    }
                    if (this.this$0.caseTypes[0] != string) break block16;
                    object = HanyuPinyinCaseType.LOWERCASE;
                    break block17;
                }
                if (this.this$0.caseTypes[1] != string) break block18;
                object = HanyuPinyinCaseType.UPPERCASE;
            }
            hanyuPinyinOutputFormat.setCaseType((HanyuPinyinCaseType)object);
        }
        object = null;
        try {
            object = stringArray = PinyinHelper.toHanyuPinyinStringArray((char)c, (HanyuPinyinOutputFormat)hanyuPinyinOutputFormat);
        }
        catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }
        object = this.concatPinyinStringArray((String[])object);
        Pinyin4jAppletDemo.access$1000((Pinyin4jAppletDemo)this.this$0).setText((String)object);
    }

    private void updateUnformattedTextField(char c) {
        Pinyin4jAppletDemo.access$400((Pinyin4jAppletDemo)this.this$0).setText(this.concatPinyinStringArray(PinyinHelper.toHanyuPinyinStringArray((char)c)));
        Pinyin4jAppletDemo.access$500((Pinyin4jAppletDemo)this.this$0).setText(this.concatPinyinStringArray(PinyinHelper.toTongyongPinyinStringArray((char)c)));
        Pinyin4jAppletDemo.access$600((Pinyin4jAppletDemo)this.this$0).setText(this.concatPinyinStringArray(PinyinHelper.toWadeGilesPinyinStringArray((char)c)));
        Pinyin4jAppletDemo.access$700((Pinyin4jAppletDemo)this.this$0).setText(this.concatPinyinStringArray(PinyinHelper.toMPS2PinyinStringArray((char)c)));
        Pinyin4jAppletDemo.access$800((Pinyin4jAppletDemo)this.this$0).setText(this.concatPinyinStringArray(PinyinHelper.toYalePinyinStringArray((char)c)));
        Pinyin4jAppletDemo.access$900((Pinyin4jAppletDemo)this.this$0).setText(this.concatPinyinStringArray(PinyinHelper.toGwoyeuRomatzyhStringArray((char)c)));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        char c = Pinyin4jAppletDemo.access$000((Pinyin4jAppletDemo)this.this$0).charAt(0);
        this.updateUnformattedTextField(c);
        this.updateFormattedTextField(c, (String)Pinyin4jAppletDemo.access$100((Pinyin4jAppletDemo)this.this$0).getSelectedItem(), (String)Pinyin4jAppletDemo.access$200((Pinyin4jAppletDemo)this.this$0).getSelectedItem(), (String)Pinyin4jAppletDemo.access$300((Pinyin4jAppletDemo)this.this$0).getSelectedItem());
    }
}
