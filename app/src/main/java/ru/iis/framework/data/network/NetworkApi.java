package ru.iis.framework.data.network;

import io.reactivex.Single;
import retrofit2.http.GET;
//Осталось от шаблонга архитектуры
public interface NetworkApi {

    @GET("/")
    Single<Object> getTest();
}
