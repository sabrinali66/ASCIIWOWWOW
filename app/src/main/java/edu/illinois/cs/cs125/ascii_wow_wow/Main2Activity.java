package edu.illinois.cs.cs125.ascii_wow_wow;

import android.graphics.Color;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.TextView;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    Uri myUri;

    private static  String BLACK = "@";
    private static String CHARCOAL = "#";
    private static String DARKGRAY = "8";
    private static String MEDIUMGRAY = "&";
    private static String MEDIUM = "o";
    private static String GRAY = ":";
    private static String SLATEGRAY = "*";
    private static  String LIGHTGRAY = ".";
    private static String WHITE = " ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView iv_photo=(ImageView)findViewById(R.id.imageView2);
        /**ImageView iv_photo2=(ImageView)findViewById(R.id.imageView3);

        ImageView iv_photo3=(ImageView)findViewById(R.id.imageView4);
        ImageView iv_photo4=(ImageView)findViewById(R.id.imageView5);
         */
        Bundle extras = getIntent().getExtras();
        String temp = extras.getString("imageUri");
        if(temp!=null){
            myUri = Uri.parse(temp);
            /**iv_photo.setImageURI(myUri);
            iv_photo2.setImageURI(myUri);
            iv_photo3.setImageURI(myUri);
            iv_photo4.setImageURI(myUri);
             **/

            Bitmap bitmap;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), myUri);
            } catch (IOException e) {
                e.printStackTrace();
                bitmap = null;
                return;
            }

            StringBuilder toTextView = new StringBuilder();

            for (int i = 0; i < bitmap.getWidth(); i++) {
                for (int j = 0; j < bitmap.getHeight(); j++) {
                    int pixel = bitmap.getPixel(i, j);
                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);
                    int  rValue = (r + g + b) / 3;

                    toTextView.append(getGrayShade(rValue));
                }
            }

            TextView textView = findViewById(R.id.convertedImage);
            textView.setText(toTextView.toString());
        }
    }

    private static  String getGrayShade(int redValue)
    {
        String asciival = " ";

        if (redValue >= 230)
        {
            asciival = WHITE;
        }
        else if (redValue >= 200)
        {
            asciival = LIGHTGRAY;
        }
        else if (redValue >= 180)
        {
            asciival = SLATEGRAY;
        }
        else if (redValue >= 160)
        {
            asciival = GRAY;
        }
        else if (redValue >= 130)
        {
            asciival = MEDIUM;
        }
        else if (redValue >= 100)
        {
            asciival = MEDIUMGRAY;
        }
        else if (redValue >= 70)
        {
            asciival = DARKGRAY;
        }
        else if (redValue >= 50)
        {
            asciival = CHARCOAL;
        }
        else
        {
            asciival = BLACK;
        }

        return asciival;
    }
}
