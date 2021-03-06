
package accommodation;

public class CheckedIn extends AbstractEvent {

    private Long id;
    private Long roomNo;
    private String roomType;
    private String roomStatus;
    private Long roomQty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Long roomNo) {
        this.roomNo = roomNo;
    }
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
    public Long getRoomQty() {
        return roomQty;
    }

    public void setRoomQty(Long roomQty) {
        this.roomQty = roomQty;
    }
}
