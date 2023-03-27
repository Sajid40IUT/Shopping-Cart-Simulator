<%
    package com.example.demo1;

    import java.io.*;
    import java.sql.*;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.Statement;
    import javax.servlet.http.*;
    import javax.servlet.annotation.*;

    String url="jdbc:mysql://localhost:3306/PCget";
    String username="root";
    String password="Kronos7988";
    String list = "";


    try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection connection = DriverManager.getConnection(url,username,password);
    Statement statement = connection.createStatement();

    ResultSet resultSet = statement.executeQuery("SELECT Name FROM ComputerList");

    while (resultSet.next()){
    list = list + resultSet.getString(1);
    }

    connection.close();
    }
    catch (Exception e) {
    System.out.println(e);
    }
%>