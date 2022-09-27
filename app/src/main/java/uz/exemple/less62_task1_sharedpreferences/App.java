package uz.exemple.less62_task1_sharedpreferences;

import android.app.Application;
import android.content.Context;

import uz.exemple.less62_task1_sharedpreferences.managers.PrefsManager;

public class App extends Application {

    private static App instance;

    public static App getInstance() {

        return instance;
    }

    public static Context getContext(){
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
