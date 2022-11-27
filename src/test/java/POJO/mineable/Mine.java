package POJO.mineable;

import POJO.Status;

public class Mine {

    public Status status;
    public Datum data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Datum getData() {
        return data;
    }

    public void setData(Datum data) {
        this.data = data;
    }
}