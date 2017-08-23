package com.albb.radiobutton.test_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.albb.radiobutton.MyConfig;
import com.albb.radiobutton.R;
import com.blankj.utilcode.util.ActivityUtils;

public class TestActivity extends AppCompatActivity {
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView = (TextView)findViewById(R.id.textView);
        textView.setText("Is ImageActivity Exists: " + ActivityUtils.isActivityExists(MyConfig.PACKAGE_NAME, MainActivity.class.getName())
                + "\ngetLauncherActivity: " + ActivityUtils.getLauncherActivity(MyConfig.PACKAGE_NAME)
                + "\ngetTopActivity: " + ActivityUtils.getTopActivity()
        );

    }
    public void buttononclick(View view){
        switch (view.getId()){
            case R.id.button:
                ActivityUtils.startActivity(MyConfig.PACKAGE_NAME,MainActivity.class.getName());
                break;
            case R.id.button2:
                ActivityUtils.finishAllActivities();
                break;
            default:
                break;
        }
    }

}
