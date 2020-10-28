package accommodation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="DashBoard_table")
public class DashBoard {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Long companyId;
        private String companyName;
        private Long roomId;
        private String roomStatus;
        private String location;
        private Long companyPhone;
        private String companyStatus;
        private String regReqStatus;

    public Long getRoomQty() {
        return roomQty;
    }

    public void setRoomQty(Long roomQty) {
        this.roomQty = roomQty;
    }

    private Long roomQty;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Long getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Long companyId) {
            this.companyId = companyId;
        }
        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }
        public Long getRoomId() {
            return roomId;
        }

        public void setRoomId(Long roomId) {
            this.roomId = roomId;
        }
        public String getRoomStatus() {
            return roomStatus;
        }

        public void setRoomStatus(String roomStatus) {
            this.roomStatus = roomStatus;
        }
        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
        public Long getCompanyPhone() {
            return companyPhone;
        }

        public void setCompanyPhone(Long companyPhone) {
            this.companyPhone = companyPhone;
        }
        public String getCompanyStatus() {
            return companyStatus;
        }

        public void setCompanyStatus(String companyStatus) {
            this.companyStatus = companyStatus;
        }
        public String getRegReqStatus() {
            return regReqStatus;
        }

        public void setRegReqStatus(String regReqStatus) {
            this.regReqStatus = regReqStatus;
        }

}
