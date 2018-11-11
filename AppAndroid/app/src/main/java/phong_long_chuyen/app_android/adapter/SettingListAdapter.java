package phong_long_chuyen.app_android.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import phong_long_chuyen.app_android.R;
import phong_long_chuyen.app_android.model.entity.SettingEntity;
import phong_long_chuyen.app_android.view.fragment.SettingList;

public class SettingListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private SettingList mSettingList;

    private List<SettingEntity> mSettingEntityList;
    private Context mContext;

    public SettingListAdapter(Context context, List<SettingEntity> settingEntityList) {
        this.mContext = context;
        this.mSettingEntityList = settingEntityList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.item_setting_list, parent, false);
        return new SettingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        final SettingEntity settingEntity = mSettingEntityList.get(position);
        SettingViewHolder settingViewHolder = (SettingViewHolder) holder;

        settingViewHolder.mIvIcon.setImageResource(settingEntity.getIcon());
        settingViewHolder.mTvText.setText(settingEntity.getText());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSettingList != null) {
                    mSettingList.onClickItem(holder.getAdapterPosition());
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mSettingEntityList.size();
    }

    public class SettingViewHolder extends RecyclerView.ViewHolder {

        ImageView mIvIcon;
        TextView mTvText;

        public SettingViewHolder(View itemView) {
            super(itemView);
            mIvIcon = itemView.findViewById(R.id.iv_icon);
            mTvText = itemView.findViewById(R.id.tv_text);
        }
    }

    public void setOnItemClickedListener(SettingList settingList) {
        this.mSettingList = settingList;
    }
}
