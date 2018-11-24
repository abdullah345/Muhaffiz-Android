package livel.taaus.com.muhaffiz;

import android.widget.TextView;

public class DataHistory {
    public String actname;
   String actdesc;
    int actimage;

    public String getActname() {
        return actname;
    }

    public String getActdesc() {
        return actdesc;
    }

    public int getActimage() {
        return actimage;
    }

    public void setActname(String actname) {

        this.actname = actname;
    }

    public void setActimage(int actimage) {
        this.actimage = actimage;
    }

    public void setActdesc(String actdesc) {
        this.actdesc = actdesc;

    }



    public DataHistory(String actname,String actdesc, int actimage) {

        this.actname = actname;
        this.actdesc = actdesc;
        this.actimage = actimage;
    }
}
