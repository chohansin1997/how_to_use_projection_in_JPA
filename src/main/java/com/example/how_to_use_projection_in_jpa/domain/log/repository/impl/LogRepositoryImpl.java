package com.example.how_to_use_projection_in_jpa.domain.log.repository.impl;

import com.example.how_to_use_projection_in_jpa.domain.board.dto.response.BoardStatisticsResponse;
import com.example.how_to_use_projection_in_jpa.domain.board.dto.response.QBoardStatisticsResponse;
import com.example.how_to_use_projection_in_jpa.domain.log.entity.QLog;
import com.example.how_to_use_projection_in_jpa.domain.log.repository.LogRepositoryCustom;
import com.querydsl.core.Tuple;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.how_to_use_projection_in_jpa.domain.board.entity.QBoard.board;
import static com.example.how_to_use_projection_in_jpa.domain.log.entity.QLog.log;

@RequiredArgsConstructor
public class LogRepositoryImpl implements LogRepositoryCustom {

	private final JPAQueryFactory queryFactory;

	@Override
	public List<BoardStatisticsResponse> viewsCountByNational(LocalDateTime start, LocalDateTime end) {

		List<BoardStatisticsResponse> result = queryFactory
				.select(
						new QBoardStatisticsResponse(JPAExpressions.select(board.title).from(board).where(board.id.eq(log.board.id)),
								log.id.count(),
								log.accessNational)
				)
				.from(log)
				.where(log.createDt.between(start, end))
				.groupBy(log.accessNational)
				.fetch();


		/*서브쿼리 */

		//select
		//count(l.id)  , access_national,(select title from TB_BOARD b where b.id = l.board_id )
		// from tb_log l
		//where create_dt >20200101 and create_dt <20210706
		//group by access_national ;

		List<BoardStatisticsResponse> fetch = queryFactory.select(new QBoardStatisticsResponse(board.title, log.id.count(), log.accessNational))
				.from(board)
				.innerJoin(board.logs, log)
				.where(log.createDt.between(start, end))
				.groupBy(log.accessNational).fetch();

		return fetch;


		/*join*/

		//select
		//b.title, l.access_national, count(l.id)
		//from
		//tb_log l
		//inner join
		//TB_board b on b.id = l.board_id
		//where l.create_dt > 20200101 and l.create_dt <20200707
		//GROUP BY  l.access_national;


	}
}
