package uz.exemple.less62_task1_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

import uz.exemple.less62_task1_sharedpreferences.managers.PrefsManager;

public class MainActivity extends AppCompatActivity {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews() {
        prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = prefs.edit();

        EditText et_ID = findViewById(R.id.et_ID);
        EditText et_Age = findViewById(R.id.et_age);
        EditText et_Weight = findViewById(R.id.et_weight);
        CheckBox et_isUzbek = findViewById(R.id.et_isUzbek);
        Button b_save = findViewById(R.id.b_save);
        Button b_load = findViewById(R.id.b_load);
        TextView res = findViewById(R.id.tv_result);

        b_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_ID.getText().toString().isEmpty()){
                    long passport = Long.parseLong(et_ID.getText().toString().trim());
                    int age = Integer.parseInt(et_Age.getText().toString().trim());
                    float weight = Float.parseFloat(et_Weight.getText().toString().trim());
                    boolean isUzbek = et_isUzbek.isChecked();
                    savePassport("passport", passport);
                    saveAge("age", age);
                    saveWeight("weight", weight);
                    saveNationality("isUzbek", isUzbek);
                    et_ID.setText("");
                    et_Age.setText("");
                    et_Weight.setText("");
                    et_isUzbek.setChecked(false);
                }

            }
        });
        b_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long res_passport = loadPassport();
                int res_age = loadAge();
                float res_weight = loadWeight();
                boolean res_isUzbek = loadNationality();

                res.setVisibility(View.VISIBLE);
                res.setText("PassportId - "+res_passport+",\n\nAge - "+res_age+",\n\nWeight - "+res_weight+",\n\nIz uzbek - "+res_isUzbek);


            }
        });
    }
    void savePassport(String key,Long passport) {
        editor.putLong("passport", passport);
        editor.apply();
    }

     Long loadPassport() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        long passport = prefs.getLong("passport", 0);
        return passport;
    }
    void saveAge(String key,int age) {
        editor.putInt("age", age);
        editor.apply();
    }

    int loadAge() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        int age = prefs.getInt("age", 0);
        return age;
    }
    void saveWeight(String key,float weight) {
        editor.putFloat("weight", weight);
        editor.apply();
    }

    float loadWeight() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        return prefs.getFloat("weight", 0);
    }

    void saveNationality(String key,boolean isUzbek) {
        editor.putBoolean("isUzbek", isUzbek);
        editor.apply();
    }

    boolean loadNationality() {
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        return prefs.getBoolean("isUzbek", false);
    }


}