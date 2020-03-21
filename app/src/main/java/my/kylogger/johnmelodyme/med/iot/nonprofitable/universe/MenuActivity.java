package my.kylogger.johnmelodyme.med.iot.nonprofitable.universe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;

public class MenuActivity extends AppCompatActivity {
    public static final String TAG = "Universe";


    public void DeclarationInit() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: " + MenuActivity.class.getSimpleName());
        DeclarationInit();
    }

    @Override
    // TODO  onCreateOptionsMenu()
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    // TODO onOptionsItemSelected()
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.about) {
            new FancyGifDialog.Builder(this)
                    .setTitle(getResources().getString(R.string.about))
                    .setMessage(getResources().getString(R.string.aboutdev))
                    .setPositiveBtnText(getResources().getString(R.string.ok))
                    .setPositiveBtnBackground("#FF4081")
                    .setGifResource(R.raw.g)   //Pass your Gif here
                    .isCancellable(true)
                    .OnPositiveClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {

                        }
                    }).build();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
