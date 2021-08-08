package ru.renessans.autotests.selenium.framework.yashkin.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *  КЛАСС ПОЛУЧЕНИЯ ДАННЫХ ВРЕМЕНИ
 */

public class Time {

    public static String beginStepTime;

        public static String getCurrentTime(){
            LocalDateTime dateTimeNow = LocalDateTime.now();
            String currentTime = dateTimeNow.format(DateTimeFormatter
                            .ofPattern("d MM uuuu HH:mm:ss.SSS"));
            return currentTime;
        }

        public static void setBeginStepTime(){
            beginStepTime = getCurrentTime();
        }

        public static String getBeginStepTime(){
            return beginStepTime;
        }

    }








