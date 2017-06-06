package com.system.ccew.dao;

import com.system.ccew.entity.UserEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author finderlo
 * @date 07/05/2017
 */
@Repository
@Component
public class UserDao extends AbstractDao<UserEntity> {


    public UserEntity findByPhone(String tel) {
        List<UserEntity> users = findBy("phone", tel);
        if (users.size() == 0) {
            return null;
        } else return users.get(0);
    }

    public List<UserEntity> findByNickName(String name) {
        return findBy("name", name);
    }

    public List<UserEntity> findByMail(String mail) {
        return findBy("mail", mail);
    }

    public UserEntity findById(int id) {
        return findById(id + "");
    }


}
