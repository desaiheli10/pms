<?php


    if($_SERVER['REQUEST_METHOD']=='POST'){
        $username = "heli@gmail.com";
        $password = 123;

        require_once __DIR__ . '/db_config.php';

        $con = mysqli_connect(DB_SERVER, DB_USER, DB_PASSWORD, DB_DATABASE);

        //$sql = "SELECT * FROM user_info WHERE email = '$username' AND password='$password'";
		
		$result = mysqli_query($con,"SELECT * FROM user_info WHERE email = '$username' AND pwd='$password'");
		
		
		if(mysqli_num_rows($result) == 1){
			echo 'success';
		}else{
			echo 'failure';
		}
		mysqli_close($con);
	}
?>	