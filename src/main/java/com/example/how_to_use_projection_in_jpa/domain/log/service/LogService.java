package com.example.how_to_use_projection_in_jpa.domain.log.service;

import com.example.how_to_use_projection_in_jpa.domain.board.dto.response.BoardStatisticsResponse;
import com.example.how_to_use_projection_in_jpa.domain.log.entity.Log;
import com.example.how_to_use_projection_in_jpa.domain.log.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {
	private final LogRepository logRepository;

	public Long create(Log log) {
		return logRepository.save(log).getId();
	}

	public Log get(Long id) {
		return logRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
	public List<BoardStatisticsResponse> viewsCountByNational(LocalDateTime start, LocalDateTime end){
		return logRepository.viewsCountByNational(start,end);
	}
}
