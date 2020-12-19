package zooClub.myExceptions;

import org.json.JSONException;

public class MyException extends JSONException {

    private String msg;

    public MyException(String s, String msg) {
        super(s);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
