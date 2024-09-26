function ajaxWithoutJQuery(context) {
    var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState === XMLHttpRequest.DONE) {   // XMLHttpRequest.DONE == 4
            if (xmlhttp.status === 200) {
                document.getElementById("ajax-target").innerHTML = xmlhttp.responseText;
            } else if (xmlhttp.status === 400) {
                alert('Error 400');
            } else {
                alert('Error maybe from server');
            }
        }
    };

    xmlhttp.open("GET", context + "/mvc/solicitudes/ajax/solicitudes-servlet", true);
    xmlhttp.send();
}

function ajaxWithJQuery(context) {
    $.ajax({
        type: 'GET',
        url: context + "/mvc/solicitudes/ajax/solicitudes-servlet",
        success: function (result) {
            $('#ajax-target').html(result);
        }
    }).fail(function ( jqXHR, textStatus, errorThrown) {
        alert("error");
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
    });
}
