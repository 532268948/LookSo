package com.zust.lookso.service.Impl;

import com.zust.lookso.dao.CommonOperate;
import com.zust.lookso.dao.SimilarDao;
import com.zust.lookso.dao.SliderDao;
import com.zust.lookso.dao.TopDao;
import com.zust.lookso.dto.MessageDto;
import com.zust.lookso.dto.MovieDto;
import com.zust.lookso.dto.RankingDto;
import com.zust.lookso.entity.Collect;
import com.zust.lookso.entity.Movie;
import com.zust.lookso.entity.Review;
import com.zust.lookso.entity.User;
import com.zust.lookso.service.MovieService;
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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/3
 * 时 间： 20:59
 * 项 目： LookSo
 * 描 述：
 */
@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    @Qualifier("sliderDao")
    SliderDao sliderDao;

    @Autowired
    @Qualifier("similarDao")
    SimilarDao similarDao;

    @Autowired
    @Qualifier("reviewDao")
    CommonOperate reviewDao;

    @Autowired
    @Qualifier("movieDao")
    CommonOperate movieDao;

    @Autowired
    @Qualifier("movieDao")
    TopDao topDao;

    @Autowired
    @Qualifier("collectDao")
    CommonOperate collectDao;

    private Movie movie = new Movie();
    private Review review = new Review();
    private User user;
    private Collect collect;
    private MessageDto messageDto;

    @Override
    public ResponseWrapper getSlider() {
        List list = this.sliderDao.getSlider();
        return ResponseUtil.checkResponseMore(list);
    }

    @Override
    public ResponseWrapper getSimilarMovie() {
        return ResponseUtil.checkResponseMore(this.similarDao.getSimilar());
    }

    @Override
    public ResponseWrapper getTopMovie() {
        return ResponseUtil.checkResponseMore(this.topDao.getTopMovie());
    }

    @Override
    public ResponseWrapper getSearchMovie(String message, Integer page) {
        if (message != null && message.trim() != "" && page != null) {
            List<MovieDto> movieDtoList = new ArrayList<>();
            if (movie == null) {
                movie = new Movie();
            }
            movie.setName(message);
            movie.setId(page - 1);
            List<Movie> list = this.movieDao.Query(movie, 0);
            System.out.println(list.size() + "search movie.size");
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (review == null) {
                        review = new Review();
                    }
                    review.setMovie(list.get(i));
                    List<Review> list1 = this.reviewDao.Query(review, 1);
                    System.out.println(list1.size() + "search review.size");
                    if (list1 != null) {
                        float grade = 0;
                        for (int j = 0; j < list1.size(); j++) {
                            grade += list1.get(j).getScore();
                        }
                        grade = (float) grade / (float) list1.size();
                        try {
                            BigDecimal b = new BigDecimal(grade);
                            grade = b.setScale(1, BigDecimal.ROUND_HALF_UP).floatValue();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.out.println(grade+"search list1 float");
                        movieDtoList.add(new MovieDto(list.get(i), grade));
                    }
                }
                messageDto = new MessageDto(movieDtoList, (long) this.movieDao.Query(movie, 7).get(0));
            }
            return ResponseUtil.checkResponseObject(messageDto);
        }
        if (message.trim().equals("")) {
            return ResponseWrapper.markSuccessButNoData();
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper getSortMovieList(String sort, Integer page) {
        if (sort != null && page != null) {
            List<MovieDto> movieDtoList = new ArrayList<>();
            List<Movie> list;
            if (sort.equals("所有")) {
                if (movie == null) {
                    movie = new Movie();
                }
                movie.setId(page - 1);
                movie.setSort("");
                list = this.movieDao.Query(movie, 2);
            } else {
                if (movie == null) {
                    movie = new Movie();
                }
                movie.setSort(sort);
                list = this.movieDao.Query(movie, 1);
            }
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    if (review == null) {
                        review = new Review();
                    }
                    review.setMovie(list.get(i));
                    List<Review> list1 = this.reviewDao.Query(review, 1);
                    if (list1 != null) {
                        float grade = 0;
                        for (int j = 0; j < list1.size(); j++) {
                            grade += list1.get(j).getScore();
                        }
                        grade = (float) grade / (float) list1.size();
                        movieDtoList.add(new MovieDto(list.get(i), grade));
                    }
                }
                messageDto = new MessageDto(movieDtoList, (long) this.movieDao.Query(movie, 3).get(0));
            }
            return ResponseUtil.checkResponseObject(messageDto);
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper getMovieInformation(Integer id) {
        if (id != null) {
            if (movie == null) {
                movie = new Movie();
            }
            movie.setId(id);
            return ResponseUtil.checkResponseOne(this.movieDao.Query(movie, 4));
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper isCollect(Integer uid, Integer mid) {
        if (uid != null && mid != null) {
            if (collect == null) {
                collect = new Collect();
            }
            if (user == null) {
                user = new User();
            }
            if (movie == null) {
                movie = new Movie();
            }

            user.setId(uid);
            movie.setId(mid);
            collect.setUser(user);
            collect.setMovie(movie);
            return ResponseUtil.checkResponseOne(this.collectDao.Query(collect, 1));
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper getRecommend(String sort) {
        if (sort != null && sort.trim() != "") {
            if (movie == null) {
                movie = new Movie();
            }
            movie.setSort(sort);
            return ResponseUtil.checkResponseMore(this.movieDao.Query(movie, 5));
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper getAllMovieWithGrade(Integer page) {
        if (page != null) {
            if (movie == null) {
                movie = new Movie();
            }
            movie.setId(0);
            List<RankingDto> rankingDtoList = this.reviewDao.Query(null, 8);
            if (rankingDtoList == null) {
                return ResponseWrapper.markError();
            } else if (rankingDtoList.size() == 0) {
                return ResponseWrapper.markSuccessButNoData();
            } else if (rankingDtoList.size() >= 0) {
                for (int i = 0; i < rankingDtoList.size(); i++) {

                    rankingDtoList.get(i).setGrade(new Double(String.format("%.1f", rankingDtoList.get(i).getGrade())));
                }
                return ResponseWrapper.markSuccess(rankingDtoList);
            }
        }
        return ResponseWrapper.markError();
    }


}
