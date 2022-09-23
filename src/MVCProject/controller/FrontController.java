package MVCProject.controller;

import MVCProject.model.Action;
import MVCProject.model.ActionFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FrontController extends HttpServlet {

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            ActionFactory actionFactory = ActionFactory.actionFactory();
            Action action = actionFactory.getAction(req);
            String page = action.process(req);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(page);
            requestDispatcher.forward(req, resp);
        } catch (RuntimeException e) {
            //resp.sendError(HttpServletResponse.SC_REQUEST_TIMEOUT, e.getMessage());
            req.setAttribute("ServletName", getServletName());
            RequestDispatcher requestDispacther = req.getRequestDispatcher("error.jsp");
            requestDispacther.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public String getServletInfo() {
        return "This servlet ( " + getServletName() + " ) is used to detect the action name and forward the request and response to proper class in MVCProject.MVCProject.model";

    }
}
