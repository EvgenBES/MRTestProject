package com.example.fox.mrtestproject.executors;

import io.reactivex.Scheduler;

public interface PostExecutionThread  {
    Scheduler getScheduler();
}
