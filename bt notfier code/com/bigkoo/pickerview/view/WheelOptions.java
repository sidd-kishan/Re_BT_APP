/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 *  android.view.View
 *  com.bigkoo.pickerview.R$id
 *  com.bigkoo.pickerview.adapter.ArrayWheelAdapter
 *  com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener
 *  com.contrarywind.adapter.WheelAdapter
 *  com.contrarywind.listener.OnItemSelectedListener
 *  com.contrarywind.view.WheelView
 *  com.contrarywind.view.WheelView$DividerType
 */
package com.bigkoo.pickerview.view;

import android.graphics.Typeface;
import android.view.View;
import com.bigkoo.pickerview.R;
import com.bigkoo.pickerview.adapter.ArrayWheelAdapter;
import com.bigkoo.pickerview.listener.OnOptionsSelectChangeListener;
import com.contrarywind.adapter.WheelAdapter;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;
import java.util.List;

public class WheelOptions<T> {
    private int dividerColor;
    private WheelView.DividerType dividerType;
    private boolean isRestoreItem;
    private float lineSpacingMultiplier;
    private boolean linkage = true;
    private List<T> mOptions1Items;
    private List<List<T>> mOptions2Items;
    private List<List<List<T>>> mOptions3Items;
    private OnOptionsSelectChangeListener optionsSelectChangeListener;
    private int textColorCenter;
    private int textColorOut;
    private View view;
    private OnItemSelectedListener wheelListener_option1;
    private OnItemSelectedListener wheelListener_option2;
    private WheelView wv_option1;
    private WheelView wv_option2;
    private WheelView wv_option3;

    public WheelOptions(View view, boolean bl) {
        this.isRestoreItem = bl;
        this.view = view;
        this.wv_option1 = (WheelView)view.findViewById(R.id.options1);
        this.wv_option2 = (WheelView)view.findViewById(R.id.options2);
        this.wv_option3 = (WheelView)view.findViewById(R.id.options3);
    }

    static /* synthetic */ List access$000(WheelOptions wheelOptions) {
        return wheelOptions.mOptions2Items;
    }

    static /* synthetic */ OnOptionsSelectChangeListener access$100(WheelOptions wheelOptions) {
        return wheelOptions.optionsSelectChangeListener;
    }

    static /* synthetic */ WheelView access$200(WheelOptions wheelOptions) {
        return wheelOptions.wv_option1;
    }

    static /* synthetic */ boolean access$300(WheelOptions wheelOptions) {
        return wheelOptions.isRestoreItem;
    }

    static /* synthetic */ WheelView access$400(WheelOptions wheelOptions) {
        return wheelOptions.wv_option2;
    }

    static /* synthetic */ List access$500(WheelOptions wheelOptions) {
        return wheelOptions.mOptions3Items;
    }

    static /* synthetic */ OnItemSelectedListener access$600(WheelOptions wheelOptions) {
        return wheelOptions.wheelListener_option2;
    }

    static /* synthetic */ WheelView access$700(WheelOptions wheelOptions) {
        return wheelOptions.wv_option3;
    }

    private void itemSelected(int n, int n2, int n3) {
        List<List<Object>> list;
        if (this.mOptions1Items != null) {
            this.wv_option1.setCurrentItem(n);
        }
        if ((list = this.mOptions2Items) != null) {
            this.wv_option2.setAdapter((WheelAdapter)new ArrayWheelAdapter(list.get(n)));
            this.wv_option2.setCurrentItem(n2);
        }
        if ((list = this.mOptions3Items) == null) return;
        this.wv_option3.setAdapter((WheelAdapter)new ArrayWheelAdapter((List)list.get(n).get(n2)));
        this.wv_option3.setCurrentItem(n3);
    }

    private void setDividerColor() {
        this.wv_option1.setDividerColor(this.dividerColor);
        this.wv_option2.setDividerColor(this.dividerColor);
        this.wv_option3.setDividerColor(this.dividerColor);
    }

    private void setDividerType() {
        this.wv_option1.setDividerType(this.dividerType);
        this.wv_option2.setDividerType(this.dividerType);
        this.wv_option3.setDividerType(this.dividerType);
    }

    private void setLineSpacingMultiplier() {
        this.wv_option1.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_option2.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        this.wv_option3.setLineSpacingMultiplier(this.lineSpacingMultiplier);
    }

    private void setTextColorCenter() {
        this.wv_option1.setTextColorCenter(this.textColorCenter);
        this.wv_option2.setTextColorCenter(this.textColorCenter);
        this.wv_option3.setTextColorCenter(this.textColorCenter);
    }

    private void setTextColorOut() {
        this.wv_option1.setTextColorOut(this.textColorOut);
        this.wv_option2.setTextColorOut(this.textColorOut);
        this.wv_option3.setTextColorOut(this.textColorOut);
    }

    public int[] getCurrentItems() {
        int[] nArray = new int[3];
        int n = this.wv_option1.getCurrentItem();
        int n2 = 0;
        nArray[0] = n;
        List<List<Object>> list = this.mOptions2Items;
        if (list != null && list.size() > 0) {
            n = this.wv_option2.getCurrentItem() > this.mOptions2Items.get(nArray[0]).size() - 1 ? 0 : this.wv_option2.getCurrentItem();
            nArray[1] = n;
        } else {
            nArray[1] = this.wv_option2.getCurrentItem();
        }
        list = this.mOptions3Items;
        if (list != null && list.size() > 0) {
            n = this.wv_option3.getCurrentItem() > this.mOptions3Items.get(nArray[0]).get(nArray[1]).size() - 1 ? n2 : this.wv_option3.getCurrentItem();
            nArray[2] = n;
        } else {
            nArray[2] = this.wv_option3.getCurrentItem();
        }
        return nArray;
    }

    public View getView() {
        return this.view;
    }

    public void isCenterLabel(boolean bl) {
        this.wv_option1.isCenterLabel(bl);
        this.wv_option2.isCenterLabel(bl);
        this.wv_option3.isCenterLabel(bl);
    }

    public void setCurrentItems(int n, int n2, int n3) {
        if (this.linkage) {
            this.itemSelected(n, n2, n3);
        } else {
            this.wv_option1.setCurrentItem(n);
            this.wv_option2.setCurrentItem(n2);
            this.wv_option3.setCurrentItem(n3);
        }
    }

    public void setCyclic(boolean bl) {
        this.wv_option1.setCyclic(bl);
        this.wv_option2.setCyclic(bl);
        this.wv_option3.setCyclic(bl);
    }

    public void setCyclic(boolean bl, boolean bl2, boolean bl3) {
        this.wv_option1.setCyclic(bl);
        this.wv_option2.setCyclic(bl2);
        this.wv_option3.setCyclic(bl3);
    }

    public void setDividerColor(int n) {
        this.dividerColor = n;
        this.setDividerColor();
    }

    public void setDividerType(WheelView.DividerType dividerType) {
        this.dividerType = dividerType;
        this.setDividerType();
    }

    public void setLabels(String string, String string2, String string3) {
        if (string != null) {
            this.wv_option1.setLabel(string);
        }
        if (string2 != null) {
            this.wv_option2.setLabel(string2);
        }
        if (string3 == null) return;
        this.wv_option3.setLabel(string3);
    }

    public void setLineSpacingMultiplier(float f) {
        this.lineSpacingMultiplier = f;
        this.setLineSpacingMultiplier();
    }

    public void setLinkage(boolean bl) {
        this.linkage = bl;
    }

    public void setNPicker(List<T> wheelView, List<T> list, List<T> list2) {
        this.wv_option1.setAdapter((WheelAdapter)new ArrayWheelAdapter(wheelView));
        this.wv_option1.setCurrentItem(0);
        if (list != null) {
            this.wv_option2.setAdapter((WheelAdapter)new ArrayWheelAdapter(list));
        }
        wheelView = this.wv_option2;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        if (list2 != null) {
            this.wv_option3.setAdapter((WheelAdapter)new ArrayWheelAdapter(list2));
        }
        wheelView = this.wv_option3;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        this.wv_option1.setIsOptions(true);
        this.wv_option2.setIsOptions(true);
        this.wv_option3.setIsOptions(true);
        if (this.optionsSelectChangeListener != null) {
            this.wv_option1.setOnItemSelectedListener((OnItemSelectedListener)new /* Unavailable Anonymous Inner Class!! */);
        }
        if (list == null) {
            this.wv_option2.setVisibility(8);
        } else {
            this.wv_option2.setVisibility(0);
            if (this.optionsSelectChangeListener != null) {
                this.wv_option2.setOnItemSelectedListener((OnItemSelectedListener)new /* Unavailable Anonymous Inner Class!! */);
            }
        }
        if (list2 == null) {
            this.wv_option3.setVisibility(8);
        } else {
            this.wv_option3.setVisibility(0);
            if (this.optionsSelectChangeListener == null) return;
            this.wv_option3.setOnItemSelectedListener((OnItemSelectedListener)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    public void setOptionsSelectChangeListener(OnOptionsSelectChangeListener onOptionsSelectChangeListener) {
        this.optionsSelectChangeListener = onOptionsSelectChangeListener;
    }

    public void setPicker(List<T> list, List<List<T>> list2, List<List<List<T>>> list3) {
        this.mOptions1Items = list;
        this.mOptions2Items = list2;
        this.mOptions3Items = list3;
        this.wv_option1.setAdapter((WheelAdapter)new ArrayWheelAdapter(list));
        this.wv_option1.setCurrentItem(0);
        Object object = this.mOptions2Items;
        if (object != null) {
            this.wv_option2.setAdapter((WheelAdapter)new ArrayWheelAdapter((List)object.get(0)));
        }
        object = this.wv_option2;
        object.setCurrentItem(object.getCurrentItem());
        object = this.mOptions3Items;
        if (object != null) {
            this.wv_option3.setAdapter((WheelAdapter)new ArrayWheelAdapter((List)((List)object.get(0)).get(0)));
        }
        object = this.wv_option3;
        object.setCurrentItem(object.getCurrentItem());
        this.wv_option1.setIsOptions(true);
        this.wv_option2.setIsOptions(true);
        this.wv_option3.setIsOptions(true);
        if (this.mOptions2Items == null) {
            this.wv_option2.setVisibility(8);
        } else {
            this.wv_option2.setVisibility(0);
        }
        if (this.mOptions3Items == null) {
            this.wv_option3.setVisibility(8);
        } else {
            this.wv_option3.setVisibility(0);
        }
        this.wheelListener_option1 = new /* Unavailable Anonymous Inner Class!! */;
        this.wheelListener_option2 = new /* Unavailable Anonymous Inner Class!! */;
        if (list != null && this.linkage) {
            this.wv_option1.setOnItemSelectedListener(this.wheelListener_option1);
        }
        if (list2 != null && this.linkage) {
            this.wv_option2.setOnItemSelectedListener(this.wheelListener_option2);
        }
        if (list3 == null) return;
        if (!this.linkage) return;
        if (this.optionsSelectChangeListener == null) return;
        this.wv_option3.setOnItemSelectedListener((OnItemSelectedListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void setTextColorCenter(int n) {
        this.textColorCenter = n;
        this.setTextColorCenter();
    }

    public void setTextColorOut(int n) {
        this.textColorOut = n;
        this.setTextColorOut();
    }

    public void setTextContentSize(int n) {
        WheelView wheelView = this.wv_option1;
        float f = n;
        wheelView.setTextSize(f);
        this.wv_option2.setTextSize(f);
        this.wv_option3.setTextSize(f);
    }

    public void setTextXOffset(int n, int n2, int n3) {
        this.wv_option1.setTextXOffset(n);
        this.wv_option2.setTextXOffset(n2);
        this.wv_option3.setTextXOffset(n3);
    }

    public void setTypeface(Typeface typeface) {
        this.wv_option1.setTypeface(typeface);
        this.wv_option2.setTypeface(typeface);
        this.wv_option3.setTypeface(typeface);
    }

    public void setView(View view) {
        this.view = view;
    }
}
