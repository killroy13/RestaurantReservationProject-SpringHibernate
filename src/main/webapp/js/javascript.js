/**
 * Created by User on 19.04.2018.
 */

window.onload = function () {

    $(document).ready(function() {
        $("#sub").click(function(){
            $.ajax({
                url : '../users?showAdvertisementByIdAjax',
                data : { id : $('#id').val()} ,
                success : function(responseText) {
                    $("#select").html(responseText);
                }
            });
        });
    });

    //
    ////******* helloWorld On Index.jsp *****
    ////document.querySelector('#btthello').onclick = function(){
    ////    var inp_name = document.querySelector('input[id=name]')
    ////    //var param = 'name=' + inp_name.value;
    ////    alert('Hello, ' + inp_name.value + '!');
    ////}


    //var inp_id = document.querySelector('input[id=delid]')
    //
    //document.querySelector('#deladv').onclick = function () {
    //
    //    //var params = 'idForDelete=' + inp_id.value;
    //    var params = 'deleteAdvertisementAjax=' + inp_id.value;
    //
    //
    //
    //    var request = new XMLHttpRequest();
    //    var forma = document.getElementById('fordel');
    //    var delid = forma.elements.delid.value;
    //    request.onreadystatechange = function () {
    //        if (request.readyState == 4 && request.status == 200) {
    //
    //            //document.querySelector('#result').innerHTML = request.responseText;
    //
    //            //alert("Hello from hell JS" /*+ delid*/);
    //
    //        }
    //    }
    //    request.open('POST', 'myServlet', true);
    //    //request.open('POST', 'jsp/showAdvertisements.jsp' + encodeURIComponent(delid), true);
    //    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    //    request.send('action=' + deleteAdvertisementAjax);
    //
    //
    //
    ////    var request = new XMLHttpRequest();
    ////    var forma=document.getElementById('new');
    ////    var firstname=forma.elements.firstname.value;
    ////    var secondname=forma.elements.secondname.value;
    ////    request.open('GET','Students/newstudent'+'?'+'firstname='+encodeURIComponent(firstname)+'&'+'secondname='+encodeURIComponent(secondname),true);
    ////    request.addEventListener('readystatechange', function() {
    ////        var request1=new XMLHttpRequest();
    ////        if (request.readyState==4 && request.status == 200) {
    ////
    ////            request1.open('GET', 'Students/select', true);
    ////            request1.addEventListener('readystatechange', function() {
    ////                if (request1.readyState==4 && request1.status == 200) {
    ////                    document.getElementById("select").innerHTML = request1.responseText;
    ////                }
    ////            });
    ////            request1.send();
    ////        }
    ////    });
    ////    request.send();
    ////}



    //
    //    //alert(inp_id.value);
    //
    //
    //    //dell(params);
    //}
}

//function dell(deleteAdvertisementAjax) {
//    var request = new XMLHttpRequest();
//    var forma = document.getElementById('fordel');
//    var delid = forma.elements.delid.value;
//    request.onreadystatechange = function () {
//        if (request.readyState == 4 && request.status == 200) {
//            document.querySelector('#result').innerHTML = request.responseText;
//            alert("Hello from hell JS" /*+ delid*/);
//        }
//    }
//    request.open('POST', 'myServlet', true);
//    //request.open('POST', 'jsp/showAdvertisements.jsp' + encodeURIComponent(delid), true);
//    request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//    request.send('action=' + deleteAdvertisementAjax);
//}

