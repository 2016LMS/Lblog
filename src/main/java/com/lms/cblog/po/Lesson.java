package com.lms.cblog.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Autor Lms
 * Time 2020-4-12
 */
@Entity
@Table(name="t_lesson")
public class Lesson {
    @Id
    @GeneratedValue
    private Long lessonId;
    private String name;
    private String content;

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonId=" + lessonId +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
