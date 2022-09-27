package uz.exemple.less62_task1_sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.io.Serializable;

import uz.exemple.less62_task1_sharedpreferences.managers.PrefsManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    void initViews() {
        EditText et_ID = findViewById(R.id.et_ID);
        EditText et_Age = findViewById(R.id.et_age);
        EditText et_Weight = findViewById(R.id.et_weight);
        CheckBox et_isUzbek = findViewById(R.id.et_isUzbek);
        Button b_save = findViewById(R.id.b_save);
        Button b_load = findViewById(R.id.b_load);

        b_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long passport = Long.parseLong(et_ID.getText().toString().trim());
                Integer age = Integer.parseInt(et_Age.getText().toString().trim());
                float weight = Float.parseFloat(et_Weight.getText().toString().trim());
                boolean isUzbek = et_isUzbek.isChecked();

                PrefsManager.getInstance(v.getContext()).saveAll("passport",passport);
                PrefsManager.getInstance(v.getContext()).saveAll("age",age);
                PrefsManager.getInstance(v.getContext()).saveAll("weight",weight);
                PrefsManager.getInstance(v.getContext()).saveAll("isUzbek",isUzbek);
                //Log.d("###","Type is - "+ email.getClass().getSimpleName());
            }
        });
        b_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Serializable passport = PrefsManager.getInstance(v.getContext()).getData("passport");
                Log.d("###","Passport is - "+passport);
                Serializable age = PrefsManager.getInstance(v.getContext()).getData("age");
                Log.d("###","Age is - "+age);
                Serializable weight = PrefsManager.getInstance(v.getContext()).getData("weight");
                Log.d("###","Weight is - "+weight);
                Serializable isUzbek = PrefsManager.getInstance(v.getContext()).getData("isUzbek");
                Log.d("###","Is Uzbek is - "+isUzbek);


            }
        });
    }


}