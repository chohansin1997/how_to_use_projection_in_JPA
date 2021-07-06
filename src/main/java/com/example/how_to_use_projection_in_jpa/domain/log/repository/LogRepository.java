package com.example.how_to_use_projection_in_jpa.domain.log.repository;

import com.example.how_to_use_projection_in_jpa.domain.board.entity.Board;
import com.example.how_to_use_projection_in_jpa.domain.log.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Long>, LogRepositoryCustom {
}
