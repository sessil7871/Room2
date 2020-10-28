package accommodation;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="CompanyManagement_table")
public class CompanyManagement {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String companyName;
    private String ownerName;
    private Long companyPhone;
    private String location;
    private String businesssType;
    private Long companyId;

    public String getCompanyManageStatus() {
        return companyManageStatus;
    }

    public void setCompanyManageStatus(String companyManageStatus) {
        this.companyManageStatus = companyManageStatus;
    }

    private String companyManageStatus;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @PostPersist
    public void onPostPersist(){
        CompayRegisted compayRegisted = new CompayRegisted();
        BeanUtils.copyProperties(this, compayRegisted);
        compayRegisted.publishAfterCommit();


        CompayCanced compayCanced = new CompayCanced();
        BeanUtils.copyProperties(this, compayCanced);
        compayCanced.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public Long getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(Long companyPhone) {
        this.companyPhone = companyPhone;
    }
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getBusinesssType() {
        return businesssType;
    }

    public void setBusinesssType(String businesssType) {
        this.businesssType = businesssType;
    }

    @PostUpdate
    public void onPostUpdate(){


    }


}
