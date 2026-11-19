<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Servlet and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    <h1>Your cart</h1>
    <table>
        <tr>
            <th>Quantity</th>
            <th>Description</th>
            <th>Price</th>
            <th>Amount</th>
            <th></th>
        </tr>
        <c:forEach items="${sessionScope.cart.items}" var="item">
            <tr>
                <td>
                    <form action="cart" method="post">
                        <input type="hidden" name="productCode" value="${item.product.productCode}">
                        <input type="number" name="quantity" value="${item.quantity}" min="1">
                        <input type="submit" value="Update">
                    </form>
                </td>
                <td><c:out value="${item.product.description}"/></td>
                <td><c:out value="${item.product.priceCurrencyFormat}"/></td>
                <td><c:out value="${item.amountCurrencyFormat}"/></td>
                <td>
                    <form action="cart" method="post">
                        <input type="hidden" name="productCode" value="${item.product.productCode}">
                        <input type="hidden" name="quantity" value="0">
                        <input type="submit" value="Remove Item">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p><b>To change the quantity</b>, enter the new quantity and click on the Update button</p>

    <p><b>Total:</b> <c:out value="${sessionScope.cart.totalCurrencyFormat}"/></p>

    <form action="" method="post">
        <input type="hidden" name="action" value="shop">
        <input type="submit" value="Continue shopping">
    </form>

    <form action="" method="post">
        <input type="hidden" name="action" value="checkOut">
        <input type="submit" value="Check Out">
    </form>
</body>
</html>