<?php
require_once __DIR__ . '/DB_Functions.php';
$db = new DB_Functions();
//require_once __DIR__ . '/db_config.php';


 
// json response array
$response = array("error" => FALSE);
 

 
	//$con = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE);
    // receiving the post params
    //$email = $_POST['email'];
    //$password = $_POST['password'];
	$email = 'heli@gmail.com';
	$password = '123';
 
    // get the user by email and password
    $user = $db->getUserByEmailAndPassword($email, $password);
	
	//$user = mysqli_query($con,"SELECT * FROM user_info WHERE email = '$email' AND pwd='$password'");
    if ($user != false) {
        // user is found
        $response["error"] = FALSE;
		$response["uid"] = $user["user_id"];
        $response["user"]["name"] = $user["fname"];
        $response["user"]["email"] = $user["email"];
		$response["user"]["created_at"] = $user["contact"];
      //  $response["user"]["updated_at"] = $user["updated_at"];
        echo json_encode($response);
    } else {
        // user is not found with the credentials
        $response["error"] = TRUE;
        $response["error_msg"] = "Login credentials are wrong. Please try again!";
        echo json_encode($response);
    }

?>