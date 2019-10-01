package xu.morgan.clockapp.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xu.morgan.clockapp.R;
import xu.morgan.clockapp.model.Clock;

public class ClockAdapter extends RecyclerView.Adapter<ClockViewHolder> {

    private Context context;
    private ArrayList<Clock> clocks;
    private Clock.TimeFormat format;

    public ClockAdapter(Context context, ArrayList<Clock> clocks){
        this.clocks = clocks;
        this.context = context;
        this.format = Clock.TimeFormat.TWELVE;
    }

    public void switchFormat(){
        if(this.format == Clock.TimeFormat.TWELVE){
            this.format = Clock.TimeFormat.TWENTYFOUR;
        } else {
            this.format = Clock.TimeFormat.TWELVE;
        }
    }

    public Clock.TimeFormat getFormat() {
        return format;
    }

    @NonNull
    @Override
    public ClockViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_clock, parent, false);
        return new ClockViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClockViewHolder clockViewHolder, int i) {
        clockViewHolder.setClock(context, clocks.get(i), format);
    }

    @Override
    public int getItemCount() {
        return clocks.size();
    }
}
