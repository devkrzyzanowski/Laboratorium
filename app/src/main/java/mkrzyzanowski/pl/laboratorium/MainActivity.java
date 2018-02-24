package mkrzyzanowski.pl.laboratorium;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView login;
    TextView password;
    UserData user;

    class UserData{
        private String login;
        private String password;

        public UserData(String login, String password){
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.loginText);
        password = findViewById(R.id.passwordText);
        user = new UserData("mojLogin", "haslo1");
    }

    public void checkLogin(View view){
        if (user.getLogin().equals(login.getText().toString()) && user.getPassword().equals(password.getText().toString())) {
            Intent i = new Intent(getBaseContext(), mainWindow.class);
            startActivity(i);
        } else {
            showWrongCredentialsDialog();
        }
    }

    public void showWrongCredentialsDialog(){
        final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Błąd logowania");
        alertDialog.setMessage("Wprowadzono błędny login lub hasło");
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
