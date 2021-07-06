package com.example.how_to_use_projection_in_jpa;

import com.example.how_to_use_projection_in_jpa.domain.board.entity.Board;
import com.example.how_to_use_projection_in_jpa.domain.board.service.BoardService;
import com.example.how_to_use_projection_in_jpa.domain.log.entity.Log;
import com.example.how_to_use_projection_in_jpa.domain.log.enumeration.National;
import com.example.how_to_use_projection_in_jpa.domain.log.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
@RequiredArgsConstructor
public class DataRunner implements ApplicationRunner {

	private final BoardService boardService;

	private final LogService logService;

	public static List<Long> BoardIdList = new ArrayList<>();

	public static List<Long> logIdList = new ArrayList<>();

	@Override
	public void run(ApplicationArguments args) {
		runData();

	}

	public void runData() {
		for (int i = 0; i < 15; i++) {
			Board board = Board.createBoard("게시판" + i);
			BoardIdList.add(boardService.create(board));
		}

		Random random = new Random();
		long start = LocalDate.of(2020, 1, 1).toEpochDay();
		long end = LocalDate.now().toEpochDay();

		for (int i = 0; i < 1000; i++) {
			long epochDay = ThreadLocalRandom.current().nextLong(start, end);
			LocalDateTime logDate = LocalDate
					.ofEpochDay(epochDay)
					.atTime(LocalTime.of(
							random.nextInt(23),
							random.nextInt(59)
					));

			logIdList.add(logService.create(
					Log.createLog("Board",
							National.values()[random.nextInt(National.values().length)],
							boardService.get(1l),
							logDate
					)
					)
			);
		}
	}

}
