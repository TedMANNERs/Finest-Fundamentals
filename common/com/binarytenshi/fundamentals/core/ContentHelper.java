package com.binarytenshi.fundamentals.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import com.binarytenshi.fundamentals.lib.Strings;

public class ContentHelper {

    private static LinkedHashMap<String, IContent[]> contentMap = new LinkedHashMap<String, IContent[]>();

    public static void registerContent(String id, IContent... enumerable) {
        contentMap.put(id, enumerable);
    }

    public static IContent getContent(String contentstr) {
        String id = contentstr.split(Strings.CONTENT_SEPERATOR)[0];
        String name = contentstr.split(Strings.CONTENT_SEPERATOR)[1];

        IContent[] entries = contentMap.get(id);

        for (IContent entry : entries) {
            if (entry.getName().equals(name))
                return entry;
        }

        return null;
    }

    public static ArrayList<IContent> getAllContents() {
        ArrayList<IContent> contents = new ArrayList<IContent>();
        
        for (IContent[] arr : contentMap.values()) {
            contents.addAll(Arrays.asList(arr));
        }

        return contents;
    }
}
