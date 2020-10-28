package accommodation;

import accommodation.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }
    @Autowired
    CompanyManagementRepository companyManagementRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationCanceled_UpdateRoomStatus(@Payload ReservationCanceled reservationCanceled){

        if(reservationCanceled.isMe()){
            System.out.println("##### listener UpdateRoomStatus : " + reservationCanceled.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReserved_UpdateRoomStatus(@Payload Reserved reserved){

        if(reserved.isMe()){
            System.out.println("##### listener UpdateRoomStatus : " + reserved.toJson());
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCompanyRegistRequested_CompanyRegist(@Payload CompanyRegistRequested companyRegistRequested){

        if(companyRegistRequested.isMe()){
            CompanyManagement companyManagement = new CompanyManagement();
            companyManagement.setCompanyId(companyRegistRequested.getId());
            companyManagement.setBusinesssType(companyRegistRequested.getBusinessType());
            companyManagement.setCompanyName(companyRegistRequested.getCompanyName());
            companyManagement.setOwnerName(companyRegistRequested.getOwnerName());
            companyManagement.setCompanyPhone(companyRegistRequested.getCompanyPhone());
            companyManagement.setLocation(companyRegistRequested.getLocation());

            companyManagement.setCompanyManageStatus("RegistCompleted");

            companyManagementRepository.save(companyManagement);

            System.out.println("##### listener CompanyRegist : " + companyRegistRequested.toJson());
        }
    }

}
