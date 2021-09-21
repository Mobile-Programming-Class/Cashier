package com.allam.cashier;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.allam.cashier.myerrorhandler.MyDouble;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText etCustomer, etItemLabel, etNumberOfItems, etPrice, etMoneyPaid;
    TextView tvCustomer, tvItemLabel, tvNumberOfItems, tvPrice, tvMoneyPaid,
            tvTotal, tvChanges, tvBonus, tvDescription;
    Button btnProceed, btnDelete, btnClose, btnAddToCart;
    ArrayList<TextView> myCart;

    String customerName, itemLabel, numberOfItems, price, moneyPaid;
    double dNumberOfItems, dPrice, dMoneyPaid, dTotal, dChanges;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Aplikasi Penjualan");

        myCart = new ArrayList<>();

        //EditText
        etCustomer = findViewById(R.id.etCustomer);
        etItemLabel = findViewById(R.id.etItemLabel);
        etNumberOfItems = findViewById(R.id.etNumberOfItems);
        etPrice = findViewById(R.id.etPrice);
        etMoneyPaid = findViewById(R.id.etMoneyPaid);

        //TextView
        tvCustomer = findViewById(R.id.tvCustomerName);
        tvItemLabel = findViewById(R.id.tvItemCart);
        tvNumberOfItems = findViewById(R.id.tvNumberOfItemsCart);
        tvPrice = findViewById(R.id.tvPriceCart);
        tvMoneyPaid = findViewById(R.id.tvMoneyPaidCart);
        tvTotal = findViewById(R.id.tvTotal);
        tvChanges = findViewById(R.id.tvChanges);
        tvBonus = findViewById(R.id.tvBonus);
        tvDescription = findViewById(R.id.tvDescription);

        //Button
        btnProceed = findViewById(R.id.btnProceed);
        btnDelete = findViewById(R.id.btnDelete);
        btnClose = findViewById(R.id.btnClose);
        btnAddToCart = findViewById(R.id.btnAddToCart);

        //Proceed
        btnProceed.setOnClickListener(view -> {
            customerName = etCustomer.getText().toString().trim();
            itemLabel = etItemLabel.getText().toString().trim();
            numberOfItems = etNumberOfItems.getText().toString().trim();
            price = etPrice.getText().toString().trim();
            moneyPaid = etMoneyPaid.getText().toString().trim();

            dNumberOfItems = MyDouble.myParseDouble(numberOfItems);
            dPrice = MyDouble.myParseDouble(price);
            dMoneyPaid = MyDouble.myParseDouble(moneyPaid);
            dTotal = (dNumberOfItems * dPrice);

            tvCustomer.setText("Nama Pembeli : " + customerName);
            tvItemLabel.setText("Nama Barang : " + itemLabel);
            tvNumberOfItems.setText("Jumlah Barang : " + numberOfItems);
            tvPrice.setText("Harga Barang : " + price);
            tvMoneyPaid.setText("Uang bayar : " + moneyPaid);

            tvTotal.setText("Total Belanja " + dTotal);
            if (dTotal >= 200000) {
                tvBonus.setText("Bonus : HardDisk 1TB");
            } else if (dTotal >= 50000) {
                tvBonus.setText("Bonus : Keyboard Gaming");
            } else if (dTotal >= 40000) {
                tvBonus.setText("Bonus : Mouse Gaming");
            } else {
                tvBonus.setText("Bonus : Tidak ada bonus!");
            }

            dChanges = (dMoneyPaid - dTotal);
            if (dMoneyPaid < dTotal) {
                tvDescription.setText("Description : Uang bayar kurang Rp. " + (-dChanges));
                tvChanges.setText("Uang Kembalian : Rp. 0");
            } else {
                tvDescription.setText("Description : Tunggu Kembalian");
                tvChanges.setText("Uang Kembalian : Rp. " + dChanges);
            }

        });

        btnDelete.setOnClickListener(view -> {
            tvCustomer.setText("");
            tvItemLabel.setText("");
            tvNumberOfItems.setText("");
            tvPrice.setText("");
            tvMoneyPaid.setText("");
            tvChanges.setText("");
            tvDescription.setText("");
            tvBonus.setText("");
            tvTotal.setText("");

            Toast.makeText(getApplicationContext(), "Data sudah dihapus", Toast.LENGTH_SHORT).show();
        });

        btnClose.setOnClickListener(view -> moveTaskToBack(true));

        btnAddToCart.setOnClickListener(view -> {
            TextView myItem = new TextView(this);
            String myText = tvCustomer.getText() + "\n" + tvNumberOfItems.getText() + "\n" + tvItemLabel.getText() + "\n" + "Total: " + tvTotal.getText();
            myItem.setText(myText);
            myItem.setId(View.generateViewId());

            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            if (myCart.size() == 0) params.addRule(RelativeLayout.BELOW, R.id.top_0);
            else params.addRule(RelativeLayout.BELOW, myCart.get(myCart.size()-1).getId());
            myItem.setLayoutParams(params);

            RelativeLayout rlMain = findViewById(R.id.rlMain);
            rlMain.addView(myItem);
            myCart.add(myItem);
        });

    }

}