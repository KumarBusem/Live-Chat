package com.roberto.manfreda.live.chat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.roberto.manfreda.live.chat.persistence.VolatileModel;

import java.lang.ref.WeakReference;

public class Application extends android.app.Application {
    protected static final String TAG = Application.class.getSimpleName();

    private static WeakReference<Application> singleton;
    private Activity currentActivity = null;
    private VolatileModel volatileModel = new VolatileModel();

    public static Application getInstance() {
        return singleton.get();
    }

    public void onCreate() {
        super.onCreate();
        singleton = new WeakReference<>((Application) getApplicationContext());
        singleton.get().registerActivityLifecycleCallbacks(new ActivityManager());
        Log.i(TAG, "Application Created");
    }

    public Activity getCurrentActivity() {
        return this.currentActivity;
    }

    public VolatileModel getVolatileModel() {
        return volatileModel;
    }

    private class ActivityManager implements ActivityLifecycleCallbacks {
        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Log.i(TAG, activity + " Created");
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            Log.i(TAG, activity + " Destroyed");
        }

        @Override
        public void onActivityStarted(Activity activity) {
            Log.i(TAG, activity + " Started");
        }

        @Override
        public void onActivityResumed(Activity activity) {
            Log.i(TAG, activity + " Initialized");
            currentActivity = activity;
        }

        @Override
        public void onActivityPaused(Activity activity) {
            Log.i(TAG, activity + " Paused");
        }

        @Override
        public void onActivityStopped(Activity activity) {
            if (currentActivity == activity) {
                Log.i(TAG, activity + " Stopped");
                currentActivity = null;
            }
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Log.i(TAG, activity + " Save Instance State");
        }
    }

}
