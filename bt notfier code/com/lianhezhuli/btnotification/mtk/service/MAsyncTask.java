/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.database.Cursor
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Message
 *  com.lianhezhuli.btnotification.mtk.service.ContactBean
 *  com.lianhezhuli.btnotification.utils.ToPinYin
 *  net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination
 */
package com.lianhezhuli.btnotification.mtk.service;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.lianhezhuli.btnotification.mtk.service.ContactBean;
import com.lianhezhuli.btnotification.utils.ToPinYin;
import java.util.ArrayList;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class MAsyncTask
extends AsyncTask<Cursor, Void, ArrayList<ContactBean>> {
    public static final int DOWNLOADING_START_MESSAGE = 7;
    public static final int DOWNLOAD_END_MESSAGE = 17;
    private static final String TAG = MAsyncTask.class.getSimpleName();
    private Context mContext = null;
    private Handler mHandler = null;

    protected MAsyncTask(Context context, Handler handler) {
        this.mContext = context;
        this.mHandler = handler;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    private String getNameNum(String string) {
        block4: {
            char[] cArray;
            if (string == null) return null;
            try {
                if (string.length() == 0) return null;
                int n = string.length();
                cArray = new char[n];
                for (int i = 0; i < n; ++i) {
                    cArray[i] = this.getOneNumFromAlpha(ToPinYin.getPinYin((String)string.substring(i)).toLowerCase().charAt(0));
                }
            }
            catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
                badHanyuPinyinOutputFormatCombination.printStackTrace();
                break block4;
            }
            {
                string = new String(cArray);
                return string;
            }
        }
        return null;
    }

    private char getOneNumFromAlpha(char c) {
        switch (c) {
            default: {
                return '0';
            }
            case 'w': 
            case 'x': 
            case 'y': 
            case 'z': {
                return '9';
            }
            case 't': 
            case 'u': 
            case 'v': {
                return '8';
            }
            case 'p': 
            case 'q': 
            case 'r': 
            case 's': {
                return '7';
            }
            case 'm': 
            case 'n': 
            case 'o': {
                return '6';
            }
            case 'j': 
            case 'k': 
            case 'l': {
                return '5';
            }
            case 'g': 
            case 'h': 
            case 'i': {
                return '4';
            }
            case 'd': 
            case 'e': 
            case 'f': {
                return '3';
            }
            case 'a': 
            case 'b': 
            case 'c': 
        }
        return '2';
    }

    private void sendEndMessage(int n, ArrayList<ContactBean> handler) {
        Message message = new Message();
        message.what = n;
        Bundle bundle = new Bundle();
        bundle.putSerializable("\u5b8c\u6210", handler);
        message.setData(bundle);
        handler = this.mHandler;
        if (handler == null) return;
        handler.sendMessage(message);
    }

    private void sendStartMessage(int n) {
        Message message = new Message();
        message.what = n;
        Handler handler = this.mHandler;
        if (handler == null) return;
        handler.sendMessage(message);
    }

    public static void startRequestServerData(Context context, Handler handler, Cursor cursor) {
        new MAsyncTask(context, handler).execute(new Cursor[]{cursor});
    }

    protected ArrayList<ContactBean> doInBackground(Cursor ... object) {
        int n = 0;
        Cursor cursor = object[0];
        object = new ArrayList();
        if (cursor == null) return object;
        if (cursor.getCount() <= 0) return object;
        try {
            cursor.moveToFirst();
            while (n < cursor.getCount()) {
                cursor.moveToPosition(n);
                String string = cursor.getString(1);
                CharSequence charSequence = cursor.getString(2);
                int n2 = cursor.getInt(4);
                ContactBean contactBean = new ContactBean();
                contactBean.setContactId(n2);
                contactBean.setNumber((String)charSequence);
                contactBean.setName(string);
                if (contactBean.getName() == null) {
                    contactBean.setNumber(contactBean.getNumber());
                }
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(contactBean.getName());
                ((StringBuilder)charSequence).append("");
                contactBean.setFormattedNumber(this.getNameNum(((StringBuilder)charSequence).toString()));
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(contactBean.getName());
                ((StringBuilder)charSequence).append("");
                contactBean.setPinyin(ToPinYin.getPinYin((String)((StringBuilder)charSequence).toString()));
                ((ArrayList)object).add(contactBean);
                ++n;
            }
            return object;
        }
        catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }
        return object;
    }

    protected void onPostExecute(ArrayList<ContactBean> arrayList) {
        this.sendEndMessage(17, arrayList);
    }

    protected void onPreExecute() {
        this.sendStartMessage(7);
    }
}
