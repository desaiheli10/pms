
<?php
 
/*
 * Following code will get single product details
 * A product is identified by product id (pid)
 */
 
// array for JSON response
$response = array();
 
// include db connect class
require_once __DIR__ . '/db_config.php';
 
// connecting to db
//$db = new DB_CONNECT();
$con = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE); 
	
	
$pid=15;
$sid=1;
//$pid = $_POST['name'];
//$sid = $_POST['price'];

$result = mysqli_query($con,"INSERT INTO `drive_applications` (`drive_id`, `student_id`) VALUES ('$pid', '$sid')");
// check for post data

if($result) {
	$response["success"] = 1;
	$response["message"] = "Created";

	echo json_encode($response);
}
?>