package com.themanol.pokecards.ui.cards.viewmodels;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.util.List;

import static java.lang.annotation.RetentionPolicy.SOURCE;

public class CardItemViewModel {

    @Retention(SOURCE)
    @StringDef({
            POKEMON,
            TRAINER,
            ENERGY
    })
    public @interface SuperType {
    }

    static final String POKEMON = "Pokémon";
    static final String TRAINER = "Trainer";
    static final String ENERGY = "Energy";

    private String mImageUrl;
    private String mName;
    private List<String> mTypes;
    private String mCardId;
    private
    @SuperType
    String mSuperType;

    public void setName(String name) {
        this.mName = name;
    }

    public void setImageUrl(String url) {
        mImageUrl = url;
    }

    public void setTypes(List<String> types) {
        this.mTypes = types;
    }

    public void setSuperType(@SuperType String superType) {
        mSuperType = superType;
    }

    public String getType() {

        if (mSuperType.equalsIgnoreCase(POKEMON)) {

            if (mTypes == null || mTypes.size() == 0) {
                return POKEMON;
            }
            StringBuilder typesBuilder = new StringBuilder(POKEMON);
            typesBuilder.append(": ");
            for (String type : mTypes) {
                typesBuilder.append(type);
                typesBuilder.append(" | ");
            }
            return typesBuilder.substring(0, typesBuilder.length() - 3);
        } else {
            return mSuperType;
        }
    }

    public String getCardId() {
        return mCardId;
    }

    public void setCardId(String cardId) {
        this.mCardId = cardId;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getName() {
        return mName;
    }
}
