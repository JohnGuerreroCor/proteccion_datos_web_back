package com.usco.edu.util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Cron {

	private static final String TIME_ZONE = "America/Bogota";

	// Ejecutar todos los días a las 2:00 AM
	@Scheduled(cron = "0 0 2 * * *", zone = TIME_ZONE)
	public void scheduleTask() {
		try {
			System.out.println("[Tarea diaria]: Ejecutando tarea programada a las 2:00 AM hora Bogotá.");
		} catch (RuntimeException e) {
			System.out.println(e + " error");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
