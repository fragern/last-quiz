package com.example.lastquiz;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class DatabaseFragment extends Fragment {

    DBHelper DB;
    EditText name, contact, dob;
    Button insert, update, delete, vieww;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_database,container,false);

        super.onCreate(savedInstanceState);
//        setContentView(android.R.layout.fragment_db);
        name = view.findViewById(R.id.name);
        contact = view.findViewById(R.id.contact);
        dob = view.findViewById(R.id.dob);
        insert = view.findViewById(R.id.btnInsert);
        update = view.findViewById(R.id.btnUpdate);
        delete = view.findViewById(R.id.btnDelete);
        vieww = view.findViewById(R.id.btnView);
        DB = new DBHelper(getActivity());

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, contactTXT, dobTXT);
                if(checkinsertdata==true)
                    Toast.makeText(getActivity(), "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getActivity(), "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String contactTXT = contact.getText().toString();
                String dobTXT = dob.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT, contactTXT, dobTXT);
                if(checkupdatedata==true)
                    Toast.makeText(getActivity(), "Entry Updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getActivity(), "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkudeletedata = DB.deletedata(nameTXT);
                if(checkudeletedata==true)
                    Toast.makeText(getActivity(), "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getActivity(), "Entry Not    Deleted", Toast.LENGTH_SHORT).show();
            }        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(getActivity(), "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("Contact :"+res.getString(1)+"\n");
                    buffer.append("Date of Birth :"+res.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });
        return view;
    }
}
