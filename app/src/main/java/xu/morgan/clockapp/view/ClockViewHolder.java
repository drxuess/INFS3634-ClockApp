package xu.morgan.clockapp.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import xu.morgan.clockapp.R;
import xu.morgan.clockapp.model.Clock;

public class ClockViewHolder extends RecyclerView.ViewHolder{
    private TextView tvCurrentTime;
    private TextView tvLocation;
    private ImageView ivLocationImage;

    public ClockViewHolder(View view) {
        super(view);
        tvCurrentTime = view.findViewById(R.id.tvCurrentTime);
        tvLocation = view.findViewById(R.id.tvCityName);
        ivLocationImage = view.findViewById(R.id.ivCityImage);
    }

    public void setClock(Context context, Clock clock, Clock.TimeFormat format){
        tvCurrentTime.setText(clock.getTime(format));
        tvLocation.setText(clock.getLocation());
        ivLocationImage.setImageResource(context.getResources().getIdentifier("drawable/" + clock.getImage(), null, context.getPackageName()));
    }
}
