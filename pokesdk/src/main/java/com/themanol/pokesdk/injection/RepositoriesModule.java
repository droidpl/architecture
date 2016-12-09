package com.themanol.pokesdk.injection;

import android.support.annotation.NonNull;

import com.themanol.pokesdk.repositories.RepositoryScope;
import com.themanol.pokesdk.repositories.cards.CardsRemoteDatasource;
import com.themanol.pokesdk.repositories.cards.CardsRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoriesModule {

    @Provides
    @RepositoryScope
    public CardsRepository providesCardRepository(@NonNull CardsRemoteDatasource remoteDatasouce) {
        return new CardsRepository(remoteDatasouce);
    }
}
