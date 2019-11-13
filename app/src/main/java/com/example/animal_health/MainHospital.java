package com.example.animal_health;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class MainHospital extends ArrayAdapter<Hospital> {
    private Activity context;
    List<Hospital> hospitals;

    public MainHospital(Activity context, List<Hospital> hospitals) {
        super(context, R.layout.layout_hospital_list, hospitals);
        this.context = context;
        this.hospitals = hospitals;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_hospital_list, null, true);

        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        TextView textViewAddress = (TextView) listViewItem.findViewById(R.id.textViewAddress);

        Hospital hospital = hospitals.get(position);
        textViewName.setText(hospital.getBIZPLC_NM());
        textViewAddress.setText(hospital.getREFINE_LOTNO_ADDR());

        return listViewItem;
    }

}