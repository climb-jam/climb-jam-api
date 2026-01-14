package com.gretacvld.climb_jam_api.services.stats;

import com.gretacvld.climb_jam_api.entities.Ascent;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class AscentsByYearService {

    public Map<Integer, Long> getAscentsByYear(List<Ascent> ascents) {
        Map<Integer, Long> ascentsByYear = new TreeMap<>();
        ascents.forEach(ascent -> {
            if(ascent.getDate() != null) {
                int year = ascent.getDate().getYear();
                ascentsByYear.put(year, ascentsByYear.getOrDefault(year, 0L) + 1);
            }
        });
        return ascentsByYear;
    }
}