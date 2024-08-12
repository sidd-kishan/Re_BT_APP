/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  demo.Pinyin4jAppletDemo
 */
package demo;

import demo.Pinyin4jAppletDemo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

final class Pinyin4jAppletDemo$3
implements ActionListener {
    private final Pinyin4jAppletDemo this$0;

    Pinyin4jAppletDemo$3(Pinyin4jAppletDemo pinyin4jAppletDemo) {
        this.this$0 = pinyin4jAppletDemo;
    }

    @Override
    public void actionPerformed(ActionEvent serializable) {
        boolean bl;
        if (this.this$0.toneTypes[2] == (String)Pinyin4jAppletDemo.access$100((Pinyin4jAppletDemo)this.this$0).getSelectedItem()) {
            Pinyin4jAppletDemo.access$200((Pinyin4jAppletDemo)this.this$0).setSelectedIndex(2);
            serializable = Pinyin4jAppletDemo.access$200((Pinyin4jAppletDemo)this.this$0);
            bl = false;
        } else {
            serializable = Pinyin4jAppletDemo.access$200((Pinyin4jAppletDemo)this.this$0);
            bl = true;
        }
        ((JComboBox)serializable).setEnabled(bl);
    }
}
