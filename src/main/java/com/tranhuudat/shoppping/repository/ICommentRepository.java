package com.tranhuudat.shoppping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tranhuudat.shoppping.model.CommentModel;

public interface ICommentRepository extends JpaRepository<CommentModel,Long>{

}
