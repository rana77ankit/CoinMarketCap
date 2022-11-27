package POJO.ID;

import POJO.Status;

import java.util.ArrayList;

public class FetchID {
    public Status status;
    public ArrayList<Datum> data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }



}
