package com.example.how_to_use_projection_in_jpa.domain.board.dto.response;

import com.example.how_to_use_projection_in_jpa.domain.log.enumeration.National;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class BoardStatisticsResponse {

	private String title;

	private Number hit;

	private National national;

	@QueryProjection
	public BoardStatisticsResponse(String title, Number hit, National national) {
		this.title = title;
		this.hit = hit;
		this.national = national;
	}

}
