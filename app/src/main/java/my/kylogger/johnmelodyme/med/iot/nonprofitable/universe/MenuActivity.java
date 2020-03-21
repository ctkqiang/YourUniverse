package my.kylogger.johnmelodyme.med.iot.nonprofitable.universe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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
//        if (menuItem.getItemId()) {
//        }
        return super.onOptionsItemSelected(menuItem);
    }
}
