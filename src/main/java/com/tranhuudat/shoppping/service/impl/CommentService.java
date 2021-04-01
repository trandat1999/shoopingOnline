package com.tranhuudat.shoppping.service.impl;

import com.tranhuudat.shoppping.model.CommentModel;
import com.tranhuudat.shoppping.repository.ICommentRepository;
import com.tranhuudat.shoppping.service.ICommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {

    @Autowired
    private ICommentRepository commentRepo;

    @Override
    public CommentModel add(CommentModel commentModel) {
        return commentRepo.save(commentModel);
    }

    @Override
    public CommentModel update(CommentModel commentModel) {
        return commentRepo.save(commentModel);
    }

    @Override
    public void delete(long id) {
        commentRepo.deleteById(id);
    }

    @Override
    public Page<CommentModel> findAll(int page, int pageSize) {
        Pageable pageable= PageRequest.of(page, pageSize);
        return commentRepo.findAll(pageable);
    }
    
}
