package com.example.how_to_use_projection_in_jpa.Service;

import com.example.how_to_use_projection_in_jpa.domain.board.dto.request.CreateBoardRequest;
import com.example.how_to_use_projection_in_jpa.domain.board.service.BoardService;
import com.example.how_to_use_projection_in_jpa.domain.log.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

	private final BoardService boardService;

	private final LogService logService;


}
