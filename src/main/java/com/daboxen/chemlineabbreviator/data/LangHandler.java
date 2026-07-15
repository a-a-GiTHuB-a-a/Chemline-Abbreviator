package com.daboxen.chemlineabbreviator.data;

import com.daboxen.chemlineabbreviator.blocks.AbbreviatorBlocks;
import com.tterrag.registrate.providers.RegistrateLangProvider;

public class LangHandler {
    public static void init(RegistrateLangProvider provider) {
        AbbreviatorBlocks.genLang(provider);
    }
}