package com.gretacvld.climb_jam_api.services.stats;

import com.gretacvld.climb_jam_api.entities.Ascent;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AscentsByMonthService {

    public Map<Month, Long> getAscentsByMonth(List<Ascent> ascents) {
        Map<Month, Long> ascentsByMonth = Arrays.stream(Month.values())
                .collect(Collectors.toMap(month -> month, month -> 0L, (a, b) -> b, LinkedHashMap::new));
        ascents.forEach(ascent -> {
            if(ascent.getDate() != null) {
                Month month = ascent.getDate().getMonth();
                ascentsByMonth.put(month, ascentsByMonth.get(month) + 1);
            }
        });
        return ascentsByMonth;
    }
}