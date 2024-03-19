package com.adamaik.law.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Adamaik
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    private String title;
    private Integer authorId;
    private String path;
}
