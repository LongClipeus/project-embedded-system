package phong_long_chuyen.app_android.model.entity;

public class SettingEntity {

    private int mIcon;
    private int mText;

    public SettingEntity() {
    }

    public SettingEntity(int icon, int text) {
        mIcon = icon;
        mText = text;
    }

    public int getIcon() {
        return mIcon;
    }

    public void setIcon(int icon) {
        mIcon = icon;
    }

    public int getText() {
        return mText;
    }

    public void setText(int text) {
        mText = text;
    }
}
