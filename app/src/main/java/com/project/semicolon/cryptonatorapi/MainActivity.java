package com.project.semicolon.cryptonatorapi;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.project.semicolon.cryptonatorapi.databinding.MainActivityBinding;
import com.project.semicolon.cryptonatorapi.model.MarketsItem;
import com.project.semicolon.cryptonatorapi.services.CryptonatorEndPoint;
import com.project.semicolon.cryptonatorapi.services.RetrofitClient;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private CoinsRecyclerAdapter adapter;
    private MainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Retrofit retrofit = RetrofitClient.getRetrofit();
        CryptonatorEndPoint cryptonatorEndPoint = retrofit.create(CryptonatorEndPoint.class);

        adapter = new CoinsRecyclerAdapter();
        setupRecyclerView();

        Observable<List<MarketsItem>> btcResponse = cryptonatorEndPoint.getCoinInfo("btc")
                .flatMap(response -> Observable.fromIterable(response.getTicker().getMarkets()))
                .filter(marketsItem -> {
                    marketsItem.setCoinName("btc");
                    return true;
                }).toList().toObservable();

        Observable<List<MarketsItem>> ethResponse = cryptonatorEndPoint.getCoinInfo("eth")
                .flatMap(response -> Observable.fromIterable(response.getTicker().getMarkets()))
                .filter(marketsItem -> {
                    marketsItem.setCoinName("eth");
                    return true;
                }).toList().toObservable();


        //Make Multiple response
        Observable.merge(ethResponse, btcResponse)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<MarketsItem>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<MarketsItem> marketsItems) {
                        Log.d(TAG, "onNext: items size: " + marketsItems.size());
                        adapter.setItems(marketsItems);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "merge call: onError: ", e);

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void setupRecyclerView() {
        binding.rvCurrencyList.setLayoutManager(new LinearLayoutManager(this));
        binding.rvCurrencyList.setAdapter(adapter);
    }
}
