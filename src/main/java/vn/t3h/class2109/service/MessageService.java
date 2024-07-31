package vn.t3h.class2109.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.t3h.class2109.dto.MessageDto;
import vn.t3h.class2109.entities.MessageEntity;
import vn.t3h.class2109.paging.PagingAndSortOject;
import vn.t3h.class2109.repositories.MessageRepository;

import java.sql.Time;
import java.util.Calendar;
import java.util.List;


@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;


    public MessageEntity saveMessage(MessageDto messageDto) {
        MessageEntity messageEntity = messageDto.mapperEntity();

        // Lấy thời gian hiện tại và thiết lập vào đối tượng MessageEntity
        Calendar calendar = Calendar.getInstance();
        Time currentTime = new Time(calendar.getTimeInMillis());
        if (messageEntity.getTime() == null) {
            messageEntity.setTime(currentTime);
        }

        return messageRepository.save(messageEntity);
    }

    public void findAll(PagingAndSortOject page) {
        page.findAll(messageRepository);
    }


    public List<MessageEntity> getAll() {
        return messageRepository.findAll();
    }

}
