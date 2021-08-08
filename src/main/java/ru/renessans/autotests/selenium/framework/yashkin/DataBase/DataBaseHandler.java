package ru.renessans.autotests.selenium.framework.yashkin.DataBase;

import java.sql.*;

/**
 *  КЛАСС ДЛЯ СОЕДИНЕНИЯ С БАЗОЙ ДАННЫХ И ВЫПОЛНЕНИЯ SQL ВЫРАЖЕНИЙ:
 * - ЗАПИСЬ ДАННЫХ ВЫПОЛНЕНИЯ АВТОТЕСТОВ В ТАБЛИЦУ БАЗЫ ДАННЫХ
 * - УДАЛЕНИЕ ТАБЛИЦЫ С ДАННЫМИ АВТОТЕСТОВ ПРОШЛЫХ ПРОГОНОВ
 * - СОЗДАНИЕ НОВОЙ ТАБЛИЦЫ ДЛЯ ЗАПИСИ ДАННЫХ АВТОТЕСТОВ ТЕКУЩЕГО ПРОГОНА
 */

public class DataBaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException{
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        return dbConnection;
    }

// ЗАПИСЬ ДАННЫХ ВЫПОЛНЕНИЯ АВТОТЕСТОВ В ТАБЛИЦУ БАЗЫ ДАННЫХ

    public void signUpTest_Report(String Step_Name,
                                  String Data_and_Time_Step_Begin,
                                  String Data_and_Time_Step_End){

        String insert = "INSERT INTO " + Const.USER_TABLE + " (" +
                Const.STEP_NAME + " , " +
                Const.DATA_AND_TIME_STEP_BEGIN + " , " +
                Const.DATA_AND_TIME_STEP_END + ")" +
                " VALUES(?,?,?)";

        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, Step_Name);
            prSt.setString(2, Data_and_Time_Step_Begin);
            prSt.setString(3, Data_and_Time_Step_End);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

// УДАЛЕНИЕ ТАБЛИЦЫ С ДАННЫМИ АВТОТЕСТОВ ПРОШЛЫХ ПРОГОНОВ

    public void dropOldTableReport(){

        String dropTable = "DROP TABLE " + Const.USER_TABLE;

        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(dropTable);
            prSt.executeUpdate();
        } catch (SQLException e) {
         // e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

// СОЗДАНИЕ НОВОЙ ТАБЛИЦЫ ДЛЯ ЗАПИСИ ДАННЫХ АВТОТЕСТОВ ТЕКУЩЕГО ПРОГОНА

    public void createNewTableReport(){
        String createTable = "CREATE TABLE " + Const.USER_TABLE + " ( " +
        Const.IDTEST_REPORT + " INT NOT NULL AUTO_INCREMENT," +
        Const.STEP_NAME + " VARCHAR(100) NULL," +
        Const.DATA_AND_TIME_STEP_BEGIN + " VARCHAR(100) NULL," +
        Const.DATA_AND_TIME_STEP_END + " VARCHAR(100) NULL," +
        "PRIMARY KEY (" + Const.IDTEST_REPORT + "));";

        System.out.println(createTable);

        try{
            PreparedStatement prSt = getDbConnection().prepareStatement(createTable);
            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }

}
