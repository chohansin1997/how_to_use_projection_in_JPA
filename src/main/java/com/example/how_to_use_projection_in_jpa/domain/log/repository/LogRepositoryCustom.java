package com.example.how_to_use_projection_in_jpa.domain.log.repository;

import com.example.how_to_use_projection_in_jpa.domain.board.dto.response.BoardStatisticsResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface LogRepositoryCustom {

	List<BoardStatisticsResponse> viewsCountByNational(LocalDateTime start, LocalDateTime end);
}
