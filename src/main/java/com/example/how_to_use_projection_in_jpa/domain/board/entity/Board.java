package com.example.how_to_use_projection_in_jpa.domain.board.entity;

import com.example.how_to_use_projection_in_jpa.domain.log.entity.Log;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Table(name = "TB_BOARD")
@Getter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor(access = PROTECTED)
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	@ColumnDefault("CURRENT_TIMESTAMP")
	private LocalDateTime createDt;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "board")
	List<Log> logs;

	private Board(String title) {
		this.title = title;
	}

	public static Board createBoard(String title) {
		return new Board(title);
	}
}
