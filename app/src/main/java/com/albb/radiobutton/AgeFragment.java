package com.albb.radiobutton;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by wyb on 2017/6/30.
 */

public class AgeFragment extends Fragment {
    View view;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_layout,container,false);
        ((TextView)view.findViewById(R.id.fragment_text)).setText("age!");
        return view;
    }
}
