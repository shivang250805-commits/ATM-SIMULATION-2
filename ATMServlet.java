package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import model.BankAccount;

public class ATMServlet extends HttpServlet {
    private BankAccount account;

    @Override
    public void init() throws ServletException {
        account = new BankAccount("Shivang", "1234", 1000.0);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("login".equals(action)) {
            String pin = req.getParameter("pin");
            if (account.validatePin(pin)) {
                req.getSession().setAttribute("account", account);
                resp.sendRedirect("home.jsp");
            } else {
                resp.sendRedirect("index.html?error=1");
            }

        } else if ("deposit".equals(action)) {
            double amt = Double.parseDouble(req.getParameter("amount"));
            account.deposit(amt);
            resp.sendRedirect("home.jsp");

        } else if ("withdraw".equals(action)) {
            double amt = Double.parseDouble(req.getParameter("amount"));
            if (!account.withdraw(amt)) {
                resp.sendRedirect("home.jsp?error=balance");
                return;
            }
            resp.sendRedirect("home.jsp");
        }
    }
}
