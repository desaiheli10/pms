
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

$name = $_POST['name'];
$posts = $_POST['post'];
$domain = $_POST['domain'];
$salary = $_POST['salary'];
$bond = $_POST['bond'];
$location = $_POST['location'];
$tenth = $_POST['tenth'];
$twelfth = $_POST['twelfth'];
$cpi = $_POST['cpi'];
$branch = $_POST['branch'];
$date = $_POST['date'];
$result = mysqli_query($con,"INSERT INTO `drive_details` (`allowed_branches`, `bond`,`criteria_10`,`criteria_12`,`criteria_be`,`date`,`domain`,`location`,`name`,`post`,`salary`) VALUES (`branch`,`tenth`,`twelfth`,`cpi`,`date`,`domain`,`location`,`name`,`post`,`salary`)");
// check for post data

if($result) {
	$response["success"] = 1;
	$response["message"] = "Created";

	echo json_encode($response);
}
?>