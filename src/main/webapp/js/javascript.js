/**
 * Created by User on 19.04.2018.
 */

window.onload = function () {

    var inp_id = document.querySelector('input[id=delid]')


    //******* helloWorld On Index.jsp *****
    //document.querySelector('#btthello').onclick = function(){
    //    var inp_name = document.querySelector('input[id=name]')
    //    //var param = 'name=' + inp_name.value;
    //    alert('Hello, ' + inp_name.value + '!');
    //}



    document.querySelector('#deladv').onclick = function () {

        var params = 'id=' + inp_id.value;



        //alert(inp_id.value);


        dell(params);
    }





}


function dell(params) {
    var request = new XMLHttpRequest();
    var forma = document.getElementById('fordel');
    var delid = forma.elements.delid.value;
    request.onreadystatechange = function () {
        if (request.readyState == 4 && request.status == 200) {

            document.querySelector('#result').innerHTML = request.responseText;
            alert("Hello from hell JS" /*+ delid*/);

        }
    }
    request.open('POST', 'myServlet', true);
    //request.open('POST', 'jsp/showAdvertisements.jsp' + encodeURIComponent(delid), true);
    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    request.send(params);

}






