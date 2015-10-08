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
            var from = $("#input1").val();
            var to = $("#input2").val();
            var unit = $("#input3").val();
            var url = "http://localhost:8080/services/distance?from="+from+"&to="+to+"&unit="+unit;


            $.getJSON(url, function(result){

                    $("#response").html(result);
            });
        }
    </script>
    <h1>Distance Location</h1>
    <label for="input1">From</label>
    <input maxlength="18" id="input1" name="input1" style="width:150px" />

    <label for="input2">To</label>
    <input maxlength="18" id="input2" name="input2" style="width:150px"  />

    <label for="input3">To</label>
    <input maxlength="18" id="input3" name="input3" style="width:150px"  value="KM"/>

    <button onclick="doSend()">Calculate</button>

    <div>
        <label for="response">Distance:</label>
        <div id="response" name="response">
        </div>
    </div>
</body>
</html>