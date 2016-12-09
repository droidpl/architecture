package com.themanol.pokesdk.injection;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        NetworkModule.class,
})
public interface PokeSDK {

    RepositoryComponent repositories();
}
