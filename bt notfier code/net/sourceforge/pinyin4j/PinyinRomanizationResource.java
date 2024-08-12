/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.hp.hpl.sparta.Document
 *  com.hp.hpl.sparta.ParseException
 *  com.hp.hpl.sparta.Parser
 *  net.sourceforge.pinyin4j.PinyinRomanizationResource$PinyinRomanizationSystemResourceHolder
 *  net.sourceforge.pinyin4j.ResourceHelper
 */
package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.ParseException;
import com.hp.hpl.sparta.Parser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import net.sourceforge.pinyin4j.PinyinRomanizationResource;
import net.sourceforge.pinyin4j.ResourceHelper;

class PinyinRomanizationResource {
    private Document pinyinMappingDoc;

    private PinyinRomanizationResource() {
        this.initializeResource();
    }

    static PinyinRomanizationResource getInstance() {
        return PinyinRomanizationSystemResourceHolder.theInstance;
    }

    private void initializeResource() {
        try {
            this.setPinyinMappingDoc(Parser.parse((String)"", (InputStream)ResourceHelper.getResourceInputStream((String)"/pinyindb/pinyin_mapping.xml")));
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

    private void setPinyinMappingDoc(Document document) {
        this.pinyinMappingDoc = document;
    }

    Document getPinyinMappingDoc() {
        return this.pinyinMappingDoc;
    }
}
