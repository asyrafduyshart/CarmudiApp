package com.carmudi.test.ui.detail;

/**
 * Created by Asyraf Duyshart on 6/2/17.
 */

public class CarDetailAdapterObject {

    String title;
    String detail;

    public void setData(String title, String detail){
        setTitle(title);
        setDetail(detail);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
