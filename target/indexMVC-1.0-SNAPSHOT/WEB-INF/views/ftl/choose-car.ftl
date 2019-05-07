<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>YOUR CART</title>

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900|Raleway:400,300,700,900" rel="stylesheet">

    <!-- Bootstrap CSS File -->
    <link href="../../../lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Libraries CSS Files -->
    <link href="../../../lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">

    <link href="../../../css/style.css" rel="stylesheet">

    <script
            src="https://code.jquery.com/jquery-3.3.1.min.js"
            integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
            crossorigin="anonymous"></script>

</head>

<script>
    function getCookie(name) {
        var matches = document.cookie.match(new RegExp(
                "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
        ));

        if (matches) {
            return decodeURIComponent(matches[1]);
        } else {
            return undefined;
        }
    }
</script>

<script>
    function sendProductId(productId) {
        $.ajax({
            type: 'post',
            url: '/products',
            data: {
                productId: productId,
                userId: getCookie('userId')
            }
        }).done(function (data) {
            var contentTableHTML = "";
            // var count = 0;

            for (var i = 0; i < data.length; i++) {

                contentTableHTML += ' <div id="card-car" class="card text-center" *ngFor="let event of eventActivities">';
                contentTableHTML += '<div class="card-header pull-left">';
                contentTableHTML += '<img src="'+ data[i].image +'" alt="Card image cap" height="180" width="270" marg>';
                contentTableHTML += '</div>';
                contentTableHTML += '<div class="card-block">';
                contentTableHTML += '<h4 class="card-title">'+ data[i].title +'</h4>';
                contentTableHTML += ' <p class="card-text text-left">Model: '+ data[i].model +'</p>';
                contentTableHTML += ' <p class="card-text text-left">Number of places: '+ data[i].number_of_places +'</p>';
                contentTableHTML += ' <p class="card-text text-left">Full price: '+ data[i].price +'₽</p>';
                contentTableHTML += '<button class="btn btn-primary" onclick="deleteProductId('+ data[i].id +')">Cancel order</button>';
                contentTableHTML += '</div>';
                contentTableHTML += '</div>';
            }


            var contentTableDiv = document.getElementById("basket");
            contentTableDiv.innerHTML = contentTableHTML;
            //document.getElementById("counter").innerHTML = count;
        }).fail(function () {
            alert("НЕ ОЧ(((")
        });
    }
</script>





<script>
    function sendOrder(productId) {
        $.ajax({
            type: 'post',
            url: '/sendorder',
            data: {
                productId : productId
            }
        }).done(function (data) {
            // var contentTableHTML = "<p>Successfully! Your feedback was added to the main page</p>";
            // var contentTableDiv = document.getElementById("resultFeed");
            // contentTableDiv.innerHTML = contentTableHTML;
        }).fail(function () {
            alert("mdaaaaa(")
        })
    }
</script>

<#--<script>-->
    <#--function button() {-->
        <#--queryProductId(document.getElementById("search").value);-->
        <#--//alert(document.getElementById("search").value);-->
    <#--}-->
<#--</script>-->

<#--<script>-->
    <#--function queryProductId(query) {-->
        <#--$.ajax({-->
            <#--type: 'post',-->
            <#--url: '/search',-->
            <#--data: {-->
                <#--query: query,-->
                <#--userId: getCookie('userId')-->
            <#--}-->
        <#--}).done(function (data) {-->
            <#--var contentTableHTML = "";-->
            <#--var count = 0;-->


            <#--for (var i = 0; i < data.length; i++) {-->

                <#--contentTableHTML += ' <div id="card-car" class="card text-center" *ngFor="let event of eventActivities">';-->
                <#--contentTableHTML += '<div class="card-header pull-left">';-->
                <#--contentTableHTML += '<img src="'+ data[i].image +'" alt="Card image cap" height="180" width="270" marg>';-->
                <#--contentTableHTML += '</div>';-->
                <#--contentTableHTML += '<div class="card-block">';-->
                <#--contentTableHTML += '<h4 class="card-title">'+ data[i].title +'</h4>';-->
                <#--contentTableHTML += ' <p class="card-text text-left">Model: '+ data[i].model +'</p>';-->
                <#--contentTableHTML += ' <p class="card-text text-left">Number of places: '+ data[i].number_of_places +'</p>';-->
                <#--contentTableHTML += ' <p class="card-text text-left">Full price: '+ data[i].price +'₽</p>';-->
                <#--contentTableHTML += '<button class="btn btn-primary" onclick="deleteProductId('+ data[i].id +')">Cancel order</button>';-->
                <#--contentTableHTML += '</div>';-->
                <#--contentTableHTML += '</div>';-->
            <#--}-->


            <#--var contentTableDiv = document.getElementById("products");-->
            <#--contentTableDiv.innerHTML = contentTableHTML;-->
            <#--//document.getElementById("counter").innerHTML = count;-->
        <#--}).fail(function () {-->
            <#--alert("НЕ ОЧ(((")-->
        <#--});-->
    <#--}-->
<#--</script>-->

<script>
    function getUserId() {
        $.ajax({
            type: 'post',
            url: '/insertfeed',
            data: {
                userId: getCookie('userId')
            }
        }).done(function (data) {
        }
    }).fail(function () {
        alert("ny takoe(0(0(")
    });

</script>

<script>
    function showProductId() {
        $.ajax({
            type: 'post',
            url: '/currentorder',
            data: {
                userId: getCookie('userId')
            }
        }).done(function (data) {
            var contentTableHTML = "";

            for (var i = 0; i < data.length; i++) {

                contentTableHTML += ' <div id="card-car" class="card text-center" *ngFor="let event of eventActivities">';
                contentTableHTML += '<div class="card-header pull-left">';
                contentTableHTML += '<img src="'+ data[i].image +'" alt="Card image cap" height="180" width="270" marg>';
                contentTableHTML += '</div>';
                contentTableHTML += '<div class="card-block">';
                contentTableHTML += '<h4 class="card-title" "font-weight-bold">'+ data[i].title +'</h4>';
                contentTableHTML += ' <p class="card-text text-left">Model: '+ data[i].model +'</p>';
                contentTableHTML += ' <p class="card-text text-left">Number of places: '+ data[i].number_of_places +'</p>';
                contentTableHTML += ' <p class="card-text text-left">Full price: '+ data[i].price +'₽</p>';
                contentTableHTML += '<button class="btn btn-primary" onclick="deleteProductId('+ data[i].id +')">Cancel car</button>';
                contentTableHTML += '</div>';
                contentTableHTML += '</div>';
            }


            var contentTableDiv = document.getElementById("basket");
            contentTableDiv.innerHTML = contentTableHTML;
            //document.getElementById("counter").innerHTML = count;
        }).fail(function () {
            alert("badbadbad(")
        });
    }
</script>

<!-- DONE -->
<script>
    function categories() {
        $.ajax({
            type: 'post',
            url: '/categories',
            data: {
                userId: getCookie('userId')
            }
        }).done(function (data) {
            var contentTableHTML = "";

            for (var i = 0; i < data.length; i++) {
                contentTableHTML += '<button id="categoryButton" class="btn btn-primary" onclick="showCategoryId('+ data[i].id +')">'+ data[i].title + '</button>';
            }


            var contentTableDiv = document.getElementById("products");
            contentTableDiv.innerHTML = contentTableHTML;
            //document.getElementById("counter").innerHTML = count;
        }).fail(function () {
            alert("НЕ ОЧ(0(0(")
        });
    }
</script>

<!-- DONE -->
<script>
    function showCategoryId(categoryId) {
        $.ajax({
            type: 'post',
            url: '/categoriesId',
            data: {
                userId: getCookie('userId'),
                categoryId: categoryId
            }
        }).done(function (data) {
            var contentTableHTML = "";
            contentTableHTML += '<div id="catBtn">';
            contentTableHTML += '<button id="categoryButtonBack" class="btn btn-primary" onclick="categories()">Back to categories</button>';
            contentTableHTML += '</div>';

            for (var i = 0; i < data.length; i++) {

                contentTableHTML += ' <div id="card-car" class="card text-center" *ngFor="let event of eventActivities">';
                contentTableHTML += '<div class="card-header pull-left">';
                contentTableHTML += '<img src="'+ data[i].image +'" alt="Card image cap" height="180" width="270" marg>';
                contentTableHTML += '</div>';
                contentTableHTML += '<div class="card-block">';
                contentTableHTML += ' <p class="card-text text-left">Model: '+ data[i].title + ' ' + data[i].model +'</p>';
                contentTableHTML += ' <p class="card-text text-left">Number of places: '+ data[i].numberOfPlaces +'</p>';
                contentTableHTML += ' <p class="card-text text-left">Full price: '+ data[i].price +' $</p>';
                contentTableHTML += '<button id="btn-order" class="btn btn-primary" onclick="sendOrder('+ data[i].id +')">Order car</button>';
                contentTableHTML += '</div>';
                contentTableHTML += '</div>';
            }

            var contentTableDiv = document.getElementById("products");
            contentTableDiv.innerHTML = contentTableHTML;


        }).fail(function () {
            alert("НЕ ОЧ(0(0(")
        });
    }
</script>

<body onload="categories()">
<!-- Fixed navbar -->
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">TEST-DRIVE CLUB</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/feed">HOME</a></li>
                <li><a href="/cars-info">CARS INFO</a></li>
                <li class="active"><a href="shop">CHECKOUT</a></li>
                <li><a href="/signUp">SIGN UP</a></li>
                <li id="logout"><a href="logOut">LOG OUT</a></li>
            </ul>
        </div>

    </div>
</div>

<div id="blue">
    <div class="container">
        <div class="row centered">
            <div class="col-lg-8 col-lg-offset-2">
                <h4>THE FIRST STEP IS TO CHANGE A CAR. COME ON!</h4>
                <p>JUST TAKE A LOOK and CONTACT US IF YOU HAVE SOME QUESTIONS</p>
            </div>
        </div>
    </div>
</div>

<div class="container w">
        <div class="column" >

            <div class="card-block card text-center" *ngFor="let event of eventActivities">
                <h2>CHOOSE CAR FOR TEST-DRIVE: </h2>

            </div>


            <div class="products-list" id="products">

            </div>
        </div>


<#--        <div class="column">-->
<#--            <div class="card-block card text-center" *ngFor="let event of eventActivities">-->
<#--                <h2>CURRENT ORDERS: </h2>-->
<#--            </div>-->


<#--            <div id="card-car" class="card text-center" *ngFor="let event of eventActivities">-->
<#--                <div class="card-block">-->
<#--                    <input id="feed" class="form-control" name="your_fb" placeholder="Your feedback" aria-label="Recipient's username" aria-describedby="basic-addon2">-->
<#--                    <div class="input-group-append">-->
<#--                        <button onclick="sendFeed()" class="btn btn-outline-secondary" id="sendFeed" type="submit" value="Send!">Send!</button>-->
<#--                    </div>-->

<#--                    <div id="resultFeed">-->

<#--                    </div>-->
<#--                </div>-->
<#--            </div>-->


<#--            <div id="basket""></div>-->


<#--        </div>-->
    <#--</div>-->
    </div>
</div>


</div>

<div id="r">
    <div class="container">
        <div class="row centered">
            <div class="col-lg-8 col-lg-offset-2">
                <h4>SOMETIMES THE RIGHT PATH IS NOT THE EASTEST ONE. JUST CHOOSE YOUR CAR!</h4>
                <p>The cars we drive say a lot about us!</p>
            </div>
        </div>
    </div>
</div>

<!-- FOOTER -->
<div id="f">
    <div class="container">
        <div class="row centered">
            <p>Subscribe to the developer!</p>
            <a href="https://vk.com/annchouss_s"><i class="fa fa-vk"></i></a><a href="https://www.instagram.com/anyana_t/"><i class="fa fa-instagram"></i></a><a href="#"></a>
        </div>
    </div>
</div>
<!-- Footer -->

<!-- COPYRIGHTS -->
<div id="copyrights">
    <div class="container">
        <p>
            Created by <strong>Anna Tugbaeva</strong>. Contact me!
        </p>
        <div class="credits">
            <strong>+7(917)897-35-32</strong>
        </div>
    </div>
</div>

</body>

</html>