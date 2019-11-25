package com.example.animal_health;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Maindisease extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView ivdismu1, ivdismu2, ivdismu3, ivdismu4;
    Glide GlideApp;
    String[] dis = {"링웜(피부병)", "발작", "급성 심부전", "심장 사상충", "음식물 중독", "장폐색"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disease);
        ivdismu1 = findViewById(R.id.dismu1);
        ivdismu2 = findViewById(R.id.dismu2);
        ivdismu3 = findViewById(R.id.dismu3);
        ivdismu4 = findViewById(R.id.dismu4);

        FirebaseStorage storage = FirebaseStorage.getInstance();

        Spinner dismu = (Spinner) findViewById(R.id.dismu);
        dismu.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter bb = new ArrayAdapter(this,android.R.layout.simple_spinner_item,dis);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        dismu.setAdapter(bb);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int menu, long l) {
        Toast.makeText(getApplicationContext(),dis[menu] , Toast.LENGTH_LONG).show();
        if(dis[menu].equals("링웜(피부병)")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fringworm.PNG?alt=media&token=8501f450-816d-4090-a1fa-e0d7e0bb4350";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fringworm2.PNG?alt=media&token=69c6151b-38ec-4d27-957b-a5598dbb9a78";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);
            String ur3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fringworm3.PNG?alt=media&token=aeb5e0d8-fc5a-4f2b-be4f-13c23b6e6db4";
            Glide.with(getApplicationContext()).load(ur3).into(ivdismu3);

        }else if(dis[menu].equals("발작")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fconvulsion1.PNG?alt=media&token=9884510f-ff8c-4918-8e78-f6bb4ea818e7";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fconvulsion2.PNG?alt=media&token=7074f56f-152c-4d7b-a722-238eb4d15fbf";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);
            String ur3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fconvulsion3.PNG?alt=media&token=895ed51c-7a48-400b-b01c-a303cb200c62";
            Glide.with(getApplicationContext()).load(ur3).into(ivdismu3);
            String ur4 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fconvulsion4.PNG?alt=media&token=8c702c07-73ae-4c6b-9572-3831c624af9d";
            Glide.with(getApplicationContext()).load(ur4).into(ivdismu4);

        }else if(dis[menu].equals("급성 심부전")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FHeart%20failure.PNG?alt=media&token=ba48e076-9dd6-4efc-a6ca-f7fb6a5ef8fe";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FHeart%20failure2.PNG?alt=media&token=2d0103fb-17ee-4c98-bcfc-56011fe9ee82";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);

        }else if(dis[menu].equals("심장 사상충")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FDirofilaria%20immitis.PNG?alt=media&token=edd9be3d-4291-4c11-bb88-440be9996f1c";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FDirofilaria%20immitis2.PNG?alt=media&token=967b776f-d81f-4bc9-baf3-617a4b16d204";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);


        }else if(dis[menu].equals("음식물 중독")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FToxicology.PNG?alt=media&token=a436a921-06fe-4f54-a9df-748cdd31a10e";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FToxicology2.PNG?alt=media&token=27db6a78-9880-4d97-aade-5d23602ab295";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);
            String ur3 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FToxicology3.PNG?alt=media&token=ec12d7e4-9520-47c4-a2cf-49c7cb182a0c";
            Glide.with(getApplicationContext()).load(ur3).into(ivdismu3);

        }else if(dis[menu].equals("장폐색")){
            String url = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2FIleus.PNG?alt=media&token=c2cfb9e0-8a1d-46b8-adb1-fad85c9c8470";
            Glide.with(getApplicationContext()).load(url).into(ivdismu1);
            String ur2 = "https://firebasestorage.googleapis.com/v0/b/animal-health-d5254.appspot.com/o/disease%2Fileus2.PNG?alt=media&token=76abd025-c1f5-4509-8e11-5b9240957edc";
            Glide.with(getApplicationContext()).load(ur2).into(ivdismu2);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // TODO Auto-generated method stub

    }
}