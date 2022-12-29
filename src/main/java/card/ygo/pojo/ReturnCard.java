package card.ygo.pojo;

import java.util.List;

public class ReturnCard {
    private Card data;
    private String message="success";
    private Long status=200L;

    public Card getData() {
        return data;
    }

    public void setData(Card data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}
