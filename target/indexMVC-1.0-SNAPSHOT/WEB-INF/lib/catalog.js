

function sendOrder(productId) {
    $.ajax({
        type: 'post',
        url: '/sendorder',
        data: {
            productId : productId
        }
    }).done(function (data) {
        window.location.replace('/order');

    }).fail(function () {
        alert("(((((")
    })
}

<!-- DONE -->
function categories() {
    $.ajax({
        type: 'post',
        url: '/categories'
    }).done(function (data) {
        var contentTableHTML = "";

        for (var i = 0; i < data.length; i++) {
            contentTableHTML += '<button id="categoryButton" class="btn btn-primary" onclick="showCategoryId('+ data[i].id +')">'+ data[i].title + '</button>';
        }


        var contentTableDiv = document.getElementById("products");
        contentTableDiv.innerHTML = contentTableHTML;
    }).fail(function () {
        alert("(((((")
    });
}

function showCategoryId(categoryId) {
    $.ajax({
        type: 'post',
        url: '/categoriesId',
        data: {
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
        alert("PLEASE SIGN IN!")
    });
}

