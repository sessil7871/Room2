package accommodation;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Room_table")
public class Room {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long roomNo;
    private String roomType;
    private String roomStatus;
    private Long roomQty;
    private Long companyId;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }



    @PostPersist
    public void onPostPersist(){
        RoomRegisted roomRegisted = new RoomRegisted();
        roomRegisted.setRoomNo(this.getId());
        BeanUtils.copyProperties(this, roomRegisted);
        roomRegisted.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        CheckedIn checkedIn = new CheckedIn();
        BeanUtils.copyProperties(this, checkedIn);
        checkedIn.publishAfterCommit();


        CheckedOut checkedOut = new CheckedOut();
        BeanUtils.copyProperties(this, checkedOut);
        checkedOut.publishAfterCommit();


    }

    @PostRemove
    public void onPostRemove(){
        RoomDeleted roomDeleted = new RoomDeleted();
        BeanUtils.copyProperties(this, roomDeleted);
        roomDeleted.publishAfterCommit();


    }


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
