package com.example.lastquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DatabaseFragment extends Fragment {

    EditText name, loc, desig;
    Button saveBtn;
    Intent intent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculation,container,false);

        name = view.findViewById(R.id.txtName);
        loc = view.findViewById(R.id.txtLocation);
        desig = view.findViewById(R.id.txtDesignation);
        saveBtn = view.findViewById(R.id.btnSave);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = name.getText().toString()+"\n";
                String location = loc.getText().toString();
                String designation = desig.getText().toString();
                DbHandler dbHandler = new DbHandler(getActivity());
                dbHandler.insertUserDetails(username,location,designation);
                intent = new Intent(getActivity(),DetailsActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "Details Inserted Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
