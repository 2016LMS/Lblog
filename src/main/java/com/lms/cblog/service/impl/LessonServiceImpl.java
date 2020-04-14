package com.lms.cblog.service.impl;

import com.lms.cblog.dao.LessonRepository;
import com.lms.cblog.po.Lesson;
import com.lms.cblog.service.LessonService;
import org.springframework.stereotype.Service;

/**
 * Autor Lms
 * Time 2020-4-13
 */
@Service
public class LessonServiceImpl implements LessonService {

    private LessonRepository lessonRepository;

    @Override
    public Lesson getLesson(Long id) {
        return lessonRepository.findByLessonId(id);
    }
}
