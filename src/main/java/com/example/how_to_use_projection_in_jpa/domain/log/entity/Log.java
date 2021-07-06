package com.example.how_to_use_projection_in_jpa.domain.log.entity;

import com.example.how_to_use_projection_in_jpa.domain.board.entity.Board;
import com.example.how_to_use_projection_in_jpa.domain.log.enumeration.National;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "TB_LOG")
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = PROTECTED)
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String category;

	private National accessNational;

	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createDt;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "board_id")
	Board board;

	public Log(String category, National accessNational) {
		this.category = category;
		this.accessNational = accessNational;
	}

	public Log(String category, National accessNational, Board board) {
		this.category = category;
		this.accessNational = accessNational;
		this.board = board;
	}

	public Log(String category, National accessNational, Board board, LocalDateTime createDt) {
		this.category = category;
		this.accessNational = accessNational;
		this.createDt = createDt;
		this.board = board;
	}

	public static Log createLog(String category, National accessNational, Board board) {
		return new Log(category, accessNational, board);
	}

	public static Log createLog(String category, National accessNational, Board board, LocalDateTime createDt) {
		return new Log(category, accessNational, board, createDt);
	}

	public static Log createLog(String category, National accessNational) {
		return new Log(category, accessNational);
	}

	public void updateBoard(Board board) {
		this.board = board;
	}
}
