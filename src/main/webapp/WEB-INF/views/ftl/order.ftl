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
    <script src="../../../lib/order.js"></script>

</head>



<body onload="showProductId()">
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
                <li class="active"><a href="/order">CHECKOUT</a></li>
                <li><a href="/shop">CATALOG</a></li>
                <li id="/logout"><a href="/logOut">LOG OUT</a></li>
            </ul>
        </div>

    </div>
</div>

<div id="blue">
    <div class="container">
        <div class="row centered">
            <div class="col-lg-8 col-lg-offset-2">
                <h4>HERE IS YOUR CURRENT ORDER</h4>
                <p>JUST TAKE A LOOK and CONTACT US IF YOU HAVE SOME QUESTIONS</p>
            </div>
        </div>
    </div>
</div>


<div class="container w">
    <div class="column_order" >
        <div class="card-block card text-center" *ngFor="let event of eventActivities">
            <h2>ORDER PARAMETERS: </h2>
<#--            <div id="card-car-order" class="card text-center" *ngFor="let event of eventActivities">-->
                <div class="card-block" id="cardParam">
                    <label for="adr">City: </label>
                    <input id="city" type="text" id="city" name="address" placeholder="Kazan" class="form-control" aria-label="Recipient's username" aria-describedby="basic-addon2">
                    <br>
                    <label for="city">Street: </label>
                    <input type="text" id="street" name="city" placeholder="Pushkina str." class="form-control" aria-label="Recipient's username" aria-describedby="basic-addon2">
                    <br>
                    <label for="city">House: </label>
                    <input type="text" id="house" name="city" placeholder="37" class="form-control" aria-label="Recipient's username" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <button onclick="sendAddress()" class="btn btn-outline-secondary" id="sendFeed1" type="submit" value="Send!">Send!</button>
                    </div>
                </div>
<#--            </div>-->
            <div id="resultSend"></div>
        </div>

        <div>OR</div>

        <div id="deleteOrder">
            <button id="categoryButtonBack" class="btn btn-primary" onclick="deleteAllCars()">CANCEL ALL</button>
        </div>

    </div>


    <div class="column_order" >
        <div class="card-block card text-center" *ngFor="let event of eventActivities">
            <h2>THE CAR YOU'VE CHOSEN: </h2>
            <div id="order"></div>
            <h2>Share your thoughts about our service:</h2>
            <div id="card-car" class="card text-center" *ngFor="let event of eventActivities">
                <div class="card-block">
                    <input id="feed" class="form-control" name="your_fb" placeholder="Your feedback" aria-label="Recipient's username" aria-describedby="basic-addon2">
                    <div class="input-group-append">
                        <button onclick="sendFeed()" class="btnOrder" id="sendFeed" type="submit" value="Send!">SEND</button>
                    </div>
                    <div id="resultFeed">
                    </div>
                </div>
            </div>

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





