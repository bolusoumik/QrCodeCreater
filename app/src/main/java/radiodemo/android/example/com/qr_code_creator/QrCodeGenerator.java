package radiodemo.android.example.com.qr_code_creator;

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

public class QrCodeGenerator extends AppCompatActivity {

    EditText text;
    Button btn;
    ImageView img;
    String TextToQR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_generator);

        text=(EditText)findViewById(R.id.input_text);
        btn=(Button)findViewById(R.id.gen_btn);
        img=(ImageView)findViewById(R.id.qr_image);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextToQR=text.getText().toString();
                MultiFormatWriter multiFormatWriter= new MultiFormatWriter();
                try{
                    BitMatrix bitMatrix= multiFormatWriter.encode(TextToQR, BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder= new BarcodeEncoder();
                    Bitmap bitmap= barcodeEncoder.createBitmap(bitMatrix);
                    img.setImageBitmap(bitmap);
                }catch (WriterException e)
                {
                    e.printStackTrace();
                }

            }
        });
    }
}
