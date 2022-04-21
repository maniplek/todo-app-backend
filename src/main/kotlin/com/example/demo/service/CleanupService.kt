package com.example.demo.service

import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.LocalDateTime

const val EVERY_NIGHT_AT_3 = "0 0 3 * * *"

@Service
@EnableScheduling
class CleanupService(
    private val todoService: TodoService
) {

    @Scheduled(cron = EVERY_NIGHT_AT_3, zone = "Europe/Berlin")
    fun removeCompletedTasks() {
        todoService.removeAllCompleted()
    }

    @Scheduled(fixedDelay = 10_000)
    fun scheduleFixedDelayTask() {
        println("fixed scheduler executed at: ${LocalDateTime.now()}")
    }
}


