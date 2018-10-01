<!DOCTYPE html>
<html>
  <head>
  	<script src="resources/js/jquery.min.js"></script>
	 <script src="resources/js/bootstrap.min.js"></script>
	 <script src="resources/js/index.js"></script>
	 <link rel="stylesheet" href="resources/css/bootstrap.min.css">
	 <link rel="stylesheet" href=resources/css/font-awesome.min.css>
     <meta charset="UTF-8">
     <title>Simple Web Application</title>
  </head>
  
  <body>
  
     <h2>jsp file</h2>
       
     <ul>
        <li><a href="home">Home</a></li>
        <li><a href="login">Login</a></li>
        <li><a href="productList">Product  List</a>
     </ul>
      
  </body>
  <script type="text/javascript">
 	 var obj = {
 			  "message_id": new Date().getTime(),
 			  "timestamp": new Date().getTime(),
 			  "farm_id": 1234,
 			  "device_id": 345,
 			  "node_id": 1234,
 			  "sensors_data": [
 			    {
 			      "sensor_id": 1,
 			      "sensor_name": "Do PH",
 			      "sensor_value": "7.8"
 			    },
 			    {
 			      "sensor_id": 2,
 			      "sensor_name": "DO do am",
 			      "sensor_value": "70"
 			    },
 			    {
 			      "sensor_id": 3,
 			      "sensor_name": "Do nhiet do",
 			      "sensor_value": "37.5"
 			    }
 			  ]
 			}
		$.ajax({
			type : 'POST',
			url : './senser',
			dataType : 'json',
			data : JSON.stringify(obj),
			contentType : 'application/json',
			async : false,
			cache : false,
			processData : false,
			success : function(res) {
				console.log("Thông tin của bạn đã được gửi thành công! \n\n Chúng tôi sẽ gửi lại qua email bạn vừa nhập \n\n Vui lòng chờ đợi!")
			},
			error : function(e) {
				console.log('error' + e);
			}
		});
  
  </script>
</html>