package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;

import com.example.project1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public native String stringFromJNI();
    public static native int initRng();
    public static native byte[] randomBytes(int no);

    // Used to load the 'project1' library on application startup.
    static {
        System.loadLibrary("project1");
        System.loadLibrary("mbedcrypto");
    }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Example of a call to a native method
        TextView tv = binding.sampleText;
        tv.setText(stringFromJNI());
    }

}