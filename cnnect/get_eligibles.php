<?php 

$response = array();
 
// include db connect class
require_once __DIR__ . '/db_config.php';
 
// connecting to db
//$db = new DB_CONNECT();
$con = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE); 

if (mysqli_connect_errno($con))
{
	echo "Failed to connect " . mysqli_connect_error();
}	
$idd = 2;
$result = mysqli_query($con,"SELECT * FROM student INNER JOIN drive_details ON student.SSC>=drive_details.criteria_10 AND student.BE>=drive_details.criteria_be AND student.HSC>=drive_details.criteria_12 WHERE drive_details.id = $idd");

if (mysqli_num_rows($result) > 0) {
    // looping through all results
    // products node
    $response["products"] = array();
 
    while ($row = mysqli_fetch_array($result)) {
        // temp user array
        $product = array();
        $product["pid"] = $row["sid"];
        // push single product into final response array
        array_push($response["products"], $product);
    }
    // success
    $response["success"] = 1;
 
    // echoing JSON response
    echo json_encode($response);
} else {
    // no products found
    $response["success"] = 0;
    $response["message"] = "No products found";
 
    // echo no users JSON
    echo json_encode($response);
}
mysqli_close($con);
?>
?>