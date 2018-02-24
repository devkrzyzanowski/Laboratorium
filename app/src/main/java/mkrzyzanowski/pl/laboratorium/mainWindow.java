package mkrzyzanowski.pl.laboratorium;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class mainWindow extends AppCompatActivity {
    DatePicker datePicker;
    TextView uzasadnienieText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_picker_layout);
        datePicker = findViewById(R.id.datePicker2);
        uzasadnienieText = findViewById(R.id.uzasadnienieText);
    }

    public void sendClick(View view){
        String title = "Raport";
        String text = "data: " + datePicker.getDayOfMonth() + "." + String.valueOf(datePicker.getMonth() + 1) + "." + datePicker.getYear() + "\n" +
                "Uzasadnienie: " + uzasadnienieText.getText().toString();



        showDateDialog(title, text);
    }


    public void showDateDialog(String title, String text){
        final AlertDialog alertDialog = new AlertDialog.Builder(mainWindow.this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(text);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
