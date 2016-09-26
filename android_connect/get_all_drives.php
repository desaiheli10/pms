<?php
 
/*
 * Following code will list all the students
 */
 
// array for JSON response
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

// get all students from student table
$result = mysqli_query($con,"SELECT * FROM drive_details");
 
// check for empty result
if (mysqli_num_rows($result) > 0) {
    // looping through all results
    // products node
    $response["products"] = array();
 
    while ($row = mysqli_fetch_array($result)) {
        // temp user array
        $product = array();
        $product["pid"] = $row["id"];
        $product["name"] = $row["name"];
        $product["price"] = $row["salary"];
        $product["description"] = $row["domain"];
        $product["updated_at"] = $row["date"];
 
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