package my.kylogger.johnmelodyme.med.iot.nonprofitable.universe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.shashank.sony.fancygifdialoglib.FancyGifDialog;
import com.shashank.sony.fancygifdialoglib.FancyGifDialogListener;
import java.util.ArrayList;
import my.kylogger.johnmelodyme.med.iot.nonprofitable.universe.Helper.CustomAdapter;
import my.kylogger.johnmelodyme.med.iot.nonprofitable.universe.Model.DataModel;
import my.kylogger.johnmelodyme.med.iot.nonprofitable.universe.Model.MyData;

public class MenuActivity extends AppCompatActivity {
    public static final String TAG = "Universe";
    public static View.OnClickListener myOnClickListener;
    public static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    private static ArrayList<Integer> removedItems;

    public void DeclarationInit() {
//        myOnClickListener = new MyOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.rview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            data.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.descriptionArray[i],
                    MyData.id_[i],
                    MyData.drawableArray[i]
            ));
            removedItems = new ArrayList<Integer>();

            adapter = new CustomAdapter(data);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: " + MenuActivity.class.getSimpleName());
        DeclarationInit();
    }

    private static class MyOnClickListener implements View.OnClickListener{
        private final Context context;

        private MyOnClickListener(Context context) {
            this.context = context;
        }
        
        @Override
        public void onClick(View v) {
            removeItem(v);
        }

        private void removeItem(View v) {
            int selectedItemPosition = recyclerView.getChildPosition(v);
            RecyclerView.ViewHolder viewHolder
                    = recyclerView.findViewHolderForPosition(selectedItemPosition);
            TextView textViewName
                    = (TextView) viewHolder.itemView.findViewById(R.id.title);
            String selectedName = (String) textViewName.getText();
            int selectedItemId = -1;
            for (int i = 0; i < MyData.nameArray.length; i++) {
                if (selectedName.equals(MyData.nameArray[i])) {
                    selectedItemId = MyData.id_[i];
                }
            }
            removedItems.add(selectedItemId);
            data.remove(selectedItemPosition);
            adapter.notifyItemRemoved(selectedItemPosition);
        }
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
                    .setGifResource(R.raw.g)
                    .isCancellable(true)
                    .OnPositiveClicked(new FancyGifDialogListener() {
                        @Override
                        public void OnClick() {
                            //////////////////////
                        }
                    }).build();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
