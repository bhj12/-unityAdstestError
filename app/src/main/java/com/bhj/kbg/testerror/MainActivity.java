package com.bhj.kbg.testerror;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.IUnityBannerListener;
import com.unity3d.services.banners.UnityBanners;

public class MainActivity extends AppCompatActivity {

    private String GameId ="3879637";
    private String bannerID = "bannerForTest";

    private  String interestialID = "interstitial";
    private Button showBannerButton;
    private Button showInterestialButton;
    private  boolean testMode = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showBannerButton = findViewById(R.id.bannerButtonId);
        showInterestialButton = findViewById(R.id.interestialButtonId);
        UnityInterestitialListerner  unityInterestitialListerner = new UnityInterestitialListerner();

        UnityAds.initialize(this,GameId,unityInterestitialListerner,testMode);
        UnityBannerListerner unityBannerListerner = new UnityBannerListerner();
        UnityBanners.setBannerListener(unityBannerListerner);
        UnityBanners.loadBanner(MainActivity.this, bannerID);
       // UnityBanners.loadBanner(MainActivity.this, bannerID);
        showBannerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              // UnityBanners.loadBanner(, bannerID);


            }
        });
        showInterestialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, workActivity.class);
                startActivity(intent);
                UnityAds.show(MainActivity.this,interestialID);

                //UnityBanners.loadBanner(MainActivity.this,bannerID);
            }
        });

    }
    private  class UnityBannerListerner implements IUnityBannerListener
    {

        @Override
        public void onUnityBannerLoaded(String s, View view) {
            ((ViewGroup) findViewById(R.id.DisplayAdsId)).removeView(view);
            ((ViewGroup) findViewById(R.id.DisplayAdsId)).addView(view);
            //((ViewGroup) findViewById(R.id.topDisplayId)).removeView(view);
           // ((ViewGroup) findViewById(R.id.topDisplayId)).addView(view);
        }

        @Override
        public void onUnityBannerUnloaded(String s) {

        }

        @Override
        public void onUnityBannerShow(String s) {

        }

        @Override
        public void onUnityBannerClick(String s) {

        }

        @Override
        public void onUnityBannerHide(String s) {

        }

        @Override
        public void onUnityBannerError(String s) {
            UnityBanners.loadBanner(MainActivity.this, bannerID);
        }
    }
    private class UnityInterestitialListerner implements  IUnityAdsListener {

        @Override
        public void onUnityAdsReady(String s) {

        }

        @Override
        public void onUnityAdsStart(String s) {

        }

        @Override
        public void onUnityAdsFinish(String s, UnityAds.FinishState finishState) {

        }

        @Override
        public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String s) {

        }
    }
}