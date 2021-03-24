package com.codecool.database;


import java.sql.*;

public class RadioCharts {

    private final String DB_URL;
    private final String DB_USER;
    private final String DB_PASSWORD;

    public RadioCharts (String DB_URL, String DB_USER, String DB_PASSWORD) {
        this.DB_URL = DB_URL;
        this.DB_USER = DB_USER;
        this.DB_PASSWORD = DB_PASSWORD;
    }

    public String getMostPlayedSong() {
        String mostPlayedSong = "";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "SELECT song FROM music_broadcast WHERE ";
            Statement st = conn.createStatement();
            ResultSet resultSet = st.executeQuery(sql);
            mostPlayedSong += resultSet.getString(1);
            if (mostPlayedSong.equals("")) return "";
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return mostPlayedSong;
    }

    public String getMostActiveArtist() {
        return "";
    }
}
