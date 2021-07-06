package com.example.how_to_use_projection_in_jpa.controller;

import com.example.how_to_use_projection_in_jpa.domain.board.dto.response.BoardStatisticsResponse;
import com.example.how_to_use_projection_in_jpa.domain.log.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {

	private final LogService logService;

	@GetMapping(value = "/")
	public String test() {
		LocalDateTime start = LocalDateTime.of(2020, 1, 1, 00, 00);
		LocalDateTime end = LocalDateTime.of(2021, 1, 1, 00, 00);

		List<BoardStatisticsResponse> responses = logService.viewsCountByNational(start, end);
		return "test";
	}
}
