package com.example.how_to_use_projection_in_jpa.domain.board.repository;

import com.example.how_to_use_projection_in_jpa.domain.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
