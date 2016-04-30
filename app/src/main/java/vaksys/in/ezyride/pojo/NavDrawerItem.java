package vaksys.in.ezyride.pojo;

/**
 * Created by dell980 on 4/21/2016.
 */
public class NavDrawerItem {
    private boolean showNotify;
    private String title;
    private int icon;

    public NavDrawerItem(){

    }

    public NavDrawerItem(boolean showNotify, String title) {
        this.showNotify = showNotify;
        this.title = title;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
