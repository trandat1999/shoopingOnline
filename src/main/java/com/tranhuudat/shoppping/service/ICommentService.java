package com.tranhuudat.shoppping.service;

import com.tranhuudat.shoppping.model.CommentModel;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface ICommentService {
    CommentModel add(CommentModel commentModel);
    CommentModel update(CommentModel commentModel);
    void delete(long id);
    Page<CommentModel> findAll(int page,int pageSize);
}
