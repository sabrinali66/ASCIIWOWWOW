package edu.illinois.cs.cs125.ascii_wow_wow;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    Uri myUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView iv_photo=(ImageView)findViewById(R.id.imageView2);
        Bundle extras = getIntent().getExtras();
        String temp = extras.getString("imageUri");
        if(temp!=null){
            myUri = Uri.parse(temp);
            iv_photo.setImageURI(myUri);
        }
    }

}
