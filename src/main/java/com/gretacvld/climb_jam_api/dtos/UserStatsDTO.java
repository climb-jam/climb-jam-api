package com.gretacvld.climb_jam_api.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Month;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserStatsDTO {

    private long totalSessions;
    private Map<String, Long> ascentsByClimbingType;
    private Map<String, Long> ascentsByGrade;
    private Map<Integer, Map<String, String>> progressionByYear;
    private Map<Month, Long> ascentsByMonth;
    private Map<Integer, Long> ascentsByYear;
    private long totalAscents;
    private int totalMetersClimbed;
    private String maxGradeClimbed;
}