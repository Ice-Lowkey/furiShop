package vn.t3h.class2109.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.t3h.class2109.entities.MessageEntity;

import java.sql.Time;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    Long id;
    String firstname;
    String lastname;
    String email;
    String mess;
    Time time;

    public MessageEntity mapperEntity() {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setId(id);
        messageEntity.setFirstname(firstname);
        messageEntity.setLastname(lastname);
        messageEntity.setEmail(email);
        messageEntity.setMess(mess);
        messageEntity.setTime(time);

        return messageEntity;
    }
}
