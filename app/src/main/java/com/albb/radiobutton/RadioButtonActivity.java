package com.albb.radiobutton;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class RadioButtonActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup radioGroup;
    RadioGroup bottomgroup;
    IBaseFragment iBaseFragment;
    AgeFragment ageFragment;
    SetFragment setFragment;
    SexFragment sexFragment;
    FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        bottomgroup = (RadioGroup)findViewById(R.id.bottom_radiogroup);
        /**
         * 设置默认选中 == android:checked="true"
         */
        radioGroup.check(R.id.timor_button);
        radioGroup.setOnCheckedChangeListener(this);
        bottomgroup.check(R.id.name_button);
        bottomgroup.setOnCheckedChangeListener(this);
        getCheckedRadioButtonId(radioGroup);
        setDefaultFragment();

    }

    /**
     * 通过RadioGroup获取到被选中的RadioButton
     * @param parentGroup
     */
    private void getCheckedRadioButtonId(RadioGroup parentGroup){
        RadioButton radioButton = (RadioButton) findViewById(parentGroup.getCheckedRadioButtonId());
        String text = radioButton.getText().toString();
        showToast(this, "默认选择的是："+text);
    }

    /**
     * 设置group不可点击
     * 必须通过遍历group中所有子radioButton，依次设置
     * 本人亲自实验，对group本身以及group的父视图进行设置
     * 都不起作用；
     * 同样通过找到每一个Radiobutton,分别对他们设置不可点击也能实现，但是代码太过冗杂！
     * @param grop
     * @param enable
     */
    private void setRadiogroupEnable(RadioGroup grop,Boolean enable){
        if (null!=grop){
            for (int i = 0;i<grop.getChildCount(); i++){
                grop.getChildAt(i).setEnabled(enable);
            }
        }else {
            showToast(RadioButtonActivity.this,"没有找到该按钮!");
        }
    }

    private Toast mToast;
    private void showToast(Context context,String message){
        if (null == mToast){
            mToast = Toast.makeText(context,message,Toast.LENGTH_SHORT);
        }else {
            mToast.setText(message);
        }
        mToast.show();
    }

    private void setDefaultFragment(){
        manager = getSupportFragmentManager();
        //开启事务时，如果当前事务已经被提交需要重新开启事务，再进行相关操作！
        FragmentTransaction transactionDefault = manager.beginTransaction();
        if (null==iBaseFragment){
            iBaseFragment = new IBaseFragment();
        }
        transactionDefault.add(R.id.fragment_container_layout,iBaseFragment);
        transactionDefault.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        FragmentTransaction transaction = manager.beginTransaction();
        if (radioGroup == group){
            switch (checkedId){
                case R.id.timor_button:
                    showToast(this,"timor");
                    break;
                case R.id.huli_button:
                    showToast(this,"huli");
                    break;
                case R.id.huangzi_button:
                    showToast(this,"huangzi");
                    break;
                default:
                    break;
            }
        }else {
            switch (checkedId){
                case R.id.name_button:
                    if (null == iBaseFragment){
                        iBaseFragment = new IBaseFragment();
                    }
                    transaction.replace(R.id.fragment_container_layout,iBaseFragment);
                    showToast(this,"name");
                    break;
                case R.id.age_button:
                    if (null == ageFragment){
                        ageFragment = new AgeFragment();
                    }
                    transaction.replace(R.id.fragment_container_layout,ageFragment);
                    showToast(this,"age");
                    break;
                case R.id.sex_button:
                    if (null == sexFragment){
                        sexFragment = new SexFragment();
                    }
                    transaction.replace(R.id.fragment_container_layout,sexFragment);
                    showToast(this,"sex");
                    break;
                case R.id.set_button:
                    if (null == setFragment){
                        setFragment = new SetFragment();
                    }
                    transaction.replace(R.id.fragment_container_layout,setFragment);
                    showToast(this,"set");
                    break;
                default:
                    break;
            }
            transaction.commit();
        }
    }
}
