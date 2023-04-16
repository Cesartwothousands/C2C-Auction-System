package view;

import controller.AdvancedSearchDao;

import model.Item;
import model.Member;
import model.Property;
import model.Type;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Explore
 */
@WebServlet("/Advanced Search")
public class AdvancedSearch {
}
