package com.project.semicolon.cryptonatorapi.services;

import com.project.semicolon.cryptonatorapi.model.CryptonatorResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CryptonatorEndPoint {
    @GET("{coin}-usd")
    Observable<CryptonatorResponse> getCoinInfo(@Path("coin") String coin);

}
