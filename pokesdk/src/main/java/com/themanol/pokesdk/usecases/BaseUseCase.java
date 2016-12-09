package com.themanol.pokesdk.usecases;

public interface BaseUseCase<T, U> {
    T execute(U params);
}
