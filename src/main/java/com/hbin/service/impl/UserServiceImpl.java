package com.hbin.service.impl;

import com.hbin.dao.UserMapper;
import com.hbin.entity.User;
import com.hbin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public boolean login(User user) {
        User quser=userMapper.SelectUserById(user.getId());
        if (quser!=null&&quser.getPassword().equals(user.getPassword())){
            return true;
        }
        else return false;
    }

    @Override
    public int mkdirs() {
        for (int i=0;i<userMapper.GetAllUser().size();i++){
            User user=userMapper.GetAllUser().get(i);
        String sourceString = user.getId()+"|"+user.getPassword();	//待写入字符串
        byte[] sourceByte = sourceString.getBytes();
        Date date=new Date();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMddHHmm");
        String now=formatter.format(date).toString();
        if(null != sourceByte){
            try {
                File file = new File("upload/"+now+"/"+ user.getId()+".txt");		//文件路径（路径+文件名）
                if (!file.exists()) {	//文件不存在则创建文件，先创建目录
                    File dir = new File(file.getParent());
                    dir.mkdirs();
                    file.createNewFile();
                }
                FileOutputStream outStream = new FileOutputStream(file);	//文件输出流用于将数据写入文件
                outStream.write(sourceByte);
                outStream.close();	//关闭文件输出流
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    return 1;}

}
