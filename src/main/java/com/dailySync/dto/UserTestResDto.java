package com.dailySync.dto;

import com.dailySync.entities.UserTest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor  //기본 생성자 생성
@AllArgsConstructor //모든 필드값을 매개변수로 받는 생성자를 생성
public class UserTestResDto {

    private Long id;
    private String userName;
    private String name;
    private String gender;

    public static UserTestResDto nullUser(){
        return new UserTestResDto();
    }



    public static UserTestResDto of(UserTest user){
        if(user==null){
            return new UserTestResDto();
        }
        //UserResDto 객체 생성
        UserTestResDto userResDto = new UserTestResDto();
        //UserResDto 생성한 객체에 매개변수로 받은 User 객체에 있던 userName 정보를 입력.
        userResDto.setId(user.getId());
        userResDto.setUserName(user.getUserName());
        userResDto.setName(user.getName());
        userResDto.setGender(user.getGender());
        //UserResDto 객체 리턴.
        return userResDto;
    }
}