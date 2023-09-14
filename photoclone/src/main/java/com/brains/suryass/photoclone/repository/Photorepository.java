package com.brains.suryass.photoclone.repository;

import com.brains.suryass.photoclone.model.Photo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Photorepository extends CrudRepository<Photo,Integer> {



}
