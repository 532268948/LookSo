package com.zust.lookso.service.Impl;

import com.zust.lookso.dao.CommonOperate;
import com.zust.lookso.dto.MessageDto;
import com.zust.lookso.entity.Movie;
import com.zust.lookso.entity.Review;
import com.zust.lookso.entity.User;
import com.zust.lookso.service.ManagerService;
import com.zust.lookso.util.ResponseUtil;
import com.zust.lookso.util.ResponseWrapper;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/10
 * 时 间： 11:11
 * 项 目： LookSo
 * 描 述：
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    @Qualifier("userDao")
    CommonOperate userDao;

    @Autowired
    @Qualifier("movieDao")
    CommonOperate movieDao;

    @Autowired
    @Qualifier("reviewDao")
    CommonOperate reviewDao;

    private User user;
    private Movie movie;
    private Review review;

    @Override
    public ResponseWrapper getAllUser() {
        return ResponseUtil.checkResponseMore(this.userDao.Query(null, 2));
    }

    @Override
    public ResponseWrapper forbiddenUser(Integer id) {
        if (id != null) {
            if (user == null) {
                user = new User();
            }
            user.setId(id);
            return ResponseUtil.checkResponseOne(this.userDao.Query(user, 3));
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper recoverUser(Integer id) {
        if (id != null) {
            if (user == null) {
                user = new User();
            }
            user.setId(id);
            return ResponseUtil.checkResponseOne(this.userDao.Query(user, 4));
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper getAllMovie(Integer page) {
        if (page != null) {
            if (movie == null) {
                movie = new Movie();
            }
            movie.setId(page - 1);
            List list = this.movieDao.Query(movie, 8);
            if (list == null) {
                return ResponseWrapper.markError();
            } else if (list.size() == 0) {
                return ResponseWrapper.markSuccessButNoData();
            } else {
                if (movie == null) {
                    movie = new Movie();
                }
                movie.setName("");
                List list1 = this.movieDao.Query(movie, 11);
                if (list1 == null) {
                    return ResponseWrapper.markError();
                } else if (list1.size() == 0) {
                    return ResponseWrapper.markSuccessButNoData();
                } else {
                    MessageDto messageDto = new MessageDto();
                    messageDto.setList(list);
                    messageDto.setNum((long) list1.get(0));
                    return ResponseWrapper.markSuccess(messageDto);
                }
            }

        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper forbiddenMovie(Integer id) {
        if (id != null) {
            if (movie == null) {
                movie = new Movie();
            }
            movie.setId(id);
            return ResponseUtil.checkResponseOne(this.movieDao.Query(movie, 9));
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper recoverMovie(Integer id) {
        if (id != null) {
            if (movie == null) {
                movie = new Movie();
            }
            movie.setId(id);
            return ResponseUtil.checkResponseOne(this.movieDao.Query(movie, 10));
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper uploadNewMovie(HttpServletRequest request, Movie movie) {
        if (request != null && movie != null) {
            List<Movie> list = this.movieDao.Query(movie, 12);

            if (list == null) {
                return ResponseWrapper.markError();
            } else if (list.size() == 0) {
                return ResponseWrapper.markSuccessButNoData();
            } else if (list.size() == 1) {
                this.movie = list.get(0);
                DiskFileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload fileUpload = new ServletFileUpload(factory);
                fileUpload.setFileSizeMax(1024 * 1024 * 4);
                fileUpload.setSizeMax(1024 * 1024 * 40);
                try {
                    List<FileItem> fileItems = fileUpload.parseRequest(request);
                    System.out.println(fileItems.size());
                    for (FileItem fileItem : fileItems) {
                        if (fileItem.isFormField()) {

                        } else {
                            long size = fileItem.getSize();
                            if (size == 0) {
                                continue;
                            }
                            String fieldName = fileItem.getFieldName();
                            System.out.println(fieldName);
                            if (fieldName.equals("cover")) {
                                String address = "E:/project/Image/movie/cover";
                                File file = new File(address);
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                String name = this.movie.getId() + ".jpg";
                                fileItem.write(new File(address + "/" + name));
                                movie.setCover("/image/movie/cover/" + name);
                            } else if (fieldName.equals("slider")) {
                                String address = "E:/project/Image/movie/slider";
                                File file = new File(address);
                                if (!file.exists()) {
                                    file.mkdirs();
                                }
                                String name = this.movie.getId() + ".jpg";
                                fileItem.write(new File(address + "/" + name));
                                movie.setSlider("/image/movie/slider/" + name);
                            }
                            return ResponseUtil.checkResponseOne(this.movieDao.Query(movie, 13));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return ResponseWrapper.markError();
                }
            }

        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper deleteReview(Integer id) {
        if (id != null) {
            if (review == null) {
                review = new Review();
            }
            System.out.println(id);
            review.setId(id);
            List list = reviewDao.Query(review, 10);
            if (list == null) {
                return ResponseWrapper.markError();
            } else if (list.size() == 0) {
                return ResponseWrapper.markSuccessButNoData();
            }
        }
        return ResponseWrapper.markError();
    }
}
