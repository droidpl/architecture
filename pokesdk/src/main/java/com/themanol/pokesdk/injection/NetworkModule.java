package com.themanol.pokesdk.injection;

import android.support.annotation.NonNull;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private static final String API_BASE_URL = "https://api.pokemontcg.io/v1/";

    @Provides
    @Singleton
    public Gson providesGson() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(new AutoValueTypeAdapterFactory())
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofit(@NonNull Gson gson, @NonNull OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    public OkHttpClient providesOkHttp() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(logging).build();
    }

    public class AutoValueTypeAdapterFactory implements TypeAdapterFactory {
        @Override
        @SuppressWarnings("unchecked")
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            Class<? super T> rawType = type.getRawType();
            AutoGson annotation = rawType.getAnnotation(AutoGson.class);
            if (annotation == null) {
                return null;
            }
            return (TypeAdapter<T>) gson.getAdapter(annotation.autoClass());
        }
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AutoGson {
        Class autoClass();
    }
}
