package uz.exemple.less62_task1_sharedpreferences.managers;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.Serializable;

public class PrefsManager <T> {
    public static PrefsManager prefsManager;
    private SharedPreferences sharedPreferences;

    public static PrefsManager getInstance(Context context) {
        if (prefsManager == null) {
            prefsManager = new PrefsManager(context);
        }
        return prefsManager;
    }

    public PrefsManager(Context context) {
        sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
    }

    public void saveData(String key, String value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
    }
    public <T> void saveAll(String key, T value) {
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        if (key.equals("passport")){
            prefsEditor.putLong(key, (Long) value);
        }else if(key.equals("age")){
            prefsEditor.putInt(key, (Integer) value);
        }else if (key.equals("weight")){
            prefsEditor.putFloat(key, (Float) value);
        }else if (key.equals("isUzbek")){
            prefsEditor.putBoolean(key, (boolean) value);
        }else {
            prefsEditor.putString(key, value.toString());
        }

        prefsEditor.commit();
    }

    public Serializable getData(String key) {
        if (sharedPreferences != null){
            if (key.equals("passport")){
                return sharedPreferences.getLong(key, 0);
            }else if(key.equals("age")){
                return sharedPreferences.getInt(key, 0);
            }else if (key.equals("weight")){
                return sharedPreferences.getFloat(key, 0);
            }else if (key.equals("isUzbek")){
                return sharedPreferences.getBoolean(key, false);
            }
        }

        return "";
    }

    public void clearAll() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
