package com.example.testmybasecode;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import com.example.testmybasecode.factory.ApplicationComponent;
import com.example.testmybasecode.factory.ApplicationModule;
import com.example.testmybasecode.factory.DaggerApplicationComponent;

import org.androidannotations.annotations.EApplication;


@SuppressLint("Registered")
@EApplication
public class MainApplication extends Application {
    protected ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        Log.e("abc","main application");

        setApplicationComponent(DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build());

        //Crash tracking
//        Mint.disableNetworkMonitoring();
//        Mint.initAndStartSession(MainApplication.this, "9c23eed6");

//        //initFB
//        FacebookSdk.sdkInitialize(getApplicationContext());
//
//        //Fabric crashlytics & twitter
//        TwitterAuthConfig authConfig = new TwitterAuthConfig(
//                BuildConfig.TWITTER_KEY, BuildConfig.TWITTER_SECRET);
//        Fabric.with(this, new Crashlytics(), new Twitter(authConfig));
//
//        //init hawk to save auth_token
//        Hawk.init(this)
//                .setEncryptionMethod(HawkBuilder.EncryptionMethod.MEDIUM)
//                .setStorage(HawkBuilder.newSharedPrefStorage(this))
//                .build();
//
//        //init Calligraphy font style
//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/Calibre-Medium.otf")
//                .build());
//
//        //init three ten
//        AndroidThreeTen.init(this);
//
//        // Branch object initialization
//        Branch.getAutoInstance(this);
//
//        printHashKey();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public void setApplicationComponent(ApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

//    private void printHashKey() {
//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(),
//                    PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.e("KeyHash FB:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }
//    }
}
