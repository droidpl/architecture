package com.themanol.pokecards.base;

import android.app.Application;

import com.themanol.pokesdk.injection.PokeSDK;

public class PokeCardsApplication extends Application {

    private static PokeSDK sdk;

    @Override
    public void onCreate() {
        super.onCreate();
        sdk = DaggerPokeSDK.builder().build();
    }

    public static PokeSDK sdk() {
        return sdk;
    }
}
