<?php
		require_once __DIR__ . '/DB_Functions.php';
		$db = new DB_Functions();
		
		$password = '123';
		$hash = $db->hashSSHA($password);
        $encrypted_password = $hash["encrypted"]; // encrypted password
        $salt = $hash["salt"];
		echo $encrypted_password;
		echo '\n';
		echo $salt;
		
?>