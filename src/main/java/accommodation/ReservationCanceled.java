package accommodation;

public class ReservationCanceled extends AbstractEvent {

    private Long id;
    private String reserveStatus;
    private Long customerId;
    private String customerName;
    private Long customerPhone;
    private Long reservePrice;
    private Long reserveQty;
    private Long roomId;
    private Long reserveId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getReserveStatus() {
        return reserveStatus;
    }

    public void setReserveStatus(String reserveStatus) {
        this.reserveStatus = reserveStatus;
    }
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Long getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(Long customerPhone) {
        this.customerPhone = customerPhone;
    }
    public Long getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(Long reservePrice) {
        this.reservePrice = reservePrice;
    }
    public Long getReserveQty() {
        return reserveQty;
    }

    public void setReserveQty(Long reserveQty) {
        this.reserveQty = reserveQty;
    }
    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    public Long getReserveId() {
        return reserveId;
    }

    public void setReserveId(Long reserveId) {
        this.reserveId = reserveId;
    }
}