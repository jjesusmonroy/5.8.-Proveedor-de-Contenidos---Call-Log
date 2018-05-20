package gpsgooglemaps.monroy.com.a58calllog;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by jjesusmonroy on 20/05/18.
 */

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.RecyclerViewHolder> {
    String [][] data;

    public CallAdapter(String[][] data) {
        this.data = data;
    }

    @Override
    public CallAdapter.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_call,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CallAdapter.RecyclerViewHolder holder, int position) {
        holder.number.setText(data[position][0]);
        holder.name.setText(data[position][1]);
        holder.duration.setText(data[position][2]+" minutes");
        switch (data[position][3]){
            case "1":
                holder.type.setText("Incoming call");
                break;
            case "2":
                holder.type.setText("Outgoing call");
                break;
            case "3":
                holder.type.setText("Missed call");
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView number,name,duration,type;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            number=itemView.findViewById(R.id.number);
            name=itemView.findViewById(R.id.name);
            duration=itemView.findViewById(R.id.duration);
            type=itemView.findViewById(R.id.type);
        }
    }
}
