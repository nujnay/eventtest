    package com.nujnay.eventtest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_main.*
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import android.util.StatsLog.logEvent
import android.R.attr.name



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        FacebookSdk.sdkInitialize(this)
        val logger = AppEventsLogger.newLogger(this)

        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID,"222")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "222")
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image")
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)

        tv_main.setOnClickListener {
            val params = Bundle()
            params.putString("a111", "a111")
            mFirebaseAnalytics.logEvent("share_image", params)
            logger.logEvent("1111111")
        }
        tv_1.setOnClickListener {
            val params = Bundle()
            params.putString("a111", "a111")
            mFirebaseAnalytics.logEvent("share_image_3343", params)
            logger.logEvent("22222")
        }
    }
}
