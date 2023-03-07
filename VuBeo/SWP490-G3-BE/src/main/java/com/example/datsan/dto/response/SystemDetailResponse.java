package com.example.datsan.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SystemDetailResponse {
    private Long id;
    private String name;
    private String owner;
    private String ownerPhone;
    private Integer pitchQuantity;
    private List<PitchResponse> pitches;
    private String image;
    private Time hiredStart;
    private Time hiredEnd;
    private String price;
    private Float rate;
    private List<RatingResponse> ratings;
    private String addressDetail;
    private String city;
    private String district;
    private String ward;
    private String description;
    private String distance;
    private Boolean enableRating;
}
