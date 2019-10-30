package cn.edu.sjtu.industry_backend.service;

import cn.edu.sjtu.industry_backend.exception.model.ServiceException;
import cn.edu.sjtu.industry_backend.model.RespStatus;
import cn.edu.sjtu.industry_backend.model.User;
import cn.edu.sjtu.industry_backend.repository.UserRepository;
import cn.edu.sjtu.industry_backend.authority.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String signIn(String userId, String password) {
        User user = findUserById(userId);
        if(!user.getPassword().equals(password)) {
            throw new ServiceException(RespStatus.WRONG_PASSWORD, this.getClass().getName());
        }
        else {
            String token = JWTUtil.encode(user);
            return token;
        }
    }

    public void signUp(User user) {
        if(userRepository.findUserByUserId(user.getUserId()) != null) {
            throw new ServiceException(RespStatus.EXIST_ACCOUNT, this.getClass().getName());
        }
        userRepository.save(user);
    }

    public User findUserById(String userId) {
        User user = userRepository.findUserByUserId(userId);
        if(user == null) {
            throw new ServiceException(RespStatus.NON_ACCOUNT, this.getClass().getName());
        }
        return user;
    }


}
