package com.homework.dao;
import com.homework.model.Buyer;
import com.homework.model.User;

public interface IUserDao {

    public Buyer selectBuyer(String nickname);

    User selectUser(long id);



}