package com.example.testmybasecode.factory;


import com.example.testmybasecode.ApiUrls;
import com.example.testmybasecode.service.authentication.RestAuthenticationService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    @Provides
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(ApiUrls.INTEGRATION_SERVER_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    public RestAuthenticationService provideAuthenticationService(Retrofit retrofit) {
        return retrofit.create(RestAuthenticationService.class);
    }


}
