package com.gretacvld.climb_jam_api.services;

import com.gretacvld.climb_jam_api.dtos.UserStatsDTO;
import com.gretacvld.climb_jam_api.entities.Ascent;
import com.gretacvld.climb_jam_api.entities.Session;
import com.gretacvld.climb_jam_api.enums.ClimbingType;
import com.gretacvld.climb_jam_api.repositories.AscentRepository;
import com.gretacvld.climb_jam_api.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserStatsService {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private AscentRepository ascentRepository;

    public UserStatsDTO getUserStats(Long userId) {

        List<Session> sessions = sessionRepository.findByUserId(userId);
        List<Ascent> ascents = ascentRepository.findByUserId(userId);

        long totalSessions = sessionRepository.countByUserId(userId);
        long totalAscents = ascentRepository.countByUserId(userId);

        int totalMetersClimbed = ascents.stream()
                .filter(ascent -> ascent.getRoute() != null && ascent.getRoute().getHeight() != null)
                .mapToInt(ascent -> ascent.getRoute().getHeight())
                .sum();

        // Ascents by Route Climbing Type
        Map<String, Long> ascentsByClimbingType = ascents.stream()
                .filter(ascent -> ascent.getRoute() != null && ascent.getRoute().getClimbingTypes() != null)
                .flatMap(ascent -> ascent.getRoute().getClimbingTypes().stream())
                .collect(Collectors.groupingBy(
                        ClimbingType::name,
                        Collectors.counting()
                ));

        // Ascents by Route Grade
        Map<String, Long> ascentsByGrade = ascents.stream()
                .filter(ascent -> ascent.getRoute() != null && ascent.getRoute().getGrade() !=null)
                .collect(Collectors.groupingBy(
                        ascent -> ascent.getRoute().getGrade(),
                        Collectors.counting()
                ));

//        Map<Integer, Map<String, String>> progressionByYear;
//        Map<Month, Long> ascentsByMonth;
//        Map<Integer, Long> ascentsByYear;
//        String maxGradeClimbed;

        UserStatsDTO dto = new UserStatsDTO();
        dto.setTotalSessions(totalSessions);
        dto.setTotalAscents(totalAscents);
        dto.setTotalMetersClimbed(totalMetersClimbed);
        dto.setAscentsByClimbingType(ascentsByClimbingType);
        dto.setAscentsByGrade(ascentsByGrade);

        return dto;
    }
}