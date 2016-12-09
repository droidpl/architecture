package com.themanol.pokesdk.injection;

import android.support.annotation.NonNull;

import com.themanol.pokesdk.repositories.cards.CardsRemoteDatasource;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class RetrofitServicesModule {

    @Provides
    public CardsRemoteDatasource providesCardService(@NonNull Retrofit retrofit) {
        return retrofit.create(CardsRemoteDatasource.class);
    }
}
