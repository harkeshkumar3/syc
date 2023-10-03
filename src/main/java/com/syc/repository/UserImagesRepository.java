package com.syc.repository;

import com.syc.model.User;
import com.syc.model.UserImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserImagesRepository extends JpaRepository<UserImages, Long> {

    List<UserImages> findByUserId(long id);
}
