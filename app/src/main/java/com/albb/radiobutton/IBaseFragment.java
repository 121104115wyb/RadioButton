package com.albb.radiobutton;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Lenovo on 2017/6/30.
 */

public class IBaseFragment extends Fragment {
    private View view = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_layout,container,false);
        ((TextView)view.findViewById(R.id.fragment_text)).setText("name");
        return view;
    }

    public void setText(String string){

    }
}
