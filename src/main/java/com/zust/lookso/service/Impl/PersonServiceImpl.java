package com.zust.lookso.service.Impl;

import com.zust.lookso.dao.CommonOperate;
import com.zust.lookso.entity.Movie;
import com.zust.lookso.entity.Review;
import com.zust.lookso.entity.User;
import com.zust.lookso.service.PersonService;
import com.zust.lookso.util.ResponseUtil;
import com.zust.lookso.util.ResponseWrapper;
import com.zust.lookso.util.ReturnCode;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/8/28
 * 时 间： 21:36
 * 项 目： LookSo
 * 描 述：
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    @Qualifier("userDao")
    CommonOperate userOperate;

    @Autowired
    @Qualifier("reviewDao")
    CommonOperate reviewDao;

    private User user;

    @Override
    public ResponseWrapper Login(String name, String password) {
        if (name != null && password != null) {
            user = new User();
            user.setName(name);
            user.setPassword(password);
            List list = this.userOperate.Query(user, 5);
            if (list == null) {
                return ResponseWrapper.markError();
            } else if (list.size() == 1) {
                return ResponseWrapper.markCustom(true, ReturnCode.USER_FORBIDDEN.getCode(), ReturnCode.USER_FORBIDDEN.getMsg(), null);
            }
            return ResponseUtil.checkResponseOne(userOperate.Query(user, 0));
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper Register(String name, String password) {
        if (name != null && password != null) {
            user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setHead("/image/head/0/0.jpg");
            user.setNickname("用户"+name);
            List list = userOperate.Add(user);
            if (list == null) {
                return ResponseWrapper.markError();
            } else if (list.size() == 0) {
                return ResponseWrapper.markCustom(false, ReturnCode.REGISTER_FALSE.getCode(),
                        ReturnCode.REGISTER_FALSE.getMsg(), null);
            } else if (list.size() == 1) {
                return ResponseWrapper.markSuccess(list);
            }
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper getUserInformation(Integer id) {
        if (id != null) {
            if (user == null) {
                user = new User();
            }
            user.setId(id);
            return ResponseUtil.checkResponseOne(this.userOperate.Query(user, 1));
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper Review(Integer score, String content, Integer uid, Integer mid) {
        if (score != null && content != null && content.trim() != "" && uid != null) {
            Review review = new Review();
            User user1 = new User();
            user1.setId(uid);
            Movie movie1 = new Movie();
            movie1.setId(mid);
            review.setUser(user1);
            review.setMovie(movie1);
            review.setContent(content);
            review.setScore(score);
            DateFormat dateTimeformat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String strBeginDate = dateTimeformat.format(new Date());
            review.setTime(strBeginDate);
            return ResponseUtil.checkResponseOne(this.reviewDao.Query(review, 9));
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper updateUserInformation(Integer id, String nickname, Integer sex, String desc) {
        if (id != null && nickname != null && sex != null && desc != null) {
            if (user == null) {
                user = new User();
            }
            user.setId(id);
            user.setNickname(nickname);
            user.setSex(sex);
            user.setDescription(desc);
            return ResponseUtil.checkResponseOne(this.userOperate.Query(user, 6));
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper updateUserHead(HttpServletRequest request, Integer id) {
        if (request != null && id != null) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload fileUpload = new ServletFileUpload(factory);
            fileUpload.setFileSizeMax(1024 * 1024 * 4);
            fileUpload.setSizeMax(1024 * 1024 * 40);
            try {
                List<FileItem> fileItems = fileUpload.parseRequest(request);
                for (FileItem fileItem : fileItems) {
                    if (fileItem.isFormField()) {

                    } else {
                        long size = fileItem.getSize();
                        if (size == 0) {
                            continue;
                        }

                        String address = "E:/project/Image/head/" + id;
                        File file = new File(address);
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                        String name = id + ".jpg";
                        fileItem.write(new File(address + "/" + name));
                        if (user == null) {
                            user = new User();
                        }
                        user.setId(id);
                        user.setHead("/image/head/" + id + "/" + name);
                        return ResponseUtil.checkResponseOne(this.userOperate.Query(user, 7));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseWrapper.markError();
            }
        }
        return ResponseWrapper.markError();
    }
}
