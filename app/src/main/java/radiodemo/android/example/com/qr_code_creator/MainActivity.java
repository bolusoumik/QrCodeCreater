package radiodemo.android.example.com.qr_code_creator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    Button sel,sel1;

    MultiFormatWriter multi = new MultiFormatWriter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sel=(Button)findViewById(R.id.btn);
        sel1=(Button)findViewById(R.id.btn1);

        sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,QrCodeScanner.class);
                startActivity(intent);
            }
        });

        sel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,QrCodeGenerator.class);
                startActivity(intent);
            }
        });


       /* TextToQR = input.getText().toString();

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    BitMatrix bitmatrix =multi.encode(TextToQR, BarcodeFormat.QR_CODE, 300,300);

                    BarcodeEncoder barcodeencoder = new BarcodeEncoder();

                    Bitmap bitmap= barcodeencoder.createBitmap(bitmatrix);

                    QR.setImageBitmap(bitmap);

                }catch (WriterException e)
                {
                    e.printStackTrace();
                }
            }
        });*/

    }
}
