package com.MajkGroup.MajkAPP.DB.Service.serviceAPI;

import com.MajkGroup.MajkAPP.Domain.User;
import org.springframework.lang.Nullable;

import java.util.List;

public interface UserService {
    @Nullable
    User get(int id);

    @Nullable
    List<User> getAll();
    @Nullable
    Integer add(User user);

    @Nullable
    Integer delete(int id);

}
