<%@ page import="model.BankAccount" %>
<%@ page import="util.Transaction" %>
<%
    BankAccount acc = (BankAccount) session.getAttribute("account");
    if (acc == null) {
        response.sendRedirect("index.html");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
  <title>ATM Home</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
<div class="atm-container">
  <h2>Welcome, <%= acc.getUserName() %></h2>
  <p>Current Balance: ₹<%= acc.getBalance() %></p>

  <form action="ATMServlet" method="post">
    <input type="hidden" name="action" value="deposit">
    <input type="number" name="amount" placeholder="Deposit Amount" required>
    <button type="submit">Deposit</button>
  </form>

  <form action="ATMServlet" method="post">
    <input type="hidden" name="action" value="withdraw">
    <input type="number" name="amount" placeholder="Withdraw Amount" required>
    <button type="submit">Withdraw</button>
  </form>

  <h3>Transaction History</h3>
  <table border="1">
    <tr><th>Type</th><th>Amount</th><th>Date</th></tr>
    <% for (Transaction t : acc.getTransactions()) { %>
      <tr>
        <td><%= t.getType() %></td>
        <td>₹<%= t.getAmount() %></td>
        <td><%= t.getDate() %></td>
      </tr>
    <% } %>
  </table>
</div>
</body>
</html>
