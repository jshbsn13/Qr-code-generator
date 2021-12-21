package net.androidbootcamp.qrcodegenerator.ui.main;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import net.androidbootcamp.qrcodegenerator.R;

public class Tab2Fragment extends Fragment {
    private Button generateBtn, clearBtn;
    private EditText productNum, lotNum, productQuantity, productLocation;
    private ImageView productNumBar, lotNumBar, quantityBar, locationBar;
    private String productNumStr, lotNumStr, quantityStr, locationStr;
    private int width = 800;
    private int height = 50;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        setRetainInstance(true);
        View view = inflater.inflate(R.layout.tab1_fragment,container,false);

        productNum = view.findViewById(R.id.productNumEdittxt);
        lotNum = view.findViewById(R.id.productLotNumEdittxt);
        productQuantity = view.findViewById(R.id.productAmountEdittxt);
        productLocation = view.findViewById(R.id.productLocationEdittxt);

        productNumBar = view.findViewById(R.id.productNumImg);
        lotNumBar = view.findViewById(R.id.productLotNumImg);
        quantityBar = view.findViewById(R.id.productAmountImg);
        locationBar = view.findViewById(R.id.productLocationImg);

        generateBtn = view.findViewById(R.id.generateBtn);
        clearBtn = view.findViewById(R.id.clearBtn);

        generateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productNumStr = productNum.getText().toString();
                lotNumStr = lotNum.getText().toString();
                quantityStr = productQuantity.getText().toString();
                locationStr = productLocation.getText().toString();

                if (!productNumStr.equals(null)){
                    productNumBar.setImageBitmap(createBarcode(productNumStr));
                }

                if(!lotNumStr.equals(null)){
                    lotNumBar.setImageBitmap(createBarcode(lotNumStr));
                }

                if (!quantityStr.equals(null)){
                    quantityBar.setImageBitmap(createBarcode(quantityStr));
                }

                if (!locationStr.equals(null)){
                    locationBar.setImageBitmap(createBarcode(locationStr));
                }

            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // clears set images for barcodes
                productNumBar.setImageBitmap(null);
                lotNumBar.setImageBitmap(null);
                locationBar.setImageBitmap(null);
                quantityBar.setImageBitmap(null);

                productNum.setText("");
                lotNum.setText("");
                productQuantity.setText("");
                productLocation.setText("");
            }
        });


        return view;
    }

    public Bitmap createBarcode(String string) {

        MultiFormatWriter multiFormatWriter=new MultiFormatWriter();




        try{

            // this makes a barcode as a BitMatrix then as a bitmap
            BitMatrix bitMatrix=multiFormatWriter.encode(string, BarcodeFormat.CODE_128,width,height);
            BarcodeEncoder barcodeEncoder=new BarcodeEncoder();
            Bitmap bitmap=barcodeEncoder.createBitmap(bitMatrix);


            return bitmap;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
