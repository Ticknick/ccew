package com.system.ccew.dao;

import com.system.ccew.entity.UserEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author finderlo
 * @date 07/05/2017
 */
@Repository
@Component
public class UserDao extends AbstractDao<UserEntity> {

    public List<UserEntity> findByUserGroup(String group){
        return findBy("usergroup",group);
    }

    public List<UserEntity> findByTel(String tel){
        return findBy("tel",tel);
    }

    public List<UserEntity> findByNickName(String name){
        return findBy("nickname",name);
    }

    public List<UserEntity> findByMail(String mail){
        return findBy("mail",mail);
    }

}
