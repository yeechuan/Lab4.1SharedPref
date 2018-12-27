package my.edu.tarc.lab41sharedpref;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SettingsActivity extends AppCompatActivity {
    private EditText editTextName;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //Linking UI to the program
        editTextName = findViewById(R.id.editTextName);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sharedPreferences = getSharedPreferences(
                getString(R.string.pref_file),
                MODE_PRIVATE);
        String name;
        int gender; //-1 = default, 1 = male, 0 = female
        name = sharedPreferences.getString("name", "");
        gender = sharedPreferences.getInt("gender", -1);
        editTextName.setText(name);
        if(gender== 1){
            radioButtonMale.setChecked(true);
        }else if(gender == 0){
            radioButtonFemale.setChecked(true);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //TODO: save shared preference
        //1. Create an instance of Editor
        SharedPreferences.Editor editor;
        //2. Read data from UI
        //3. Begin transaction
        //4. Write data to the shared preference
        //5. Commit or Apply changes
    }
}
