package com.ycu.wedding.serviceImp;

import com.ycu.wedding.mapper.UserMapper;
import com.ycu.wedding.pojo.Dir;
import com.ycu.wedding.pojo.User;
import com.ycu.wedding.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static org.apache.tomcat.util.codec.binary.Base64.decodeBase64;

@Service
public class UserServiceImp implements UserService {
    private static final Logger log = LogManager.getLogger(UserServiceImp.class);

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired(required = false)
    private Dir dir;

    /*@Value("${avatar.upLoad-WinDir}")
    private static String winDir;

    @Value("${avatar.upLoad-LinuxDir}")
    private static String linuxDir;*/

    /**
     * 添加用户的方法
     *
     * @param user 用户信息，包括 Base64 格式的头像
     * @throws IOException 文件处理时可能抛出的异常
     */
    @Override
    public int addUser(User user) throws IOException {
        long timestamp1 = System.currentTimeMillis();
        String separator = File.separator;
        // 解码 Base64 图片
//        log.error("\nqqq,avatar:\n"+user.getAvatar());
        byte[] imageBytes = decodeBase64(user.getAvatar());
        long timestampImageBytes = System.currentTimeMillis();
        log.error("qqq,头像解码时长： "+ (timestampImageBytes-timestamp1));
        // 生成图片保存路径 D:\project\wedding\note\avatar
        String imagePath = "";
        String os = System.getProperty("os.name");
        if (os.toLowerCase().contains("windows")) {
            imagePath = dir.getWinDir() + separator + user.getOpenid() + ".jpg";
        } else if (os.toLowerCase().contains("linux")) {
            imagePath = dir.getLinuxDir() + separator + user.getOpenid() + ".jpg";
        }

        // 将解码后的图片字节数组保存为文件
        saveImageToFile(imageBytes, imagePath);
        // 检查文件是否成功保存
        File imageFile = new File(imagePath);
        if (!imageFile.exists()) {
            throw new IOException("头像图片保存失败");
        }
        long timestampImageFile = System.currentTimeMillis();
        log.error("qqq,保存头像文件时长： "+ (timestampImageFile-timestampImageBytes));
        // 将图片路径存入数据库
//        log.error("qqq,imagePath\n" + imagePath);
        user.setAvatar(imagePath);
        // 调用 MyBatis Mapper 插入用户数据到数据库
        int index = userMapper.insertUser(user);
        long timestampMapper = System.currentTimeMillis();
        log.error("qqq,sql执行时长： "+ (timestampMapper-timestampImageFile));
        if (index > 0) {
            long timestamp2 = System.currentTimeMillis();
            log.error("qqq,addUser总时长： "+ (timestamp2-timestamp1));
            return user.getId();  // 返回插入后的 ID
        } else {
            long timestamp2 = System.currentTimeMillis();
            log.error("qqq,addUser总时长： "+ (timestamp2-timestamp1));
            return -1;
//            throw new RuntimeException("用户插入失败，数据库操作未成功");
        }
    }

    /**
     * 解码 Base64 字符串为字节数组
     *
     * @param base64String Base64 格式的字符串
     * @return 解码后的字节数组
     */
    private byte[] decodeBase64(String base64String) {
        return Base64.getDecoder().decode(base64String);
    }

    /**
     * 将图片字节数组保存为文件
     *
     * @param imageBytes 图片字节数组
     * @param imagePath  图片保存路径
     * @throws IOException 文件操作时可能抛出的异常
     */
    private void saveImageToFile(byte[] imageBytes, String imagePath) throws IOException {
        File imageFile = new File(imagePath);
        FileUtils.writeByteArrayToFile(imageFile, imageBytes);
    }
}
