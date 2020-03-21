package my.kylogger.johnmelodyme.med.iot.nonprofitable.universe.Helper;


import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import my.kylogger.johnmelodyme.med.iot.nonprofitable.universe.MenuActivity;
import my.kylogger.johnmelodyme.med.iot.nonprofitable.universe.Model.DataModel;
import my.kylogger.johnmelodyme.med.iot.nonprofitable.universe.Model.MyData;
import my.kylogger.johnmelodyme.med.iot.nonprofitable.universe.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewVersion;
        ImageView imageViewIcon;

        public  MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.title);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.text);
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.imageView);
        }

    }

    public CustomAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view, parent, false);

        view.setOnClickListener(MenuActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getName());
        textViewVersion.setText(dataSet.get(listPosition).getDescription());
        imageView.setImageResource(dataSet.get(listPosition).getImage());


    }

    @Override
    public int getItemCount() {
        //////////////
        return dataSet.size();
    }

    public void bind(final MyData item, final OnClickListener listener){
        //
    }
}