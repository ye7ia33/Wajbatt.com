package pcode.com.wajbatt;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginView extends CustomClass {
    private EditText login_txt_username , login_txt_password ;
public void newUser (View btn_Reg){

    startActivity( new Intent(this, RegistrationView.class));
}
    public  void  chkLogin (View btn_Loin){
      //  startActivity(new Intent(this, MasterFoodView.class));

        if (login_txt_username.getText().length() > 0 ){
            if (login_txt_password.getText().length() > 0 ){
                // check login using volley
                if (true) startActivity(new Intent(this, MasterFoodView.class));
                else {
                    String reg_showHint = "لا يوجد  اتصال بالانترنت" ;
                    Toast.makeText(LoginView.this , reg_showHint ,Toast.LENGTH_LONG).show();
                }
            }else {
                String reg_showHint = "برجاء إدخال كلمه المرور";
                login_txt_password.setError(Html.fromHtml("<font color='blue'>" + reg_showHint + "</font>"));
            }
        }else {
            String reg_showHint =  "برجاء إدخال أسم المستخدم" ;
            login_txt_username.setError(Html.fromHtml("<font color='blue'>" + reg_showHint + "</font>"));
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
        login_txt_username = (EditText) findViewById(R.id.login_txt_username);
        login_txt_password = (EditText)findViewById(R.id.login_txt_password) ;


    }

}
