<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
  <title>LatLong</title></head>
    <script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<body>
    <script>
        function doSend(){
            var number = $("#input1").val();

            var url = "http://localhost:8080/services/distance?loc1="+number;


            $.getJSON(url, function(result){
                $.each(result, function(i, field){
                    $("#response").html(field);
                });
            });
        }
    </script>
    <h1>Distance Location</h1>
    <label for="input1">Number</label>
    <input maxlength="18" id="input1" name="input1" style="width:150px" onkeyup="doSend()" />


    <div>
        <label for="response">Distance:</label>
        <div id="response" name="response">
        </div>
    </div>
</body>
</html>