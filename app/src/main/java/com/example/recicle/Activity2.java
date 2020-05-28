package com.example.recicle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.content.Intent;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity {
    TextView mTitleView, mDescriptionView,mProfesorView,mHoraview,mDiaView,mFechaProxView;
    ImageView mImageView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad2);

        ActionBar actionBar=getSupportActionBar();

        mTitleView=findViewById(R.id.titleview);
        mDescriptionView=findViewById(R.id.descripcionview);
        mImageView=findViewById(R.id.imageview);
        mProfesorView=findViewById(R.id.profesorview);
        mHoraview=findViewById(R.id.horaview);
        mDiaView=findViewById(R.id.diaview);
        mFechaProxView=findViewById(R.id.fechaproxview);
        Intent intent=getIntent();
        String mTitle=intent.getStringExtra("iTitle");
        String mDes=intent.getStringExtra("iDesc");
        String mProfesor=intent.getStringExtra("iProfesor");
        String mHora=intent.getStringExtra("iHora");
        String mDia=intent.getStringExtra("iDia");
        String mFechaProx=intent.getStringExtra("iProxima");


        byte[] mBytes=getIntent().getByteArrayExtra("iImage");
        Bitmap bitmap=BitmapFactory.decodeByteArray(mBytes,0,mBytes.length);

        actionBar.setTitle(mTitle);
        mTitleView.setText(mTitle);
        mDescriptionView.setText(mDes);
        mProfesorView.setText(mProfesor);
        mHoraview.setText(mHora);
        mDiaView.setText(mDia);
        mFechaProxView.setText(mFechaProx);
        mImageView.setImageBitmap(bitmap);



    }

}
