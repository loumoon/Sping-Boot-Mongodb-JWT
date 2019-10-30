package cn.edu.sjtu.industry_backend.controller;

import cn.edu.sjtu.industry_backend.authority.annotation.MaintainerToken;
import cn.edu.sjtu.industry_backend.authority.annotation.ManagerToken;
import cn.edu.sjtu.industry_backend.authority.annotation.PassToken;
import cn.edu.sjtu.industry_backend.authority.util.JWTUtil;
import cn.edu.sjtu.industry_backend.dto.SignInDTO;
import cn.edu.sjtu.industry_backend.dto.TokenDTO;
import cn.edu.sjtu.industry_backend.dto.UserDTO;
import cn.edu.sjtu.industry_backend.model.Result;
import cn.edu.sjtu.industry_backend.model.User;
import cn.edu.sjtu.industry_backend.service.UserService;
import cn.edu.sjtu.industry_backend.util.ResultUtil;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private Mapper mapper;

    @PassToken
    @RequestMapping(value = "/user/signIn", method = RequestMethod.POST)
    public Result signIn(@RequestBody SignInDTO signInDTO) {

        String userId = signInDTO.getUserId();
        String password = signInDTO.getPassword();
        String token = userService.signIn(userId, password);
        TokenDTO tokenDTO = TokenDTO.builder().token(token).build();

        return ResultUtil.success(tokenDTO);
    }

    @PassToken
    @RequestMapping(value = "/user/signUp", method = RequestMethod.POST)
    public Result signUp(@RequestBody UserDTO userDTO) {
        User user = mapper.map(userDTO, User.class);
        userService.signUp(user);
        return ResultUtil.success();
    }


    /*测试，只有运维人员和管理人员有权限访问的服务*/
    @MaintainerToken
    @ManagerToken
    @RequestMapping(value = "/user/test", method = RequestMethod.GET)
    public Result test(@RequestHeader("token") String token) {
        String userId = JWTUtil.decodeUserId(token);
        User user = userService.findUserById(userId);
        UserDTO userDTO = mapper.map(user, UserDTO.class);
        return ResultUtil.success(userDTO);
    }

}
