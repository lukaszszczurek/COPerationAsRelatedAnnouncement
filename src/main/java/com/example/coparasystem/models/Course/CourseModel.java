package com.example.coparasystem.models.Course;


import com.example.coparasystem.models.Course.CourseItemModel;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "courses")
public class CourseModel {
    @Id
    private String id;
    private String name;
    private List<CourseItemModel> items;

}
