package coms.example.allinonelowfiproject.objects;

public class DashItem {

    String mainMemo;
    String semiMemo;

    public DashItem(String mainMemo, String semiMemo) {
        super();
        this.mainMemo = mainMemo;
        this.semiMemo = semiMemo;
    }

    public String getMainMemo() {
        return mainMemo;
    }

    public void setMainMemo(String mainMemo) {
        this.mainMemo = mainMemo;
    }

    public String getSemiMemo() {
        return semiMemo;
    }

    public void setSemiMemo(String semiMemo) {
        this.semiMemo = semiMemo;
    }
}
