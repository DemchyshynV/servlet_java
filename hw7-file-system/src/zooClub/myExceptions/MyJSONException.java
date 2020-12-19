package zooClub.myExceptions;

import org.json.JSONException;

public class MyJSONException extends JSONException {

    private String msg;

    public MyJSONException(String s, String msg) {
        super(s);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
