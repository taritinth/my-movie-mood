/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sop.chapter7.productservice.core.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewCreatedEvent {
//    private String _Id;
    private String id;
    private String movieId;
    private Double rating;
    private String review;
    private String reviewBy;
}
