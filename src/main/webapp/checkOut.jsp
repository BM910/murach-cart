<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Servlet and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    <h1>Check out</h1>
    <table>
        <tr>
            <th>Quantity</th>
            <th>Description</th>
            <th>Price</th>
            <th>Amount</th>
        </tr>
        <c:forEach items="${sessionScope.cart.items}" var="item">
            <tr>
                <td><c:out value="${item.quantity}"/></td>
                <td><c:out value="${item.product.description}"/></td>
                <td><c:out value="${item.product.priceCurrencyFormat}"/></td>
                <td><c:out value="${item.amountCurrencyFormat}"/></td>
            </tr>
        </c:forEach>
    </table>

    <p><b>Total:</b> <c:out value="${sessionScope.cart.totalCurrencyFormat}"/></p>

    <form action="" method="get">
        <input type="hidden" name="action" value="shop">
        <input type="submit" value="Back to shop">
    </form>
</body>
</html>