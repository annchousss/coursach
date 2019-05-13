let count = 0;
function deleteProductId(productId) {
    $.ajax({
        type: 'post',
        url: '/deleteOrder',
        data: {
            productId: productId
        }
    }).done(function (data) {

        if(count === 0){
            var contentHTML = "";
            contentHTML += '<h4>Empty order!</h4>';
            contentHTML += '<h4>Please, go to Catalog</h4>';
            var contentDiv = document.getElementById("order");
            contentDiv.innerHTML = contentHTML;
        } else {
            document.getElementById("card-car" + productId).remove();
            count--;
            if (count === 0)  {
                var contentHTML = "";
                contentHTML += '<h4>Empty order!</h4>';
                contentHTML += '<h4>Please, go to Catalog</h4>';
                var contentDiv = document.getElementById("order");
                contentDiv.innerHTML = contentHTML;
            }
        }


    }).fail(function () {
        alert("(((((")
    });
}


function deleteAllCars() {
    $.ajax({
        type: 'post',
        url: '/deleteAllProducts'
    }).done(function (data) {

        window.location.replace('/shop');

    }).fail(function () {
        alert("(((((")
    });
}




function showProductId() {
    $.ajax({
        type: 'post',
        url: '/getOrder'
    }).done(function (data) {
        if(data.length === 0) {
            var contentHTML = "";
            contentHTML += 'Empty order';
            var contentDiv = document.getElementById("order");
            contentDiv.innerHTML = contentHTML;
        } else {
            var contentTableHTML = "";
            count = data.length;


            for (var i = 0; i < data.length; i++) {
                contentTableHTML += ' <div id="card-car' + data[i].id +'" ="card text-center" *ngFor="let event of eventActivities">';
                contentTableHTML += '<div class="card-header pull-left">';
                contentTableHTML += '<img src="'+ data[i].image +'" alt="Card image cap" height="180" width="270" marg>';
                contentTableHTML += '</div>';
                contentTableHTML += '<div class="card-block">';
                contentTableHTML += ' <p class="card-text text-left" "font-weight-bold">Model: '+ data[i].title + ' ' + data[i].model +'</p>';
                contentTableHTML += ' <p class="card-text text-left" "font-weight-bold">Number of places: '+ data[i].numberOfPlaces +'</p>';
                contentTableHTML += ' <p class="card-text text-left" "font-weight-bold">Full price: '+ data[i].price +' $</p>';
                contentTableHTML += '<button id="categoryButtonBack" class="btn btn-primary" onclick="deleteProductId('+ data[i].id +')">CANCEL</button>'
                contentTableHTML += '</div>';
                contentTableHTML += '</div>';
            }


            var contentTableDiv = document.getElementById("order");
            contentTableDiv.innerHTML = contentTableHTML;
        }
    }).fail(function () {
        alert("(((((")
    });
}



function sendAddress() {
    $.ajax({
        type: 'post',
        url: '/sendAddress',
        data: {
            city : document.getElementById("city").value,
            street : document.getElementById("street").value,
            house : document.getElementById("house").value
        }
    }).done(function (data) {
        var contentTableHTML = "<p>Successfully!</p>";
        contentTableHTML += "<p><strong>Wait for a call to confirm the order</strong></p>";
        var contentTableDiv = document.getElementById("resultSend");
        contentTableDiv.innerHTML = contentTableHTML;
    }).fail(function () {
        alert("(((((")
    });
}



function sendFeed() {
    $.ajax({
        type: 'post',
        url: '/insertfeed',
        data: {
            your_fb : document.getElementById("feed").value
            // userId: getCookie('userId')
        }
    }).done(function (data) {
        var contentTableHTML = "<p>Successfully! Your feedback was added to the main page</p>";
        var contentTableDiv = document.getElementById("resultFeed");
        contentTableDiv.innerHTML = contentTableHTML;
    }).fail(function () {
        alert("(((((")
    });
}


