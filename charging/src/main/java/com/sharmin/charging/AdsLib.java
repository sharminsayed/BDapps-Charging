package com.sharmin.charging;

import android.util.Log;
import android.widget.Toast;


import com.sharmin.charging.bdapps.Robi;
import com.sharmin.charging.datamodel.Status;
import com.sharmin.charging.retrofit.APIInterface;
import com.sharmin.charging.retrofit.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class AdsLib {

    private Robi robi;

    public AdsLib(Robi robi) {
        this.robi = robi;
    }

    public void checkSubStatus(String code) {
        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

        APIInterface apiInterface = retrofit.create(APIInterface.class);
        Call<Status> call = apiInterface.getStatus(code);

        call.enqueue(new Callback<Status>() {
            @Override
            public void onResponse(Call<Status> call, Response<Status> response) {

                Log.e("response", response.toString());
                if (response.body() != null) {


                    if (response.body().getStat()) {
                        SP.setSubscriptionStatus(false);
                        Toast.makeText(AppConfig.getContext(), "Subscription Status True", Toast.LENGTH_SHORT).show();
                    } else {
                        SP.setSubscriptionStatus(true);
                        Toast.makeText(AppConfig.getContext(), "not a valid subscriber", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {

                SP.setSubscriptionStatus(true);
                // Toast.makeText(AppConfig.getContext(), "Status Getting Failed", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void subscribe() {
        RetrofitClientInstance.getRetrofitInstance()
                .create(APIInterface.class)
                .subscribe(robi.getAPP_ID(), robi.getAPP_PATH())
                .enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.e("response", response.toString());

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("error", t.toString());

                    }
                });
    }


}
