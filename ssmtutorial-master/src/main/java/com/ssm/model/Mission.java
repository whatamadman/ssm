package com.ssm.model;

/**
 * Created by Administrator on 2017/4/9.
 */
public class Mission {
    private String mID;
    private String message;
    private float complete;
    private String cID;

    public String getmID() {
        return mID;
    }

    public void setmID(String mID) {
        this.mID = mID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public float getComplete() {
        return complete;
    }

    public void setComplete(float complete) {
        this.complete = complete;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }
}
