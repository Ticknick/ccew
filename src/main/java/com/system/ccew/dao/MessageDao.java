package com.system.ccew.dao;

import com.system.ccew.entity.MessageEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import sun.plugin2.message.Message;

import java.util.List;

/**
 * @author finderlo
 * @date 07/05/2017
 */
@Repository
@Component
public class MessageDao extends AbstractDao<MessageEntity> {


    public List<MessageEntity> findByType(String messtype) {
        return findBy("messtype", messtype);
    }

    public List<MessageEntity> findByTitle(String title) {
        return findBy("title", title);
    }

    public List<MessageEntity> findByUserId(String userId) {
        return findBy("userid", userId);
    }

    public List<MessageEntity> findByAdmin(String admin) {
        return findBy("admin", admin);
    }
}
