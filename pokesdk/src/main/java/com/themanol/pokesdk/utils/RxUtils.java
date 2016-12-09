package com.themanol.pokesdk.utils;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.MaybeTransformer;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by javierdepedrolopez on 12/9/16.
 */

public class RxUtils {
    public static <T> SingleTransformer<T, T> defaultSchedulersSingle() {
        return new SingleTransformer<T, T>() {
            @Override
            public SingleSource<T> apply(Single<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> MaybeTransformer<T, T> defaultSchedulersMaybe() {
        return new MaybeTransformer<T, T>() {
            @Override
            public MaybeSource<T> apply(Maybe<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
