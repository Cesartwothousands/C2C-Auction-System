package controller;

import model.QuestionItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class QuestionDao extends Dao {

    public List<QuestionItem> getAll() {
        Connection con = getConnection();
        String sql = "SELECT * FROM mydb.question;";
        List<QuestionItem> questionItems = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                Integer idquestion = rs.getInt("idquestion");
                Integer idUser = rs.getInt("idUser");
                String username = getUserName(idUser);
                String questionTitle = rs.getString("questiontitle");
                String question = rs.getString("question");
                String answerTitle = rs.getString("answertitle");
                String answer = rs.getString("answer");

                QuestionItem questionItem = new QuestionItem(idquestion, username, questionTitle, question, answerTitle,
                        answer);
                questionItems.add(questionItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questionItems;
    }

    public List<QuestionItem> get(String query) {
        Connection con = getConnection();
        String sql = "SELECT * FROM mydb.question WHERE MATCH(questiontitle, question, answertitle, answer) AGAINST(? IN BOOLEAN MODE);";
        List<QuestionItem> questionItems = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, query);
            ResultSet rs = ps.executeQuery();

            while (rs != null && rs.next()) {
                Integer idquestion = rs.getInt("idquestion");
                Integer idUser = rs.getInt("idUser");
                String username = getUserName(idUser);
                String questionTitle = rs.getString("questiontitle");
                String question = rs.getString("question");
                String answerTitle = rs.getString("answertitle");
                String answer = rs.getString("answer");

                QuestionItem questionItem = new QuestionItem(idquestion, username, questionTitle, question, answerTitle,
                        answer);
                questionItems.add(questionItem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questionItems;
    }

    public String getUserName(Integer idUser) {
        String sql = "SELECT name FROM mydb.end_user WHERE idUser = ?";
        String username = "";

        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                username = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return username;
    }

    public void insertQuestion(String questionTitle, String question, Integer idUser) {
        String sql = "INSERT INTO mydb.question (questiontitle, question, idUser) VALUES (?, ?, ?);";

        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, questionTitle);
            ps.setString(2, question);
            ps.setInt(3, idUser);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertAnswer(Integer idquestion, String answerTitle, String answer) {
        String sql = "UPDATE mydb.question SET answertitle = ?, answer = ? WHERE idquestion = ?;";

        try (Connection con = getConnection();
                PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, answerTitle);
            ps.setString(2, answer);
            ps.setInt(3, idquestion);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
