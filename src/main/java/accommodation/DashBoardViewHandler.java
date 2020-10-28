package accommodation;

import accommodation.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DashBoardViewHandler {


    @Autowired
    private DashBoardRepository dashBoardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenCompanyRegistRequested_then_CREATE_1 (@Payload CompanyRegistRequested companyRegistRequested) {
        try {
            if (companyRegistRequested.isMe()) {
                // view 객체 생성
                DashBoard dashBoard = new DashBoard();
                // view 객체에 이벤트의 Value 를 set 함
                dashBoard.setId(companyRegistRequested.getId());
                dashBoard.setCompanyId(companyRegistRequested.getId());
                dashBoard.setCompanyName(companyRegistRequested.getCompanyName());
                dashBoard.setLocation(companyRegistRequested.getLocation());
                dashBoard.setCompanyPhone(companyRegistRequested.getCompanyPhone());
                // view 레파지 토리에 save
                dashBoardRepository.save(dashBoard);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenCompayRegisted_then_UPDATE_1(@Payload CompayRegisted compayRegisted) {
        try {
            if (compayRegisted.isMe()) {
                // view 객체 조회
                List<DashBoard> dashBoardList = dashBoardRepository.findByCompanyId(compayRegisted.getCompanyId());
                for(DashBoard dashBoard : dashBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashBoard.setCompanyStatus(compayRegisted.getcompanyManageStatus());
                    // view 레파지 토리에 save
                    dashBoardRepository.save(dashBoard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenRoomRegisted_then_UPDATE_2(@Payload RoomRegisted roomRegisted) {
        try {
            if (roomRegisted.isMe()) {
                // view 객체 조회
                List<DashBoard> dashBoardList = dashBoardRepository.findByCompanyId(roomRegisted.getCompanyId());
                for(DashBoard dashBoard : dashBoardList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    dashBoard.setRoomStatus(roomRegisted.getRoomStatus());
                    dashBoard.setRoomId(roomRegisted.getId());
                    dashBoard.setRoomQty(roomRegisted.getRoomQty());
                    // view 레파지 토리에 save
                    dashBoardRepository.save(dashBoard);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}