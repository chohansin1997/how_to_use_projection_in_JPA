package com.example.how_to_use_projection_in_jpa.domain.board.service;

import com.example.how_to_use_projection_in_jpa.domain.board.entity.Board;
import com.example.how_to_use_projection_in_jpa.domain.board.repository.BoardRepository;
import com.example.how_to_use_projection_in_jpa.domain.log.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;

	public Long create(Board board) {
		return boardRepository.save(board).getId();
	}

	public Board get(Long id) {
		return boardRepository.findById(id).orElseThrow(EntityNotFoundException::new);
	}
}
