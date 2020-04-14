package com.lms.cblog.dao;

import com.lms.cblog.po.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson,Long> {

    Lesson findByLessonId(Long id);
}
