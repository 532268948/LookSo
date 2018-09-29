package com.zust.lookso.service.Impl;

import com.zust.lookso.dao.CommonOperate;
import com.zust.lookso.dto.CommentDto;
import com.zust.lookso.dto.MessageDto;
import com.zust.lookso.dto.ReviewDto;
import com.zust.lookso.entity.Movie;
import com.zust.lookso.entity.Review;
import com.zust.lookso.entity.User;
import com.zust.lookso.service.ReviewService;
import com.zust.lookso.util.ResponseUtil;
import com.zust.lookso.util.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作 者： ZUST_YTH
 * 日 期： 2018/9/4
 * 时 间： 21:08
 * 项 目： LookSo
 * 描 述：
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    @Qualifier("reviewDao")
    CommonOperate reviewDao;

    private Review review;
    private Movie movie;
    private User user;

    @Override
    public ResponseWrapper getReviewList(Integer id) {
        if (id != null) {
            if (review == null) {
                review = new Review();
            }
            if (movie == null) {
                movie = new Movie();
            }
            movie.setId(id);
            review.setMovie(movie);
            List<CommentDto> list = this.reviewDao.Query(review, 0);
            if (list == null) {
                return ResponseWrapper.markError();
            } else if (list.size() == 0) {
                return ResponseWrapper.markSuccessButNoData();
            } else if (list.size() >= 1) {
                int grade = 0;
                for (int i = 0; i < list.size(); i++) {
                    grade += list.get(i).getScore();
                }
                list.get(0).setGrade((float) grade / (float) (list.size()));
                return ResponseWrapper.markSuccess(list);
            }

        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper getReviewNum(Integer id) {
        if (id != null) {
            if (review == null) {
                review = new Review();
            }
            review.setId(id);
            List<ReviewDto> reviewDtoList = this.reviewDao.Query(review, 2);
            if (reviewDtoList == null) {
                return ResponseWrapper.markError();
            } else if (reviewDtoList.size() == 0) {
                return ResponseWrapper.markSuccessButNoData();
            } else if (reviewDtoList.size() == 1) {
                for (int i = 0; i < reviewDtoList.size(); i++) {
                    reviewDtoList.get(i).setGrade(new Double(String.format("%.1f", reviewDtoList.get(i).getGrade())));
                }
                return ResponseWrapper.markSuccess(reviewDtoList);
            }
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper getUserReviewList(Integer id, Integer page) {
        if (id != null && page != null) {
            if (review == null) {
                review = new Review();
            }
            if (user == null) {
                user = new User();
            }
            user.setId(id);
            review = new Review();
            review.setUser(user);
            return ResponseUtil.checkResponseMore(this.reviewDao.Query(review, 3));
        }
        return ResponseWrapper.markError();
    }

    @Override
    public ResponseWrapper getHotReviewList() {
        return ResponseUtil.checkResponseMore(this.reviewDao.Query(null, 4));
    }

    @Override
    public ResponseWrapper getHotReview(Integer page, Integer type) {
        if (page != null && type != null) {
            if (review == null) {
                review = new Review();
            }
            review.setId(page - 1);
            MessageDto messageDto = new MessageDto();
            List<Review> reviews = null;
            if (type == 0) {
                reviews = this.reviewDao.Query(review, 5);
            }
            if (type == 1) {
                reviews = this.reviewDao.Query(review, 7);
            }
            if (reviews == null) {
                return ResponseWrapper.markError();
            } else if (reviews.size() == 0) {
                return ResponseWrapper.markSuccessButNoData();
            }
            messageDto.setList(reviews);
            List<Long> list = this.reviewDao.Query(null, 6);
            if (list.size() == 1) {
                messageDto.setNum(list.get(0));
            }
            return ResponseWrapper.markSuccess(messageDto);
        }
        return ResponseWrapper.markError();
    }
}
