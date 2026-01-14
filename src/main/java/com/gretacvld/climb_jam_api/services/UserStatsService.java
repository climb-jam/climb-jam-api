package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.UserStatsDTO;
import com.gretacvld.climb_jam_api.entities.Ascent;
import com.gretacvld.climb_jam_api.entities.Session;
import com.gretacvld.climb_jam_api.repositories.AscentRepository;
import com.gretacvld.climb_jam_api.repositories.SessionRepository;
import com.gretacvld.climb_jam_api.services.stats.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.*;

@Service
public class UserStatsService {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private AscentRepository ascentRepository;

    @Autowired
    private AscentsByClimbingTypeService ascentsByClimbingTypeService;
    @Autowired
    private AscentsByGradeService ascentsByGradeService;
    @Autowired
    private AscentsByMonthService ascentsByMonthService;
    @Autowired
    private AscentsByYearService ascentsByYearService;
    @Autowired
    private ProgressionByYearService progressionByYearService;

    public UserStatsDTO getUserStats(Long userId) {

        List<Session> sessions = sessionRepository.findByUserId(userId);
        List<Ascent> ascents = ascentRepository.findByUserIdOrderByDateDesc(userId);

        long totalSessions = sessionRepository.countByUserId(userId);
        long totalAscents = ascentRepository.countByUserId(userId);

        int totalMetersClimbed = ascents.stream()
                .filter(ascent -> ascent.getRoute() != null && ascent.getRoute().getHeight() != null)
                .mapToInt(ascent -> ascent.getRoute().getHeight())
                .sum();

        Map<String, Long> ascentsByClimbingType = ascentsByClimbingTypeService.getAscentsByClimbingType(ascents);
        Map<String, Long> ascentsByGrade = ascentsByGradeService.getAscentsByGrade(ascents);
        Map<Month, Long> ascentsByMonth = ascentsByMonthService.getAscentsByMonth(ascents);
        Map<Integer, Long> ascentsByYear = ascentsByYearService.getAscentsByYear(ascents);
        Map<Integer, Map<String, String>> progressionByYear = progressionByYearService.getProgressionByYear(ascents);

        UserStatsDTO dto = new UserStatsDTO();
        dto.setTotalSessions(totalSessions);
        dto.setTotalAscents(totalAscents);
        dto.setTotalMetersClimbed(totalMetersClimbed);
        dto.setAscentsByClimbingType(ascentsByClimbingType);
        dto.setAscentsByGrade(ascentsByGrade);
        dto.setAscentsByMonth(ascentsByMonth);
        dto.setAscentsByYear(ascentsByYear);
        dto.setProgressionByYear(progressionByYear);

        return dto;
    }
}