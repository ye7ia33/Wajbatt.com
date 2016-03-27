package pcode.com.wajbatt;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class SplashView extends CustomClass {
    private final long splashtimer = 3500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_view);

        ImageView intro_BKG = (ImageView)findViewById(R.id.intro_img_BKG);
        float w_bkg = intro_BKG.getScaleX();
        float h_bkg = intro_BKG.getScaleY();
        intro_BKG.setScaleX(0);
        intro_BKG.setScaleY(0);
        intro_BKG.animate().alpha(1f).setDuration(2000);
        intro_BKG.animate().scaleX(w_bkg).scaleY(h_bkg).setDuration(splashtimer).
                    setStartDelay(0).setListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Intent intent_goLogin = new Intent().setClass(SplashView.this, LoginView.class);
                startActivity(intent_goLogin);
                finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
