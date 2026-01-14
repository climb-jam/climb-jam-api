package com.gretacvld.climb_jam_api.mappers;

import com.gretacvld.climb_jam_api.dtos.SessionDTO;
import com.gretacvld.climb_jam_api.entities.Session;

public class SessionMapper {

    // Entity Session ==> SessionDTO
    public static SessionDTO toDTO(Session session) {
        if (session == null) return null;
        return new SessionDTO(
                session.getId(),
                UserMapper.toDTO(session.getUser()),
                CragMapper.toDTO(session.getCrag()),
                session.getDate()
        );
    }

    // SessionDTO ==> Entity Session
    public static Session toEntity(SessionDTO dto) {
        if (dto == null) return null;
        Session session = new Session();
        session.setId(dto.getId());
        session.setUser(UserMapper.toEntity(dto.getUser()));
        session.setCrag(CragMapper.toEntity(dto.getCrag()));
        session.setDate(dto.getDate());
        return session;
    }
}