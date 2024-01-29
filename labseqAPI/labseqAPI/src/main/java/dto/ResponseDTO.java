package dto;

import java.math.BigInteger;

public class ResponseDTO {
    private long time;
    private BigInteger result;

    public ResponseDTO(long time, BigInteger result) {
        this.time = time;
        this.result = result;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public BigInteger getResult() {
        return result;
    }

    public void setResult(BigInteger result) {
        this.result = result;
    }
}
