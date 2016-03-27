package pcode.com.wajbatt;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by yahia on 25/03/2016.
 */
public class CustomClass extends Activity {

    public  View add_newFood_CustomView() {


        final EditText temp_editText_name = new EditText(this);
        temp_editText_name.setWidth((int) (getWindowManager().getDefaultDisplay().getWidth()/1.2));
        temp_editText_name.setHint("الأضافة");

        final EditText temp_editText_price = new EditText(this);
        temp_editText_price.setWidth((int) (getWindowManager().getDefaultDisplay().getWidth()/8));
        temp_editText_price.setHint("الثمن");

        LinearLayout temo_newfood_customLayOut = new LinearLayout(this);
        RadioGroup.LayoutParams layDiemension = new RadioGroup.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT , ViewGroup.LayoutParams.WRAP_CONTENT);

        temo_newfood_customLayOut.setLayoutParams(layDiemension);
        temo_newfood_customLayOut.setOrientation(LinearLayout.HORIZONTAL);

        temo_newfood_customLayOut.addView(temp_editText_price);
        temo_newfood_customLayOut.addView(temp_editText_name);


//        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams
//                            (ActionBar.LayoutParams.FILL_PARENT, RadioGroup.LayoutParams.FILL_PARENT);
//        relativeParams.addRule(RelativeLayout.BELOW, R.id.addnewfood_CustomLinearLayOut);
        return temo_newfood_customLayOut;
    }


    public boolean internetChecked (){
        Toast.makeText(this,"Test",Toast.LENGTH_LONG).show();
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

       if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
               connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED ) {
            return true;
        }else
            return false;
    }








}
