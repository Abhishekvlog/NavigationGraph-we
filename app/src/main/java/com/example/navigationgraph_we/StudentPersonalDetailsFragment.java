package com.example.navigationgraph_we;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;



public class StudentPersonalDetailsFragment extends Fragment {
    private Button mBtnNext;
    private EditText mEtName;
    private EditText mEtAge;
    private NavController navController;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_personal_details, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        initView(view);
    }

    private void initView(View v) {
        mBtnNext =v.findViewById(R.id.btnNext);
        mEtName = v.findViewById(R.id.etStudentName);
        mEtAge = v.findViewById(R.id.etStudentAge);
        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = mEtName.getText().toString();
                int age = Integer.parseInt(mEtAge.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putString("name",name);
                bundle.putInt("age",age);
                navController.navigate(R.id.action_studentPersonalDetailsFragment_to_studentPerformanceDetailsFragment,bundle);

            }
        });
    }
}