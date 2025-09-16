<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlet and JSP</title>
    <link rel="stylesheet" href="styles/main.css">
</head>
<body>
    <h1>CD list</h1>
    <table>
        <tr>
            <th>Description</th>
            <th class="right">Price</th>
            <th> </th>
        </tr>
        <tr>
            <th>Taylor Swift's Album</th>
            <th>$10.00</th>
            <th>
                <form action="cart" method="post">
                    <input type="hidden" name="productCode" value="ts-album">
                    <input type="submit" value="Add to cart">
                </form><!--<a href="cart?productCode=ts-album">Add to cart</a>-->
                        <!--URL Rewriting-->
            </th>
        </tr>
        <tr>
            <th>LowG Tournaments</th>
            <th>$12.00</th>
            <th>
                <form action="cart" method="post">
                    <input type="hidden" name="productCode" value="lg-album">
                    <input type="submit" value="Add to cart">
                </form>
            </th>
        </tr>
        <tr>
            <th>Super Junior CD Playlist</th>
            <th>$30.15</th>
            <th>
                <form action="cart" method="post">
                    <input type="hidden" name="productCode" value="sj-album">
                    <input type="submit" value="Add to cart">
                </form>
            </th>
        </tr>
        <tr>
            <th>Kimetsu no Yaiba - Infinity Castle (Ticket)</th>
            <th>120.000VND</th>
            <th>
                <form action="cart" method="post">
                    <input type="hidden" name="productCode" value="kny-album">
                    <input type="submit" value="Add to cart">
                </form>
            </th>
        </tr>
    </table>
</body>