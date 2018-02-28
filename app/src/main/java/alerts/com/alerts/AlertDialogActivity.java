package alerts.com.alerts;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Srinath on 24/02/18.
 */

public class AlertDialogActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton button1;
    AppCompatButton button3;
    AppCompatButton button2;
    AppCompatButton button4;
    AppCompatButton button5;
    PopupMenu popupMenu;
    Dialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alertdialog);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    AlertDialog alertDialog;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.popup, menu);//Menu Resource, Menu
        return true;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {


            case R.id.button2:

                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                View customView = getLayoutInflater().inflate(R.layout.inflate_customdialog,
                        null);

                TextView tv = customView.findViewById(R.id.tv);
                Button btyes = customView.findViewById(R.id.btyes);
                Button btno = customView.findViewById(R.id.btno);

                btyes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        alertDialog.dismiss();
                    }
                });
                btno.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        alertDialog.dismiss();
                    }
                });
                builder.setView(customView);
                alertDialog = builder.show();

                break;

            case R.id.button5:

                builder = new AlertDialog.Builder(AlertDialogActivity.this);
                builder.setMessage("this is normal alert dialog");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        Toast.makeText(AlertDialogActivity.this, "PositiveButton",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(AlertDialogActivity.this, "Negativebutton",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNeutralButton("Info", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(AlertDialogActivity.this, "Neutralbutton",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog = builder.show();

                break;

            case R.id.button1:

                dialog = new Dialog(this);
                customView = getLayoutInflater().inflate(R.layout.inflate_customdialog,
                        null);
                tv = customView.findViewById(R.id.tv);
                btyes = customView.findViewById(R.id.btyes);
                btno = customView.findViewById(R.id.btno);
                dialog.setContentView(customView);
                btyes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog.dismiss();
                    }
                });
                btno.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog.dismiss();
                    }
                });


                dialog.show();

                break;


            case R.id.button4:

                Toast.makeText(AlertDialogActivity.this, "This is toast message",
                        Toast.LENGTH_SHORT).show();

                break;

            case R.id.button3:


                popupMenu = new PopupMenu(AlertDialogActivity.this, button3);
                popupMenu.getMenuInflater().inflate(R.menu.popup, popupMenu.getMenu());
                popupMenu.setGravity(Gravity.CENTER);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {


                        switch (menuItem.getItemId()) {


                            case R.id.item1:
                                Toast.makeText(AlertDialogActivity.this, "item1",
                                        Toast.LENGTH_SHORT).show();
                                popupMenu.dismiss();
                                break;
                            case R.id.item2:
                                Toast.makeText(AlertDialogActivity.this, "item2",
                                        Toast.LENGTH_SHORT).show();
                                popupMenu.dismiss();
                                break;
                        }

                        return false;
                    }
                });


                popupMenu.show();
                break;
        }

    }
}
