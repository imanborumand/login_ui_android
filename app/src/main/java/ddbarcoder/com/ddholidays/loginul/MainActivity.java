package ddbarcoder.com.ddholidays.loginul;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private EditText txt_email;
    private EditText txt_password;
    private Button    btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_email            = (EditText) findViewById(R.id.username);
        txt_password    = (EditText) findViewById(R.id.password);
        btn_login            = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLogin(view);
            }
        });
    }

    public void checkLogin(View arg0) {

        final String email = txt_email.getText().toString();
        if (!isValidEmail(email)) {
            Toast.makeText(this, "Email Validate Error!", Toast.LENGTH_SHORT).show();
        }

        final String pass = txt_password.getText().toString();
        if (!isValidPassword(pass)) {
            Toast.makeText(this, "Password Error!", Toast.LENGTH_SHORT).show();
        }

        if(isValidEmail(email) && isValidPassword(pass))
        {
            Toast.makeText(this, "Now Login :)", Toast.LENGTH_SHORT).show();
        }

    }

    // validating email
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() >= 4) {
            return true;
        }
        return false;
    }
}