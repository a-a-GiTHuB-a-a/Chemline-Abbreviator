package com.daboxen.chemlineabbreviator.data;

import com.tterrag.registrate.providers.ProviderType;
import static com.daboxen.chemlineabbreviator.AbbreviatorMod.REGISTRATE;

public class AbbreviatorDatagen {
    public static void init() {
        REGISTRATE.addDataGenerator(ProviderType.LANG, LangHandler::init);
    }
}
