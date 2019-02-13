package radiodemo.android.example.com.qr_code_creator;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class QrCodeScanner extends AppCompatActivity  {

    Button convert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code_scanner);

        convert=(Button)findViewById(R.id.scan);

       final Activity activity=this;

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator integrator= new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
               // integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();
            }
        });
    }

   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result!=null)
        {
            if(result.getContents()==null)
            {
                Toast.makeText(this, "You cancelled scanning", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this,result.getContents(), Toast.LENGTH_SHORT).show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
