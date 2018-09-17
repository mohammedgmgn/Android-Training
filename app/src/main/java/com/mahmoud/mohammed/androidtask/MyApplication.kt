package com.mahmoud.mohammed.androidtask

import android.app.Activity
import android.app.Application
import com.mahmoud.mohammed.androidtask.dagger.application.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class MyApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        /*DaggerApplicationComponent.builder().application(this)
                .build().inject(this);*/

           DaggerApplicationComponent.create()
                .inject(this)

     //   DaggerAppComponent.builder().appModule(ApplicationModule()).build()
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector
}